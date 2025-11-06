document.getElementById('registerForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const userData = {
        nombres: document.getElementById('nombres').value,
        apellidos: document.getElementById('apellidos').value,
        fechaNacimiento: document.getElementById('fechaNacimiento').value,
        CURP: document.getElementById('CURP').value
    };
    document.addEventListener('DOMContentLoaded', function() {
        var today = new Date().toISOString().split('T')[0];
        document.getElementById('fechaNacimiento').setAttribute('max', today);
    });
    fetch('/api/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userData)
    })
        .then(response => response.json())
        .then(data => {
            const messageDiv = document.getElementById('message');
            messageDiv.style.display = 'block';

            if (data.message === 'User registered successfully') {
                messageDiv.className = 'alert alert-success';
                messageDiv.textContent = 'Usuario registrado exitosamente. Redirigiendo al login...';

                // Redirigir al login después de 2 segundos
                setTimeout(() => {
                    window.location.href = '/login';
                }, 2000); // 2 segundos en función de milisegundos
            } else {
                messageDiv.className = 'alert alert-error';
                messageDiv.textContent = data.message || 'Error en el registro';
            }
        })
        .catch(error => {
            console.error('Error:', error);
            const messageDiv = document.getElementById('message');
            messageDiv.style.display = 'block';
            messageDiv.className = 'alert alert-error';
            messageDiv.textContent = 'Error en el registro, Intente de nuevo mas tarde.';
        });
});