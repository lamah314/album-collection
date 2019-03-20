const artist = document.querySelector("#artist");

fetch('/artists')
    .then(response => response.json())
    .then(artists => {

        let contentArtist = `<ul>`
        artists.forEach((artist) => {
            let albums = ''
            artist.albums.forEach(album => {
                let songs = ''
                album.songs.forEach(song => {
                    songs += `
                    <li class = "song">
                        <h5 class= "song_title">Song: ${song.title}</h5>
                    </li>`
                })
                albums += `
                    <li class = "album">
                        <h5 class= "album_title">Album: ${album.title}</h5>
                        <ul class= "songs">
                        ${songs}
                        </ul>
                    </li>`
            })
            contentArtist += `
                <li>Artist: ${artist.name}
                    <ul class="albums">
                    ${albums}
                    </ul>
                </li>
                `;
        })
        contentArtist += `</ul>`;

        artist.innerHTML = contentArtist;
    })

    .catch(err => console.log(err))

fetch('/artist/addArtist')
// <h5 class= "song_title">Song: ${song.title}</h5>