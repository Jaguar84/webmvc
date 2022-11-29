package az.MyProject.SpringMVC.webmvc.repository;

import az.MyProject.SpringMVC.webmvc.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepositoryJPA extends JpaRepository<Language, Integer> {
}
