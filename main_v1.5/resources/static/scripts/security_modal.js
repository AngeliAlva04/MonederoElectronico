let openModal = document.getElementById('openModal-security');
let modalSecurity = document.getElementById('open_Modal');
let closeModal = document.getElementById('close');

// Abre modal
openModal.onclick = function(){
    modalSecurity.style.visibility = "visible";
    // Visualiza el modal oculto
}

closeModal.onclick = function(){
    modalSecurity.style.visibility = "hidden";
    // Oculta de nuevo el modal una vez que se visualiza
}

modalSecurity.onclick = function(){
    modalSecurity.style.visibility = "hidden";
}