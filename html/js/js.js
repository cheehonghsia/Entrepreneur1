$(document).ready(function(){

	/* datepicker */
	var nowTemp = new Date();
	var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
	 
	var checkin = $('#dpd1').datepicker({
	  onRender: function(date) {
	    return date.valueOf() < now.valueOf() ? 'disabled' : '';
	  }
	}).on('changeDate', function(ev) {
	  if (ev.date.valueOf() > checkout.date.valueOf()) {
	    var newDate = new Date(ev.date)
	    newDate.setDate(newDate.getDate() + 1);
	    checkout.setValue(newDate);
	  }
	  checkin.hide();
	  $('#dpd2')[0].focus();
	}).data('datepicker');
	var checkout = $('#dpd2').datepicker({
	  onRender: function(date) {
	    return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
	  }
	}).on('changeDate', function(ev) {
	  checkout.hide();
	}).data('datepicker');
	
	/* amChart */
	
	var chart = AmCharts.makeChart("chartdiv", {
	    "type": "serial",
	    "theme": "light",
	    "legend": {
	        "useGraphSettings": true
	    },
	    "dataProvider": [{
	        "year": 1930,
	        "italy": 1,
	        "germany": 5,
	        "uk": 3
	    }, {
	        "year": 1934,
	        "italy": 1,
	        "germany": 2,
	        "uk": 6
	    }, {
	        "year": 1938,
	        "italy": 2,
	        "germany": 3,
	        "uk": 1
	    }, {
	        "year": 1950,
	        "italy": 3,
	        "germany": 4,
	        "uk": 1
	    }, {
	        "year": 1954,
	        "italy": 5,
	        "germany": 1,
	        "uk": 2
	    }, {
	        "year": 1958,
	        "italy": 3,
	        "germany": 2,
	        "uk": 1
	    }, {
	        "year": 1962,
	        "italy": 1,
	        "germany": 2,
	        "uk": 3
	    }, {
	        "year": 1966,
	        "italy": 2,
	        "germany": 1,
	        "uk": 5
	    }, {
	        "year": 1970,
	        "italy": 3,
	        "germany": 5,
	        "uk": 2
	    }, {
	        "year": 1974,
	        "italy": 4,
	        "germany": 3,
	        "uk": 6
	    }, {
	        "year": 1978,
	        "italy": 1,
	        "germany": 2,
	        "uk": 4
	    }],
	    "valueAxes": [{
	        "integersOnly": true,
	        "maximum": 6,
	        "minimum": 1,
	        "reversed": true,
	        "axisAlpha": 0,
	        "dashLength": 5,
	        "gridCount": 10,
	        "position": "left",
	        "title": "Place taken"
	    }],
	    "startDuration": 0.5,
	    "graphs": [{
	        "balloonText": "place taken by Italy in [[category]]: [[value]]",
	        "bullet": "round",
	        "hidden": true,
	        "title": "Italy",
	        "valueField": "italy",
			"fillAlphas": 0
	    }, {
	        "balloonText": "place taken by Germany in [[category]]: [[value]]",
	        "bullet": "round",
	        "title": "Germany",
	        "valueField": "germany",
			"fillAlphas": 0
	    }, {
	        "balloonText": "place taken by UK in [[category]]: [[value]]",
	        "bullet": "round",
	        "title": "United Kingdom",
	        "valueField": "uk",
			"fillAlphas": 0
	    }],
	    "chartCursor": {
	        "cursorAlpha": 0,
	        "cursorPosition": "mouse",
	        "zoomable": false
	    },
	    "categoryField": "year",
	    "categoryAxis": {
	        "gridPosition": "start",
	        "axisAlpha": 0,
	        "fillAlpha": 0.05,
	        "fillColor": "#000000",
	        "gridAlpha": 0,
	        "position": "top"
	    },
	    "exportConfig": {
	        "menuBottom": "15px",
	        "menuRight": "15px",
	        "menuItems": [{
	            "icon": '/lib/3/images/export.png',
	            "format": 'png'
	        }]
	    }
	});

	
});