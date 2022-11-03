package az.MyProject.SpringMVC.webmvc.model;

public class Student {
    private Integer id;
    private String name;
    private String sureName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public Student(){}
    public Student(Integer id, String name, String sureName) {
        this.id = id;
        this.name = name;
        this.sureName = sureName;
    }
}
