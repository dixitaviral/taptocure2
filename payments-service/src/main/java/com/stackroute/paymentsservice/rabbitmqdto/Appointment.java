package com.stackroute.paymentsservice.rabbitmqdto;

import org.springframework.stereotype.Component;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Component
public class Appointment {
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

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public Patient getPatientDetails() {
		return patientDetails;
	}

	public void setPatientDetails(Patient patientDetails) {
		this.patientDetails = patientDetails;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate
				+ ", appointmentTime=" + appointmentTime + ", appointmentStatus=" + appointmentStatus
				+ ", patientDetails=" + patientDetails + "]";
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}

