# EPIC-010-STORY-005-TASK-002: Service starten und Erreichbarkeit prüfen

## Zugehörige Story
EPIC-010-STORY-005 Build-Verifikation und Tests

## Beschreibung
Den fotopfad-service lokal starten und sicherstellen, dass er erreichbar ist und korrekt funktioniert.

## Technische Details
- Service läuft standardmäßig auf Port 8080 (prüfen in application.yaml)
- GraphHopper-Cache muss eventuell neu initialisiert werden (liegt in `osm/germany-latest-cache/`)
- Die Daten (CSV-Dateien) sind bereits im Projekt und müssen nicht neu geladen werden
- Abhängigkeit: TASK-001 (Build) muss erfolgreich sein

## Schritte
- [ ] Service starten: `mvn spring-boot:run`
- [ ] Log-Output beobachten – auf `Started Application` oder `Tomcat started on port` warten
- [ ] Auf Fehler im Start-Log achten (DB-Verbindung, GraphHopper-Cache, Datei-Laden)
- [ ] In neuem Terminal: Erreichbarkeit prüfen:
  `curl -s http://localhost:8080/api/` (oder bekannten Endpunkt)
- [ ] Beispiel-Request ausführen (einen POI-Pfad abrufen):
  `curl -s "http://localhost:8080/..." | head -50`
- [ ] Log-Output auf Errors/Warnings prüfen
- [ ] Service ordnungsgemäß beenden: `Ctrl+C` in Terminal

## Ergebnis
Service startet fehlerfrei, ist auf Port 8080 erreichbar und beantwortet Anfragen korrekt.

## Status
Todo

## Aufwand
S
