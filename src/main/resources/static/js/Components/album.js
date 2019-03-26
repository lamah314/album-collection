import api from '../Utils/API/api-actions'

export default function listAlbums(specificArtist) {
    return `
        ${api.getRequest('/artists/' + specificArtist.name, artist => {
            artist.albums.map(album => {
                return `
                <option value=${album.id}>${album.name}</option>
                `
            })
            .join("")
        })}
        `;
}