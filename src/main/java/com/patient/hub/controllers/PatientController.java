package com.patient.hub.controllers;

import com.patient.hub.common.ResponseMapper;
import com.patient.hub.common.exceptions.PatientNotFoundException;
import com.patient.hub.entity.Patient;
import com.patient.hub.request.PatientCreationRequest;
import com.patient.hub.response.PatientResponse;
import com.patient.hub.services.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    private Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

    @RequestMapping(value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<PatientResponse> createPatient(@RequestBody PatientCreationRequest request) {
        try {
            Patient patient = patientService.createPatient(request);
            return new ResponseEntity<>(ResponseMapper.mapPatientResponse(patient), HttpStatus.CREATED);
        } catch (Exception ex) {
            LOGGER.error("Error occurred while creating patient");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{patientId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public ResponseEntity<PatientResponse> getPatient(@PathVariable("patientId") UUID patientId) {
        try {
            Patient patient = patientService.getPatientDetails(patientId);
            return new ResponseEntity<>(ResponseMapper.mapPatientResponse(patient), HttpStatus.OK);
        } catch (PatientNotFoundException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            LOGGER.error("Error occurred while getting patient details");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{patientId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable UUID patientId, @RequestBody Patient patient) {
        try {
            Patient updatedPatient = patientService.updatePatientDetails(patient);
            return new ResponseEntity<>(new PatientResponse(), HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("Error occurred while updating patient details");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{patientId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePatient(@PathVariable("patientId") UUID patientId) {
        try {
            patientService.deletePatient(patientId);
            return new ResponseEntity<>(patientId.toString(), HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("Error occurred while deleting patient details");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


}
