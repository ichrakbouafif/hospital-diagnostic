package com.hospital.diagnostic;

import com.hospital.diagnostic.service.DiagnosisService;
import com.hospital.diagnostic.service.HealthIndexService;

public class HealthIndexProcessor {
    private final DiagnosisService diagnosisService;

    public HealthIndexProcessor() {
        this.diagnosisService = new DiagnosisService(new HealthIndexService());
    }

    public HealthIndexProcessor(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    public String process(int healthIndex) {
        try {
            return diagnosisService.processHealthIndex(healthIndex);
        } catch (IllegalArgumentException e) {
            return "Erreur: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java HealthIndexProcessor <health_index>");
            return;
        }

        try {
            int healthIndex = Integer.parseInt(args[0]);
            HealthIndexProcessor processor = new HealthIndexProcessor();
            String result = processor.process(healthIndex);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Erreur: L'index de santé doit être un nombre entier");
        }
    }
}
