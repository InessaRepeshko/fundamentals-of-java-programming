package task3;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ReadFromZip {
    public static void main(String[] args) {
        System.out.println("Student list:");

        try (ZipInputStream zIn = new ZipInputStream(new FileInputStream("resources/task3/Group.zip"));
             DataInputStream in = new DataInputStream(zIn)) {
            ZipEntry entry;

            while ((entry = zIn.getNextEntry()) != null) {
                System.out.print("\tStudent ID:\t" + entry.getName());
                System.out.print("\tRating Score:\t" + in.readDouble());
                System.out.print("\tFirst Name:\t" + in.readUTF());
                System.out.println("\tLast Name:\t" + in.readUTF());
                zIn.closeEntry();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to read file.");
            e.printStackTrace();
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        }
    }
}
