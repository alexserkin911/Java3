package lesson2;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public interface StudentsDao {

    boolean studentExists(int id) throws SQLException;

    Student getStudentById(int id) throws SQLException;

    void updateStudent (Student student) throws SQLException;

    List<Student> getAllStudents() throws SQLException;
}
