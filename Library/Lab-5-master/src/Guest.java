import java.util.InputMismatchException;
import java.util.Scanner;

public class Guest {

    public void viewCatalog(){
        for (Book i: Library.getCatalog()){
            i.displayBook();
            System.out.println();
        }
    }

    public void borrowBook(Library library){

        System.out.println("Please, Sign Up before borrowing the book.");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        System.out.println("Enter your login: ");
        String login = sc.next();
        System.out.println("Enter your password: ");
        String password = sc.next();
        Role role = Role.MEMBER;

        Member member = new Member(name, age, login, password, role);
        library.registerMember(member);

        System.out.println("You are noe a member of this library");
        System.out.println();
    }

    public void loginAsGuest(Library library){
        System.out.println("Welcome to the Library!");

        Scanner scanner = new Scanner(System.in);

        boolean validChoice = false;

        while(!validChoice){

            System.out.println("1. View Available Books");
            System.out.println("2. Borrow Book");
            System.out.println("0. Return to main menu");

            try {
                int choice = scanner.nextInt();

                if (choice == 1){
                    viewCatalog();
                } else if (choice == 2){
                    borrowBook(library);
                } else if (choice == 0){
                    return;
                } else {
                    System.out.println("Invalid Choice");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option!");
            }

        }

    }

}
