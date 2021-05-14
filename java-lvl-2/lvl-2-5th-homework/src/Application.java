import java.util.Arrays;

public class Application {
    static final int SIZE = 10000000;
    static final int H = SIZE / 2;


    public static void main(String[] args) {

        first();
        second();

    }

    public static void first() {

        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Первый метод закончил работу за: " + (System.currentTimeMillis() - startTime)); // 6300 +- 300
    }
    
    public static void second() {

        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        float[] a1 = new float[H];
        float[] a2 = new float[H];

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < H; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < H; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        long startTime = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, H);
        System.arraycopy(arr, H, a2, 0, H);

        thread1.start();
        thread2.start();


        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, H, H);

        System.out.println("Второй метод закончил работу за: " + (System.currentTimeMillis() - startTime)); // 18 +- 1
    }
}