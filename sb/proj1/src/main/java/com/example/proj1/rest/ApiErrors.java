package com.example.proj1.rest;


import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErrors {
    @Getter
    private List<String> errors;

    public ApiErrors (List<String> errors){
        this.errors=errors;
    }

    public ApiErrors (String m){
        this.errors = Arrays.asList(m);
    }
}
