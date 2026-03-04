# EPIC-010-STORY-003: Anpassung der Konfigurationsdateien

## User Story
Als Entwickler möchte ich alle Konfigurationsdateien (pom.xml, application.yaml, etc.) an den neuen Service-Namen anpassen, damit das Projekt korrekt als fotopfad-service gebaut und ausgeführt wird.

## Beschreibung
Aktualisierung aller projektbezogenen Konfigurationsdateien mit dem neuen Service-Namen. Dies umfasst Maven-Konfiguration, Spring Boot-Konfiguration und Build-Artefakte.

## Akzeptanzkriterien
- [ ] `pom.xml` aktualisiert:
  - `<artifactId>` auf `fotopfade` oder `fotopfad-service` geändert
  - `<name>` und `<description>` angepasst
  - Build-Output-Name aktualisiert
- [ ] `application.yaml` / `application.properties` angepasst:
  - `spring.application.name` auf `fotopfad-service` geändert
  - Eventuelle Pfad-Referenzen geprüft und aktualisiert
- [ ] `.gitignore` geprüft und bei Bedarf angepasst
- [ ] Eventuelle Shell-Scripts (.sh Dateien) geprüft
- [ ] Maven build erzeugt korrektes Artefakt (fotopfade-*.jar)

## Technische Aufgaben
1. pom.xml editieren:
   - artifactId, name, description
   - finalName im build-Abschnitt
2. application.yaml editieren:
   - spring.application.name
   - logging-Konfiguration prüfen
3. Shell-Scripts prüfen und ggf. anpassen
4. Build testen: `mvn clean package`
5. JAR-Namen verifizieren im target/ Verzeichnis

## Tasks
- EPIC-010-STORY-003-TASK-001 pom.xml anpassen
- EPIC-010-STORY-003-TASK-002 application.yaml anpassen
- EPIC-010-STORY-003-TASK-003 Shell-Scripts prüfen und anpassen
- EPIC-010-STORY-003-TASK-004 Build verifizieren und JAR-Dateiname prüfen

## Abhängigkeiten
- EPIC-010-STORY-001 (Repository muss existieren)
- Idealerweise nach EPIC-010-STORY-002 (damit Package-Namen konsistent sind)

## Geschätzte Komplexität
S (1-2 Stunden)

## Status
To Do

## Notizen
- Prüfen ob es weitere Konfigurationsdateien gibt (z.B. in resources/)
- Docker-Konfiguration falls vorhanden
- CI/CD-Konfiguration falls vorhanden
