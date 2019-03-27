import events from './Utils/Events/event-actions'
import api from './Utils/API/api-actions'
import Artists from './Components/Artists'
import Albums from './Components/Albums'
import Songs from './Components/Songs'
import Header from './Components/header'


main()
header()

function header() {
    getHeaderContext().innerHTML = Header()

    events.on(getHeaderContext(), 'click', () => {
        if (event.target.classList.contains('logo')) {
            api.getRequest('/artists', (artists) => {
                getAppContext().innerHTML = Artists.renderArtistsAndAlbumsAndSongs(artists);
            })
        }
        if (event.target.classList.contains('nav-artist')) {
            api.getRequest('/artists', (artists) => {
                getAppContext().innerHTML = Artists.renderArtists(artists);
            })
        }
        if (event.target.classList.contains('nav-album')) {
            api.getRequest('/albums', (albums) => {
                getAppContext().innerHTML = Albums.renderAlbumsAdd(albums);
            })
        }
        if (event.target.classList.contains('nav-song')) {
            api.getRequest('/songs', (songs) => {
                getAppContext().innerHTML = Songs.renderSongsAdd(songs);
            })
        }
    })  
}

function main() {

    api.getRequest('/artists', artists => {
        getAppContext().innerHTML = Artists.renderArtistsAndAlbumsAndSongs(artists);
    })

    events.on(getAppContext(), 'click', () => {
        if (event.target.classList.contains('artist__name')) {
            api.getRequest('/artists', (artists) => {
                getAppContext().innerHTML = Artists.renderArtists(artists);
            })
        }
        if (event.target.classList.contains('album__title')) {
            api.getRequest('/albums', (albums) => {
                getAppContext().innerHTML = Albums.renderAlbumsAdd(albums);
            })
        }
        if (event.target.classList.contains('song__title')) {
            api.getRequest('/songs', (songs) => {
                getAppContext().innerHTML = Songs.renderSongsAdd(songs);
            })
        }

        if (event.target.classList.contains('add__artist--submit')) {
            const name = document.querySelector('.add__artist--name').value
            const image = document.querySelector('.add__artist--image').value
            api.postRequest('/artists/addArtist', {
                name: name,
                image: image
            }, (artists) => {
                console.log(artists);
                getAppContext().innerHTML = Artists.renderArtistsAndAlbumsAndSongs(artists);
            })
        }
        if (event.target.classList.contains('add__album--submit')) {
            const artist = document.querySelector('.add__album--artist').value
            const title = document.querySelector('.add__album--title').value
            const image = document.querySelector('.add__album--image').value
            const recordLabel = document.querySelector('.add__album--recordLabel').value
            api.postRequest('/albums/addAlbum', {
                artist: artist,
                title: title,
                image: image,
                recordLabel: recordLabel
            }, (artists) => {
                getAppContext().innerHTML = Artists.renderArtistsAndAlbumsAndSongs(artists);
            })
        }

        if (event.target.classList.contains('add__song--submit')) {
            const album = document.querySelector('.add__song--album').value
            const title = document.querySelector('.add__song--title').value
            const link = document.querySelector('.add__song--link').value
            const duration = document.querySelector('.add__song--duration').value
            api.postRequest('/songs/addSong', {
                album: album,
                title: title,
                link: link,
                duration: duration
            }, (artists) => {
                getAppContext().innerHTML = Artists.renderArtistsAndAlbumsAndSongs(artists);
            })
        }

        console.log("checker")
    })
}

function getHeaderContext() {
    return document.querySelector("#header");
}

function getAppContext() {
    return document.querySelector("#app");
}