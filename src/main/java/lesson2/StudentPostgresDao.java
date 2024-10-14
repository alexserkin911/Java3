package lesson2;

import java.io.Closeable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentPostgresDao implements StudentsDao, Closeable {

    private final Connection connection;
    private final Statement statement;

    public StudentPostgresDao() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myjavadb", "postgres", "qwerty");
        statement = connection.createStatement();
    }

    @Override
    public boolean studentExists(int id) throws SQLException {
        String sql = String.format("SELECT ID FROM STUDENTS WHERE ID = %d", id);
        ResultSet rs = statement.executeQuery(sql);
        return rs.next();
    }

    @Override
    public Student getStudentById(int id) throws SQLException {
        Student student = new Student(0, null, null, null, 0);
        String sql = String.format("SELECT * FROM STUDENTS WHERE ID = %d", id);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            student.setId(resultSet.getInt("ID"));
            student.setName(resultSet.getString("NAME"));
            student.setSurName(resultSet.getString("SURNAME"));
            student.setBirthDate(resultSet.getDate("BIRTH_DATE").toLocalDate());
            student.setGroup(resultSet.getInt("GROUP_ID"));
        }
        return student;
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        String sql;
        if (student.getId() != 0 && studentExists(student.getId())) {
            sql = String.format("UPDATE STUDENTS SET NAME = '%s', SURNAME = '%s', " + "BIRTH_DATE = '%s', GROUP_ID = %d WHERE ID = %d",
                    student.getName(),
                    student.getSurName(),
                    Date.valueOf(student.getBirthDate()),
                    student.getGroup(),
                    student.getId());
        } else {
            sql = String.format("INSERT INTO STUDENTS (NAME, SURNAME, BIRTH_DATE, GROUP_ID) " + "VALUES ('%s', '%s', '%s', %d)",
                    student.getName(),
                    student.getSurName(),
                    Date.valueOf(student.getBirthDate()),
                    student.getId());
        }
        statement.execute(sql);
    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Student student = new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getDate("birth_date").toLocalDate(),
                    resultSet.getInt("group_id"));
            students.add(student);
        }

        return students;
    }

    @Override
    public void close() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
