const app = document.querySelector("#app");

app.textContent = "Hello JS!"

fetch('/artists')
    .then(response => response.json())
    .then(jsonData => {
        
        const content = '<ul>'
        jasonData.forEach((artist) => {
            content += ' <li>${artist.name} : ${artist.description}</li>'
        })
        content += '</ul>'

        app.innerHTML = content;
    })
    .catch(err => console.log(err))
