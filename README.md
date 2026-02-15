# kulturpfadservice

## Idee

Der KulturpfadeService bietet die Möglichkeit, aus einer Liste an Orten eine Fussgänger-Route zwischen diesen Orten zu
erstellen.

Hierfür wird ein Dokument mit Orten übergeben. Anhand der Adressen werden die notwendigen x/y-Koordinaten erstellt. Mit
Hilfe der Routing-Software Graphhopper wird hieraus eine Route erstellt, die in Form von geojson-Objekten zur Verfügung
gestellt werden. Die Orte enhalten eine eindeutige ID, die es ermöglicht, weitergehende Informationen mit dem Ort zu
verknüpfen.

Die Software ist als Service gedacht, die es erlaubt, die notwendigen Daten für die Bereitstellung einer Oberfläche ohne
Backend zu generieren.

Der Service soll eine einfache Weboberfläche enthalten, um das Ergebnis einfach kontrollieren zu können.

## Download, build, start

Voraussetzung für die Ausführung des Services ist die Installation von `git`, `Java 21` und `Maven 3`. 

### Einrichtung

1. Repository klonen:
   ```bash
   git clone https://github.com/weberius/kulturpfadservice.git
   cd kulturpfadservice
   ```

2. OSM-Daten besorgen:
   Die Anwendung benötigt OpenStreetMap-Daten im PBF-Format. Diese müssen im `osm` Verzeichnis abgelegt werden:
   ```bash
   # Beispiel für Regierungsbezirk Köln
   wget -P osm/ https://download.geofabrik.de/europe/germany/nordrhein-westfalen/koeln-regbez-latest.osm.pbf
   ```
   
   Weitere verfügbare Regionen finden Sie auf https://download.geofabrik.de/europe/germany.html

3. Projekt bauen und starten:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

**Hinweis:** Die OSM-Datei und die GraphHopper-Cache-Datenbank werden im `osm` Verzeichnis gespeichert und bleiben bei `mvn clean` erhalten. Dies ermöglicht schnellere Build-Zeiten nach dem ersten Start.

Mit Starten der Applikation (`mvn spring-boot:run`) steht auf localhost:8080 ein einfacher Service mit unterschiedlichen Schnittstellen zur Verfügung:

* `http://localhost:8080/service/poi/<id>`
* `http://localhost:8080/service/route/<id>`
* `http://localhost:8080/service/gpx/<id>`
* `http://localhost:8080/service/data/<id>`

Unter `http://localhost:8080/index.html?id=<id>` kann eine Weboberfläche aufgerufen werden, die bei der Erstellung der Routen und Pois unterstützt. Der Wert für `id` bezeichnet einen Kulturpfad. Z.B. `http://localhost:8080/index.html?id=b03-t06` öffnet die Route für den Kulturpfad 06 "Braunsfeld/ Lindenthal".

## Dokumentation

Die Dokumentation des Service wird unter [src/main/asciidoc](https://github.com/weberius/kulturpfadservice/tree/main/src/main/asciidoc) fortgeführt. 
Die Dokumentation wird im Rahmen der `prepare-package` Phase in html überführt und steht unter [weberius.github.io/kulturpfadservice/main.html](https://weberius.github.io/kulturpfadservice/main.html) zur Verfügung.
