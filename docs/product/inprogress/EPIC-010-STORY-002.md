# EPIC-010-STORY-002: Umbenennung der Java-Packages und Klassen

## User Story
Als Entwickler möchte ich die Java-Packages und relevanten Klassennamen von "kulturpfad" auf "fotopfad" umbenennen, damit der Code den neuen Service-Namen widerspiegelt.

## Beschreibung
Systematische Umbenennung aller Java-Packages, Klassen und Referenzen die "kulturpfad" enthalten auf "fotopfad". Dies betrifft hauptsächlich Package-Namen, Klassennamen und Import-Statements.

## Akzeptanzkriterien
- [ ] Package `de.illilli.kulturpfade` umbenannt in `de.illilli.fotopfade`
- [ ] Alle Java-Klassen mit "Kulturpfad" im Namen umbenannt (z.B. `KulturpfadeController` → `FotopfadeController`)
- [ ] Alle Import-Statements aktualisiert
- [ ] Alle Referenzen in Java-Code aktualisiert
- [ ] Verzeichnisstruktur unter `src/main/java` angepasst
- [ ] Verzeichnisstruktur unter `src/test/java` angepasst
- [ ] Code kompiliert fehlerfrei

## Technische Aufgaben
1. Package-Struktur umbenennen: `de/illilli/kulturpfade` → `de/illilli/fotopfade`
2. Klassennamen refactoren (z.B. KulturpfadeController, KulturpfadeService, etc.)
3. String-Literale mit "kulturpfad" prüfen und wo sinnvoll anpassen
4. Test-Klassen entsprechend umbenennen
5. Kompilierung testen: `mvn clean compile`

## Tasks
- EPIC-010-STORY-002-TASK-001 Projekt in IntelliJ IDEA öffnen
- EPIC-010-STORY-002-TASK-002 Package de.illilli.kulturpfade umbenennen
- EPIC-010-STORY-002-TASK-003 KulturpfadeController umbenennen
- EPIC-010-STORY-002-TASK-004 Verbleibende kulturpfad-Referenzen im Java-Code prüfen
- EPIC-010-STORY-002-TASK-005 Kompilierung nach Umbenennung prüfen

## Abhängigkeiten
- EPIC-010-STORY-001 (Repository muss existieren)

## Geschätzte Komplexität
M (2-4 Stunden)

## Status
To Do

## Notizen
- IDE-Refactoring-Tools nutzen (z.B. IntelliJ "Rename Package")
- Vorsicht bei String-Literalen: Nicht alle "kulturpfad" sollten ersetzt werden (z.B. in Daten/CSV)
- Test-Klassen müssen auch umbenannt werden
