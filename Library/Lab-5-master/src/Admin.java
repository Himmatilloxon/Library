import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Admin extends Person{
    private String adminID;

    public Admin(String name, int age, String login, String password, Role role) {
        super(name, age, login, password, role);
    }

    public void addLibrarian(Library library) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Librarian's name: ");
        String name = sc.nextLine();
        System.out.println("Enter Librarian's age: ");
        int age = sc.nextInt();
        System.out.println("Enter Librarian's login: ");
        String login = sc.next();
        System.out.println("Enter Librarian's password: ");
        String password = sc.next();
        Role role = Role.LIBRARIAN;

        Librarian librarian = new Librarian(name, age, login, password, role);
        library.registerLibrarian(librarian);

        System.out.println("New Librarian added!");
        librarian.displayInfo();
    }

    public void loggedAsAdmin(Library library) {
        System.out.println("\tAdmin logged in");

        Scanner sc = new Scanner(System.in);

        boolean validChoice = false;

        while (!validChoice) {

            System.out.println("1. Add Librarian");
//            System.out.println("2. Add Admin");
//            System.out.println("3. Remove Librarian");
//            System.out.println("4. Remove Admin");
            System.out.println("0. Exit");

            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 0:
                        return;
                    case 1:
                        addLibrarian(library);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid choice");
            }

        }
    }

}
