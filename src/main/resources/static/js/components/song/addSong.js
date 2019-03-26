import React, { Component } from 'react';

class addSong extends Component {
    render() {
        return (
            <section class="add__song">
                <input type="text" className="add__song--title" placeholder="title"/>
                <input type="text" className="add__song--link" placeholder="link"/>
                <input type="text" className="add__song--duration" placeholder="duration"/>
                <button className="add__song--submit">Add Song</button>
            </section>
        );
    }
}

export default addSong;