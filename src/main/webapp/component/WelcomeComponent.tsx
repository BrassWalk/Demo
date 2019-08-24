import * as React from 'react';
import * as ReactDOM from 'react-dom';

import HelloConnector from '../connector/HelloConnector';

type WelcomeState = {
    message: string
}

export default class WelcomeComponent extends React.Component<{}, WelcomeState> {

    constructor(props) {
            super(props)
            this.state = {
                message: "waiting for welcome message..."
            }
            this.getWelcomeMessage = this.getWelcomeMessage.bind(this)
        }

    componentDidMount() {
        this.getWelcomeMessage();
    }

    getWelcomeMessage() {
        HelloConnector.getWelcomeMessage()
            .then(
                response => {
                    console.log(response);
                    this.setState({
                        message: response.data.message
                    })
                }
            )
    }

    render() {
        return (
            <div className="container">
                <h3>Welcome Message:</h3>
                {this.state.message}
            </div>
        )
    }
}