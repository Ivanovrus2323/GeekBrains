import annotation.AfterSuite;
import annotation.BeforeSuite;
import annotation.Test;

public class MathTest {

  @BeforeSuite()
  public void beforeSuite() {
    System.out.println("beforeSuite method message");
  }

  @Test(priority = 6)
  public void sum1() {
    Assert.assertEquals(16, Math.sum(15, 1));
  }

  @Test(priority = 3)
  public void sum2() {
    Assert.assertEquals(20919302, Math.sum(13461456, 7457846));
  }

  @Test(priority = 1)
  public void sum3() {
    Assert.assertEquals(7.592877, Math.sum(1.24674, 6.346137));
  }

  @Test(priority = 10)
  public void sum4() {
    Assert.assertEquals(1454812.5933757, Math.sum(97567.3461357, 1357245.24724));
  }

  @Test(priority = 10)
  public void sum5() {
    Assert.assertEquals(20, Math.incorrectSum(10, 10));
  }

  @AfterSuite()
  public void afterSuite() {
    System.out.println("afterSuite method message");
  }
}
