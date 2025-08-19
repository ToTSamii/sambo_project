fetch("http://localhost:8080/", { mode: 'cors' })
.then(response => response.json())
.then(data => pars(data));

let container = document.getElementById('columns');

function pars(data) {
    for (let i = 0; i < Object.keys(data).length; i++) {
        container.innerHTML = '<div class="column">' +
            '<div class="image-container">' +
                '<img src="'+ data[i]['url_on_img'] +'" alt="Приём ' + data[i]['id'] + '">' +
                '<div class="image-caption">'+ data[i]['name'] + '</div>' +
                '<div class="image-resume">'+ data[i]['resume'] + '</div>' +
                '<button id="put_priem">Редактировать</button>' +
                '<button id="delete_priem">Удалить</button>' +
            '</div>';
    }
}


/*
const clickButton = document.querySelector('button');
if (clickButton) {
    clickButton.addEventListener('click', showMessage)
}

function showMessage() {
   fetch("http://localhost:8080/", { mode: 'cors' })
   .then(response => response.json())
   .then(data => console.log(data))
}

*/