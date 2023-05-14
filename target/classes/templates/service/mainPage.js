const appointmentButton = document.getElementById("appointment-button");

appointmentButton.addEventListener("click", function() {
    const userId = localStorage.getItem("user_id");

    if (userId) {
        // Переходим на страницу записи на прием
        window.location.href = "appointment.html";
    } else {
        // Переходим на страницу авторизации
        window.location.href = "auth.html";
    }
});
