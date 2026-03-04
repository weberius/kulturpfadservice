# EPIC-010-STORY-003-TASK-004: Build verifizieren und JAR-Dateiname prüfen

## Zugehörige Story
EPIC-010-STORY-003 Anpassung der Konfigurationsdateien

## Beschreibung
Maven-Build ausführen und sicherstellen, dass das Build-Artefakt den korrekten neuen Namen trägt. Änderungen committen.

## Technische Details
- Erwarteter JAR-Name nach Umbenennung: `fotopfade-0.1.0-SNAPSHOT.jar`
- `mvn clean package` baut, testet und paketiert
- Abhängigkeit: TASK-001 und TASK-002 müssen abgeschlossen sein

## Schritte
- [ ] In Projektverzeichnis wechseln: `cd /Users/wolfram/fotopfade/fotopfad-service`
- [ ] Build ausführen: `mvn clean package -DskipTests`
- [ ] Ausgabe prüfen: `BUILD SUCCESS` erwartet
- [ ] JAR-Datei prüfen: `ls target/*.jar`
- [ ] Erwarteter Dateiname: `fotopfade-0.1.0-SNAPSHOT.jar`
- [ ] Falls falscher Name: `<finalName>`-Eintrag in pom.xml prüfen und ergänzen
- [ ] Build-Änderungen committen:
  `git add pom.xml src/main/resources/application.yaml *.sh && git commit -m "config: rename service to fotopfad-service"`

## Ergebnis
`target/fotopfade-0.1.0-SNAPSHOT.jar` existiert. Konfigurationsänderungen sind committet.

## Status
Todo

## Aufwand
XS
