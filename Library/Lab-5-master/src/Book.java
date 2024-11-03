import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book{
    private final String bookID;
    private final String title;
    private final String author;
    private boolean isAvailable;
    private LocalDate borrowedDate;

    private static final String CSV_FILE = "books.csv";

    public Book(String title, String author){
        this.bookID = BookIDGenerator.generateBookID();
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.borrowedDate = null;
//        writeBookToCsv();
    }

    public String getBookID(){
        return this.bookID;
    }

    public boolean getStatus(){
        return this.isAvailable;
    }

    public void setStatus(boolean status){
        this.isAvailable = status;
    }

    public LocalDate getBorrowedDate(){
        return this.borrowedDate;
    }

    public boolean borrowBook(){
        if (isAvailable){
            isAvailable = false;
            borrowedDate = LocalDate.now();
//            updateBookInCsv();
            return true;
        } else {
            System.out.println("The book is currently unavailable");
            return false;
        }
    }

    public boolean returnBook(){
        if (!isAvailable) {
            isAvailable = true;
            borrowedDate = null;
//            updateBookInCsv();
            return true;
        } else {
            System.out.println("The book was not borrowed");
            return false;
        }
    }

    public void displayBook(){
        System.out.println("Book ID: " + bookID);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability status : " + ((isAvailable) ? "available" : "not available"));
    }

   /* private void writeBookToCsv() {
        try (FileWriter writer = new FileWriter(CSV_FILE, true)) {
            writer.append(bookID)
                    .append(",").append(title)
                    .append(",").append(author)
                    .append(",").append(isAvailable ? "available" : "not available")
                    .append(",").append(borrowedDate != null ? borrowedDate.toString() : "N/A")
                    .append("\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    private void updateBookInCsv() {
        try {

            List<String> lines = Files.readAllLines(Paths.get(CSV_FILE));
            List<String> updatedLines = new ArrayList<>();

            for (String line : lines) {
                if (line.startsWith(bookID)) {
                    String updatedLine = bookID + "," + title + "," + author + "," +
                            (isAvailable ? "available" : "not available") + "," +
                            (borrowedDate != null ? borrowedDate.toString() : "N/A");
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
