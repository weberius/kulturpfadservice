# EPIC-010: Fotopfad-Service

## Ziel
Erstellung eines neuen Service "fotopfad-service" basierend auf dem bestehenden kulturpfadservice als neue Entwicklungsbasis. Nach Abschluss existieren zwei parallel lauffähige Services mit identischer Funktionalität, wobei die Weiterentwicklung ausschließlich im fotopfad-service stattfindet.

## Kontext
Der kulturpfadservice hat sich als stabile Basis erwiesen. Um die weitere Entwicklung zu fokussieren und eine klare Trennung zwischen stabilem Service und Weiterentwicklung zu schaffen, wird der fotopfad-service als Fork/Kopie angelegt. Der kulturpfadservice bleibt als Referenzimplementierung bestehen, wird aber perspektivisch nicht weiter entwickelt.

Der fotopfad-service wird als eigenständiges GitHub-Repository eingecheckt und dient als Ausgangspunkt für neue Features und Weiterentwicklungen.

## Abgrenzung
Was ist explizit **nicht** Teil dieses EPICs:
- Migration bestehender produktiver Instanzen vom kulturpfadservice zum fotopfad-service
- Funktionale Erweiterungen oder neue Features im fotopfad-service (erfolgt in späteren EPICs)
- Änderungen oder Wartung am kulturpfadservice nach der Erstellung des fotopfad-service
- Deprecation-Prozess oder Abschaltung des kulturpfadservice

## Zugehörige ADRs
- (noch keine spezifischen ADRs)

## Erfolgsdefinition (Definition of Done)
- fotopfad-service Repository auf GitHub erstellt
- Vollständiger Code vom kulturpfadservice übertragen
- Build läuft erfolgreich durch (mvn clean package)
- Service startet lokal (mvn spring-boot:run)
- Alle Tests laufen erfolgreich durch
- README.md angepasst mit neuem Service-Namen
- Initiales Git-Repository eingecheckt und gepusht
- Dokumentation aktualisiert (Projektname, Beschreibungen)

## Stories
- EPIC-010-STORY-001 Repository-Setup und initiales Commit
- EPIC-010-STORY-002 Umbenennung der Java-Packages und Klassen
- EPIC-010-STORY-003 Anpassung der Konfigurationsdateien (pom.xml, application.yaml)
- EPIC-010-STORY-004 Dokumentation aktualisieren (README, AsciiDoc)
- EPIC-010-STORY-005 Build-Verifikation und Tests
- EPIC-010-STORY-006 GitHub-Repository erstellen und pushen

## Risiken / Offene Fragen
- Naming-Konventionen: Wie konsistent muss der fotopfad-Service umbenannt werden?
- Dependencies: Müssen externe Abhängigkeiten angepasst werden?
- Datenmigration: Werden bestehende Daten/Pfade vom kulturpfadservice übernommen?
- Deployment: Wo und wie wird der fotopfad-service deployed?

## Status
In Progress

## Owner
(optional)

## Datum
2026-03-04
