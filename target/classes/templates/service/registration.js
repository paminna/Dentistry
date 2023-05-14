const form = document.querySelector('form');
form.addEventListener('submit', (event) => {
    event.preventDefault();

    const name = document.getElementById("name").value;
    const phone = document.getElementById("phone").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    fetch("http://localhost:8080/registration/" + name + "/" + phone + "/" + email + "/" + password)
        .then(response => response.json())
        .then(data => {
            if (data != null) {
                window.location.href = 'auth.html';
            } else {
                console.error("Server returned null data");
            }
        })
        .catch(error => console.error(error));
});
