package com.patient.hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {
        "com.patient.hub"
})
public class PatientHubApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(PatientHubApplication.class, args);
    }
}