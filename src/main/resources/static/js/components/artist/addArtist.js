import React, { Component } from 'react';

class addArtist extends Component {
    render() {
        return (
            <section class="add__artist">
                <input type="text" className="add__artist--name" placeholder="name"/>
                <input type="text" className="add__artist--image" placeholder="image"/>
                <button className="add__artist--submit">Add Album</button>
            </section>
        );
    }
}

export default addArtist;