package az.MyProject.SpringMVC.webmvc.repository;

import az.MyProject.SpringMVC.webmvc.model.Sector;
import az.MyProject.SpringMVC.webmvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface SectorRepository  extends JpaRepository<Sector, Integer> {

}

