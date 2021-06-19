public class Assert {

  public static void assertEquals(String message, Object expected, Object actual) {
    if (!equalsRegardingNull(expected, actual)) {
      if (expected instanceof String && actual instanceof String) {
        String cleanMessage = message == null ? "" : message;
        throw new RuntimeException(cleanMessage);
      } else {
        failNotEquals(message, expected, actual);
      }
    }
  }

  public static void assertEquals(Object expected, Object actual) {
    assertEquals((String)null, (Object)expected, (Object)actual);
  }

  private static boolean equalsRegardingNull(Object expected, Object actual) {
    if (expected == null) {
      return actual == null;
    } else {
      return isEquals(expected, actual);
    }
  }

  private static boolean isEquals(Object expected, Object actual) {
    return expected.equals(actual);
  }

  private static void failNotEquals(String message, Object expected, Object actual) {
    fail(format(message, expected, actual));
  }

  public static void fail(String message) {
    if (message == null) {
      throw new AssertionError();
    } else {
      throw new AssertionError(message);
    }
  }

  static String format(String message, Object expected, Object actual) {
    String formatted = "";
    if (message != null && !message.equals("")) {
      formatted = message + " ";
    }

    String expectedString = String.valueOf(expected);
    String actualString = String.valueOf(actual);
    return expectedString.equals(actualString)
        ? formatted + "expected: " + formatClassAndValue(expected, expectedString) +
          " but was: " + formatClassAndValue(actual, actualString)
        : formatted + "expected:<" + expectedString + "> but was:<" + actualString + ">";
  }

  private static String formatClassAndValue(Object value, String valueString) {
    String className = value == null ? "null" : value.getClass().getName();
    return className + "<" + valueString + ">";
  }
}
