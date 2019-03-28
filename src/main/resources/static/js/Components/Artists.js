import Add from './add'
import Songs from './Songs'
import Albums from './Albums'



function renderArtistsAndAlbumsAndSongs(artists) {
    return `
    <div>
        <ul class="artists">
            ${artists.map(artist => {
            return `
                    <li class="artist">
                        <h5 class="artist__name clickable">${artist.name}</h5>  
                            ${Albums.renderAlbumsAndSongs(artist.albums)}                      
                    </li>
                `;
        })
        .join("")}
        </ul>
    </div>
    <div class="user-input">
        ${Add.addArtist()}
        ${Add.addAlbum()}
        ${Add.addSong()}
    </div>
    `;
}

function renderArtists(artists) {
    return `
    <div>
        <ul class="artists">
            ${artists.map(artist => {
            return `
                    <li class="artist">
                        <h5 class="artist__name clickable">${artist.name}</h5>  
                                                
                    </li>
                `;
        })
        .join("")}
        </ul>
    </div>
    <div class="user-input">
        ${Add.addArtist()}
    </div>
    `;
}

function renderArtistAndAlbumsAndSongs(artist) {
    return `
        <h2 class="artist__name">${artist.name}</h2>  
            ${Albums.renderAlbumsHeaderAndSongs(artist.albums)}                  
    `;
}

export default {
    renderArtists, renderArtistsAndAlbumsAndSongs, renderArtistAndAlbumsAndSongs
}
 