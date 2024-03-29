package com.patient.hub.entity;

import java.util.Date;

public class PatientHealthRecord {
    private long id;
    private String visitId;
    private String doctorFullName;
    private Date visitDate;
    private String visitPurpose;
    private String prescriptionDocumentLink;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitPurpose() {
        return visitPurpose;
    }

    public void setVisitPurpose(String visitPurpose) {
        this.visitPurpose = visitPurpose;
    }

    public String getPrescriptionDocumentLink() {
        return prescriptionDocumentLink;
    }

    public void setPrescriptionDocumentLink(String prescriptionDocumentLink) {
        this.prescriptionDocumentLink = prescriptionDocumentLink;
    }
}