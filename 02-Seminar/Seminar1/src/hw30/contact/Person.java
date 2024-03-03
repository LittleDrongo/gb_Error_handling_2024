package hw30.contact;

import java.time.LocalDate;

public class Person {

    String lastName;
    String firstName;
    String middleName;
    LocalDate dateOfBirth;
    String phoneNumber;
    Gender gender;

    public Person(String lastName, String firstName, String middleName, LocalDate dateOfBirth, String phoneNumber, Gender gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public static Person parseString(String input) {
        String[] parts = input.split(" ");

        // Фамилия, имя, отчество
        String lastName = parts[0];
        String firstName = parts[1];
        String middleName = parts[2];

        // Дата рождения
        String[] dateParts = parts[3].split("\\.");
        LocalDate dateOfBirth = LocalDate.of(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[0]));

        // Номер телефона
        String phoneNumber = parts[4];

        // Пол
        Gender gender = parts[5].equalsIgnoreCase("f") ? Gender.FEMALE : Gender.MALE;

        return new Person(lastName, firstName, middleName, dateOfBirth, phoneNumber, gender);
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                '}';
    }
}