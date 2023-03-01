import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.*;
public class HW4 {
    public static void main(String[] args) {
        int[] arr = CreateArray();
        System.out.println("Input: " + Arrays.toString(arr));
        MyLogger.writeLog("Input: " + Arrays.toString(arr)); 
        heapSort(arr);
        System.out.println("Output: " + Arrays.toString(arr));
        MyLogger.writeLog("Output: " + Arrays.toString(arr));
    }
    
    public static int[] CreateArray() {
        Random rand = new Random();
        int mas[] = new int[10];
        for (int i = 0; i < 10; i++) {
            mas[i] = rand.nextInt(20);
        }
        return mas;
    }
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n/2-1; i>=0; i--)
        heapify(arr, i, n);

        for (int i = n-1; i>=0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
    }
    public static void heapify(int[] arr, int i, int n) {
        int l = i*2+1;
        int r = i*2+2;
        int largest = i;
        if (l < n && arr[l]> arr[largest])
        largest = l;
        if (r < n && arr[r]> arr[largest])
        largest = r;
        if (i !=largest) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, n);
        }
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
    

