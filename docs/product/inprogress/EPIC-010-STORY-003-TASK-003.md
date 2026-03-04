# EPIC-010-STORY-003-TASK-003: Shell-Scripts prüfen und anpassen

## Zugehörige Story
EPIC-010-STORY-003 Anpassung der Konfigurationsdateien

## Beschreibung
Die im Projekt-Root vorhandenen Shell-Scripts (`*.sh`) auf Referenzen zu `kulturpfadservice` oder `kulturpfade` prüfen und bei Bedarf anpassen.

## Technische Details
Vorhandene Shell-Scripts im Projekt-Root:
- `frankenberg.sh`, `fritzlar.sh`, `homberg.sh`, `korbach.sh`
- `hannover-rote-route.sh`
- `koeln-innenstadt.sh`, `koeln-muelheim.sh`
- `koelnLindenthal1.sh`
- `moers.sh`

Diese Scripts rufen wahrscheinlich den Service via HTTP auf – der Hostname/Port-Referenzen prüfen.

## Schritte
- [ ] Scripts auf kulturpfad-Referenzen durchsuchen:
  `grep -r "kulturpfad\|kulturpfade" /Users/wolfram/fotopfade/fotopfad-service/*.sh`
- [ ] Jeden Treffer analysieren:
  - Ist es ein Hostname? → prüfen ob Änderung sinnvoll ist
  - Ist es ein Pfad? → ggf. anpassen
  - Ist es ein JAR-Dateiname? → anpassen (neuer JAR-Name: `fotopfade-0.1.0-SNAPSHOT.jar`)
- [ ] Anpassungen vornehmen
- [ ] Scripts testen (optional: einen Script testweise ausführen)
- [ ] Änderungen speichern

## Ergebnis
Shell-Scripts verweisen auf keinen alten Service-Namen mehr. Referenzen auf JAR-Datei sind aktuell.

## Status
Todo

## Aufwand
XS
