import React, { Component } from 'react';
import Song from './song'
import AddSong from './addSong'

class songs extends Component {
    render () {
        const {songs} = this.props;
        
        return (
            <div className="song-list">
                <ul className="songs">
                    {songs}.map(song => {
                        <Song specificSong={song} />
                    }).join("")
                </ul>
                <AddSong />
            </div>
        );
    }
}

export default songs;