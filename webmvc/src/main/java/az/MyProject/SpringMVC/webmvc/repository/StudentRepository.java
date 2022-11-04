package az.MyProject.SpringMVC.webmvc.repository;


import az.MyProject.SpringMVC.webmvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private DataSource dataSource;

    public void addStudentDb(Student student) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection
                    .prepareStatement("INSERT  into studentn (name, surename) values(?,?)");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSureName());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }


    public List<Student> findAll() {
        List<Student> students = new ArrayList<Student>();

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection
                    .prepareStatement("select * from studentn");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("surename"));
                students.add(student);
            }
            statement.close();
            connection.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return students;


    }


    public void deleteById(Integer id) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection
                    .prepareStatement("Delete from   studentn where id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public Student findById(Integer id) {
        Student student = null;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection
                    .prepareStatement("select * from studentn where id=?;");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                student = new Student(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("surename")
                );
            }
            result.close();
            statement.close();
            connection.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return student;

    }

    public void editStudentDb(Student student) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection
                    .prepareStatement("update  studentn set name=?, surename=? where id=?");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSureName());
            statement.setInt(3,student.getId());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }



}
