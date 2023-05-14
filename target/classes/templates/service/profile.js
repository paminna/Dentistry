// Получаем элементы таблицы для отображения данных о пациенте
const nameElement = document.querySelector('#patient-name');
const ageElement = document.querySelector('#patient-age');
const genderElement = document.querySelector('#patient-gender');
const addressElement = document.querySelector('#patient-address');
const phoneElement = document.querySelector('#patient-phone');
const emailElement = document.querySelector('#patient-email');
// получаем id пациента из localStorage
const patientId = localStorage.getItem('user_id');

async function loadAppointmentHistory() {
    if (!patientId) {
        window.location.href = "../pages/auth.html";
    }
    else {
        const response = await fetch('http://localhost:8080/appointment/history/by/' + patientId);
        const data = await response.json();
        return data;
    }
}


// Функция для загрузки данных о пациенте с сервера
function loadPatientData() {
    // Здесь должен быть код для отправки запроса на сервер и получения данных о пациенте

    fetch(`http://localhost:8080/getUserBy/` + patientId) // отправляем запрос на сервер, заменив example.com и /api/patients на реальные значения для вашего сервера
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(patientData => {
            // Отображаем полученные данные на странице
            nameElement.textContent = patientData.name;
            ageElement.textContent = `${patientData.age} лет`;
            genderElement.textContent = patientData.gender;
            addressElement.textContent = patientData.address;
            phoneElement.textContent = patientData.phone;
            emailElement.textContent = patientData.email;
            console.log(patientData);
        })
        .catch(error => {
            console.error('Error fetching patient data:', error);
        });

}

function displayAppointmentHistory(appointmentHistory) {
    const appointmentList = document.getElementById("appointment-list");
    for (const appointment of appointmentHistory) {
        const listItem = document.createElement('li');
        const dateString = new Date(appointment.date).toLocaleDateString('ru-RU');
        listItem.textContent = `${dateString}, ${appointment.time} - ${appointment.type}`;
        appointmentList.appendChild(listItem);
    }
    const appointmentHistorySection = document.querySelector('.appointment-history');
    appointmentHistorySection.innerHTML = '<h2 style="font-size: 24px; font-weight: bold; text-align: center">История записей</h2>';
    appointmentHistorySection.appendChild(appointmentList);
}



// Вызываем функцию загрузки данных при загрузке страницы
window.onload = async function() {
    const appointmentHistory = await loadAppointmentHistory();
    loadPatientData();
    displayAppointmentHistory(appointmentHistory);
};

function logout() {
    localStorage.clear(); // Очистка данных в localStorage
    window.location.href = "../pages/auth.html"; // Переход на страницу входа
}
