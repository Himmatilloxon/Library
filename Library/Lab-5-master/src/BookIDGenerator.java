import java.util.Random;

public class BookIDGenerator {
    public static String generateBookID() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder bookID = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(characters.length());
            bookID.append(characters.charAt(index));
        }

        return bookID.toString();
    }
}