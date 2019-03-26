import Add from './add'

function renderSongsAdd(songs) {
    return `
    <div>
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
    </div>
    <div class="user-input">
        ${Add.addSong()}
    </div>   
        `;
}

function renderSongs(songs) {
    return `
    <div>
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
    </div>  
        `;
}

export default {
    renderSongsAdd, renderSongs
}
