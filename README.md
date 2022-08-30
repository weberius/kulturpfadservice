# kulturpfadservice

## Idee

Der KulturpfadeService bietet die Möglichkeit, aus einer Liste an Orten eine Fussgänger-Route zwischen diesen Orten zu erstellen.

Hierfür wird ein Dokument mit Orten übergeben. Anhand der Adressen werden die notwendigen x/y-Koordinaten erstellt. Mit Hilfe der Routing-Software Graphhopper wird hieraus eine Route erstellt, die in Form von geojson-Objekten zur Verfügung gestellt werden. Die Orte enhalten eine eindeutige ID, die es ermöglicht, weitergehende Informationen mit dem Ort zu verknüpfen. 

Die Software ist als Service gedacht, die es erlaubt, die notwendigen Daten für die Bereitstellung einer Oberfläche ohne Backend zu generieren. 

Der Service soll eine einfache Weboberfläche enthalten, um das Ergebnis einfach kontrollieren zu können.
