import React, { Component } from 'react';

class song extends Component {
    render() {
        const {specificSong} = this.props;

        return (
            <li className="song">
                <h5 className="song__title">{specificSong.title}</h5>                       
            </li>
        );
    }
}

export default song;