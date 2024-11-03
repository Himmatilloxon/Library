import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\tWelcome to NUU library");

        Library library = new Library("NUU", "Tashkent");

        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("Animal Farm", "George Orwell");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald");

        library.registerBook(book1);
        library.registerBook(book2);
        library.registerBook(book3);

        Admin admin0 = new Admin("Ximmatilloxon", 19, "admin0", "123", Role.ADMIN);
        library.registerAdmin(admin0);

        Librarian librarian1 = new Librarian("lib1", 22, "lib1", "123", Role.LIBRARIAN);
        library.registerLibrarian(librarian1);

        Member member1 = new Member("mem1", 21, "mem1", "123", Role.MEMBER);
        library.registerMember(member1);

        mainMenu(library);

    }

    public static void mainMenu(Library library){

        Guest guest = new Guest(); // Choice: 4

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\tChoose with numbers only!!!");
            System.out.println("\t1. Login as ADMIN");
            System.out.println("\t2. Login as Librarian");
            System.out.println("\t3. Login as Member");
            System.out.println("\t4. Continue as Guest");
            System.out.println("\t0. Exit \n");

            try {
                System.out.println("Make a choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 0: return;

                    case 1:

                        // Login as an Admin
                        loginAsRole(Role.ADMIN, library);
                        break;

                    case 2:

                        // Login as a Librarian
                        loginAsRole(Role.LIBRARIAN, library);
                        break;

                    case 3:

                        // Login as a Member
                        loginAsRole(Role.MEMBER, library);
                        break;

                    case 4:

                        // Login as a Guest
                        guest.loginAsGuest(library);
                        break;

                    default:
                        System.out.println("Please enter a number between 0 and 4");
                }

            } catch (InputMismatchException e) {

                System.out.println("Please enter a number between 0 and 4");
                scanner.nextLine();

            }
        }
    }

    public static void loginAsRole(Role role, Library library){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Enter your login (0. Return to main menu): ");
            String login = scanner.nextLine();
            if (login.equals("0")) {mainMenu(library);}
            System.out.println("Enter your password (0. Return to main menu): ");
            String password = scanner.nextLine();
            if (password.equals("0")) {mainMenu(library);}

            switch (role) {
                case ADMIN:
                    for (Admin admin : library.getAdmins()) {
                        if (admin.getLogin().equals(login) && admin.getPassword().equals(password)) {
                            admin.loggedAsAdmin(library);
                            return;
                        }
                    }
                case LIBRARIAN:
                    for (Librarian librarian : library.getLibrarians()) {
                        if (login.equals(librarian.getLogin()) && password.equals(librarian.getPassword())) {
                            librarian.loggedAsLibrarian();
                            return;
                        }
                    }
                case MEMBER:
                    for (Member member : library.getMembers()) {
                        if (login.equals(member.getLogin()) && password.equals(member.getPassword())) {
                            member.loggedAsMember();
                            return;
                        }
                    }

                default:
                    System.out.println("Wrong login or password!!!");
            }
        }
    }
}