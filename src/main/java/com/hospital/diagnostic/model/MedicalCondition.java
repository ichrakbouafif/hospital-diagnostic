package com.hospital.diagnostic.model;

public enum MedicalCondition {
    CARDIAC("Cardiologie"),
    FRACTURE("Traumatologie");

    private final String medicalUnit;

    MedicalCondition(String medicalUnit) {
        this.medicalUnit = medicalUnit;
    }

    public String getMedicalUnit() {
        return medicalUnit;
    }
}
