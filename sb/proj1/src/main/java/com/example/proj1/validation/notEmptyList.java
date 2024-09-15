package com.example.proj1.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = constraintValidation.class)
public @interface notEmptyList {

    String m() default "A lista nao pode ser vazia";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};

} 
