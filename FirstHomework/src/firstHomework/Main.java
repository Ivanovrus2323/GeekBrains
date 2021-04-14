package firstHomework;

public class Main {
    public static void main(String[] args) {
        byte byt = 0;
        short shor = 0;
        int in = 0;
        long lon = 0;
        float floa = 0;
        double doubl = 0.0;
        char cha = 'c';
        boolean boolea = true;

        System.out.println(calc(1,1,1,1));
        System.out.println(checkAmount(10,10));
        printNegativity(2021);
        System.out.println(checkNegativity(-457));
        printName("Мир");
        checkLeap(2020);
    }

    public static float calc(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean checkAmount(int a, int b) {
        boolean result = false;
        int amount = a + b;

        if ( amount <= 20 && amount >= 10) {
            return true;
        }


        return result;
    }

    public static void printNegativity(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean checkNegativity(int a) {
        if (a >= 0) {
            return false;
        }

        return true;
    }

    public static void printName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void checkLeap(int currentYear) {
        if (currentYear % 4 == 0 && currentYear % 100 != 0 || currentYear % 4 == 0 && currentYear % 400 == 0) {
            System.out.println("Год " + currentYear + " - високосный");
        } else {
            System.out.println("Год " + currentYear + " - не високосный");
        }

    }
}

