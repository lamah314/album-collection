import React, { Component } from 'react';
import title from './title';

class header extends Component {
    render() {
      return (
        <header className="header">
            <title isDown={true} />
        </header>
      );
    }
  }

  export default header;