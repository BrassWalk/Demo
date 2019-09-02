import * as React from 'react';
import * as ReactDOM from 'react-dom';

import './App.css';
import Welcome from './component/Welcome';

declare global {
    interface Window { webappconfig: { host: any}; }
}

export default class App extends React.Component {
  render() {
    return (
      <div className="container">
        <Welcome />
      </div>
    );
  }
}