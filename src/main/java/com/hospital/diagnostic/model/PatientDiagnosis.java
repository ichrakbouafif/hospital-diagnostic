package com.hospital.diagnostic.model;

import java.util.Set;
import java.util.stream.Collectors;

public class PatientDiagnosis {
    private final int healthIndex;
    private final Set<MedicalCondition> conditions;

    public PatientDiagnosis(int healthIndex, Set<MedicalCondition> conditions) {
        this.healthIndex = healthIndex;
        this.conditions = conditions;
    }

    public int getHealthIndex() {
        return healthIndex;
    }

    public Set<MedicalCondition> getConditions() {
        return conditions;
    }

    public String getMedicalUnits() {
        return conditions.stream()
                .map(MedicalCondition::getMedicalUnit)
                .collect(Collectors.joining(", "));
    }

    public boolean hasConditions() {
        return !conditions.isEmpty();
    }
}
