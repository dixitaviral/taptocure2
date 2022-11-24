package com.stackroute.appointmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "appointment_detail")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;
    private String appointmentDate;
    private String appointmentTime;
    // enum reference: for custom status values
    private AppointmentStatus appointmentStatus = AppointmentStatus.AVAILABLE;

    @OneToOne
    @JoinColumn(name = "patientId") // name= "primary key of second table"
    private Patient patientDetails;
}

