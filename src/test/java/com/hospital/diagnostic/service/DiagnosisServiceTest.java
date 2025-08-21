package com.hospital.diagnostic.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagnosisServiceTest {
    private DiagnosisService diagnosisService;

    @BeforeEach
    void setUp() {
        HealthIndexService healthIndexService = new HealthIndexService();
        diagnosisService = new DiagnosisService(healthIndexService);
    }

    @Test
    void processHealthIndex_ShouldReturnCardiology_ForCardiacCondition() {
        String result = diagnosisService.processHealthIndex(3);
        assertEquals("Cardiologie", result);
    }

    @Test
    void processHealthIndex_ShouldReturnTraumatology_ForFractureCondition() {
        String result = diagnosisService.processHealthIndex(5);
        assertEquals("Traumatologie", result);
    }

    @Test
    void processHealthIndex_ShouldReturnBoth_ForMultipleConditions() {
        String result = diagnosisService.processHealthIndex(15);
        assertEquals("Cardiologie, Traumatologie", result);
    }

    @Test
    void processHealthIndex_ShouldReturnNoPathologyMessage_ForNoConditions() {
        String result = diagnosisService.processHealthIndex(1);
        assertEquals("Aucune pathologie détectée. Consultation générale recommandée.", result);
    }
}
