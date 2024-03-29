package com.patient.hub.repository;

import com.patient.hub.entity.Patient;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class PatientRepository {

    private Map<UUID,Patient> patientCache = new HashMap<>();

    @Cacheable("patients")
    public Patient updatePatient(Patient patient) {
        patientCache.put(patient.getPatientId(),patient);
        return patient;
    }

    @Cacheable("patients")
    public Patient getPatient(UUID patientId) {
        return patientCache.get(patientId);
    }

    @CacheEvict("patients")
    public Patient deletePatient(UUID patientId) {
        return patientCache.remove(patientId);
    }
}
