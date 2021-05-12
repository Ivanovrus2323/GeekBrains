public class Application {
    public static void main(String[] args) throws Exception {
        String[][] array = {{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"}};

        int amount = 0;

        try {
            amount = getAmount(array);
        } catch (MySizeArrayException exception) {
            System.err.println(exception.getMessage());
        } catch (MyArrayDataException exception) {
            System.err.println(exception.getMessage());
        }

        System.out.println(amount);

    }

    public static int getAmount(String[][] array) throws Exception {

        if (array.length != 4) {
            throw new MySizeArrayException();
        }

        int result = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i].length != 4) {
                    throw new MySizeArrayException();
                }

                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException exp) {
                    throw new MyArrayDataException(i, j);
                }

            }
        }

        return result;
    }

    private static class MySizeArrayException extends Exception {
        MySizeArrayException() {
            super("Недопустимый размер массива");
        }
    }

    private static class MyArrayDataException extends Exception {
        MyArrayDataException(int i, int j) {
            super("Недопустимое значение в ячейке [" + i + "][" + j + "]");
        }
    }
}