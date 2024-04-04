package bt1.bussinessImpl;

import bt1.bussiness.IShop;
import bt1.config.ShopConfig;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Book implements IShop {
    public static List<Book> bookList = new ArrayList<>();
    private int bookId, numberOfPages, quantity;
    private String bookName, title;
    private Author author;
    private float importPrice, exportPrice;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, int numberOfPages, int quantity, String bookName, String title, Author author, float importPrice, float exportPrice, boolean bookStatus) {
        this.bookId = bookId;
        this.numberOfPages = numberOfPages;
        this.quantity = quantity;
        this.bookName = bookName;
        this.title = title;
        this.author = author;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        System.out.println("How many Book you want to add");
        byte count = Byte.parseByte(ShopConfig.getInput());

        for (int i = 1; i <= count; i++) {
            Book book = new Book();
            book.inputPerBook();
            bookList.add(book);
        }
        System.out.println("Add Book completed");

    }


    private void inputPerBook() {

        System.out.println("Input Book ID");
        this.bookId = Integer.parseInt(ShopConfig.getInput());
        System.out.println("Input Book Name");
        this.bookName = ShopConfig.getInput();
        System.out.println("Input Book Title");
        this.title = ShopConfig.getInput();
        System.out.println("Input Book Number Of Pages");
        this.bookId = Integer.parseInt(ShopConfig.getInput());
        System.out.println("Input Book Import price ");
        this.importPrice = Float.parseFloat(ShopConfig.getInput());
        this.exportPrice = this.importPrice * IShop.RATE;
        System.out.println("Input Book quantity");
        this.bookId = Integer.parseInt(ShopConfig.getInput());
        System.out.println("Input Book Status");
        this.bookStatus = Boolean.parseBoolean(ShopConfig.getInput());

        System.out.println("Do you want to select author");
        System.out.println("1. YES   | 2. NO ");
        byte choice = Byte.parseByte(ShopConfig.getInput());
        switch (choice) {
            case 1:
                Author author1 = new Author();
                if (Author.authorList.isEmpty()) {
                    System.out.println("There arent author, please add author");
                    author1.inputPerAuthor();
                    this.author = author1;
                    Author.authorList.add(author1);
                    System.out.println("Add Author completed");

                } else {
                    Author.authorList.forEach(Author::displayPerAuthor);
                    System.out.println("This is Author list, input Author Id to add for this book");
                    int authorId = Byte.parseByte(ShopConfig.getInput());
                    boolean ischeck = false;
                    for (Author author2 : Author.authorList) {
                        if (Author.authorList.stream().anyMatch(au -> au.getAuthorId() == authorId)) {
                            this.author = author2;
                            Author.authorList.add(author2);
                            ischeck = true;
                            System.out.println("Add Author completed");
                            break;
                        }
                    }
                    if (!ischeck) {
                        System.out.println("Author not found");
                    }
                }
                break;

            default:

                break;
        }

    }


    @Override
    public void displayData() {
        bookList.forEach(Book::displayPerBook);
    }

    public void displayPerBook() {
        System.out.printf("| ID: %d | Name: %-10s | " +
                        " | Author Name: %-10s " +
                        "|  Import Price : %-4s" +
                        " | Quantity  : %-2s" +
                        " | Status : %-5s \n",
                bookId, bookName, author.getAuthorName(), importPrice
                , quantity, bookStatus ? "Dang ban" : "Chua Ban"
        );
        System.out.println("----------------------------------------");
    }

    public void sortByExportPrice() {
        bookList.stream().sorted(Comparator.comparing(Book::getExportPrice)).forEach(Book::displayPerBook);
    }

    public void searchBookByAuthorName() {
        System.out.println("Input author Name");
        String authorName = ShopConfig.getInput();
        boolean isFound = false;
        for (Book book : bookList) {
            if (bookList.stream().anyMatch(b -> b.author.getAuthorName().equals(authorName))) {
                book.displayData();
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("No Book Found of this Author");
        }
    }
}
