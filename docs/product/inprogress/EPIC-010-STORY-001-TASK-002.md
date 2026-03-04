# EPIC-010-STORY-001-TASK-002: Codebasis kopieren

## Zugehörige Story
EPIC-010-STORY-001 Repository-Setup und initiales Commit

## Beschreibung
Vollständige Kopie aller Projektdateien vom kulturpfadservice ins neue fotopfad-service-Verzeichnis. Dabei werden `.git` und `target` explizit ausgeschlossen.

## Technische Details
- `rsync` mit Exclude-Filtern verwenden
- `.git`-Verzeichnis wird **nicht** kopiert (frischer Git-Start)
- `target`-Verzeichnis wird **nicht** kopiert (wird neu gebaut)
- Alle anderen Dateien inkl. Hidden-Files (.gitignore, etc.) werden kopiert

## Schritte
- [ ] In das fotopfade-Verzeichnis wechseln: `cd /Users/wolfram/fotopfade`
- [ ] Kopie durchführen:
  ```
  rsync -av --exclude='.git' --exclude='target' kulturpfadservice/ fotopfad-service/
  ```
- [ ] Vollständigkeit prüfen: `ls -la fotopfad-service/`
- [ ] Prüfen ob src/ Verzeichnis übertragen wurde: `ls fotopfad-service/src/`
- [ ] Prüfen ob pom.xml vorhanden: `ls fotopfad-service/pom.xml`
- [ ] Prüfen ob .gitignore vorhanden: `ls -la fotopfad-service/.gitignore`

## Ergebnis
Alle Projektdateien (außer .git und target) liegen in `/Users/wolfram/fotopfade/fotopfad-service`.

## Status
Todo

## Aufwand
XS
