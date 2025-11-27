// Obtener botones y modal
const buttons = document.querySelectorAll('#MeMuevo, #Metrorrey, #Express');
const modalTicket = document.getElementById('open_Modal');
const closeModal = document.getElementById('close');
const ticketInput = document.getElementById('ticketCount');

// Función para cambiar el valor del ticket
function changeValue(delta) {
  let currentValue = parseInt(ticketInput.value);
  currentValue += delta;
  if (currentValue < 1) currentValue = 1; // Evitar valores negativos
  ticketInput.value = currentValue;
}

// Mostrar modal al hacer clic en un botón
buttons.forEach((button) => {
  button.addEventListener('click', () => {
    modalTicket.style.visibility = 'visible';
  });
});

// Cerrar modal al hacer clic en el botón "Cancelar"
closeModal.addEventListener('click', () => {
  modalTicket.style.visibility = 'hidden';
});

// Cerrar modal al hacer clic fuera de la ventana
modalTicket.addEventListener('click', (event) => {
  if (event.target === modalTicket) {
    modalTicket.style.visibility = 'hidden';
  }
});

// Función de aceptación (ejemplo)
function accept() {
  alert(`Has seleccionado ${ticketInput.value} boletos.`);
  modalTicket.style.visibility = 'hidden';
}
