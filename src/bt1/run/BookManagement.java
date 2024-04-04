package bt1.run;

import bt1.bussinessImpl.Author;
import bt1.bussinessImpl.Book;
import bt1.config.ShopConfig;

public class BookManagement {
    public static Book book = new Book();
    public static Author author = new Author();

    public static void main(String[] args) {

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập số tác giả và nhập thông tin các tác giả");
            System.out.println("2. Nhập số sách và nhập thông tin các sách");
            System.out.println("3. Sắp xếp sách theo giá xuất sách tăng dần");
            System.out.println("4. Tìm kiếm sách theo tên tác giả sách");
            System.out.println("5. Thoát");
            byte choice = Byte.parseByte(ShopConfig.scanner.nextLine());
            switch (choice) {
                case 1:
                    author.inputData();
                    break;
                case 2:
                    book.inputData();
                    break;
                case 3:
                    book.sortByExportPrice();
                    break;
                case 4:
                    book.searchBookByAuthorName();
                    break;
                case 5:
                    System.exit(1);
                    break;


                default:
                    System.out.println("Your choice out of range");
                    break;
            }
        }
    }
}
