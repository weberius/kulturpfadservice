# EPIC-010-STORY-002-TASK-001: Projekt in IntelliJ IDEA öffnen

## Zugehörige Story
EPIC-010-STORY-002 Umbenennung der Java-Packages und Klassen

## Beschreibung
Das neue fotopfad-service-Projekt in IntelliJ IDEA öffnen, damit die IDE-Refactoring-Werkzeuge genutzt werden können.

## Technische Details
- IntelliJ IDEA als IDE, da Maven-Refactoring-Unterstützung notwendig
- Projekt muss vollständig indexiert sein bevor Refactoring startet
- Abhängigkeit: EPIC-010-STORY-001-TASK-005 (Initiales Commit) abgeschlossen

## Schritte
- [ ] IntelliJ IDEA öffnen
- [ ] `File > Open` → `/Users/wolfram/fotopfade/fotopfad-service` wählen
- [ ] Warten bis Maven-Import und Indexierung abgeschlossen (Progress-Bar unten rechts)
- [ ] Prüfen ob `pom.xml` korrekt erkannt wurde (Projekt-View zeigt Source-Sets)
- [ ] Maven-Tool-Window öffnen (`View > Tool Windows > Maven`) und Struktur prüfen

## Ergebnis
Projekt ist in IntelliJ vollständig geladen und indexiert. Refactoring-Tools sind verfügbar.

## Status
Todo

## Aufwand
XS
