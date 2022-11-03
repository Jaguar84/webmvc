package az.MyProject.SpringMVC.webmvc.controller;


import az.MyProject.SpringMVC.webmvc.model.Student;
import az.MyProject.SpringMVC.webmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(path = "/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/list")
    public String showstudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @GetMapping(path = "/list/param")
    public String showStudentsParam(Model model,
                                    @RequestParam(name = "student-name") String studentName,
                                    @RequestParam(name = "student-surename", required = false, defaultValue = "Kerimli") String studentsureName) {
        System.out.println("Student surename: " + studentsureName);
        List<Student> studentLists = studentService.findAll();
         List<Student> studentsListFiltered = new ArrayList<>();
        for (Student s : studentLists) {
            if (s.getName().equals(studentName)) {
                studentsListFiltered.add(s);
            }

        }


        model.addAttribute("students", studentsListFiltered);

        return "students";
    }

    @GetMapping(path = "/new")
    public String showAddStudentPage(Model model) {
        Student s = new Student();
        model.addAttribute("student", s);
       // s.setName("Nusret");
        return "save-student";
    }

    @PostMapping(path = "/save")
    public String saveStudent(@ModelAttribute(name="student") Student student){
        studentService.addStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteByIdStudentPage(@PathVariable(name="id") Integer id) {
        studentService.deleteById(id);
        return "redirect:/students/list";
    }

}
