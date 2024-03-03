package hw30.archive;

import hw30.person.Person;

import java.io.*;
import java.util.Map;

public class PersonArchive {
    private Map<String, BufferedWriter> files;

    public PersonArchive(Map<String, BufferedWriter> files) {
        this.files = files;
    }

    public void savePerson(Person person) {
        String filename = Settings.DATA_DIRECTORY + person.getLastName() + ".txt";
        File file = new File(filename);

        try {
            BufferedWriter writer = files.computeIfAbsent(person.getLastName(), key -> {
                try {
                    return new BufferedWriter(new FileWriter(file, true));
                } catch (IOException e) {
                    throw new IllegalArgumentException("Ошибка при создании файла для фамилии " + key);
                }
            });

            // Считываем содержимое файла, если он существует
            StringBuilder content = new StringBuilder();
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();
            }

            // Дополняем содержимое новой строкой
            String newLine = String.format("%s %s %s %s %d %s%n",
                    person.getLastName(), person.getFirstName(), person.getMiddleName(),
                    person.getDateOfBirth(), person.getPhoneNumber(), person.getGender().toString().toLowerCase());
            content.append(newLine);

            // Записываем обновленное содержимое обратно в файл
            writer.write(content.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void close() {
        for (BufferedWriter writer : files.values()) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}