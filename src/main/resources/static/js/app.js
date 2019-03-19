


const app = document.querySelector("#app");

app.textContent = "Hello JS!"

fetch('/songs')
    .then(response => response.json())
    .then(songs => {
        
        let content = `<ul>`
        songs.forEach((song) => {
            content += `<li>${song.title} </li>`;
        })
        content += `</ul>`;

        app.innerHTML = content;
    })
    .catch(err => console.log(err))