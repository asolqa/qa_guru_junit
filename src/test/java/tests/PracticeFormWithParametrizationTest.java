package tests;

import data.Student;
import data.StudentData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.PracticeFormPageObjects;

import java.util.stream.Stream;


public class PracticeFormWithParametrizationTest extends TestBase {

    PracticeFormPageObjects practiceFormPage = new PracticeFormPageObjects();

    @Tag("slow")
    @ParameterizedTest
    @CsvFileSource(resources = "/students_data.csv")
    @DisplayName("Проверка заполнения всех полей формы данными из csv файла")
    void csvFileParametrizedTest(ArgumentsAccessor data) {
        Student student = studentFromData(data);

        practiceFormPage.openPage()
                .setFirstName(student.getFirstname())
                .setLastName(student.getLastname())
                .setEmail(student.getEmail())
                .setGender(student.getGender())
                .setNumber(student.getUserPhone())
                .setDateOfBirth(student.getDayOfBirth(), student.getMonthOfBirth(), student.getYearOfBirth())
                .setSubject(student.getSubject())
                .setHobbies(student.getHobby())
                .uploadFile(student.getAvatar())
                .setAddress(student.getAddress())
                .setState(student.getState())
                .setCity(student.getCity())
                .submitForm();

        //Assertions
        practiceFormPage.checkResult("Student Name", student.getFirstname() + " " + student.getLastname())
                .checkResult("Student Email", student.getEmail())
                .checkResult("Gender", student.getGender())
                .checkResult("Mobile", student.getUserPhone())
                .checkResult("Date of Birth", student.getDateOfBirthPrettified())
                .checkResult("Subjects", student.getSubject())
                .checkResult("Hobbies", student.getHobby())
                .checkResult("Picture", student.getAvatar())
                .checkResult("Address", student.getAddress())
                .checkResult("State and City", student.getState() + " " + student.getCity());
    }

    private Student studentFromData(ArgumentsAccessor data) {
        Student student = new Student();

        student.setFirstname(data.getString(0));
        student.setLastname(data.getString(1));
        student.setEmail(data.getString(2));
        student.setGender(data.getString(3));
        student.setUserPhone(data.getString(4));
        student.setDayOfBirth(data.getString(5));
        student.setMonthOfBirth(data.getString(6));
        student.setYearOfBirth(data.getString(7));
        student.setSubject(data.getString(8));
        student.setHobby(data.getString(9));
        student.setAddress(data.getString(10));
        student.setState(data.getString(11));
        student.setCity(data.getString(12));
        student.setAvatar(data.getString(13));

        return student;
    }

    @ParameterizedTest
    @MethodSource("students")
    @DisplayName("Проверка заполнения всех полей формы данными метода")
    void methodSourceParametrizeTest(Student student) {
        practiceFormPage.openPage()
                .setFirstName(student.getFirstname())
                .setLastName(student.getLastname())
                .setEmail(student.getEmail())
                .setGender(student.getGender())
                .setNumber(student.getUserPhone())
                .setDateOfBirth(student.getDayOfBirth(), student.getMonthOfBirth(), student.getYearOfBirth())
                .setSubject(student.getSubject())
                .setHobbies(student.getHobby())
                .uploadFile(student.getAvatar())
                .setAddress(student.getAddress())
                .setState(student.getState())
                .setCity(student.getCity())
                .submitForm();

        //Assertions
        practiceFormPage.checkResult("Student Name", student.getFirstname() + " " + student.getLastname())
                .checkResult("Student Email", student.getEmail())
                .checkResult("Gender", student.getGender())
                .checkResult("Mobile", student.getUserPhone())
                .checkResult("Date of Birth", student.getDateOfBirthPrettified())
                .checkResult("Subjects", student.getSubject())
                .checkResult("Hobbies", student.getHobby())
                .checkResult("Picture", student.getAvatar())
                .checkResult("Address", student.getAddress())
                .checkResult("State and City", student.getState() + " " + student.getCity());
    }

    private static Stream<Arguments> students() {
        return Stream.of(
                Arguments.of(StudentData.Laddy_Simonis()),
                Arguments.of(StudentData.Felton_McGlynn())
        );
    }


}
