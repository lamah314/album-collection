const artist = document.querySelector("#artist");

getRequest('/artists', artists => {
    getArtistContext().innerHTML = renderArtistsAndAlbumsAndSongs(artists);
})

on(getArtistContext(), 'click', () => {
    if (event.target.classList.contains('add__artist--submit')) {
        const name = document.querySelector('.add__artist--name').value
        const image = document.querySelector('.add__artist--image').value
        postRequest('/artists/addArtist', {
            name: name,
            image: image
        }, (artists) => {
            console.log(artists);
            getArtistContext().innerHTML = renderArtistsAndAlbumsAndSongs(artists);
        })
    }
    if (event.target.classList.contains('add__song--submit')) {
        const title = document.querySelector('.add__song--title').value
        const link = document.querySelector('.add__song--link').value
        const duration = document.querySelector('.add__song--duration').value
        postRequest('/songs/addSong', {
            title: title,
            link: link,
            duration: duration
        }, (songs) => {
            getArtistContext().innerHTML = renderSongs(songs);
        })
    }
    console.log("checker")
})



function getArtistContext() {
    return document.querySelector("#artist");
}

//API Functions

function getRequest(location, callback) {
    fetch(location)
        .then(response => response.json())
        .then(data => callback(data))
        .catch(err => console.log(err))
}

function postRequest(location, requestBody, callback) {
    fetch(location, {
            method: "POST",
            body: JSON.stringify(requestBody)
        })
        .then(response => response.json())
        .then(data => callback(data))
        .catch(err => console.log(err))
}

function renderSongs(songs) {
    return `
    <ul class="songs">
    ${songs.map(song => {
            return `
                        <li class="song">
                            <h5 class="song__title">${song.title}</h5>                       
                        </li>
                    `;
        })
        .join("")}
        </ul>
        <section class="add__song">
            <input type="text" class="add__song--title" placeholder="title">
            <input type="text" class="add__song--link" placeholder="link">
            <input type="text" class="add__song--duration" placeholder="duration">
            <button class="add__song--submit">Add Song</button>
        </section>
        `;
}

function renderAlbums(albums) {
    return `
    <ul class="albums">
    ${albums.map(album => {
            return `
                        <li class="album">
                            <h5 class="album__title">${album.title}</h5>                       
                        </li>
                    `;
        })
        .join("")}
        </ul>
        `;
}

function renderAlbumsAndSongs(albums) {
    return `
    <ul class="albums">
    ${albums.map(album => {
        return `
                <li class="album">
                    <h5 class="album__title">${album.title}</h5>  
                        ${renderSongs(album.songs)}             
                </li>
            `;
    })
    .join("")}
    </ul>
    `;
}

function renderArtistsAndAlbumsAndSongs(artists) {
    return `
    <ul class="artists">
        ${artists.map(artist => {
        return `
                <li class="artist">
                    <h5 class="artist__name">${artist.name}</h5>  
                        ${renderAlbumsAndSongs(artist.albums)}                      
                </li>
            `;
    })
    .join("")}
    </ul>
    <section class="add__artist">
    <input type="text" class="add__artist--name" placeholder="name">
    <input type="text" class="add__artist--image" placeholder="image">
    <button class="add__artist--submit">Add Artist</button>
    </section>
    `;
}

// Event Functions

function on(element, eventType, callback) {
    element.addEventListener(eventType, (event) => callback(event))
}