# kulturpfadservice

## Idee

Der KulturpfadeService bietet die Möglichkeit, aus einer Liste an Orten eine Fussgänger-Route zwischen diesen Orten zu erstellen.

Hierfür wird ein Dokument mit Orten übergeben. Anhand der Adressen werden die notwendigen x/y-Koordinaten erstellt. Mit Hilfe der Routing-Software Graphhopper wird hieraus eine Route erstellt, die in Form von geojson-Objekten zur Verfügung gestellt werden. Die Orte enhalten eine eindeutige ID, die es ermöglicht, weitergehende Informationen mit dem Ort zu verknüpfen. 

Die Software ist als Service gedacht, die es erlaubt, die notwendigen Daten für die Bereitstellung einer Oberfläche ohne Backend zu generieren. 

Der Service soll eine einfache Weboberfläche enthalten, um das Ergebnis einfach kontrollieren zu können.

## Download, build, start

Voraussetzung für die Ausführung des Services ist die Installation von git, Java 11 und Maven 3. Der Service kann dann mit folgenden Befehlen heruntergeladen, gebaut und ausgeführt werden:

  1. git clone https://github.com/weberius/kulturpfadservice.git
  2. mvn clean install
  3. mvn spring-boot:run

Der Prozess 'mvn clean install' kann je nach Internetverbindung mehr als 5 Minuten dauern. Vor den Tests wird der aktuelle Abzug der OSM-Daten für den Regierungsbezirk Köln heruntergeladen. Mit Starten der Applikation ('mvn spring-boot:run') steht auf localhost:8080 ein einfacher Service mit zwei Schnittstellen zur Verfügung:

* http://localhost:8080/service/poi
* http://localhost:8080/service/route

## Dokumentation

Die Dokumentation des Service wird unter src/main/asciidoc fortgeführt. Mit folgendem Befehl wird unter 'target/generated-docs' html-Code erzeugt, der mit 'main.html' aufgerufen werden kann.

