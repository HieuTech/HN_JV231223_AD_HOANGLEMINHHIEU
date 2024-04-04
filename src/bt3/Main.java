package bt3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        while (true){
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập tên khách hàng chờ mua vé xem phim");
            System.out.println("2. Khách tiếp theo");
            System.out.println("3. Thoát");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Input Customer Name");
                    String customerName = scanner.nextLine();
                    queue.add(customerName);
                    System.out.println("Add successfully");
                    break;

                case 2:
                    if(queue.isEmpty()){
                        System.out.println("You need to add customer first");
                        break;
                    }
                    System.out.printf("Next Customer %s, \n", queue.peek());
                    System.out.printf("Delete Customer %s Successfully \n"
                            , queue.peek());
                    queue.poll();
                    break;

                case 3:
                    System.exit(1);
                    break;

                default:
                    System.out.println("Your choice out of range");
                    break;
            }
        }

    }
}
