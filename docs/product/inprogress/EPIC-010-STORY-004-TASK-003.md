# EPIC-010-STORY-004-TASK-003: AsciiDoc-Dokumentation neu generieren

## Zugehörige Story
EPIC-010-STORY-004 Dokumentation aktualisieren

## Beschreibung
Nach der Aktualisierung der AsciiDoc-Quelldateien die HTML-Dokumentation neu generieren, damit `docs/` und `target/generated-docs/` auf dem aktuellen Stand sind.

## Technische Details
- Maven-Plugin `asciidoctor-maven-plugin` generiert HTML aus den `.adoc`-Dateien
- Output landet in `target/generated-docs/`
- Die Kopien in `docs/` müssen ggf. manuell aktualisiert werden
- Abhängigkeit: TASK-002 muss abgeschlossen sein

## Schritte
- [ ] In Projektverzeichnis wechseln: `cd /Users/wolfram/fotopfade/fotopfad-service`
- [ ] Dokumentation generieren: `mvn generate-resources`
- [ ] Ausgabe prüfen: `BUILD SUCCESS` erwartet
- [ ] Generierte Dateien prüfen: `ls target/generated-docs/`
- [ ] Generierte HTML-Dateien auf korrekten Inhalt (fotopfad-service) prüfen: z.B. `grep fotopfad target/generated-docs/main.html`
- [ ] Falls `docs/`-Verzeichnis manuell gepflegt wird: HTML-Dateien nach `docs/` kopieren
- [ ] Änderungen committen:
  `git add src/main/asciidoc/ docs/ README.md && git commit -m "docs: update documentation for fotopfad-service"`

## Ergebnis
Generierte HTML-Dokumentation in `target/generated-docs/` und `docs/` ist aktuell und bezieht sich auf fotopfad-service.

## Status
Todo

## Aufwand
XS
