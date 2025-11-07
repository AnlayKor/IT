import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "File.txt";
        String destinationFile = "CopyOfFile.txt";
        try (FileInputStream inS = new FileInputStream(sourceFile);
             FileOutputStream outS = new FileOutputStream(destinationFile)) {
            byte[] b = new byte[1024];
            int bytesRead;
            while ((bytesRead = inS.read(b)) != -1) {
                outS.close();
                outS.write(b, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден - \"" + e.getMessage() + "\"");
        } catch (IOException e) {
            System.out.println("Ошибка: неправильный ввод-вывод - \"" + e.getMessage() + "\"");
        }
    }
}