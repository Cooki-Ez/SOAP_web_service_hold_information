package services;

import java.util.Date;
import java.util.Objects;

public class Person {
    private String FirstName;
    private String Surname;
    private Date BirthDate;

    public Person() {
    }

    public Person(String firstName, String surname, Date birthDate) {
        FirstName = firstName;
        Surname = surname;
        BirthDate = birthDate;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getSurname() {
        return Surname;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Surname.equals(person.Surname) &&
                BirthDate.equals(person.BirthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Surname, BirthDate);
    }

    @Override
    public String toString() {
        return "Person{" +
                "FirstName='" + FirstName + '\'' +
                ", Surname='" + Surname + '\'' +
                ", BirthDate=" + BirthDate +
                '}';
    }
}
