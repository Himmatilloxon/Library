import java.util.List;
import java.util.Objects;

public class Member extends Person{
    private String memberID;
    private String title;
    private List<Book> borrowedBooks;

    public Member(String name, int age, String login, String password, Role role) {
        super(name, age, login, password, role);
    }

    public void borrowBook(String bookID){
        Book book = Library.getBook(bookID);
        if (book != null){
            boolean status = book.borrowBook();
            if (status){
                System.out.println("Book Borrowed!");
            }
        }
        else System.out.println("Book not found");
    }

    public void returnBook(String bookID){
        for (Book book : borrowedBooks){
            if (Objects.equals(book.getBookID(), bookID)){
                boolean status = book.returnBook();
                if (status){
                    System.out.println("Book Returned!");
                }
                borrowedBooks.remove(book);
                return;
            }
        }
        System.out.println("Book was not borrowed");
    }

    public void viewBorrowedBooks(){
        for (Book book : borrowedBooks){
            book.displayBook();
        }
    }

    public void loggedAsMember(){
        System.out.println("Member logged in");
    }
}
