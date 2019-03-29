function renderSongComments(song) {
    return `
    <div>
        <ul class="comments">
        ${song.songComments.map(comment => {
                return `
                            <li class="comment">
                                <h5 class="song__comment clickable">${comment.commentContent}</h5>                       
                            </li>
                        `;
            })
            .join("")}
        </ul>
    </div>  
        `;
}

function renderAlbumComments(album) {
    return `
    <div>
        <ul class="comments">
        ${album.albumComments.map(comment => {
                return `
                            <li class="comment">
                                <h5 class="album__comment clickable">${comment.commentContent}</h5>                       
                            </li>
                        `;
            })
            .join("")}
        </ul>
    </div>  
        `;
}

function renderArtistComments(artist) {
    return `
    <div>
        <ul class="comments">
        ${artist.artistComments.map(comment => {
                return `
                            <li class="comment">
                                <h5 class="artist__comment clickable">${comment.commentContent}</h5>                       
                            </li>
                        `;
            })
            .join("")}
        </ul>
    </div>  
        `;
}

export default {
    renderArtistComments, renderAlbumComments, renderSongComments
}

