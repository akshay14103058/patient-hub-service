package com.patient.hub.common;

import com.patient.hub.entity.Patient;
import com.patient.hub.response.PatientResponse;

public class ResponseMapper {
    public static PatientResponse mapPatientResponse(Patient patient) {
        PatientResponse patientResponse = new PatientResponse();
        if(patient!=null) {
            patientResponse.setPatientId(patient.getPatientId());
            patientResponse.setAge(patient.getAge());
            patientResponse.setPatientFullName(patient.getFirstName() + " " + patient.getLastName());
            patientResponse.setPhone(patient.getPhone());
            return patientResponse;
        } else {
            patientResponse.setError("Patient not found");
        }
        return patientResponse;
    }
}
