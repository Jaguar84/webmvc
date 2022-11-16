package az.MyProject.SpringMVC.webmvc.repository;


import az.MyProject.SpringMVC.webmvc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface StudentRepositoryJPA  extends JpaRepository<Student, Integer> {
    List<Student> findAllByName(String name);

    @Query(value = "select * from studentn where name like %?1%", nativeQuery = true)
    List<Student> searchStudentByName(String name);
}
