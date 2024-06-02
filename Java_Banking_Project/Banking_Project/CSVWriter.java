package Banking_Project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    public static void write(String filePath, List<Account> accounts) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Account account : accounts) {
                writer.write(account.toCSV() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to CSV file.");
            e.printStackTrace();
        }
    }
}
