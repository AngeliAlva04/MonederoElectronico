// signin.js - Versión simplificada para testing
document.addEventListener('DOMContentLoaded', function() {
    console.log('signin.js cargado');
    
    const form = document.getElementById('registerForm');
    
    if (form) {
        // Solo para logging, no prevenir el envío normal del formulario
        form.addEventListener('submit', function() {
            console.log(' :-: Formulario enviado con datos:');
            console.log('  - nombres:', document.getElementById('nombres').value);
            console.log('  - apellidos:', document.getElementById('apellidos').value);
            console.log('  - fechaNacimiento:', document.getElementById('fechaNacimiento').value);
            console.log('  - CURP:', document.getElementById('CURP').value);
        });
    }
});