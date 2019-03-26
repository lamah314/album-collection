import React, { Component } from 'react';

import Album from './album'
import AddAlbum from './album'


class albumsAndSongs extends Component {
    render () {
        const {albums} = this.props;
        
        return (
            <div className="album-list">
                <ul className="albums">
                    {albums}.map(album => {
                        <Album.albumAndSongs specificAlbum={album} />
                    }).join("")
                </ul>
                <AddAlbum />
            </div>
        );
    }
}

class albums extends Component {
    render () {
        const {albums} = this.props;
        
        return (
            <div className="album-list">
                <ul className="albums">
                    {albums}.map(album => {
                        <Album.albums specificAlbum={album} />
                    }).join("")
                </ul>
                <AddAlbum />
            </div>
        );
    }
}

export default {
    albums, albumsAndSongs
}