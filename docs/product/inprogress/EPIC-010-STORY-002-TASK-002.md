# EPIC-010-STORY-002-TASK-002: Package de.illilli.kulturpfade umbenennen

## Zugehörige Story
EPIC-010-STORY-002 Umbenennung der Java-Packages und Klassen

## Beschreibung
Das Java-Package `de.illilli.kulturpfade` via IntelliJ-Refactoring in `de.illilli.fotopfade` umbenennen. Dabei werden automatisch alle Package-Deklarationen, Import-Statements und Verzeichnisstrukturen in `src/main/java` **und** `src/test/java` angepasst.

## Technische Details
- IntelliJ "Rename Package"-Refactoring passt gleichzeitig an:
  - Verzeichnisstruktur auf Dateisystem
  - `package`-Deklaration in allen `.java`-Dateien
  - `import`-Statements in allen Dateien die das Package referenzieren
- Betrifft **alle** Java-Klassen (main und test):
  - `Application.java`, `BuildGraphHopperCache.java`
  - `controller/KulturpfadeController.java`
  - `model/Culturalpath.java`, `DataTable.java`, `Gallery.java`, `POI.java`, `RoutingData.java`
  - `repository/JdbcRepository.java`, `PoiJdbcRepository.java`, `PoiValuesRepository.java`
  - `services/*.java` (8 Klassen)
  - Test-Klassen: `ApplicationIntegrationTest.java`, `KulturpfadeControllerIntegrationTest.java`, etc.

## Schritte
- [ ] Im Project-View das Package `de.illilli.kulturpfade` (unter `src/main/java`) rechtsklicken
- [ ] `Refactor > Rename` wählen
- [ ] Neuer Name: `fotopfade` eingeben (nur letztes Segment, IntelliJ merkt sich den Prefix)
- [ ] Option „Search in comments and strings" **deaktivieren** (CSV-Daten nicht anfassen)
- [ ] Preview anzeigen lassen und Änderungen prüfen
- [ ] `Refactor` bestätigen
- [ ] Warten bis Refactoring abgeschlossen ist
- [ ] Im Project-View prüfen: `de/illilli/fotopfade` erscheint in main und test

## Ergebnis
Package-Verzeichnisse lauten `de/illilli/fotopfade`. Alle `package`- und `import`-Statements in Java-Dateien sind aktualisiert.

## Status
Todo

## Aufwand
S
