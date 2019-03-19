const app = document.querySelector("#app");

app.textContent = "Hello JS!"

fetch('/songs')
    .then(response => response.json())
    .then(jsonData => {
        
        const content = `<ul>`
        jsonData.forEach((song) => {
            content += `<li>${song.title} </li>`;
        })
        content += `</ul>`;

        app.innerHTML = content;
    })
    .catch(err => console.log(err))
