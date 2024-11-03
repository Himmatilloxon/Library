import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Librarian extends Person{
    private List<Book> managedBooks;

    private static final String CSV_FILE = "librarian.csv";

    public Librarian(String name, int age, String login, String password, Role role) {
        super(name, age, login, password, role);
        this.managedBooks = new ArrayList<>();

//        writeLibrarianToCsv();
    }

    public void addBook(Book book){
        managedBooks.add(book);
    }

    public void removeBook(String bookID){
        for (Book i: managedBooks){
            if (Objects.equals(i.getBookID(), bookID)){
                if (i.getStatus()) managedBooks.remove(i);
            }
        }
    }

    public void issueBook(String bookID, Member member){
        for (Book i: managedBooks){
            if (Objects.equals(i.getBookID(), bookID)){
                if (i.getStatus()){
                    member.borrowBook(bookID);
                    i.setStatus(false);
                }
            }
        }
    }

    public void returnBook(String bookID){
        for (Book i: managedBooks){
            if (Objects.equals(i.getBookID(), bookID)){
                i.returnBook();
            }
        }
    }

    public void checkOverdue(){
        for (Book i: managedBooks){
            if (ChronoUnit.DAYS.between(i.getBorrowedDate(), LocalDate.now()) > 15){
                System.out.println("Please, return the book with ID: " + i.getBookID());
                System.out.println("If you can't return on-time you will be charged with additional fee!!!");
            }
        }
    }

    public void loggedAsLibrarian(){

        System.out.println("Librarian " + getName() + " logged as librarian");

        Scanner sc = new Scanner(System.in);

        boolean validChoice = false;

        while (!validChoice) {

            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Issue a book");
            System.out.println("4. Check Overdue");
            System.out.println("0. Exit");

            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 0:
                        return;
                    case 1:

                        break;
                    default:
                        System.out.println("Invalid choice");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid choice");
            }

        }
    }

    /*private void writeLibrarianToCsv() {
        try (FileWriter writer = new FileWriter(CSV_FILE, true)) {
            writer.append(getID())
                    .append(",").append(getName())
                    .append(",").append(Integer.toString(getAge()))
                    .append(",").append(getLogin())
                    .append(",").append(getRole().toString())
                    .append("\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    private void updateLibrarianInCsv() {
        try {

            List<String> lines = Files.readAllLines(Paths.get(CSV_FILE));
            List<String> updatedLines = new ArrayList<>();

            for (String line : lines) {
                if (line.startsWith(getID())) {
                    String updatedLine = getID() + "," + getName() + "," + getAge() + "," + getLogin() + "," + getRole();
                    updatedLines.add(updatedLine);
                } else {
                    updatedLines.add(line);
                }
            }

            Files.write(Paths.get(CSV_FILE), updatedLines);
        } catch (IOException e) {
            System.out.println("Error updating CSV file: " + e.getMessage());
        }
    }*/
}
