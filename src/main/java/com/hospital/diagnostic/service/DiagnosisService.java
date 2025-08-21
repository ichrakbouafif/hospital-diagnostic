package com.hospital.diagnostic.service;

import com.hospital.diagnostic.model.PatientDiagnosis;

public class DiagnosisService {
    private final HealthIndexService healthIndexService;

    public DiagnosisService(HealthIndexService healthIndexService) {
        this.healthIndexService = healthIndexService;
    }

    public String processHealthIndex(int healthIndex) {
        PatientDiagnosis diagnosis = healthIndexService.analyzeHealthIndex(healthIndex);

        if (!diagnosis.hasConditions()) {
            return "Aucune pathologie détectée. Consultation générale recommandée.";
        }

        return diagnosis.getMedicalUnits();
    }
}
