import React, { Component } from 'react';
import Albums from '../album/albums'

class artistAlbumsAndSongs extends Component {
    render() {
        const {specificArtist} = this.props;

        return (
            <li class="artist">
                <h5 class="artist__name"> {specificArtist.name}</h5>  
                <Albums.albumsAndSongs albums= {specificArtist.albums}/>            
            </li>
        );
    }
}

class artist extends Component {
    render() {
        const {specificArtist} = this.props;

        return (
            <li class="artist">
                <h5 class="artist__name"> {specificArtist.name}</h5>         
            </li>
        );
    }
}



export default {
    artistAlbumsAndSongs, artist
}