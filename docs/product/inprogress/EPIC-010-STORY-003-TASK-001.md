# EPIC-010-STORY-003-TASK-001: pom.xml anpassen

## Zugehörige Story
EPIC-010-STORY-003 Anpassung der Konfigurationsdateien

## Beschreibung
Die `pom.xml` des fotopfad-service mit dem neuen Projektnamen, Artefakt-ID und Beschreibung aktualisieren.

## Technische Details
Aktuelle Werte in der pom.xml (vom kulturpfadservice):
- `<artifactId>kulturpfade</artifactId>`
- `<name>routingservice</name>`
- `<description>Service for routing georeferenced points to a path for walking</description>`

Neue Werte:
- `<artifactId>fotopfade</artifactId>`
- `<name>fotopfad-service</name>`
- `<description>Service for photo-guided routing and walking paths (Fork of kulturpfadservice)</description>`

## Schritte
- [ ] pom.xml öffnen: `/Users/wolfram/fotopfade/fotopfad-service/pom.xml`
- [ ] `<artifactId>kulturpfade</artifactId>` → `<artifactId>fotopfade</artifactId>`
- [ ] `<name>routingservice</name>` → `<name>fotopfad-service</name>`
- [ ] `<description>` entsprechend anpassen
- [ ] Prüfen ob ein `<finalName>` im `<build>`-Abschnitt existiert – falls ja, ebenfalls anpassen
- [ ] Datei speichern
- [ ] In IntelliJ: Maven-Reload bestätigen wenn gefragt (`Load Maven Changes`)

## Ergebnis
`pom.xml` enthält `fotopfade` als artifactId und `fotopfad-service` als Projektname.

## Status
Todo

## Aufwand
XS
