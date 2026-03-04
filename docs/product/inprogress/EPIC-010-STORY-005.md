# EPIC-010-STORY-005: Build-Verifikation und Tests

## User Story
Als Entwickler möchte ich sicherstellen, dass der fotopfad-service vollständig funktionsfähig ist, indem alle Tests erfolgreich durchlaufen und der Service lokal startet.

## Beschreibung
Vollständige Verifikation der Build- und Runtime-Funktionalität des neuen fotopfad-service. Dies umfasst Maven-Build, Unit-Tests, Integration-Tests und einen erfolgreichen Service-Start.

## Akzeptanzkriterien
- [ ] Maven Clean Build erfolgreich: `mvn clean package`
- [ ] Alle Unit-Tests erfolgreich: Tests in `src/test/java` laufen durch
- [ ] Alle Integration-Tests erfolgreich
- [ ] Keine Compiler-Warnings oder -Errors
- [ ] Service startet lokal: `mvn spring-boot:run`
- [ ] Service ist erreichbar (z.B. auf http://localhost:8080)
- [ ] Health-Check Endpoint antwortet (falls vorhanden)
- [ ] Beispiel-Request funktioniert (z.B. GET auf einen POI-Endpoint)
- [ ] Log-Output zeigt keine Errors

## Technische Aufgaben
1. Clean Build durchführen: `mvn clean package`
2. Test-Report prüfen: `target/surefire-reports/`
3. JAR-Datei prüfen: `target/fotopfade-*.jar`
4. Service starten: `mvn spring-boot:run`
5. Endpoints testen:
   - curl http://localhost:8080/actuator/health (falls vorhanden)
   - curl http://localhost:8080/api/... (POI-Endpoints)
6. Log-Output analysieren
7. Service ordnungsgemäß beenden

## Tasks
- EPIC-010-STORY-005-TASK-001 Vollständigen Maven-Build durchführen
- EPIC-010-STORY-005-TASK-002 Service starten und Erreichbarkeit prüfen
- EPIC-010-STORY-005-TASK-003 Test-Ergebnisse dokumentieren und committen

## Abhängigkeiten
- EPIC-010-STORY-001 (Repository muss existieren)
- EPIC-010-STORY-002 (Code muss umbenannt sein)
- EPIC-010-STORY-003 (Konfiguration muss angepasst sein)

## Geschätzte Komplexität
S (1-2 Stunden)

## Status
To Do

## Notizen
- Eventuell müssen Test-Daten angepasst werden
- Prüfen ob alle CSV/GPX-Dateien noch korrekt geladen werden
- GraphHopper-Cache muss eventuell neu generiert werden
- Dokumentieren welche Endpoints getestet wurden
