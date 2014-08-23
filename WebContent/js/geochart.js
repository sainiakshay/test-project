google.load('visualization', '1', {'packages': ['geochart']});
     google.setOnLoadCallback(drawRegionsMap);

      function drawRegionsMap() {
        var data = google.visualization.arrayToDataTable([
          ['Country', 'Popularity'],
          ['United States', 300]
          
        ]);

        var options = {};

        var chart = new google.visualization.GeoChart(document.getElementById('chart_geo'));
        chart.draw(data, options);
    };