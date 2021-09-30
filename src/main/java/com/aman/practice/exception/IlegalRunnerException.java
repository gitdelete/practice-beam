package com.aman.practice.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IlegalRunnerException extends RuntimeException{

    public IlegalRunnerException(String message){
        super(message);
    }

}
