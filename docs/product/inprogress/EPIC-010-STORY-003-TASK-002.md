# EPIC-010-STORY-003-TASK-002: application.yaml anpassen

## Zugehörige Story
EPIC-010-STORY-003 Anpassung der Konfigurationsdateien

## Beschreibung
Die `application.yaml` (Spring Boot Konfiguration) auf den neuen Service-Namen aktualisieren und alle Konfigurationsreferenzen die auf `kulturpfad` verweisen anpassen.

## Technische Details
- Datei liegt unter `src/main/resources/application.yaml`
- Testressourcen prüfen: `src/test/resources/` (falls vorhanden)
- `spring.application.name` ist der primäre Änderungspunkt

## Schritte
- [ ] application.yaml öffnen: `src/main/resources/application.yaml`
- [ ] `spring.application.name` prüfen und auf `fotopfad-service` setzen
- [ ] Alle weiteren Einträge auf `kulturpfad`-Referenzen durchsuchen
- [ ] Dateinamen-Referenzen (CSV-Pfade, etc.) prüfen – diese beziehen sich auf Datenpfade und sollten **nicht** geändert werden
- [ ] Logging-Konfiguration prüfen (z.B. Logger-Namen)
- [ ] Prüfen ob `src/test/resources/` eine eigene `application.yaml` oder `application-test.yaml` hat
- [ ] Test-Ressourcen ebenfalls anpassen falls vorhanden
- [ ] Änderungen speichern

## Ergebnis
`spring.application.name` ist auf `fotopfad-service` gesetzt. Keine unbeabsichtigten kulturpfad-Referenzen in YAML-Konfiguration.

## Status
Todo

## Aufwand
XS
