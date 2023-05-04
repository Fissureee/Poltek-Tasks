package Book;

public class Book {
    String title, authorName;
    int publishedYear, pageAmmount, price;

    public Book(String tt, String nm, int yr, int pam, int pr) {
        this.title = tt;
        this.authorName = nm;
        this.publishedYear = yr;
        this.pageAmmount = pam;
        this.price = pr;
    }
}
