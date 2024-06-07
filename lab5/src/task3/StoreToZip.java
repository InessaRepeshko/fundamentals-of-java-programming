package task3;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class StoreToZip {
    public static void main(String[] args) {
        Group group = Group.createTestGroup();

        try (ZipOutputStream zOut = new ZipOutputStream(new FileOutputStream("resources/task3/Group.zip"));
             DataOutputStream out = new DataOutputStream(zOut)) {
            for (Student student : group.getStudents()) {
                zOut.putNextEntry(new ZipEntry(Integer.toString(student.getStudentID())));
                out.writeDouble(student.getRatingScore());
                out.writeUTF(student.getFirstName());
                out.writeUTF(student.getLastName());
                zOut.closeEntry();
            }
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        }
    }
}
