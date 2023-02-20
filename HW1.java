import java.util.Scanner;

public class HW1 {

    public static void main(String[] args) {
        int n = getNumberByUser();
        int number = triangle(n);
        System.out.printf("%d-е треугольное число: %d \n", n, number);
    }

    public static int getNumberByUser() {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите номер треугольного числа: n = ");
        String num = console.nextLine();
        while (check(num) == false) {
            System.out.print("Попробуйте еще раз\n n = "); 
            num = console.nextLine();
        };
        console.close();
        return Integer.parseInt(num);
    }

    public static int triangle(int n) {
        int TriangleNumber = (n * (n + 1)) / 2;
        return TriangleNumber;
    }
    
    public static boolean check(String string) {
        try { 
            Integer.parseInt(string); {
                int num = Integer.parseInt(string);
                if (num > 0) {
                    return true;
                }
                else {
                    System.out.println("Ошибка! Число должно положительным!");
                }
            }
            } catch (NumberFormatException e) { 
            System.out.println("Ошибка! Число должно быть целым и положительным!"); 
            } 
            return false; 
            } 
    }

