import Add from './add'
import Songs from './Songs'
import Albums from './Albums'
import Comments from './comments'


function renderArtistsAndAlbumsAndSongs(artists) {
    return `
    <div>
        <ul class="artists">
            ${artists.map(artist => {
            return `
                    <img class= "artist__image clickable" src="${artist.image}" />
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
                        <img class="artist__image clickable"src="${artist.image}" />
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
        <div>    
        <h2 class="artist__name">${artist.name}</h2> 
        <img class= "artist__image" src="${artist.image}" /> 
            ${Albums.renderAlbumsHeaderAndSongs(artist.albums)}  
            <h4 class="artist__rating">Average Rating: ${artist.avgRating}</h4>
            <h4 class="artist__comments">Comments</h4>
                ${Comments.renderArtistComments(artist)}   
        <div class="user-input">
        ${Add.addAlbum()}
        ${Add.addRatingAndCommentArtist(artist)}
        </div> 
        </div>                
    `;
}



export default {
    renderArtists, renderArtistsAndAlbumsAndSongs, renderArtistAndAlbumsAndSongs
}
 