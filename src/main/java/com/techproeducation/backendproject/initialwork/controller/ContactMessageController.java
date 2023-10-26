package com.techproeducation.backendproject.initialwork.controller;

import com.techproeducation.backendproject.initialwork.entity.ContactMessage;
import com.techproeducation.backendproject.initialwork.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//endpointlerin bu classta olduğunu söyleyen bi anotation -- crud(create,read,update,delete) operationsların olduğunu belirtir.
@RequestMapping("/messages") //http://localhost:8070/ //  "/messages")--> endpoint
public class ContactMessageController {
    @Autowired
    private ContactMessageService contactMessageService; // objesini oluşturduk

    @PostMapping //create  //PostMapping database de obje oluşturmaya yarar.
    public ResponseEntity<Map<String, String>> sendMessage(@RequestBody @Valid ContactMessage contactMessage) {
        contactMessageService.saveMessage(contactMessage);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Message is saved succesfully");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactMessage>> getAllContactMessages() {
        List<ContactMessage> contactMessageList = contactMessageService.getAllMessages();
        return new ResponseEntity<>(contactMessageList, HttpStatus.OK);


    }
}
