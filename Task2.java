import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.printf("Введите число: ");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int[] res = swapping(num1, num2);
        System.out.printf("Поменяли: %d %d\n", res[0], res[1]);
        in.close();
    }
    public static int[] swapping(int a, int b) { //меняем местами числа, вернём массивом
        a = a + b;
        b = a - b;
        a = a - b;
        int[] sw = new int[2];
        sw[0] = a;
        sw[1] = b;
        return sw;
    }

}
