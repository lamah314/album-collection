


const app = document.querySelector("#app");

app.textContent = "Hello JS!"

fetch('/songs')
    .then(response => response.json())
    .then(songs => {
        
        let content = `<ul>`
        songs.forEach((song) => {
            content += `<li>TITLE: ${song.title} LINK: ${song.link} DURATION: ${song.duration} </li>`;
            
        })
        content += `</ul>`;

        app.innerHTML = content;
    })
    
 const artist = document.querySelector("#artist");
    fetch('/artists')
    .then(response => response.json())
    .then(artists => {
        
        let contentArtist = `<ul>`
        artists.forEach((artist) => {
            contentArtist += `<li>NAME: ${artist.name} IMAGE: ${artist.image} </li>`;
        })
        contentArtist += `</ul>`;

        artist.innerHTML = contentArtist;
    })
    
    const album = document.querySelector("#album");
    fetch('/albums')
    .then(response => response.json())
    .then(albums => {
        
        let contentAlbums = `<ul>`
        albums.forEach((album) => {
            contentAlbums += `<li>NAME: ${album.title} IMAGE: ${album.image} ${album.recordLabel}</li>`;
        })
        contentAlbums += `</ul>`;

        album.innerHTML = contentAlbums;
    })
    
    .catch(err => console.log(err))