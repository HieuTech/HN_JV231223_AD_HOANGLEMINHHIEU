package bt1.bussinessImpl;

import bt1.bussiness.IShop;
import bt1.config.ShopConfig;

import java.util.ArrayList;
import java.util.List;

public class Author implements IShop {
    public static List<Author> authorList = new ArrayList<>();
    private int authorId, year;
    private String authorName;
    private boolean gender;

    public Author() {
    }

    public Author(int authorId, int year, String authorName, boolean gender) {
        this.authorId = authorId;
        this.year = year;
        this.authorName = authorName;
        this.gender = gender;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public void displayData() {
        authorList.forEach(Author::displayPerAuthor);
    }

    public void displayPerAuthor() {
        System.out.printf("| ID: %d | Name: %-10s \n", authorId, authorName);
        System.out.println("----------------------------------------");

    }

    @Override
    public void inputData() {
        System.out.println("How many authors you want to add");
        byte count = Byte.parseByte(ShopConfig.getInput());
        for (int i = 1; i <= count; i++) {
            Author author = new Author();
            author.inputPerAuthor();
            authorList.add(author);
        }
        System.out.println("Add successfully");
    }

    public void inputPerAuthor() {
        System.out.println("Input authorId");
        this.authorId = Integer.parseInt(ShopConfig.getInput());
        System.out.println("Input author Name");
        this.authorName = ShopConfig.getInput();
        System.out.println("Input year");
        this.year = Integer.parseInt(ShopConfig.getInput());
        System.out.println("Input gender");
        this.gender = Boolean.parseBoolean(ShopConfig.getInput());


    }

}

