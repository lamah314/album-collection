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

function renderAlbumsAndSongs(albums) {
    return `
    <ul class="albums">
    ${albums.map(album => {
        return `
                <li class="album">
                    <h5 class="album__title">${album.title}</h5>  
                        ${Songs(album.songs)}             
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