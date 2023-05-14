$(function() {
    // Получаем список врачей с сервера и добавляем варианты выбора в селект
    // Получаем элемент <select> врачей
    var select = $('#doctor');

    // Отправляем запрос на сервер для получения списка врачей
    $.ajax({
        url: 'http://localhost:8080/doctors',
        type: 'GET',
        dataType: 'json',
        success: function(doctors) {
            // Если запрос успешен, добавляем варианты выбора в список
            $.each(doctors, function(i, doctor) {
                select.append($('<option>', {
                    value: doctor.id,
                    text: doctor.name
                }));
            });
        },
        error: function(xhr, status, error) {
            // Если произошла ошибка, выводим сообщение об ошибке в консоль
            console.error(error);
        }
    });

    const form = document.getElementById('appointment-form');

    form.addEventListener('submit', function(event) {
        event.preventDefault(); // отменяем стандартное поведение отправки формы

        const name = document.getElementById("name").value;
        const email = document.getElementById("email").value;
        const type = document.getElementById("type").value;
        const date = document.getElementById("datepicker").value;
        const time = document.getElementById("timepicker").value;
        const doctor = document.getElementById("doctor").value;

        fetch("http://localhost:8080/save/" + name + "/" + email + "/" + type + "/" + date + "/" + time + "/" + doctor)
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error('Network response was not ok.');
            })
            .then(response => {
                if (response.success) {
                    alert('Ошибка при записи');// Перенаправляем на страницу успешной записи
                } else {
                    alert('Вы успешно записаны'); // Выводим сообщение об ошибке
                }
            })
            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });
    });

});

