package com.patient.hub.services;

import com.patient.hub.common.exceptions.PatientNotFoundException;
import com.patient.hub.entity.Patient;
import com.patient.hub.request.PatientCreationRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface PatientService {
    Patient createPatient(PatientCreationRequest request);

    Patient getPatientDetails(UUID patientId) throws PatientNotFoundException;

    Patient updatePatientDetails(Patient patient);

    void deletePatient(UUID PatientId);
}
