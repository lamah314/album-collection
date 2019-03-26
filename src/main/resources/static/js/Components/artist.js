import api from '../Utils/API/api-actions'

export default function listArtists(artists) {
    return (artists.map(artist => {
            console.log(artist.id + artist.name)
            return `   
            <option value=${artist.id}>${artist.name}</option>    
            `
        })
        .join(""))
}