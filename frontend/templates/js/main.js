fetch("http://localhost:8080/", { mode: 'cors' })
.then(response => response.json())
.then(data => pars(data));

let container = document.getElementById('columns');
let priems_html = "";

function pars(data) {
    for (let i = 0; i < Object.keys(data).length; i++) {
        priems_html += '<div class="column">' +

            '<div class="image-container">' +
                '<img src="'+ data[i]['url_on_img'] +'" alt="Приём ' + data[i]['id'] + '">' +
                '<div class="image-caption">'+ data[i]['name'] + '</div>' +
                '<div class="image-resume">'+ data[i]['resume'] + '</div>' +
            '</div>' +

        "</div>";
    }

    container.innerHTML = priems_html;
    console.log(Object.keys(data).length);
}


const clickButton_delete = document.getElementById("delete_ok");
if (clickButton_delete) {
    clickButton_delete.addEventListener('click', delete_priem)
}

function delete_priem() {
    let id_delete = document.getElementById("dialog_id").value

    fetch("http://localhost:8080/" + id_delete, { 
        mode: 'cors',
        method: 'DELETE' 
    })

    window.location = window.location.href;

}


const clickButton_add = document.getElementById("add_priem");
if (clickButton_add) {
    clickButton_add.addEventListener('click', add_priem)
}

function add_priem() {
    window.location.href = "add_priem.html";
}
