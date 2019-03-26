import Songs from './Songs'
import Add from './add'

function renderAlbumsAdd(albums) {
    return `
    <div>
    <ul class="albums">
    ${albums.map(album => {
            return `
                        <li class="album">
                            <h5 class="album__title">${album.title}</h5>                       
                        </li>
                    `;
        })
        .join("")}
        </ul>
        </div>
        <div class="user-input">
        ${Add.addAlbum()}
    </div>
        `;
}

function renderAlbums(albums) {
    return `
    <div>
    <ul class="albums">
    ${albums.map(album => {
            return `
                        <li class="album">
                            <h5 class="album__title">${album.title}</h5>                       
                        </li>
                    `;
        })
        .join("")}
        </ul>
        </div>
        `;
}

function renderAlbumsAndSongs(albums, artistName) {
    return `
    <div>
    <ul class="albums">
    ${albums.map(album => {
        return `
                <li class="album">
                    <h5 class="album__title">${album.title}</h5>  
                        ${Songs.renderSongs(album.songs)}             
                </li>
            `;
    })
    .join("")}
    </ul>
    </div>
    `;
}

export default {
    renderAlbums, renderAlbumsAdd,  renderAlbumsAndSongs
}

{/* <section class="add__album">
    <input type="hidden" class="add__album--artist album__id--${album.id}" placeholder="" value =${artistName}>
    <input type="text" class="add__album--title" placeholder="title">
    <input type="text" class="add__album--image" placeholder="image">
    <input type="text" class="add__album--recordLabel" placeholder="recordLabel">
    <button class="add__album--submit">Add Album</button>
</section> */}