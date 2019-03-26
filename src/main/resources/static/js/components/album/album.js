import React, { Component } from 'react';
import Songs from './songs'

class albumAndSongs extends Component {
    render() {
        const {specificAlbum} = this.props;

        return (
            <li class="album">
                <h5 class="album__title"> {specificAlbum.title}</h5>  
                <Songs songs= {specificAlbum.songs}/>            
            </li>
        );
    }
}

class album extends Component {
    render() {
        const {specificAlbum} = this.props;

        return (
            <li class="album">
                <h5 class="album__title"> {specificAlbum.title}</h5>         
            </li>
        );
    }
}



export default {
    albumAndSongs, albums
}