package com.hospital.diagnostic.model;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

public class PatientDiagnosisTest {
    @Test
    void getMedicalUnits_ShouldReturnCorrectFormat_ForSingleCondition() {
        PatientDiagnosis diagnosis = new PatientDiagnosis(3,
                EnumSet.of(MedicalCondition.CARDIAC));

        assertEquals("Cardiologie", diagnosis.getMedicalUnits());
    }

    @Test
    void getMedicalUnits_ShouldReturnCorrectFormat_ForMultipleConditions() {
        PatientDiagnosis diagnosis = new PatientDiagnosis(15,
                EnumSet.of(MedicalCondition.CARDIAC, MedicalCondition.FRACTURE));

        assertEquals("Cardiologie, Traumatologie", diagnosis.getMedicalUnits());
    }

    @Test
    void hasConditions_ShouldReturnFalse_WhenNoConditions() {
        PatientDiagnosis diagnosis = new PatientDiagnosis(1, EnumSet.noneOf(MedicalCondition.class));
        assertFalse(diagnosis.hasConditions());
    }

    @Test
    void hasConditions_ShouldReturnTrue_WhenConditionsPresent() {
        PatientDiagnosis diagnosis = new PatientDiagnosis(3,
                EnumSet.of(MedicalCondition.CARDIAC));
        assertTrue(diagnosis.hasConditions());
    }


}
