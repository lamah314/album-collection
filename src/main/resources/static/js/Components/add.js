import Artists from './Artists.js'
import Albums from './Albums.js'
import Songs from './Songs.js'
import artist from './artist.js'
import listArtists from './artist.js';

function addArtist() {
    return `
        <h3>Add Artist</h3>
        <section class="add__artist">
            <input type="select" class="add__artist--name" placeholder="artist name">
            <input type="text" class="add__artist--image" placeholder="image">
            <button class="add__artist--submit">Add Artist</button>
        </section> 
        `
}

function addAlbum() {
    return `
        <h3>Add Album</h3>
        <section class="add__album">
            <select type="select" class="add__album--artist" placeholder="Pick Artist">
            ${api.getRequest('/artists', artists => {    
                listArtists(artists) 
            })}
            </select>                 
            <input type="text" class="add__album--title" placeholder="title">
            <input type="text" class="add__album--image" placeholder="image">
            <input type="text" class="add__album--recordLabel" placeholder="recordLabel">
            <button class="add__album--submit">Add Album</button>
        </section>
        `
}

function addSong() {
    return `
        <h3>Add Song</h3>
        <section class="add__song">
            <select type="select" class="add__song--artist" placeholder="Pick Artist">
                ${listArtists()}
            </select>
            <select type="select" class="add__song--album" placeholder="Pick Album">
                ${listAlbums(document.querySelector('.add__song--artist').value)}
            </select>
            <input type="text" class="add__song--title album__id--${albumId}" placeholder="title">
            <input type="text" class="add__song--link album__id--${albumId}" placeholder="link">
            <input type="text" class="add__song--duration album__id--${albumId}" placeholder="duration">
            <button class="add__song--submit">Add Song</button>
        </section>
        `
}



export default {
    addArtist, addAlbum, addSong
}
  