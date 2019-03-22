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
        if (event.target.classList.contains('add__song--submit')) {
            const title = document.querySelector('.add__song--title').value
            const link = document.querySelector('.add__song--link').value
            const duration = document.querySelector('.add__song--duration').value
            api.postRequest('/songs/addSong', {
                title: title,
                link: link,
                duration: duration
            }, (songs) => {
                getArtistContext().innerHTML = Songs(songs);
            })
        }
        console.log("checker")
    })
}


function getArtistContext() {
    return document.querySelector("#artist");
}