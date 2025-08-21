# Health Index Processor

Système d'auto-diagnostic pour cabine médicale automatisée.

## Fonctionnalités

- Analyse l'index de santé des patients
- Détecte les pathologies cardiaques (multiples de 3)
- Détecte les fractures (multiples de 5)
- Redirige vers les unités médicales appropriées

## Utilisation

```bash
java -cp target/hospital-diagnostic-1.0-SNAPSHOT.jar com.hospital.diagnostic.HealthIndexProcessor <health_index>
