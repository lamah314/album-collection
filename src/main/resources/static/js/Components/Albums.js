import Songs from './Songs'
import Add from './add'

function renderAlbums(albums) {
    return `
    <div>
    <ul class="albums">
    ${albums.map(album => {
            return `

                        <li class="album">
                            <h5 class="album__title clickable">${album.title}</h5>                       
                        </li>
                        <img src="${album.image}" /> 
                    `;
        })
        .join("")}
        </ul>
        </div>
        `;
}

function renderAlbumsAdd(albums) {
    return `
        ${renderAlbums(albums)}
        <div class="user-input">
        ${Add.addAlbum()}
    </div>
        `;
}

function renderAlbumsAndSongs(albums) {
    return `
    <div>
    <ul class="albums">
    ${albums.map(album => {
        return `
        <h5 class="album__title clickable" value=${album.id}>${album.title}</h5>  
        <img src="${album.image}" /> 
                <li class="album">
                    
                        ${Songs.renderSongs(album.songs)}             
                </li>
            `;
    })
    .join("")}
    </ul>
    </div>
    `;
}

function renderAlbumsHeaderAndSongs(albums) {
    return `
        <h4 class="Album__header">Albums</h4>
        ${this.renderAlbumsAndSongs(albums)}
    `
}
function renderAlbumAndSongs(album) {
    return `
        <h2 class="album__title">${album.title}</h2> 
        <img src="${album.image}" />  
            ${Songs.renderSongsHeader(album.songs)}             
    `;
}




export default {
    renderAlbums, renderAlbumsAdd,  renderAlbumsAndSongs, renderAlbumAndSongs, renderAlbumsHeaderAndSongs
}

{/* <section class="add__album">
    <input type="hidden" class="add__album--artist album__id--${album.id}" placeholder="" value =${artistName}>
    <input type="text" class="add__album--title" placeholder="title">
    <input type="text" class="add__album--image" placeholder="image">
    <input type="text" class="add__album--recordLabel" placeholder="recordLabel">
    <button class="add__album--submit">Add Album</button>
</section> */}