# kulturpfadservice

## Idee

Der KulturpfadeService bietet die Möglichkeit, aus einer Liste an Orten eine Fussgänger-Route zu erstellen. Anhand der Adressen werden die notwendigen x/y-Koordinaten erstellt.

Die Liste an Orten enhalten eine eindeutige ID, den Namen und die x/y Koordinaten. Mit Hilfe der Routing-Software Graphhopper wird hieraus eine Route erstellt, die in Form von geojson-Objekten zur Verfügung gestellt werden. Ausserdem ermöglicht es eine eindeutige ID, weitergehende Informationen mit dem Ort zu verknüpfen. Es wird darüber hinaus einen Schnittstelle zur Verfügung gestellt, die den Download der Information im `gpx` Format ermöglicht. Somit ist die Voraussetzung gegeben, die Route in eine Routing-App, wie komoot zu importieren.

Die Software ist als Service gedacht, die es erlaubt, die notwendigen Daten für die Bereitstellung einer Oberfläche ohne Backend zu generieren. 

Der Service enthält eine einfache Weboberfläche enthalten, die es erlaubt das Ergebnis zu kontrollieren. Sie dient ausserdem als Grundlage für die später zu erstellenden Webseiten.

## Download, build, start

Voraussetzung für die Ausführung des Services ist die Installation von `git`, `Java 17` und `Maven 3`. Der Service kann dann mit folgenden Befehlen heruntergeladen, gebaut und ausgeführt werden:

  1. git clone https://github.com/weberius/kulturpfadservice.git
  2. mvn clean install
  3. mvn spring-boot:run

Der Prozess 'mvn clean install' kann je nach Internetverbindung mehr als 5 Minuten dauern. Vor den Tests wird der aktuelle Abzug der OSM-Daten für den Regierungsbezirk Köln heruntergeladen. Mit Starten der Applikation ('mvn spring-boot:run') steht auf localhost:8080 ein einfacher Service mit zwei Schnittstellen zur Verfügung:

* http://localhost:8080/service/poi/<id>
* http://localhost:8080/service/route/<id>
* http://localhost:8080/service/gpx/<id>

Unter http://localhost:8080/index.html?id=id kann eine Weboberfläche aufgerufen werden, die bei der Erstellung der Routen und Pois unterstützt. Der Wert für id` bezeichnet einen Kulturpfad. Z.B. http://localhost:8080/index.html?id=b03-t06 öffnet die Route für den Kulturpfad 06 "Braunsfeld/ Lindenthal".

## Dokumentation

Die Dokumentation des Service wird unter src/main/asciidoc fortgeführt. 
Die Dokumentation wird im Rahmen der `prepare-package` Phase in html überführt und steht unter [weberius.github.io/kulturpfadservice/main.html](https://weberius.github.io/kulturpfadservice/main.html) zur Verfügung.
