package bt2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập URL muốn truy cập");
            System.out.println("2. Quay lại");
            System.out.println("3. Thoát");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Input URL");
                    String url = scanner.nextLine();
                    stack.push(url);
                    System.out.println("Data In Stack");
                    System.out.println(stack);
                    break;

                case 2:
                    stack.pop();
                    System.out.println("Deleted Top Element Successfully!");
                    System.out.println("Next URL");
                    System.out.println(stack.peek());
                    break;

                case 3:
                    System.exit(1);
                    System.out.println("Good Bye");
                    break;
                default:
                    System.out.println("Your choice out of range");
                    break;
            }
        }


    }
}
