# EPIC-010-STORY-002-TASK-003: KulturpfadeController umbenennen

## Zugehörige Story
EPIC-010-STORY-002 Umbenennung der Java-Packages und Klassen

## Beschreibung
Die Klasse `KulturpfadeController` in `FotopfadeController` umbenennen sowie den dazugehörigen Integration-Test `KulturpfadeControllerIntegrationTest` entsprechend anpassen.

## Technische Details
- Umbenennung via IntelliJ `Refactor > Rename` (passt Klassen-Datei, Deklaration und alle Referenzen an)
- Betrifft:
  - `src/main/java/de/illilli/fotopfade/controller/KulturpfadeController.java` → `FotopfadeController.java`
  - `src/test/java/de/illilli/fotopfade/controller/KulturpfadeControllerIntegrationTest.java` → `FotopfadeControllerIntegrationTest.java`
- Abhängigkeit: TASK-002 (Package muss bereits umbenannt sein)

## Schritte
- [ ] Datei `KulturpfadeController.java` im Project-View markieren
- [ ] `Refactor > Rename` (Shift+F6) wählen
- [ ] Neuer Klassenname: `FotopfadeController`
- [ ] Bestätigen und Refactoring-Preview prüfen
- [ ] `Refactor` ausführen
- [ ] Datei `KulturpfadeControllerIntegrationTest.java` markieren
- [ ] `Refactor > Rename` → `FotopfadeControllerIntegrationTest`
- [ ] Bestätigen und ausführen
- [ ] Prüfen: Beide Dateien haben neuen Namen, keine Referenzen auf alten Namen

## Ergebnis
`FotopfadeController.java` und `FotopfadeControllerIntegrationTest.java` existieren. Keine Referenzen auf `KulturpfadeController` mehr vorhanden.

## Status
Todo

## Aufwand
XS
