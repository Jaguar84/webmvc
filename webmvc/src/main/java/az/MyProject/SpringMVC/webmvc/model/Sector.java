package az.MyProject.SpringMVC.webmvc.model;


import lombok.*;

import javax.persistence.*;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sectors")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String name;
}
