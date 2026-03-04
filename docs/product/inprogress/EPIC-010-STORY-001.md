# EPIC-010-STORY-001: Repository-Setup und initiales Commit

## User Story
Als Entwickler möchte ich ein neues lokales Repository für den fotopfad-service erstellen, damit ich die Codebasis unabhängig vom kulturpfadservice verwalten kann.

## Beschreibung
Erstelle ein neues Verzeichnis für den fotopfad-service und kopiere die gesamte Codebasis vom kulturpfadservice. Initialisiere ein neues Git-Repository und erstelle ein erstes Commit mit dem ursprünglichen Stand.

## Akzeptanzkriterien
- [ ] Neues Verzeichnis `/Users/wolfram/fotopfade/fotopfad-service` erstellt
- [ ] Vollständige Codebasis vom kulturpfadservice kopiert (inkl. `.gitignore`, aber ohne `.git` Verzeichnis)
- [ ] Git-Repository initialisiert (`git init`)
- [ ] Alle Dateien zum ersten Commit hinzugefügt
- [ ] Erstes Commit mit aussagekräftiger Commit-Message erstellt
- [ ] Projekt-Struktur ist identisch mit kulturpfadservice

## Technische Aufgaben
1. Verzeichnis erstellen: `mkdir /Users/wolfram/fotopfade/fotopfad-service`
2. Dateien kopieren (ohne .git): `rsync -av --exclude='.git' --exclude='target' kulturpfadservice/ fotopfad-service/`
3. Git initialisieren: `cd fotopfad-service && git init`
4. Initial commit: `git add . && git commit -m "Initial commit: Fork from kulturpfadservice"`

## Tasks
- EPIC-010-STORY-001-TASK-001 Zielverzeichnis erstellen
- EPIC-010-STORY-001-TASK-002 Codebasis kopieren
- EPIC-010-STORY-001-TASK-003 .gitignore prüfen und anpassen
- EPIC-010-STORY-001-TASK-004 Git-Repository initialisieren
- EPIC-010-STORY-001-TASK-005 Initiales Commit erstellen

## Abhängigkeiten
Keine

## Geschätzte Komplexität
XS (< 1 Stunde)

## Status
To Do

## Notizen
- Das `target` Verzeichnis sollte nicht kopiert werden (wird neu gebaut)
- Die `.git` History wird nicht übernommen (fresh start)
- Original kulturpfadservice bleibt unverändert
