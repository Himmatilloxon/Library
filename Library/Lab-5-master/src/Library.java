import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private String name;
    private String location;
    private static List<Book> catalog = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Librarian> librarians = new ArrayList<>();
    private List<Admin> admins = new ArrayList<>();
    private List<Person> personList= new ArrayList<>();

//    private static final String BOOKS_CSV = "book.csv";
//    private static final String MEMBERS_CSV = "member.csv";
//    private static final String LIBRARIANS_CSV = "librarian.csv";
//    private static final String ADMINS_CSV = "admin.csv";

//    public void loadLibraryData() {
//        loadBooksFromCsv();
//        loadMembersFromCsv();
//        loadLibrariansFromCsv();
//        loadAdminsFromCsv();
//    }

    public Library(String name, String location){
        this.name = name;
        this.location = location;
    }

    public void registerBook(Book book){
        catalog.add(book);
    }

    public void registerAdmin(Admin admin){
        admins.add(admin);
    }

    public void registerMember(Member member){
        members.add(member);
    }

    public void registerLibrarian(Librarian librarian){
        librarians.add(librarian);
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public static Book getBook(String bookID){
        for (Book i: catalog) {
            if (Objects.equals(i.getBookID(), bookID)) return i;
        }
        return null;
    }

    public static List<Book> getCatalog() {
        return catalog;
    }

    /*private void loadBooksFromCsv() {
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKS_CSV))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String bookID = values[0];
                String title = values[1];
                String author = values[2];
                boolean isAvailable = values[3].equals("available");
                String borrowedDate = values[4];

                Book book = new Book(title, author);
                book.setStatus(isAvailable);

                if (!borrowedDate.equals("N/A")) {
                    book.borrowBook();  // Set the borrowed status if applicable
                }
                catalog.add(book);
            }
        } catch (IOException e) {
            System.out.println("Error loading books from CSV: " + e.getMessage());
        }
    }

    private void loadMembersFromCsv() {
        try (BufferedReader br = new BufferedReader(new FileReader(MEMBERS_CSV))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String memberID = values[0];
                String name = values[1];
                int age = Integer.parseInt(values[2]);
                String login = values[3];
                String password = values[4];

                Member member = new Member(name, age, login, password, Role.MEMBER);
                members.add(member);
            }
        } catch (IOException e) {
            System.out.println("Error loading members from CSV: " + e.getMessage());
        }
    }

    private void loadLibrariansFromCsv() {
        try (BufferedReader br = new BufferedReader(new FileReader(LIBRARIANS_CSV))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String librarianID = values[0];
                String name = values[1];
                int age = Integer.parseInt(values[2]);
                String login = values[3];
                String password = values[4];

                Librarian librarian = new Librarian(name, age, login, password, Role.LIBRARIAN);
                librarians.add(librarian);
            }
        } catch (IOException e) {
            System.out.println("Error loading librarians from CSV: " + e.getMessage());
        }
    }

    private void loadAdminsFromCsv() {
        try (BufferedReader br = new BufferedReader(new FileReader(ADMINS_CSV))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String adminID = values[0];
                String name = values[1];
                int age = Integer.parseInt(values[2]);
                String login = values[3];
                String password = values[4];

                Admin admin = new Admin(name, age, login, password, Role.ADMIN);
                admins.add(admin);
            }
        } catch (IOException e) {
            System.out.println("Error loading admins from CSV: " + e.getMessage());
        }
    } */
}
