package lesson2;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        StudentPostgresDao studentDAO = new StudentPostgresDao();

        try (studentDAO) {
            // Получаем студента по ID
            Student student = studentDAO.getStudentById(1);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("Студент с таким ID не найден.");
            }


            // Получаем всех студентов
            List<Student> allStudents = studentDAO.getAllStudents();
            for (Student s : allStudents) {
                System.out.println(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Student student = studentDAO.getStudentById(1);
        Student st = studentDAO.getStudentById(1);
        assert student != null;
        student.setGroup(2);
        student.setSurName("Sergei");
        studentDAO.updateStudent(student);

    }


}
