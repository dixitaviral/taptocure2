package com.stackroute.emailservice.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
 private String recipient;
 private String subject;
 private String message;

}
