public class Application {
    public static void main(String[] args) throws Exception {
        String[][] array = {{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"}};

        int amount = 0;

        try {
            amount = getAmount(array);
        } catch (MySizeArrayException exception) {
            exception.getException();
        } catch (MyArrayDataException exception) {
            exception.getException();
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
        public void getException() {
            System.err.println("Недопустимый размер массива");
        }
    }

    private static class MyArrayDataException extends Exception {
        public int i;
        public int j;

        MyArrayDataException(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public void getException() {
            System.err.println("Недопустимое значение в ячейке [" + i + "][" + j + "]");
        }
    }
}