import React, { Component } from 'react';

class addAlbum extends Component {
    render() {
        return (
            <section class="add__album">
                <input type="text" className="add__album--title" placeholder="title"/>
                <input type="text" className="add__album--image" placeholder="image"/>
                <input type="text" className="add__album--recordLabel" placeholder="recordLabel"/>
                <button className="add__album--submit">Add Album</button>
            </section>
        );
    }
}

export default addAlbum;