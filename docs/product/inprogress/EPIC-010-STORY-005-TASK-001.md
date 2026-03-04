# EPIC-010-STORY-005-TASK-001: Vollständigen Maven-Build durchführen

## Zugehörige Story
EPIC-010-STORY-005 Build-Verifikation und Tests

## Beschreibung
Den vollständigen Maven-Build inkl. aller Tests ausführen und sicherstellen, dass keine Fehler auftreten.

## Technische Details
- `mvn clean package` führt: clean → compile → test-compile → test → package aus
- Abhängigkeiten: STORY-002 (Code), STORY-003 (Konfiguration) abgeschlossen

## Schritte
- [ ] In Projektverzeichnis wechseln: `cd /Users/wolfram/fotopfade/fotopfad-service`
- [ ] Vollständigen Build starten: `mvn clean package`
- [ ] Ausgabe überwachen – auf `ERROR` oder `FAILED` achten
- [ ] Erwartetes Ergebnis: `BUILD SUCCESS` mit allen Tests `Tests run: X, Failures: 0, Errors: 0`
- [ ] JAR-Datei prüfen: `ls -lh target/fotopfade-*.jar`
- [ ] Test-Reports prüfen: `ls target/surefire-reports/`
- [ ] Bei Fehlern: Fehlermeldung analysieren und beheben (Compile-Fehler, Package-Referenzen, etc.)

## Ergebnis
`mvn clean package` beendet mit `BUILD SUCCESS`. Alle Tests bestanden. JAR-Datei vorhanden.

## Status
Todo

## Aufwand
S
