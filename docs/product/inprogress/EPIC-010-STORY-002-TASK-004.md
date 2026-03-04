# EPIC-010-STORY-002-TASK-004: Verbleibende kulturpfad-Referenzen im Java-Code prüfen

## Zugehörige Story
EPIC-010-STORY-002 Umbenennung der Java-Packages und Klassen

## Beschreibung
Nach dem IDE-Refactoring eine manuelle Suche nach verbleibenden „kulturpfad"-Vorkommen im Java-Code durchführen und entscheiden, welche angepasst werden sollen.

## Technische Details
- String-Literale (z.B. in Log-Ausgaben, Kommentare) wurden vom IDE-Refactoring nicht automatisch geändert
- Nicht alle Vorkommen müssen ersetzt werden: CSV-Dateinamen, Datenpfade und historische Kommentare bleiben ggf. bestehen
- Klasse `Culturalpath.java` prüfen: Name ist englisch und muss ggf. **nicht** geändert werden

## Schritte
- [ ] IntelliJ `Find in Files` öffnen: `Cmd+Shift+F`
- [ ] Suche nach `kulturpfad` (case-insensitive) auf `src/main/java` und `src/test/java` beschränken
- [ ] Treffer analysieren:
  - Kommentare: ggf. anpassen
  - Log-Meldungen (z.B. `logger.info("Kulturpfade loaded")`) → auf `Fotopfad` anpassen
  - Annotationen / RequestMapping-Werte prüfen
- [ ] `Culturalpath.java`: Prüfen ob Umbenennung in `Fotopfad.java` sinnvoll ist (im Rahmen dieser Story belassen)
- [ ] Alle gewünschten Änderungen durchführen
- [ ] Ergebnisse notieren (was geändert, was bewusst belassen)

## Ergebnis
Keine unbeabsichtigten `kulturpfad`-Referenzen mehr im Java-Quellcode. Bewusst beibehaltene Vorkommen sind dokumentiert.

## Status
Todo

## Aufwand
S
