import api from '../Utils/API/api-actions'

export default function listArtists() {
    return `
        ${api.getRequest('/artists', artists => {
            artists.map(artist => {
                return `
                <option value=${artist.id}>${artist.name}</option>
                `
            })
            .join("");
        })}
        `;
}