package com.stackroute.appointmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Component
@NoArgsConstructor
//@AllArgsConstructor
@Data
@Entity(name = "appointment_detail")
public class Appointment {
    @Id
    private int appointmentId;
    private String appointmentDate;
    private String appointmentTime;

    // enum reference: for custom status values
    private AppointmentStatus appointmentStatus = AppointmentStatus.AVAILABLE;

    @OneToOne
    @JoinColumn(name = "patientId") // name= "primary key of second table"
    private Patient patientDetails;

    //int clinicId;

    public Appointment(int appointmentId, Patient patient) {
        this.appointmentId = appointmentId;
        this.patientDetails = patient;
    }

    public Appointment(int appointmentId, String appointmentDate, String appointmentTime, AppointmentStatus appointmentStatus, Patient patientDetails) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentStatus = appointmentStatus;
        this.patientDetails = patientDetails;
    }
}

