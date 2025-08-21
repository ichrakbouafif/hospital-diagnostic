package com.hospital.diagnostic.service;

import com.hospital.diagnostic.model.MedicalCondition;
import com.hospital.diagnostic.model.PatientDiagnosis;

import java.util.EnumSet;
import java.util.Set;

public class HealthIndexService {
    public PatientDiagnosis analyzeHealthIndex(int healthIndex) {
        if (healthIndex <= 0) {
            throw new IllegalArgumentException("Health index must be a positive integer");
        }

        Set<MedicalCondition> conditions = EnumSet.noneOf(MedicalCondition.class);

        if (isMultipleOf(healthIndex, 3)) {
            conditions.add(MedicalCondition.CARDIAC);
        }

        if (isMultipleOf(healthIndex, 5)) {
            conditions.add(MedicalCondition.FRACTURE);
        }

        return new PatientDiagnosis(healthIndex, conditions);
    }

    private boolean isMultipleOf(int number, int divisor) {
        return number % divisor == 0;
    }

}
