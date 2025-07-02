
const clickButton = document.querySelector('button');
if (clickButton) {
    clickButton.addEventListener('click', showMessage)
}

function showMessage() {
    fetch("http://localhost:8080")
}
