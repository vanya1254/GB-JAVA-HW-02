import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после
 * каждой итерации запишите в лог-файл.
 */

public class task_02 {

    private static final Logger logger = Logger.getLogger(task_02.class.getName());

    public static void main(String[] args) throws SecurityException, IOException {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 50);
        }
        System.out.println(Arrays.toString(arr));


        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                    logger.info(Arrays.toString(arr));
                }
            }
        }
    }
}