/*async function login(event) {
    event.preventDefault();
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let response = await fetch('/api/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
    });

    if (response.ok) {
    // Redirigir al usuario a la página deseada después del login
    window.location.href = "/public/home";
} else {
    alert("Credenciales incorrectas");
}
}*/