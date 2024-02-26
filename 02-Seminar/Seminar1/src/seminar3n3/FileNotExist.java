package seminar3n3;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileNotExist extends FileNotFoundException {

    public FileNotExist() {
        super("Файл не найден");
    }

    public FileNotExist(String baf) {
        super("Файл по пути не существует: " + baf);
    }
}
