package az.MyProject.SpringMVC.webmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class MyRuleValidator implements ConstraintValidator<MyRule, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value==null){
            return  false;
        }
        return value.startsWith("My");
    }
}
