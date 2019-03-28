import events from '../Utils/Events/event-actions'
import Artists from './Artists.js'
import Albums from './Albums.js'
import Songs from './Songs.js'
import artist from './artist.js'
import listArtists from './artist.js'
import listAlbums from './album.js'
import api from '../Utils/API/api-actions'

function addArtist() {
    return `
    <section class="add__artist">
        <h3>Add Artist</h3>
        
            <input type="select" class="add__artist--name" placeholder="artist name">
            <input type="text" class="add__artist--image" placeholder="image">
            <button class="add__artist--submit clickable">Add Artist</button>
        </section> 
        `
}

function addAlbum() {
    api.getRequest('/artists', artists => {    
        document.querySelector('.add__album--artist').innerHTML =  listArtists(artists) 
    })
    return `
    <section class="add__album">
        <h3>Add Album</h3>
        
            <select type="select" class="add__album--artist" placeholder="Pick Artist">
            
            </select>                 
            <input type="text" class="add__album--title" placeholder="title">
            <input type="text" class="add__album--image" placeholder="image">
            <input type="text" class="add__album--recordLabel" placeholder="recordLabel">
            <button class="add__album--submit clickable">Add Album</button>
        </section>
        `
}

function addSong() {
    api.getRequest('/albums', albums => {    
        document.querySelector('.add__song--album').innerHTML =  listAlbums(albums) 
    })

    return `
    <section class="add__song">
        <h3>Add Song</h3>
        
            <select type="select" class="add__song--album" placeholder="Pick Album">
            </select>
            <input type="text" class="add__song--title" placeholder="title">
            <input type="text" class="add__song--link" placeholder="link">
            <input type="text" class="add__song--duration" placeholder="duration">
            <button class="add__song--submit clickable">Add Song</button>
        </section>
        `
}

function addRatingAndCommentSong(song) {
    return `
    <section class="add__rating__comment">
        <h3>Add Rating and Comment to ${song.title}</h3>
        <input type="hidden" class="add__songId" value="${song.id}">
        <select type="select" class="add__rating" placeholder="Choose Rating">
            <option value=1>1</option> 
            <option value=2>2</option>
            <option value=3>3</option>
            <option value=4>4</option>
            <option value=5>5</option> 
        </select>
        <input type="text" class="add__comment--content" placeholder="comment">
        <button class="add__songRatingComment--submit clickable">Add Comment</button>
    </section> 
        `
}

function addRatingAndCommentAlbum(album) {
    return `
    <section class="add__rating__comment">
        <h3>Add Rating and Comment to ${album.title}</h3>
        <input type="hidden" class="add__albumId" value="${album.id}">
        <select type="select" class="add__rating" placeholder="Choose Rating">
            <option value=1>1</option> 
            <option value=2>2</option>
            <option value=3>3</option>
            <option value=4>4</option>
            <option value=5>5</option> 
        </select>
        <input type="text" class="add__comment--content" placeholder="comment">
        <button class="add__albumRatingComment--submit clickable">Add Comment</button>
    </section> 
        `
}

function addRatingAndCommentArtist(artist) {
    return `
    <section class="add__rating__comment">
        <h3>Add Rating and Comment to ${artist.name}</h3>
        <input type="hidden" class="add__artistId" value="${artist.id}">
        <select type="select" class="add__rating" placeholder="Choose Rating">
            <option value=1>1</option> 
            <option value=2>2</option>
            <option value=3>3</option>
            <option value=4>4</option>
            <option value=5>5</option> 
        </select>
        <input type="text" class="add__comment--content" placeholder="comment">
        <button class="add__artistRatingComment--submit clickable">Add Comment</button>
    </section> 
        `
}


export default {
    addArtist, addAlbum, addSong, addRatingAndCommentSong, addRatingAndCommentAlbum, addRatingAndCommentArtist
}
