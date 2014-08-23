// Guage Chart 

google.load('visualization', '1', {packages:['gauge']});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Label', 'Value'],
          ['Cancer Severity', 2]
        ]);

        var options = {
          width: 700, height: 350,
          
          min: 0,
          max: 4,
          redFrom: 3, redTo: 4,
          yellowFrom:1, yellowTo: 2,
          
          orangeFrom:2, orangeTo:3,
          greenFrom : 0, greenTo: 1,
          majorTicks: 4,
          minorTicks: 5
          
        };
        var chart = new google.visualization.Gauge(document.getElementById('chart_guage'));
        chart.draw(data, options);
}