package com.techproeducation.backendproject.initialwork.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactMessage {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="id", nullable = false)
    private Long id;

    @NotNull (message = "Name can not be null.") //bu anatationsların görevi validation (doğrulama) nayapmak
    @NotBlank (message = "Name can not be blank.")
    @NotEmpty(message = "Name can not be empty.")
    private String name;


    @NotNull (message = "Email can not be null.")
    @NotBlank (message = "Email can not be blank.")
    @NotEmpty(message = "Email can not be empty.")
    @Email
    private String email;

    @NotNull (message = "Subject can not be null.")
    @NotBlank (message = "Subject can not be blank.")
    @NotEmpty(message = "Subject can not be empty.")
    private String subject;

    @NotNull (message = "Message can not be null.")
    @NotBlank (message = "Message can not be blank.")
    @NotEmpty(message = "Message can not be empty.")
    private String message;

    //private LocalDateTime localDateTime = LocalDateTime.now();

    @Setter(AccessLevel.NONE)
    private String creationDateTime;

    @PrePersist
    private void setDateTime(){
        
        ZoneId zoneid = ZoneId.of("America/New_York");
        LocalDateTime creationDate = LocalDateTime.now(zoneid);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        creationDateTime =creationDate.format(dateTimeFormatter);
    }

}
