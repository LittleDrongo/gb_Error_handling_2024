package hw30;

/*
    Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:

    Фамилия Имя Отчество дата _ рождения номер _ телефона пол

    Форматы данных:
    Фамилия, имя, отчество - строки
    дата _ рождения - строка формата dd.mm.yyyy
    номер _ телефона - целое беззнаковое число без форматирования
    пол - символ латиницей f или m.

    Приложение должно проверить введенные данные по количеству. Если количество не совпадает, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

    Приложение должно распарсить полученную строку и выделить из них требуемые значения. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

    Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
    <Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>

    Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
    Не забудьте закрыть соединение с файлом.
    При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

    Данная промежуточная аттестация оценивается по системе "зачет" / "не зачет"
*/

import hw30.archive.PersonArchive;
import hw30.person.Gender;
import hw30.person.Person;

import java.io.BufferedWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        test2();
    }

    public static void test(){

        Person person2 = new Person("Фомин", "Алексей", "Валерьевич", LocalDate.of(1988,10,4), 8965716, Gender.MALE);
        System.out.println(person2);
        String input = "Иванов Иванов Иванович 01.01.1990 1234567890 f";
        Person person = Person.parseString(input);
        System.out.println(person);

    }

    public static void test2(){

        Map<String, BufferedWriter> files = new HashMap<>();
        PersonArchive archive = new PersonArchive(files);
        String input1 = "Иванов Иван Иванович 01.01.1990 1234567890 m";
        String input2 = "Петров Петр Петрович 02.02.1991 0987654321 m";
        String input3 = "Иванова Мария Ивановна 03.03.1992 1357924680 f";
        String input4 = "Иванов Игорь Петрович 04.04.1993 465153156 m";
        String input5 = "Иванов Игорь Петрович 04.04.1993 7777 m";

        archive.savePerson(Person.parseString(input1));
        archive.savePerson(Person.parseString(input2));
        archive.savePerson(Person.parseString(input3));
        archive.savePerson(Person.parseString(input4));
        archive.savePerson(Person.parseString(input5));

        archive.close();
    }
}
