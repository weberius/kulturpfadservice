# EPIC-010-STORY-004: Dokumentation aktualisieren

## User Story
Als Entwickler möchte ich die gesamte Projektdokumentation aktualisieren, damit sie den neuen fotopfad-service korrekt beschreibt und keine veralteten Referenzen zum kulturpfadservice enthält.

## Beschreibung
Systematische Aktualisierung aller Dokumentationsdateien (README.md, AsciiDoc-Dateien, etc.) mit dem neuen Service-Namen und angepassten Beschreibungen. Hinzufügen eines Hinweises auf den Ursprung vom kulturpfadservice.

## Akzeptanzkriterien
- [ ] `README.md` vollständig aktualisiert:
  - Projekt-Titel geändert
  - Beschreibung angepasst
  - Build- und Run-Anweisungen geprüft
  - Hinweis auf Ursprung vom kulturpfadservice eingefügt
- [ ] AsciiDoc-Dateien in `src/main/asciidoc/` aktualisiert
- [ ] Generierte Dokumentation in `docs/` geprüft und bei Bedarf aktualisiert
- [ ] Alle Referenzen "kulturpfad" in Dokumentation durch "fotopfad" ersetzt (wo sinnvoll)
- [ ] LICENSE-Datei geprüft (bleibt wahrscheinlich gleich)
- [ ] EPIC und Stories in `docs/product/` sind aktuell

## Technische Aufgaben
1. README.md editieren:
   - Titel und Überschrift
   - Projekt-Beschreibung
   - Herkunfts-Info hinzufügen
2. AsciiDoc-Dateien durchgehen:
   - main.adoc
   - Alle Kapitel-Dateien
3. docs/ Verzeichnis prüfen
4. Dokumentation neu generieren falls nötig
5. Alle .md Dateien durchsuchen und aktualisieren

## Tasks
- EPIC-010-STORY-004-TASK-001 README.md aktualisieren
- EPIC-010-STORY-004-TASK-002 AsciiDoc-Dateien aktualisieren
- EPIC-010-STORY-004-TASK-003 AsciiDoc-Dokumentation neu generieren

## Abhängigkeiten
- EPIC-010-STORY-001 (Repository muss existieren)
- Idealerweise nach EPIC-010-STORY-002 und -003 (damit Code-Referenzen konsistent sind)

## Geschätzte Komplexität
M (2-3 Stunden)

## Status
To Do

## Notizen
- Eventuell eine CHANGELOG.md oder MIGRATION.md Datei erstellen
- Hinweis dass kulturpfadservice weiterhin als Referenz existiert
- Screenshot/Diagramme müssen eventuell aktualisiert werden
- Prüfen ob AsciiDoc neu gebaut werden muss: `mvn generate-resources`
