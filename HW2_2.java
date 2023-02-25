// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.*;

public class HW2_2 {
    
    public static void main(String[] args) throws SecurityException, IOException {
        int[] array = CreateArray();
        printArray(array);
        printArray(bubbleSort(array));  
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
       
    public static int[] CreateArray() {
        Random rand = new Random();
        int mas[] = new int[10];
        for (int i = 0; i < 10; i++) {
            mas[i] = rand.nextInt(20);
            // System.out.println(mas[i]);
        }
        return mas;
    } 
    public static int[] bubbleSort(int[] mas){
        for (int i = 0; i < mas.length - 1; i++) {
            for(int j = 0; j < mas.length - i - 1; j++) {
                if(mas[j + 1] < mas[j]) {
                    int temp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = temp;
                }
            }
        MyLogger.writeLog(Arrays.toString(mas)); 
            
        }
        return mas;
    }
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++){
            if (i > 0) {
                System.out.print(",");
            }
        System.out.print(arr[i]);
        }
        System.out.print("]\n");
    }
}
