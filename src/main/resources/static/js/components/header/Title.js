import React, { Component } from 'react';

class title extends Component {
    render() {
        const header = this.props.isDown ? 
         '<h1>Down with the Hipsters!!!!</h1>' :
         '<h1>Up with the Hipsters!!!!</h1>';
      return (
          {header}  
      );
    }
}

export default title;