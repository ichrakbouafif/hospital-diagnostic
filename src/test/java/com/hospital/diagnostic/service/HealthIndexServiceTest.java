package com.hospital.diagnostic.service;

import com.hospital.diagnostic.model.MedicalCondition;
import com.hospital.diagnostic.model.PatientDiagnosis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class HealthIndexServiceTest {
    private HealthIndexService healthIndexService;

    @BeforeEach
    void setUp() {
        healthIndexService = new HealthIndexService();
    }

    @Test
    void analyzeHealthIndex_ShouldThrowException_WhenNegativeIndex() {
        assertThrows(IllegalArgumentException.class,
                () -> healthIndexService.analyzeHealthIndex(-1));
    }

    @Test
    void analyzeHealthIndex_ShouldThrowException_WhenZeroIndex() {
        assertThrows(IllegalArgumentException.class,
                () -> healthIndexService.analyzeHealthIndex(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 33})
    void analyzeHealthIndex_ShouldDetectCardiac_WhenMultipleOf3(int index) {
        PatientDiagnosis diagnosis = healthIndexService.analyzeHealthIndex(index);
        assertTrue(diagnosis.getConditions().contains(MedicalCondition.CARDIAC));
        assertEquals(1, diagnosis.getConditions().size());
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 55})
    void analyzeHealthIndex_ShouldDetectFracture_WhenMultipleOf5(int index) {
        PatientDiagnosis diagnosis = healthIndexService.analyzeHealthIndex(index);
        assertTrue(diagnosis.getConditions().contains(MedicalCondition.FRACTURE));
        assertEquals(1, diagnosis.getConditions().size());
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60})
    void analyzeHealthIndex_ShouldDetectBoth_WhenMultipleOf3And5(int index) {
        PatientDiagnosis diagnosis = healthIndexService.analyzeHealthIndex(index);
        assertTrue(diagnosis.getConditions().contains(MedicalCondition.CARDIAC));
        assertTrue(diagnosis.getConditions().contains(MedicalCondition.FRACTURE));
        assertEquals(2, diagnosis.getConditions().size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 7, 8})
    void analyzeHealthIndex_ShouldDetectNoCondition_WhenNotMultipleOf3Or5(int index) {
        PatientDiagnosis diagnosis = healthIndexService.analyzeHealthIndex(index);
        assertTrue(diagnosis.getConditions().isEmpty());
    }
}
