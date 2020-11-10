package test.task2.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private int id;
    private String firstName, lastName, middleName, studyGroup, dateOfBirth;

    public Student(int id, String firstName, String lastName, String middleName, String studyGroup, String dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.studyGroup = studyGroup;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }


    public String getStudyGroup() {
        return studyGroup;
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }


    @Override
    public String toString() {
        return "ID: " + getId() + " Student name: " + getFirstName() + " last name: " + getLastName() + " middle name : " + getMiddleName()
                + " date of birth: " + getDateOfBirth() + " study group: " + getStudyGroup();
    }
}
