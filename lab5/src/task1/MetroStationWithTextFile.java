package task1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.Scanner;


/**
 * This class inherits from the base {@link MetroStationWithFile} class.
 * The {@link MetroStationWithTextFile} class is extended with the ability to create a text file,
 * read data from this text file and write this data to another file after sorting.
 */
public class MetroStationWithTextFile extends MetroStationWithFile {
    /** Unique version identifier for serialization and deserialization which ensures the uniqueness of the class. */
    @Serial
    private static final long serialVersionUID = -424242424242424242L;
    /**
     * Writes Metro Station and Operating Hours data to a given file.
     * @param fileName file name for writing data;
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void writeToFile(String fileName) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            out.println("Station:\tName: \'" + getName() + "\'.\tOpened: " + getOpened() + ".\tHours: " + countHours());

            for (Hour hour : getHours()) {
                out.println("Hour\t{ ridership = " + hour.getRidership() + ",\tcomment = \'" + hour.getComment() + "\' }");
            }
        }
    }

    /**
     * Reads Metro Station and Operating Hours data from a given file.
     * @param fileName file name for reading data;
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void readFromFile(String fileName) throws IOException {
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            String line = scanner.nextLine();
            setName(line.split("Name: \'")[1].split("\'.")[0]);
            setOpened(Integer.parseInt(line.split("Opened: ")[1].split(".\t")[0]));

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();

                if (line.startsWith("Hour\t{ ridership = ")) {
                    int ridership = Integer.parseInt(line.split("ridership = ")[1].split(",\t")[0]);
                    String comment = line.split("comment = \'")[1].replace("\' }", "");
                    addHour(new Hour(ridership, comment));
                }
            }
        }
    }

    /**
     * Tests interaction (read and write operations) with text files.
     * The {@code args} are not used.
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        String path = "resources/task1/textFiles/";
        new MetroStationWithTextFile().testWithFile(
                path + "MetroStationWithHours.txt",
                path + "MetroStationWithoutHours.txt",
                path + "SortedByDecrRidership.txt",
                path + "SortedByDescCommentLength.txt"
        );
    }
}
