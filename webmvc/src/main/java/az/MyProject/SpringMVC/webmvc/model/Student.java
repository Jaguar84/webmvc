package az.MyProject.SpringMVC.webmvc.model;


import az.MyProject.SpringMVC.webmvc.validation.MyRule;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;


//@AllArgsConstructor
@Data
@Getter
@Setter
//@NoArgsConstructor
@Table(name = "studentn")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotEmpty(message = "Ad xanasin boş buraxmaq olmaz")
    @Size(min=3, message = "Ad minimum 2 simvol olmalidir!!")
    @Size(max = 10, message = "Ad maksimum 10 simvol olmalidir")
    private String name;

    @NotNull
    @NotEmpty(message = "Ad xanasin boş buraxmaq olmaz")
    @Size(min=3, message = "Ad minimum 2 simvol olmalidir!!")
    @Size(max = 10, message = "Ad maksimum 10 simvol olmalidir")
    private String sureName;

    //@NotNull
    //@NotEmpty(message = "sinif xanasin boş buraxmaq olmaz")
    @Min(value = 1, message = "Minimum sinif 1 dir")
    @Max(value = 11, message ="Maksimum sinif 11 dir")
    private Integer studentClass;

    @Past(message = "Tarixi keçmiş zamanda olmalıdır.")
    private Date birthday;

    @Pattern(regexp = "[a-z0-9]+@[a-z0-9]+\\.[a-z]{2,4}",message = "Emaili duzgun daxil edin")
    private String email;

    @MyRule()
    private String courseCode;

    @Pattern(regexp ="[0-9]{3}-[0-9]{3}-[0-9]{4}", message = "Telefon nomresin duzgun daxil edin")
    private  String phone;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private  Sector sector;
//    public Integer getStudentClass() {
//        return studentClass;
//    }
//
//    public void setStudentClass(Integer studentClass) {
//        this.studentClass = studentClass;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Student(Integer id, String name, String sureName, Integer studentClass) {
        this.id = id;
        this.name = name;
        this.sureName = sureName;
        this.studentClass = studentClass;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSureName() {
//        return sureName;
//    }
//
//    public void setSureName(String sureName) {
//        this.sureName = sureName;
//    }


    public Student(){}

    public Student(Integer id, String name, String sureName) {
        this.id = id;
        this.name = name;
        this.sureName = sureName;
    }


    public Student(Integer id, String name, String sureName, Integer studentClass, Date birthday) {
        this.id = id;
        this.name = name;
        this.sureName = sureName;
        this.studentClass = studentClass;
        this.birthday = birthday;
    }

//    public Date getBirthday() {
//        return birthday;
//    }
//
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }

    public Student(Integer id, String name, String sureName, Integer studentClass, Date birthday, String email) {
        this.id = id;
        this.name = name;
        this.sureName = sureName;
        this.studentClass = studentClass;
        this.birthday = birthday;
        this.email = email;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public Student(Integer id, String name, String sureName, Integer studentClass, Date birthday, String email, String courseCode) {
        this.id = id;
        this.name = name;
        this.sureName = sureName;
        this.studentClass = studentClass;
        this.birthday = birthday;
        this.email = email;
        this.courseCode = courseCode;
    }


//    public String getCourseCode() {
//        return courseCode;
//    }
//
//    public void setCourseCode(String courseCode) {
//        this.courseCode = courseCode;
//    }


    public Student(Integer id, String name, String sureName, Integer studentClass, Date birthday, String email, String courseCode, String phone) {
        this.id = id;
        this.name = name;
        this.sureName = sureName;
        this.studentClass = studentClass;
        this.birthday = birthday;
        this.email = email;
        this.courseCode = courseCode;
        this.phone = phone;
    }
}

