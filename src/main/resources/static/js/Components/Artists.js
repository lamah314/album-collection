import Add from './add'
import Songs from './Songs'
import Albums from './Albums'



export default function renderArtistsAndAlbumsAndSongs(artists) {
    return `
    <ul class="artists">
        ${artists.map(artist => {
        return `
                <li class="artist">
                    <h5 class="artist__name">${artist.name}</h5>  
                        ${Albums.renderAlbumsAndSongs(artist.albums)}                      
                </li>
            `;
    })
    .join("")}
    </ul>
    <div>
       
        ${Add.addAlbum()}
        
    </div>
    `;
}

{/* <section class="add__artist">
<input type="text" class="add__artist--name" placeholder="name">
<input type="text" class="add__artist--image" placeholder="image">
<button class="add__artist--submit">Add Artist</button>
</section> */}

// ${Add.addArtist()}

// ${Add.addSong()}