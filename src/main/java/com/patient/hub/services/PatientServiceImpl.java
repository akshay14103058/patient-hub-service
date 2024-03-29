package com.patient.hub.services;

import com.patient.hub.common.exceptions.PatientNotFoundException;
import com.patient.hub.entity.Patient;
import com.patient.hub.repository.PatientRepository;
import com.patient.hub.request.PatientCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient createPatient(PatientCreationRequest request) {
        Patient patient = new Patient(request.getFirstName(), request.getLastName(), request.getAge());
        patient.setPhone(request.getPhone());
        patientRepository.updatePatient(patient);
        return patient;
    }

    @Override
    public Patient getPatientDetails(UUID patientId) throws PatientNotFoundException {
        Patient patient = patientRepository.getPatient(patientId);
        if (patient == null) {
            throw new PatientNotFoundException("P-001", "Patient does not exist with given id");
        }
        return patient;
    }

    @Override
    public Patient updatePatientDetails(Patient patient) {
        return null;
    }

    @Override
    public void deletePatient(UUID patientId) {
        patientRepository.deletePatient(patientId);
    }
}
