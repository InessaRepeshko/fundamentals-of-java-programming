package task1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serial;

/**
 * This class inherits from the base {@link MetroStationWithFile} class.
 * The {@link MetroStationWithBinaryFile} class is extended with the ability to create a binary data file,
 * read data from this data file and write this data to another file after sorting.
 */
public class MetroStationWithBinaryFile extends MetroStationWithFile {
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
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            out.writeUTF(getName());
            out.writeInt(getOpened());
            out.writeInt(countHours());

            for (Hour hour : getHours()) {
                out.writeInt(hour.getRidership());
                out.writeUTF(hour.getComment());
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
        try (DataInputStream in = new DataInputStream(new FileInputStream(fileName))) {
            setName(in.readUTF());
            setOpened(in.readInt());
            int hoursCount = in.readInt();

            for (int i = 0; i < hoursCount; i++) {
                int ridership = in.readInt();
                String comment = in.readUTF();
                addHour(new Hour(ridership, comment));
            }
        }
    }

    /**
     * Tests interaction (read and write operations) with binary data files.
     * The {@code args} are not used.
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        String path = "resources/task1/binaryFiles/";
        new MetroStationWithBinaryFile().testWithFile(
                path + "MetroStationWithHours.dat",
                path + "MetroStationWithoutHours.dat",
                path + "SortedByDecrRidership.dat",
                path + "SortedByDescCommentLength.dat"
        );
    }
}
