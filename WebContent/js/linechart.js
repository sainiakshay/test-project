google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Year', 'Sales', 'Expenses'],
          ['2004',  1000,      400],
          ['2005',  1170,      460],
          ['2006',  660,       1120],
          ['2007',  1030,      540]
        ]);

        var options = {
          title: 'Deaths for a range of 5 years for both Male & Female', vAxis: {title: 'No. Of Deaths (Male & Female)',  titleTextStyle: {color: 'red'}},
          hAxis: {title: 'Deaths for particular Year',  titleTextStyle: {color: 'red'}}
        };

        var chart = new google.visualization.LineChart(document.getElementById('chart_line'));
        chart.draw(data, options);
      }