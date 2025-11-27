const ctx = document.getElementById('lineChart').getContext('2d');

const data = {
  labels: ['Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
  datasets: [{
    label: 'Transacciones',
    data: [456, 456, 428, 480],
    borderColor: 'rgba(110, 209, 152, 1)',
    backgroundColor: 'rgba(110, 209, 152, 0.2)',
    borderWidth: 2,
    tension: 0.4
  },
  {
    label: 'Recargas',
    data: [550, 400, 500, 450],
    borderColor: 'rgba(43, 136, 82, 1)',
    backgroundColor: 'rgba(43, 136, 82, 0.2)',
    borderWidth: 2
  }]
};

const config = {
  type: 'line', // tipo de grafica: bar, line, pie, area, bubble, stacked, box
  data: data, // toma los datos definidos arriba en la variable data
  options: {
    responsive: true, // grafica adaptable a la pantalla del usuario
    plugins: {
      legend: {
        position: 'top'
      },
      tooltip: { // cuadro que aparece al poner el cursor dentro de uno de los puntos de la grafica
        enabled: true
      }
    },
    scales: {
      x: { // Eje horizontal
        title: {
          display: true,
          text: 'Meses'
        }
      },
      y: { // Eje vertical
        title: {
          display: true,
          text: 'Monto'
        },
        beginAtZero: true //Hace que el eje Y comience desde 0
      }
    }
  }
};
new Chart(ctx, config);
