
document.getElementById('techniqueForm').addEventListener('submit', function(e) {
    e.preventDefault();     
    successMessage = document.getElementById('successMessage');
    successMessage.style.display = 'block';

    add_priem()
            
    // Прячем сообщение через 3 секунды
    setTimeout(() => {
        successMessage.style.display = 'none';
    }, 3000);
            
    // Очищаем форму (в реальном приложении после успешной отправки)
    this.reset();
});


function add_priem() {
    let name = document.getElementById("name").value;
    let category = document.getElementById("category").value;
    let resume = document.getElementById("description").value;
    let execution = document.getElementById("execution").value;
    let img = document.getElementById("img").value;
    let video = document.getElementById("video").value;

    let priem = new Map([
        ["name", name], 
        ["category", category], 
        ["resume", resume], 
        ["execution", execution],
        ["url_on_img", img],
        ["url_on_video", video]
    ]);

    fetch("http://localhost:8080/", {
        mode: 'cors', 
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(Object.fromEntries(priem))
    })

    console.log(JSON.stringify(Object.fromEntries(priem)));
}


const clickButton_back = document.getElementById("back_button");
if (clickButton_back) {
    clickButton_back.addEventListener('click', back_index);
}

function back_index() {
    window.location.href = "index.html";
}

