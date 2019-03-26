import api from '../Utils/API/api-actions'

export default function listArtists(artists) {
    return (artists.map(artist => {
            return `   
            <option value=${artist.id}>${artist.name}</option>    
            `
        })
        .join(""))
}