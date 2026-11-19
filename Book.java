public class Book {
    private String title;
    private String author;
    private Student borrower;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Student getBorrower() {
        return borrower;
    }

    public String borrowBy(Student student) {
        this.borrower = student;
        student.setBorrowedBook(this);
        return student.getName() + " with matric number " + student.getMatric()
                + " has borrow a book with title " + this.title + ".";
    }

    @Override
    public String toString() {
        return title + " (" + author + ")";
    }
}
