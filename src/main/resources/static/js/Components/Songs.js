import Add from './add'

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
        <div class="user-input">
            ${Add.addRatingAndComment()}    
        </div>               
    `;
}

export default {
    renderSongsAdd, renderSongs, renderSong, renderSongsHeader
}