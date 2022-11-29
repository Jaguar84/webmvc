package az.MyProject.SpringMVC.webmvc.controller;


import az.MyProject.SpringMVC.webmvc.model.Student;
import az.MyProject.SpringMVC.webmvc.repository.LanguageRepositoryJPA;
import az.MyProject.SpringMVC.webmvc.repository.SectorRepository;
import az.MyProject.SpringMVC.webmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import javax.naming.Binding;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(path = "/students")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private LanguageRepositoryJPA languageRepositoryJPA;

    @GetMapping(path = "/list")
    @PreAuthorize(value = "hasAuthority('read:all:students')")
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
    @PreAuthorize(value = "hasAuthority('open:new:student:page')")
    public String showAddStudentPage(Model model) {
        Student s = new Student();
        s.setId(0);
        model.addAttribute("student", s);
        model.addAttribute("header","Tələbə qeydiyyatı");
        model.addAttribute("sectors",sectorRepository.findAll());
        model.addAttribute("languages",languageRepositoryJPA.findAll());
       // s.setName("Nusret");
        return "save-student";
    }

    @PostMapping(path = "/save")
    @PreAuthorize(value = "hasAuthority('save:student')")
    public String saveStudent(@Valid @ModelAttribute(name="student") Student student, BindingResult result, Model model){
       if(result.hasErrors()){
           model.addAttribute("header","Tələbə qeydiyyatı");
           return "save-student";
       }else{
           model.addAttribute("header","Tələbə məlumatlarının redaktəsi");
       }
        if(student.getId()==0){
            studentService.addStudent(student);
        }else if(student.getId()>0){
            studentService.editStudent(student);
        }

        return "redirect:/students/list";
    }

    @GetMapping(path = "/delete/{id}")
    @PreAuthorize(value = "hasAuthority('delete:student')")
    public String deleteByIdStudentPage(@PathVariable(name="id") Integer id, Model model) {
        boolean result=studentService.deleteById(id);
        if(!result){
            model.addAttribute("errorMessage", "Telebe tapilmadi Id"+id);
            return "error";
        }


        studentService.deleteById(id);
        return "redirect:/students/list";
    }

    @GetMapping(path = "/edit/{id}")
    @PreAuthorize(value = "hasAuthority('edit:student')")
    public String showEditStudentPage(@PathVariable(name="id") Integer id, Model model) {
        Student student=studentService.findById(id);
        model.addAttribute("student", student);
        model.addAttribute("header","Tələbə məlumatlarının redaktəsi");
        model.addAttribute("sectors",sectorRepository.findAll());
        model.addAttribute("languages",languageRepositoryJPA.findAll());
        return "save-student";
    }

    @InitBinder
    public  void  initBinder(WebDataBinder binder){
        StringTrimmerEditor trimmerEditor=new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, trimmerEditor);
    }

    @GetMapping(path = "/list/search")
    @PreAuthorize(value = "hasAuthority('search:student')")
    public String searchStudent(@RequestParam(name = "studentName") String studentName, Model model){
        model.addAttribute("students",studentService.findAllSearch(studentName));
        return "students";
    }
}
