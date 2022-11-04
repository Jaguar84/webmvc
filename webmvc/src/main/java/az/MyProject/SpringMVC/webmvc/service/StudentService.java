package az.MyProject.SpringMVC.webmvc.service;

import az.MyProject.SpringMVC.webmvc.model.Student;
import az.MyProject.SpringMVC.webmvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    private List<Student> studentLists = new ArrayList<>();

    {

        studentLists.add(new Student(1, "Nusret11", "Kerimov"));
        studentLists.add(new Student(2, "Fikret", "Kerimov"));
        studentLists.add(new Student(3, "Mensur", "Baxseliyev"));
        studentLists.add(new Student(4, "Qulu", "Kerimov"));


    }

    public void addStudent(Student student) {

        repository.addStudentDb(student);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public  void deleteById(Integer id){
        repository.deleteById(id);

    }

    public Student findById(Integer id){
      return repository.findById(id);

    }

    public void editStudent(Student student) {

        repository.editStudentDb(student);
    }
}
