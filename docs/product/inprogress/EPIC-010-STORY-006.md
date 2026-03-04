# EPIC-010-STORY-006: GitHub-Repository erstellen und pushen

## User Story
Als Entwickler möchte ich den fotopfad-service auf GitHub veröffentlichen, damit der Code versioniert und online verfügbar ist.

## Beschreibung
Erstelle ein neues GitHub-Repository für den fotopfad-service und pushe die vollständige Codebasis. Konfiguriere das Repository mit sinnvollen Einstellungen und verknüpfe es mit dem lokalen Git-Repository.

## Akzeptanzkriterien
- [ ] Neues GitHub-Repository erstellt (z.B. `github.com/yourusername/fotopfad-service`)
- [ ] Repository-Beschreibung und Topics gesetzt
- [ ] Lokales Git-Repository mit GitHub verknüpft: `git remote add origin ...`
- [ ] Vollständiger Code gepusht: `git push -u origin main` (oder `master`)
- [ ] README.md wird auf GitHub korrekt angezeigt
- [ ] .gitignore funktioniert (target/, .idea/, etc. nicht eingecheckt)
- [ ] Alle Branches gepusht (falls vorhanden)
- [ ] Optional: GitHub Actions / CI-Pipeline konfiguriert

## Technische Aufgaben
1. GitHub-Repository erstellen (via Web-Interface oder GitHub CLI)
2. Remote hinzufügen: `git remote add origin git@github.com:username/fotopfad-service.git`
3. Branch prüfen/umbenennen falls nötig: `git branch -M main`
4. Initial Push: `git push -u origin main`
5. Repository-Settings konfigurieren:
   - Description hinzufügen
   - Topics hinzufügen (z.B. java, spring-boot, poi, routing)
   - Wiki/Issues nach Bedarf aktivieren
6. README auf GitHub verifizieren
7. Optional: Branch-Protection-Rules setzen

## Tasks
- EPIC-010-STORY-006-TASK-001 GitHub-Repository erstellen
- EPIC-010-STORY-006-TASK-002 Remote-URL konfigurieren und pushen
- EPIC-010-STORY-006-TASK-003 GitHub-Repository-Einstellungen konfigurieren

## Abhängigkeiten
- EPIC-010-STORY-001 (Git-Repository muss initialisiert sein)
- EPIC-010-STORY-002 (Code-Umbenennung abgeschlossen)
- EPIC-010-STORY-003 (Konfiguration angepasst)
- EPIC-010-STORY-004 (Dokumentation aktualisiert)
- EPIC-010-STORY-005 (Build erfolgreich, alles funktioniert)

## Geschätzte Komplexität
XS (< 1 Stunde)

## Status
To Do

## Notizen
- SSH-Keys für GitHub müssen konfiguriert sein
- Überlegen ob eine GitHub Actions CI/CD-Pipeline sinnvoll ist
- Eventuell ein initiales Release (v0.1.0) taggen
- .gitignore prüfen bevor gepusht wird
- Sensible Daten (API-Keys, Credentials) dürfen nicht committed werden
