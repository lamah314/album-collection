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
                getAppContext().innerHTML = LandingPage();
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
        if (event.target.classList.contains('artist__image')) {
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
        if (event.target.classList.contains('album__image')) {
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
            const name = event.target.parentElement.querySelector('.add__artist--name').value
            const image = event.target.parentElement.querySelector('.add__artist--image').value
            api.postRequest('/artists/addArtist', {
                name: name,
                image: image
            }, (artists) => {
                console.log(artists);
                getAppContext().innerHTML = Artists.renderArtists(artists);
            })
        }
        if (event.target.classList.contains('add__album--submit')) {
            const artist = event.target.parentElement.querySelector('.add__album--artist').value
            const title = event.target.parentElement.querySelector('.add__album--title').value
            const image = event.target.parentElement.querySelector('.add__album--image').value
            const recordLabel = event.target.parentElement.querySelector('.add__album--recordLabel').value
            api.postRequest('/albums/addAlbum', {
                artist: artist,
                title: title,
                image: image,
                recordLabel: recordLabel
            }, (albums) => {
                getAppContext().innerHTML = Albums.renderAlbumsAdd(albums);
            })
        }
        if (event.target.classList.contains('add__albumSpecific--submit')) {
            const artist = event.target.parentElement.querySelector('.add__album--artist').value
            const title = event.target.parentElement.querySelector('.add__album--title').value
            const image = event.target.parentElement.querySelector('.add__album--image').value
            const recordLabel = event.target.parentElement.querySelector('.add__album--recordLabel').value
            api.postRequest('/albums/addAlbumSpecific', {
                artist: artist,
                title: title,
                image: image,
                recordLabel: recordLabel
            }, (artist) => {
                getAppContext().innerHTML = Artists.renderArtistAndAlbumsAndSongs(artist);
            })
        }
        if (event.target.classList.contains('add__song--submit')) {
            const album = event.target.parentElement.querySelector('.add__song--album').value
            const title = event.target.parentElement.querySelector('.add__song--title').value
            const link = event.target.parentElement.querySelector('.add__song--link').value
            const duration = event.target.parentElement.querySelector('.add__song--duration').value
            api.postRequest('/songs/addSong', {
                album: album,
                title: title,
                link: link,
                duration: duration
            }, (songs) => {
                    getAppContext().innerHTML = Songs.renderSongsAdd(songs);
            })
        }
        if (event.target.classList.contains('add__songSpecific--submit')) {
            const album = event.target.parentElement.querySelector('.add__song--album').value
            const title = event.target.parentElement.querySelector('.add__song--title').value
            const link = event.target.parentElement.querySelector('.add__song--link').value
            const duration = event.target.parentElement.querySelector('.add__song--duration').value
            api.postRequest('/songs/addSongSpecific', {
                album: album,
                title: title,
                link: link,
                duration: duration
            }, (album) => {
                    getAppContext().innerHTML =  Albums.renderAlbumAndSongs(album);
            })
        }
        if (event.target.classList.contains('add__songRatingComment--submit')) {
            const songId = event.target.parentElement.querySelector('.add__songId').value
            const rating = event.target.parentElement.querySelector('.add__rating').value
            const comment = event.target.parentElement.querySelector('.add__comment--content').value
            api.postRequest('/songs/addRatingComment', {
                songId: songId,
                rating: rating,
                comment: comment
            }, (song) => {
                getAppContext().innerHTML = Songs.renderSong(song);
            })
        }
        if (event.target.classList.contains('add__albumRatingComment--submit')) {
            const albumId = event.target.parentElement.querySelector('.add__albumId').value
            const rating = event.target.parentElement.querySelector('.add__rating').value
            const comment = event.target.parentElement.querySelector('.add__comment--content').value
            api.postRequest('/albums/addRatingComment', {
                albumId: albumId,
                rating: rating,
                comment: comment
            }, (album) => {
                getAppContext().innerHTML = Albums.renderAlbumAndSongs(album);
            })
        }
        if (event.target.classList.contains('add__artistRatingComment--submit')) {
            const artistId = event.target.parentElement.querySelector('.add__artistId').value
            const rating = event.target.parentElement.querySelector('.add__rating').value
            const comment = event.target.parentElement.querySelector('.add__comment--content').value
            api.postRequest('/artists/addRatingComment', {
                artistId: artistId,
                rating: rating,
                comment: comment
            }, (artist) => {
                getAppContext().innerHTML = Artists.renderArtistAndAlbumsAndSongs(artist);
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