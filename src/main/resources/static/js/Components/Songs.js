import Add from './add'
import Comments from './comments'

function renderSongs(songs) {
    return `
    <div>
        <ul class="songs">
        ${songs.map(song => {
                return `
                            <li class="song">
                                <h5 class="song__title clickable">${song.title}</h5>                       
                            </li>
                        `;
            })
            .join("")}
        </ul>
    </div>  
        `;
}

function renderSongsAdd(songs) {
    return `
    ${renderSongs(songs)}
    <div class="user-input">
        ${Add.addSong()}
    </div>   
        `;
}

function renderSongsHeader(songs) {
    return `
        <h4 class="song__header">Songs</h4>
        ${this.renderSongs(songs)}
    `;
}

function renderSong(song) {
    return `
        <h2 class="song__title">${song.title}</h2>  
        <iframe class="landingVideo" width="560" height="315" src="${song.link}?autoplay=1" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        <h4 class="song__rating">Average Rating: ${song.avgRating}</h4>
        <h4 class="song__comments">Comments</h4>
            ${Comments.renderSongComments(song)}
        <div class="user-input">
            ${Add.addRatingAndCommentSong(song)}    
        </div>               
    `;
}

export default {
    renderSongsAdd, renderSongs, renderSong, renderSongsHeader
}