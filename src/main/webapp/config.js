var config = {
	"requireArcGISLogin": false, // Does the user need to log in to ArcGIS Online or ArcGIS Server?
	"tokenUrl": 'https://www.arcgis.com/sharing/generateToken', // ArcGIS token generation URL

	"title": "Kulturpfade Köln",
	"start": {
		// "maxZoom": 16,
		"center": [50.93551,6.953081],
		"zoom": 13,
		"attributionControl": true,
		"zoomControl": false,
		"data": "data"
	},
	"about": {
		"title": "Kulturpfade",
		"contents": "<p>This is an open-source version of the excellent <a href='https://github.com/bmcbride/bootleaf'>Bootleaf map </a>started by Bryan McBride.</p><p>It's designed for rapid web map development. See <a href='https://github.com/iag-geo/bootleaf'>https://github.com/iag-geo/bootleaf</a> for more information.</p><p>Chage this message in the config file</p>"
	},
	"controls": {
		"zoom": {
			"position": "topleft"
		},
		"leafletGeocoder": {
			//https://github.com/perliedman/leaflet-control-geocoder
			"collapsed": true,
			"position": "topleft",
			"placeholder": "Search for a location",
			"type": "OpenStreetMap", // OpenStreetMap, Google, ArcGIS
			//"suffix": "Australia", // optional keyword to append to every search
			//"key": "AIzaS....sbW_E", // when using the Google geocoder, include your Google Maps API key (https://developers.google.com/maps/documentation/geocoding/start#get-a-key)
		},
		"TOC": {
			//https://leafletjs.com/reference-1.0.2.html#control-layers-option
			"collapsed": true,
			"uncategorisedLabel": "Layers",
			"position": "topright",
			"toggleAll": true
		},
		"history": {
			"position": "bottomleft"
		},
		"bookmarks": {}
	},

	"activeTool": "filterWidget", // options are identify/coordinates/queryWidget
	"basemaps": ['esriGray', 'esriDarkGray', 'esriStreets', 'OpenStreetMap'],
	// "defaultIcon": {
	// 	"imagePath": "https://leafletjs.com/examples/custom-icons/",
	// 	"iconUrl": "leaf-green.png",
	// 	"shadowUrl": "leaf-shadow.png",
	// 	"iconSize":     [38, 95],
	// 		"shadowSize":   [50, 64],
	// 		"iconAnchor":   [22, 94],
	// 		"shadowAnchor": [4, 62],
	// 		"popupAnchor":  [-3, -76]
	// },
	"tocCategories": [
		{
			"name": "GeoJSON layers",
			"layers": ["theatres", "museums", "us_density"]
		},
		{
			"name": "ArcGIS Layers",
			"layers" : ["cities", "counties", "railways", "us_states"]
		},
		{
			"name": "WMS/WFS layers",
			"layers": ["US_population", "countries"],
			"exclusive": false
		}
	],
	"projections": [
		{4269: '+proj=longlat +ellps=GRS80 +datum=NAD83 +no_defs '}
	],
	"highlightStyle": {
		"weight": 2,
		"opacity": 1,
		"color": 'white',
		"dashArray": '3',
		"fillOpacity": 0.5,
		"fillColor": '#E31A1C',
		"stroke": true
	},
    "culturalpath": {
        "url": "/service/data/data.json"
    },
	"layers": [
	{
        "id": "poi",
        "name": "Kulturdenkm&auml;ler",
        "type": "geoJSON",
        "cluster": false,
        "showCoverageOnHover": false,
        "minZoom": 14,
        "url": "/service/poi/data.geojson",
        "icon": {
            "iconUrl": "./img/reddot.png",
            "iconSize": [18,18]
        },
        "style": {
            "stroke": true,
            "fillColor": "#00FFFF",
            "fillOpacity": 0.5,
            "radius": 10,
            "weight": 0.5,
            "opacity": 1,
            "color": '#727272',
        },
        "visible": true,
        "label": {
            "name": "name",
            "minZoom": 15
        }
	}, // poi layer
    {
        "id": "routes",
        "name": "Routen",
        "type": "geoJSON",
        "url": "/service/route/data.geojson",
        "style": {
            "stroke": true,
            "weight": 5.5
        },
        "radius": 10,
        "weight": 4,
        "opacity": 1,
        "color": "#FF0000"
    } //route layer
	]
}
