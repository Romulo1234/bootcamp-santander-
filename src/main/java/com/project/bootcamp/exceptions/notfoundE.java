package com.project.bootcamp.exceptions;

import com.project.bootcamp.util.messageutil;

public class notfoundE extends RuntimeException{

    public notfoundE(){
        super(messageutil.NO_RECORDS_FOUND);
    }
}
