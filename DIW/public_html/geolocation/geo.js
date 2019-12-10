var x;
var map, infoWindow;
var latitud, longitud;
window.onload = function () {
    x = document.getElementById("miLocalicacion");
    getLocation();

}
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition, showError);
        navigator.geolocation.getCurrentPosition(initMap, showError);

    } else {
        x.innerHTML = "Geolocation is not supported by this browser.";
    }
}

function getCoord(position) {

    latitud = position.coords.latitude;
    longitud = position.coords.longitude;

}
function showPosition(position) {
    getCoord(position);
    x.innerHTML = "Latitude: " + latitud +
            "<br>Longitude: " + longitud;
}



function initMap(position) {

    getCoord(position);

    var mapOptions = {
        zoom: 10,
        center: new google.maps.LatLng(latitud, longitud),
        mapTypeId: 'roadmap'
    };

    var map = new google.maps.Map(document.getElementById('mapaCasa'), mapOptions);


    var central = {lat: latitud, lng: longitud};
    var santa = {lat: 39.499944, lng: 2.470897};
    var paguera = {lat: 39.540366, lng: 2.447466};
    var felanitx = {lat: 39.472802, lng: 3.147222};
    var alcudia = {lat: 39.840767, lng: 3.114743};



    var marker = new google.maps.Marker({
        position: central,
        map: map,
        title: 'centro del mapa'
    });

    var marker = new google.maps.Marker({
        position: felanitx,
        map: map,
        title: 'felanitx'
    });

    var marker = new google.maps.Marker({
        position: alcudia,
        map: map,
        title: 'alcudia'
    });
    var marker = new google.maps.Marker({
        position: santa,
        map: map,
        title: 'santa ponsa'
    });

    var marker = new google.maps.Marker({
        position: paguera,
        map: map,
        title: 'paguera'
    });
}

function showError(error) {
    switch (error.code) {
        case error.PERMISSION_DENIED:
            x.innerHTML = "User denied the request for Geolocation."
            break;
        case error.POSITION_UNAVAILABLE:
            x.innerHTML = "Location information is unavailable."
            break;
        case error.TIMEOUT:
            x.innerHTML = "The request to get user location timed out."
            break;
        case error.UNKNOWN_ERROR:
            x.innerHTML = "An unknown error occurred."
            break;
    }
}

