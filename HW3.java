// Реализовать алгоритм сортировки слиянием.
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.*;

public class HW3 {
    
    public static void main(String[] args) throws SecurityException, IOException {
        int[] array = CreateArray();
        System.out.println("Input: " + Arrays.toString(array));
        System.out.println("Output: " + Arrays.toString(MergeSort(array))); 
        MyLogger.writeLog("Input: " + Arrays.toString(array)); 
        MyLogger.writeLog("Output: " + Arrays.toString(MergeSort(array)));
    }
    public static int[] CreateArray() {
        Random rand = new Random();
        int mas[] = new int[10];
        for (int i = 0; i < 10; i++) {
            mas[i] = rand.nextInt(20);
        }
        return mas;
    } 

    public static int[] MergeSort(int[] mas){
        if (mas == null){
            System.out.println("Mассив пуст");
            return null;
        }

        if (mas.length < 2){
            return mas;
        }

        int[] left = new int[mas.length/2];
        int[] right = new int[mas.length-mas.length/2];
        System.arraycopy(mas, 0, left, 0, mas.length/2);
        System.arraycopy(mas, mas.length/2 , right, 0, mas.length-mas.length/2);
        left = MergeSort(left);
        right = MergeSort(right);
        return merge(left, right);
        }
    
    public static int[] merge(int a[], int b[]) {
      
        int[] res = new int[a.length + b.length];
        int n = a.length;
        int m = b.length;
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]){
                res[k] = a[i];
                i++;
            }
            else {
                res[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < n) {
            res[k] = a[i];
            i++;
            k++;
        }
        while (j < m){ 
            res[k] = b[j];
            j++;
            k++;          
        }
        return res;
    }
    class MyLogger {
        private static final Logger log = Logger.getLogger("MyLogger");

        static {
            FileHandler fh;

            try {
                fh = new FileHandler("log.txt", false);
                log.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
            } catch (IOException e) {
                log.log(Level.SEVERE, e.getMessage());
            }
        }

        public static void writeLog(String message) {
            log.log(Level.INFO, message);
        }

        public static void writeLog(String message, Exception e) {
            log.log(Level.WARNING, message, e);
        }
    }
}


