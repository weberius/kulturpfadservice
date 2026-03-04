# EPIC-010-STORY-004-TASK-002: AsciiDoc-Dateien aktualisieren

## Zugehörige Story
EPIC-010-STORY-004 Dokumentation aktualisieren

## Beschreibung
Alle AsciiDoc-Quelldateien in `src/main/asciidoc/` auf den neuen Service-Namen aktualisieren.

## Technische Details
Vorhandene AsciiDoc-Dateien:
- `main.adoc` (Hauptdokument)
- `preface.adoc`
- `01_interfaces.adoc`
- `02_data.adoc`
- `05_ui.adoc`
- `08_test.adoc`
- `09_documentation.adoc`
- `bibliography.adoc`

## Schritte
- [ ] Vorkommen suchen: `grep -r "kulturpfad\|Kulturpfad\|kulturpfadservice" src/main/asciidoc/`
- [ ] `main.adoc` öffnen: Titel und Haupt-Überschrift anpassen
- [ ] `preface.adoc` öffnen: Projektbeschreibung aktualisieren
- [ ] `01_interfaces.adoc`: Endpunkt-Beschreibungen prüfen (Package-Namen in Code-Blöcken)
- [ ] `02_data.adoc`: Datenmodell-Referenzen prüfen
- [ ] Weitere Dateien auf `kulturpfad`-Nennungen durchsuchen und anpassen
- [ ] Alle Änderungen speichern

## Ergebnis
Alle AsciiDoc-Dateien nennen korrekt `fotopfad-service`. Keine veralteten `kulturpfad`-Referenzen im Fließtext.

## Status
Todo

## Aufwand
S
