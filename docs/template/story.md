# EPIC-001-STORY-002: Bilder per REST hochladen

## Zugehöriges EPIC
EPIC-001 Image Backend Basis

## User Story
Als **Nutzer / System**
möchte ich **Bilder hochladen**
damit **sie gespeichert und angezeigt werden können**.

## Akzeptanzkriterien
- POST /api/images akzeptiert Multipart-Upload
- Erfolgreiche Antwort enthält Bild-ID
- Fehlerhafte Uploads werden sauber behandelt

## Technische Hinweise
- Kotlin Backend
- Speicherung zunächst im Dateisystem
- Keine Authentifizierung

## Abhängigkeiten
- Kotlin-Projekt existiert
- Basis-Controller vorhanden

## Tasks
- EPIC-001-STORY-002-TASK-001 REST-Endpoint anlegen
- EPIC-001-STORY-002-TASK-002 Multipart konfigurieren
- EPIC-001-STORY-002-TASK-003 Datei speichern

## Status
Backlog | Todo | In Progress | Done