import api from '../Utils/API/api-actions'

export default function listAlbums(albums) {
    return (albums.map(album => {
        return `   
        <option value=${album.id}>${album.title}</option>    
        `
    })
    .join(""));
}