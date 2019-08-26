import * as React from 'react';
import * as ReactDOM from 'react-dom';

import './App.css';
import WelcomeComponent from './component/WelcomeComponent';

declare global {
    interface Window { webappconfig: { host: any}; }
}

export default class App extends React.Component {
  render() {
    return (
      <div className="container">
        <WelcomeComponent />
      </div>
    );
  }
}