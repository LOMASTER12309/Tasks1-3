// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class Task3_1 {
    public static void main(String[] args) {//Демонстрация инвертирования односвязного списка
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int num = 0;
        while (num <= 0) { //проверка ввода целого числа
            if (in.hasNextInt()) num = in.nextInt();
            else in.next();
        }
        System.out.printf("Принято %d\n", num);
        int[] mas = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.printf("mas[%d] = ", i);
            boolean ver = false;
            while (ver == false) { //проверка ввода целых чисел
                if (in.hasNextInt()) {
                    mas[i] = in.nextInt();
                    ver = true;
                } else {
                    in.next();
                    System.out.printf("mas[%d] = ", i);
                }
            }
        }
        LinkedList test = new LinkedList(mas);
        System.out.printf("Первоначальный список: ");
        test.printList();
        test.reverse();
        System.out.printf("\nИнвертированный список: ");
        test.printList();
    }
}


class LinkedList { //односвязный список
    Node head;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
        public void setNext(Node elem) {
            next = elem;
        }
    }
    LinkedList(int[] mas){
        if (mas.length == 0) head = null;
        else {
            head = new Node(mas[0]);
            Node variable = head;
            for (int i = 1; i < mas.length; i++){
                variable.setNext(new Node(mas[i]));
                variable = variable.next;
            }
        }
    }

    LinkedList(){ // на всякий)
       head = null;
    }
    public void printList(){
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
    public void reverse(){ //инвертируем список, храня в цикле предыдущий и текущий элементы
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node nextElement = current.next;
            current.setNext(previous);
            previous = current;
            if (nextElement == null) head = current;
            current = nextElement;
        }
    }
}