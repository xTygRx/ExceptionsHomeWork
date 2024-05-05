package Save;

import java.io.FileWriter;
import java.io.IOException;

public abstract class SaveAbstract {
    public void saveToTxt(String input, String name) {
        try (FileWriter fileWriter = new FileWriter(name + ".txt", true)) {
            fileWriter.append(input);
            fileWriter.flush();
            fileWriter.append("\n");
            fileWriter.flush();
            System.out.println("Запись прошла успешно");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
            throw new RuntimeException(e);
        }
    }
}
