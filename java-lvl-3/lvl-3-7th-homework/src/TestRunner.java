import annotation.AfterSuite;
import annotation.BeforeSuite;
import annotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestRunner {
  public static void run(Class testClass) {
    List<Method> methodList = new ArrayList<>(Arrays.asList(testClass.getDeclaredMethods()));

    List<Method> beforeSuiteMethodList = new ArrayList<>(methodList);
    beforeSuiteMethodList.removeIf(m -> !m.isAnnotationPresent(BeforeSuite.class));
    if (beforeSuiteMethodList.size() != 1 && beforeSuiteMethodList.size() != 0) {
      throw new RuntimeException("There are too many suite methods in the test class: " + testClass.getName());
    }

    List<Method> testMethodList = new ArrayList<>(methodList);
    testMethodList.removeIf(m -> !m.isAnnotationPresent(Test.class));
    Collections.sort(testMethodList, TestRunner.COMPARE_BY_COUNT.get());

    List<Method> afterSuiteMethodList = new ArrayList<>(methodList);
    afterSuiteMethodList.removeIf(m -> !m.isAnnotationPresent(AfterSuite.class));
    if (afterSuiteMethodList.size() != 1 && afterSuiteMethodList.size() != 0) {
      throw new RuntimeException("There are too many suite methods in the test class: " + testClass.getName());
    }

    if (beforeSuiteMethodList.size() != 0)
        runSuiteMethod(beforeSuiteMethodList.get(0), testClass);

    runTests(testMethodList, testClass);

    if (afterSuiteMethodList.size() != 0)
        runSuiteMethod(afterSuiteMethodList.get(0), testClass);
  }

  private static void runSuiteMethod(Method method, Class clazz){
    try {
      method.invoke(clazz.getDeclaredConstructor().newInstance(null));
    } catch (InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException e) {
      e.printStackTrace();
    }
  }

  private static void runTests(List<Method> methodList, Class clazz) {
    int tests = 0;
    int passed = 0;
    for (Method method : methodList) {
      tests++;
      try {
        method.setAccessible(true);
        method.invoke(clazz.getDeclaredConstructor().newInstance(null));
        passed++;
      } catch (InvocationTargetException wrappedExc) {
        Throwable exc = wrappedExc.getCause();
        System.out.println(method + " failed: " + exc);
      } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
        e.printStackTrace();
      }
    }
    System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
  }

  public static final ThreadLocal<Comparator<Method>> COMPARE_BY_COUNT = ThreadLocal.withInitial(() -> Comparator.comparingInt(lhs -> lhs.getAnnotation(Test.class).priority()));
}
