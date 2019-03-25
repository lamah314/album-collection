import Songs from './Songs'

function renderAlbums(albums) {
    return `
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
        `;
}

function renderAlbumsAndSongs(albums, artistName) {
    return `
    <ul class="albums">
    ${albums.map(album => {
        return `
                <li class="album">
                    <h5 class="album__title">${album.title}</h5>  
                        ${Songs(album.songs, album.title, album.id)}             
                </li>
            `;
    })
    .join("")}
    </ul>
    
    `;
}

export default {
    renderAlbums, renderAlbumsAndSongs
}

{/* <section class="add__album">
    <input type="hidden" class="add__album--artist album__id--${album.id}" placeholder="" value =${artistName}>
    <input type="text" class="add__album--title" placeholder="title">
    <input type="text" class="add__album--image" placeholder="image">
    <input type="text" class="add__album--recordLabel" placeholder="recordLabel">
    <button class="add__album--submit">Add Album</button>
</section> */}