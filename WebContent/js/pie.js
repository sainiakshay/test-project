  google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['California',     11],
          ['Texas',      2],
          ['Newyork',  2],
          ['Chicago', 2],
          ['Indiana',    7]
        ]);

        var options = {
          title: "How many people are affected by cancer in USA ?"
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
      }