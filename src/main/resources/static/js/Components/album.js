import api from '../Utils/API/api-actions'

export default function listAlbums(artist) {
    return `
        ${api.getRequest('/artists/' + artist.name, artist => {
            artist.albums.map(album => {
                return `
                <option value=${album.id}>${album.name}</option>
                `
            })
            .join("");
        })}
        `;
}