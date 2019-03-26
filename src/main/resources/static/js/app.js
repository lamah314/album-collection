import events from './Utils/Events/event-actions'
import api from './Utils/API/api-actions'
import Artists from './Components/Artists'
import Albums from './Components/Albums'
import Songs from './Components/Songs'

main()

function main() {

    api.getRequest('/artists', artists => {
        getArtistContext().innerHTML = Artists(artists);
    })

    events.on(getArtistContext(), 'click', () => {
        if (event.target.classList.contains('add__artist--submit')) {
            const name = document.querySelector('.add__artist--name').value
            const image = document.querySelector('.add__artist--image').value
            api.postRequest('/artists/addArtist', {
                name: name,
                image: image
            }, (artists) => {
                console.log(artists);
                getArtistContext().innerHTML = Artists(artists);
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
                getArtistContext().innerHTML = Artists(artists);
            })
        }
        // if (event.target.classList.contains('add__song--submit')) {
        //     const artist = document.querySelector('.add__song--artist').value
        //     const album = document.querySelector('.add__song--album').value
        //     const title = document.querySelector('.add__song--title').value
        //     const link = document.querySelector('.add__song--link').value
        //     const duration = document.querySelector('.add__song--duration').value
        //     api.postRequest('/songs/addSong', {
        //         artist = artist,
        //         album: album,
        //         title: title,
        //         link: link,
        //         duration: duration
        //     }, (artists) => {
        //         getArtistContext().innerHTML = Artists(artists);
        //     })
        // }
        console.log("checker")
    })
}


function getArtistContext() {
    return document.querySelector("#artist");
}