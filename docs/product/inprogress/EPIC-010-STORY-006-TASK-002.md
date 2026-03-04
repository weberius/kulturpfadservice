# EPIC-010-STORY-006-TASK-002: Remote-URL konfigurieren und pushen

## Zugehörige Story
EPIC-010-STORY-006 GitHub-Repository erstellen und pushen

## Beschreibung
Das lokale Git-Repository mit dem neu erstellten GitHub-Repository verbinden und alle Commits pushen.

## Technische Details
- SSH-Authentifizierung wird vorausgesetzt (SSH-Key für GitHub konfiguriert)
- Remote-Name: `origin` (Standard)
- Branch: `main`
- Abhängigkeit: TASK-001 (GitHub-Repository muss existieren)

## Schritte
- [ ] In Projektverzeichnis wechseln: `cd /Users/wolfram/fotopfade/fotopfad-service`
- [ ] Remote hinzufügen (URL von GitHub-Task-001 übernehmen):
  `git remote add origin git@github.com:<username>/fotopfad-service.git`
- [ ] Remote prüfen: `git remote -v`
- [ ] Initialen Push durchführen:
  `git push -u origin main`
- [ ] Ausgabe prüfen: `Branch 'main' set up to track remote branch 'main' from 'origin'`
- [ ] GitHub-Seite im Browser neu laden und Inhalt prüfen:
  - Alle Commits sichtbar?
  - README.md wird angezeigt?
  - Dateien vollständig?

## Ergebnis
Alle lokalen Commits sind auf GitHub verfügbar. `git push` (ohne weitere Optionen) funktioniert.

## Status
Todo

## Aufwand
XS
