let openModal = document.getElementById('openModal-rate');
let modalRate = document.getElementById('open_ModalRate');
let closeModal = document.getElementById('close');

// Abre modal
openModal.onclick = function(){
    modalRate.style.visibility = "visible";
    // Visualiza el modal oculto
}

closeModal.onclick = function(){
    modalRate.style.visibility = "hidden";
    // Oculta de nuevo el modal una vez que se visualiza
}

modalRate.onclick = function(){
    modalRate.style.visibility = "hidden";
}