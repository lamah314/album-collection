import React, { Component } from 'react';

class App extends Component {
    constructor() {
      super();
    }
    increment = () => {
      this.setState({count: this.state.count + 1 });
    }
    decrement = () => {
      this.setState({count: this.state.count - 1 });
    }


function getRequest(location, callback) {
    fetch(location)
        .then(response => response.json())
        .then(data => callback(data))
        .catch(err => console.log(err))
}

function postRequest(location, requestBody, callback) {
    fetch(location, {
            method: "POST",
            body: JSON.stringify(requestBody)
        })
        .then(response => response.json())
        .then(data => callback(data))
        .catch(err => console.log(err))
}

export default {
    getRequest, postRequest
}