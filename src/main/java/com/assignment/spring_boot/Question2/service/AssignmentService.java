package com.assignment.spring_boot.Question2.service;

import com.assignment.spring_boot.Question2.configuration.AssignmentProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {
    @Autowired
    AssignmentProperty assignmentProperty;

    public String getService(){
        return assignmentProperty.getMyProperty() +" this is from service layer";
    }

}
