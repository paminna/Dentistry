const form = document.getElementById("login-form");

form.addEventListener("submit", (event) => {
    event.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    fetch("http://localhost:8080/login/" + email + "/" + password)
        .then(response => response.json())
        .then(data => {
            if (data != null) {
                localStorage.setItem('user_id', data.id);
                window.location.href = 'profile.html';
            } else {
                console.error("Server returned null data");
            }
        })
        .catch(error => console.error(error));
});

