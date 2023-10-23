package com.techproeducation.backendproject.initialwork.controller;

import com.techproeducation.backendproject.initialwork.entity.ContactMessage;
import com.techproeducation.backendproject.initialwork.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages") //http://localhost:8070/
public class ContactMessageController {
    @Autowired
    private ContactMessageService contactMessageService; // objesini oluşturduk

    @PostMapping
     public ResponseEntity<String> sendMessage(@RequestBody ContactMessage contactMessage){

        contactMessageService.saveMessage(contactMessage);

        String message = "Message is saved succesfully";

        return new ResponseEntity<>(message, HttpStatus.CREATED);


    }

}
