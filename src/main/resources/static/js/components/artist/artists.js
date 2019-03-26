import React, { Component } from 'react';

import Artist from './artist'


class artistsAlbumsAndSongs extends Component {
    render () {
        const {artists} = this.props;
        return (
            <div className="artist-list">
                <ul className="artist">
                    {artists}.map(artist => {
                        <Artist.artistAlbumsAndSongs specificArtist={artist} />
                    }).join("")
                </ul>
                <AddAlbum />
            </div>
        );
    }
}

class artists extends Component {
    render () {
        const {artists} = this.props;
        
        return (
            <div className="artist-list">
                <ul className="artists">
                    {artists}.map(artist => {
                        <Artist.artist specificArtist={artist} />
                    }).join("")
                </ul>
                <AddAlbum />
            </div>
        );
    }
}

export default {
    artists, artistsAlbumsAndSongs
}