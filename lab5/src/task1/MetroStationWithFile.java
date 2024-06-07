package task1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serial;
import java.util.InputMismatchException;

/**
 * The {@link MetroStationWithFile} class is a base class that declares read and write operations
 * and implements the ability to demonstrate interaction with files of different formats.
 * This class is inherited from the {@link MetroStationWithList}.
 */
public abstract class MetroStationWithFile extends MetroStationWithList {
    /** Unique version identifier for serialization and deserialization which ensures the uniqueness of the class. */
    @Serial
    private static final long serialVersionUID = -424242424242424242L;

    /**
     * Writes Metro Station and Operating Hours data to a given file.
     * @param fileName file name for writing data;
     * @throws Exception if an error occurs while writing or processing data.
     */
    public abstract void writeToFile(String fileName) throws Exception;

    /**
     * Reads Metro Station and Operating Hours data from a given file.
     * @param fileName file name for reading data;
     * @throws Exception if an error occurs while reading or processing data from a file.
     */
    public abstract void readFromFile(String fileName) throws Exception;

    /**
     * Test interaction (read and write operations) with files of different formats.
     * @param MSWithHoursFile the file to store the data of the class object with the operating hours;
     * @param MSWithoutHoursFile the file to store the data of the class object without the operating hours;
     * @param SortedByCommentFile the file to store the data of the class object sorted by descending comment length;
     * @param SortedByRidershipFile the file to store the data of the class object sorted by decreasing ridership.
     */
    public void testWithFile(String MSWithHoursFile,
                             String MSWithoutHoursFile,
                             String SortedByRidershipFile,
                             String SortedByCommentFile) {
        createMetroStationHours();

        try {
            System.out.println("\n\nOPERATIONS OF WRITING AND READING FROM A FILE:");
            System.out.println("Write to file Metro Station with Operating Hours:");
            writeToFile(MSWithHoursFile);
            System.out.println(this);

            System.out.println("Write to file Metro Station with removed Operating Hours:");
            removeHours();
            writeToFile(MSWithoutHoursFile);
            System.out.println(this);

            readFromFile(MSWithoutHoursFile);
            System.out.println("Read from file Metro Station without Operating Hours:");
            System.out.println(this);

            System.out.println("Read from file Metro Station with Operating Hours and set its data:");
            readFromFile(MSWithHoursFile);
            System.out.println(this);

            System.out.println("Write to file Metro Station with Operating Hours sorted by decreasing ridership:");
            sortByDecreasingRidership();
            writeToFile(SortedByRidershipFile);
            System.out.println(this);

            System.out.println("Write to file Metro Station with Operating Hours sorted by descending comment length:");
            sortByDescendingCommentLength();
            writeToFile(SortedByCommentFile);
            System.out.println(this);
        } catch (FileNotFoundException e) {
            System.err.println("Failed to read file.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Failed to write to file.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Class definition of a serialized object cannot be found.");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.err.println("Wrong data format.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
