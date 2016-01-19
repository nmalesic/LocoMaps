/**
 * 
 */



var MAPFILES_URL = "http://maps.gstatic.com/intl/en_us/mapfiles/";
var map = null;
var geocoder = null;
var shadow = null;
var clickIcon = null;
var clickMarker = null;
var markers = null;
var selected = null;
var infowindow = null;
var boundsOverlay = null;
var viewportOverlay = null;
var initialized = false;
var hashFragment = "";

function init() {
	  //var params = parseUrlParams();
	  //clearOptions();
	  //setOptions(params);
	  /*var mapOptions = {
	    'zoom': (params.zoom ? params.zoom : 1),
	    'center': (params.center ? params.center : new google.maps.LatLng(0.0,0.0)),
	    'mapTypeId': google.maps.MapTypeId.ROADMAP,
	    'scaleControl': true
	  }
	  map = new google.maps.Map(document.getElementById("map"), mapOptions);*/
	  geocoder = new google.maps.Geocoder();
	  /*infowindow = new google.maps.InfoWindow({
	    'size': new google.maps.Size(292, 120)
	  });
	  shadow = new google.maps.MarkerImage(
	    MAPFILES_URL + "shadow50.png",
	    new google.maps.Size(37, 34),
	    new google.maps.Point(0, 0),
	    new google.maps.Point(10, 34)
	  );
	  clickIcon = new google.maps.MarkerImage(
	    MAPFILES_URL + 'dd-start.png',
	    new google.maps.Size(20, 34),
	    new google.maps.Point(0, 0),
	    new google.maps.Point(10, 34)
	  );
	  google.maps.event.addListener(map, 'click', onClickCallback);
	  // Bounds changes are asynchronous in v3, so we have to wait for the idle
	  // event to ensure that viewport biasing picks up the correct viewport
	  google.maps.event.addListener(map, 'idle', function() {
	    if (document.getElementById("query").value && ! initialized) {
	      submitQuery();
	    }
	    initialized = true;
	  });
	  document.getElementById('query').onkeyup = function(e) {
	    if (!e) var e = window.event;
	    if (e.keyCode != 13) return;
	    document.getElementById("query").blur();
	    submitQuery();
	  }
	  setInterval(checkHashFragment, 200);*/
	}

function submitQuery() {
	  var query = document.getElementById("origin").value;
	  /*if (/\s*^\-?\d+(\.\d+)?\s*\,\s*\-?\d+(\.\d+)?\s*$/.test(query)) {
	    var latlng = parseLatLng(query);
	    if (latlng == null) {
	      document.getElementById("query").value = "";
	    } else {
	      geocode({ 'latLng': latlng });
	    }
	  } else {*/
	    geocode({ 'address': query });
	  //}
	}

/**
 * Prepare a geocoding request and send it to the API.
 * @param {!google.maps.GeocoderRequest} request Geocoding request.
 */
function geocode(request) {
  //resetMap();
  var query = '';
  if (request.latLng) {
    clickMarker = new google.maps.Marker({
      'position': request.latLng,
      'map': map,
      'title': request.latLng.toString(),
      'clickable': false,
      'icon': clickIcon,
      'shadow': shadow
    });
    query = request.latLng.toUrlValue();
  } else {
    query = request.address;
  }
  
  geocoder.geocode(request, traitementResults);
}

 function traitementResults(results, status) {
	  
	  if (! results) {
	    alert("Geocoder did not return a valid response");
	  } else {
	    
	    if (status == google.maps.GeocoderStatus.OK) {
	      
	      saveResults(results);
	    }
	  }
	}

 
 
 function saveResults(results) {
	  /*markers = new Array(results.length);
	  var resultsListHtml = "";
	  
	      result.address_components;
	      {'bounds': result.geometry.bounds,  });
	        
	      
	  for (var i = 0; i < results.length; i++) {
	    
	    markers[i] = new google.maps.Marker({
	      'position': results[i].geometry.location,
	      'map': map,
	      'icon': icon,
	      'shadow': shadow
	    });
	    //google.maps.event.addListener(markers[i], 'click', openInfoWindow(i, results[i], markers[i]));
	    //resultsListHtml += getResultsListItem(i, getResultDescription(results[i]));
	  }
	  document.getElementById("suggestions").innerHTML = getPostcodeLocalitiesSuggestion(results[0]);
	  result.formatted_address;
	  result.postcode_localities;
	  result.geometry.location;
	  //getAddressComponentsHtml(result.address_components);
	  */ 
	  document.forms['f']['result'].value  = JSON.stringify(results[0]);
	  document.forms['f']['coords'].value = JSON.stringify(results[0].geometry.location);
      document.forms['f']['coordslat'].value = results[0].geometry.location.lat();
      document.forms['f']['coordslng'].value = results[0].geometry.location.lng();
	}
 
 /**
  * Get suggestions for a postcode with multiple localities.
  * @param {!google.maps.GeocoderResult} resultDescription Geocoding result.
  */
 function getPostcodeLocalitiesSuggestion(resultDescription) {
   if (resultDescription.types.indexOf("postal_code") == -1) return "";
   console.log(resultDescription.postcode_localities.length + " localities");
   var postcode = resultDescription.address_components[0].long_name;
   var html = '<span class="dym">Did you mean</span>: '
       + '<span class="pc_localities">' + postcode + ' in ';
   for (i in resultDescription.postcode_localities) {
       var locality = resultDescription.postcode_localities[i];
       html += '<a href="#' + escape(getPermalink(postcode + ' ' + locality)) + '">';
       html += locality + '</a>';
       html += (i == resultDescription.postcode_localities.length - 1 ? '.' : ', ');
   }
   return html;
 }

  
  function getAddressComponentsHtml(components) {
	  var html = '<div class="infoWindowContent">' +
	               '<table class="tabContent">';
	  for (var i = 0; i < components.length; i++) {
	    html += tr("Long name", components[i].long_name);
	    html += tr("Short name", components[i].short_name);
	    html += tr("Types", components[i].types[0]);
	    for (var j = 1; j < components[i].types.length; j++) {
	      html += tr("", components[i].types[j]);
	    }
	    if (i < components.length-1) {
	      html += br();
	    }
	  }
	  html += '</table></div>';
	  return html;
	}
	function tr(key, value) {
	  return '<tr>' +
	           '<td class="key">' + key + (key ? ':' : '') + '</td>' +
	           '<td class="value">' + value + '</td>' +
	         '</tr>';
	}
	function br() {
	  return '<tr><td colspan="2"><div style="width: 100%; border-bottom: 1px solid grey; margin: 2px;"</td></tr>';
	}

