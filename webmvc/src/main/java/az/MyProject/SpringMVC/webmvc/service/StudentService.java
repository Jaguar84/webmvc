package az.MyProject.SpringMVC.webmvc.service;

import az.MyProject.SpringMVC.webmvc.model.Sector;
import az.MyProject.SpringMVC.webmvc.model.Student;
import az.MyProject.SpringMVC.webmvc.repository.SectorRepository;
import az.MyProject.SpringMVC.webmvc.repository.StudentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepositoryJPA studentRepositoryJPA;



    // private StudentRepository repository;

    private List<Student> studentLists = new ArrayList<>();

    {

        studentLists.add(new Student(1, "Nusret11", "Kerimov"));
        studentLists.add(new Student(2, "Fikret", "Kerimov"));
        studentLists.add(new Student(3, "Mensur", "Baxseliyev"));
        studentLists.add(new Student(4, "Qulu", "Kerimov"));


    }

    public void addStudent(Student student) {

        studentRepositoryJPA.save(student);
    }

    public List<Student> findAll() {

        List<Student> students= studentRepositoryJPA.findAll();

        for( Student student : students){
            if(student.getSector()==null){
                student.setSector(new Sector());
            }
        }
        return students;
    }

    public  boolean deleteById(Integer id){

        boolean studentExits=studentRepositoryJPA.findById(id).isPresent();

        if(studentExits){
            studentRepositoryJPA.deleteById(id);
            return true;
        }else {
            return  false;
        }


    }

    public Student findById(Integer id){
      return studentRepositoryJPA.findById(id).get();

    }

    public void editStudent(Student student) {

      studentRepositoryJPA.save(student);
    }

    public  List<Student> findAllSearch(String name){;
      // return studentRepositoryJPA.findAllByName(name);
      //  return studentRepositoryJPA.searchStudentByName(name);
        return null;
    }
}
