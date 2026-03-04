# EPIC-010-STORY-001-TASK-003: .gitignore prüfen und anpassen

## Zugehörige Story
EPIC-010-STORY-001 Repository-Setup und initiales Commit

## Beschreibung
Die kopierte `.gitignore`-Datei prüfen und sicherstellen, dass alle relevanten Verzeichnisse und Dateien korrekt ausgeschlossen werden.

## Technische Details
- `target/` muss ausgeschlossen sein
- `.idea/` (IntelliJ) sollte ausgeschlossen sein
- `*.class` sollte ausgeschlossen sein
- `osm/germany-latest.osm.pbf` wegen Dateigröße prüfen (ggf. ausschließen)
- `osm/germany-latest-cache/` wegen Dateigröße ausschließen

## Schritte
- [ ] .gitignore öffnen: `cat /Users/wolfram/fotopfade/fotopfad-service/.gitignore`
- [ ] Folgende Einträge prüfen/ergänzen:
  - `target/`
  - `.idea/`
  - `*.iml`
  - `osm/germany-latest.osm.pbf`
  - `osm/germany-latest-cache/`
- [ ] .gitignore bei Bedarf ergänzen
- [ ] Dateigrößen der OSM-Daten prüfen: `du -sh /Users/wolfram/fotopfade/fotopfad-service/osm/`

## Ergebnis
`.gitignore` verhindert, dass große und generierte Dateien ins Repository gelangen.

## Status
Todo

## Aufwand
XS
