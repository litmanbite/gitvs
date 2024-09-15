package com.example.proj1.validation;

import java.util.List;
import com.example.proj1.validation.notEmptyList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class constraintValidation implements ConstraintValidator<notEmptyList,List>{

    @Override
    public boolean isValid(List list, ConstraintValidatorContext context) {
        return list != null && !list.isEmpty();
    }

    
    public void inicialize(notEmptyList constraintAnotation){
    }
}
