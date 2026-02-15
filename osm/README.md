# OSM-Datenverzeichnis

Dieses Verzeichnis enthält die OpenStreetMap-Daten (*.osm.pbf) und die GraphHopper-Cache-Datenbank.

## Einrichtung

1. Laden Sie die gewünschte OSM-Datei herunter, z.B. von https://download.geofabrik.de/
2. Kopieren Sie die .osm.pbf Datei in dieses Verzeichnis
3. Beispiel: `cp germany-latest.osm.pbf osm/`

## Vorteile

- Die OSM-Datei und der GraphHopper-Cache bleiben bei `mvn clean` erhalten
- Die GraphHopper-Datenbank muss nicht bei jedem Build neu erstellt werden
- Schnellere Build-Zeiten nach dem ersten Start

## Konfigurierte Region

Aktuell konfigurierte OSM-Region in pom.xml:
- `europe/germany/nordrhein-westfalen/koeln-regbez-latest.osm.pbf`

Sie können die gewünschte Region in der pom.xml anpassen (`download-osm.fromFile` Property).
