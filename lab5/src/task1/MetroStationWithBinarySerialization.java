package task1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.Serial;

/**
 * This class inherits from the {@link MetroStationWithFile} class and implements {@link Serializable} interface.
 * The {@link MetroStationWithBinarySerialization} class is extended with the ability to serialization
 * and deserialization of objects of this class.
 */
public class MetroStationWithBinarySerialization extends MetroStationWithFile {
    /** Unique version identifier for serialization and deserialization which ensures the uniqueness of the class. */
    @Serial
    private static final long serialVersionUID = -424242424242424242L;
    /**
     * Implements serialization of class objects.
     * Writes object of {@code MetroStationWithBinarySerialization} class to a bit stream to be saved in a given file.
     * @param fileName file name for writing;
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void writeToFile(String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(this);
        }
    }

    /**
     * Implements deserialization of class objects.
     * Reads the bit stream, creating saved objects of {@code MetroStationWithBinarySerialization} class
     * and recreating their state at the time of saving object.
     * @param fileName file name for reading;
     * @throws IOException if an I/O error occurs;
     * @throws ClassNotFoundException class definition of a serialized object cannot be found.
     */
    @Override
    public void readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            MetroStationWithBinarySerialization metroStation = (MetroStationWithBinarySerialization) in.readObject();
            setName(metroStation.getName());
            setOpened(metroStation.getOpened());
            setHours(metroStation.getHours());
        }
    }

    /**
     * Tests interaction (Serialization and deserialization) with binary object files.
     * The {@code args} are not used.
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        String path = "resources/task1/objectFiles/";
        new MetroStationWithBinarySerialization().testWithFile(
                path + "MetroStationWithHours.dat",
                path + "MetroStationWithoutHours.dat",
                path + "SortedByDecrRidership.dat",
                path + "SortedByDescCommentLength.dat"
        );
    }
}
