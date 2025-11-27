const buttons = document.querySelectorAll('#RechargeCard, #RechargeCash');
const modalRecharge = document.getElementById('open_Modal');
const closeModal = document.getElementById('closeModal');

//Mostrar ventana modal al hacer click en un botón
buttons.forEach((button) => {
  button.addEventListener('click', () => {
    modalRecharge.style.visibility = 'visible';
  });
});

// Cerrar ventana modal al hacer click en cancelar
closeModal.addEventListener('click', () => {
  modalRecharge.style.visibility = 'hidden';
});

// Cerrar ventana modal al hacer click fuera de la ventana
modalRecharge.addEventListener('click', (event) => {
  if(event.target === modalRecharge) {
    modalRecharge.style.visibility = 'Hidden';
  }
});