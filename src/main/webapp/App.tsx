import React from 'react';
import './App.css';
import WelcomeComponent from './component/WelcomeComponent';

export default class App extends React.Component {
  render() {
    return (
      <div className="container">
        <WelcomeComponent />
      </div>
    );
  }
}