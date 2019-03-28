import events from './Utils/Events/event-actions'
import api from './Utils/API/api-actions'
import Artists from './Components/Artists'
import Albums from './Components/Albums'
import Songs from './Components/Songs'
import Header from './Components/header'
import LandingPage from './Components/landingPage'

header()
main()

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
        getAppContext().innerHTML = LandingPage();
    })

    events.on(getAppContext(), 'click', () => {
        if (event.target.classList.contains('artist__name')) {
            const artistName = event.target.parentElement.querySelector('.artist__name').textContent
            var artistId
            api.postRequest('/artists/nameToId', {
                artistName: artistName
            }, (id)=> 
            {
                artistId = id
                api.getRequest(('/artists/' + artistId), (artist) => {
                    getAppContext().innerHTML = Artists.renderArtistAndAlbumsAndSongs(artist);
                })
            })
        }
        if (event.target.classList.contains('album__title')) {
            const albumTitle = event.target.parentElement.querySelector('.album__title').textContent
            var albumId
            api.postRequest('/albums/nameToId', {
                albumTitle: albumTitle
            }, (id)=> 
            {
                albumId = id
                api.getRequest(('/albums/' + albumId), (album) => {
                    getAppContext().innerHTML = Albums.renderAlbumAndSongs(album);
                })
            })     
        }
        if (event.target.classList.contains('song__title')) {
            const songTitle = event.target.parentElement.querySelector('.song__title').textContent
            var songId
            api.postRequest('/songs/nameToId', {
                songTitle: songTitle
            }, (id)=> 
            {
                songId = id
                api.getRequest(('/songs/' + songId), (song) => {
                    getAppContext().innerHTML = Songs.renderSong(song);
                })
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

    })
}

function getHeaderContext() {
    return document.querySelector("#header");
}

function getAppContext() {
    return document.querySelector("#app");
}