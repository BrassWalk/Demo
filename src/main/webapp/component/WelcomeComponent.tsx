import * as React from 'react';
import * as ReactDOM from 'react-dom';
import * as io from 'socket.io-client';

const SOCKET_URL = `${window.webappconfig.host}/topic/lobby-updates`
const socket = io(`SOCKET_URL`);

type WelcomeState = {
    status: string
    message: string
}

export default class WelcomeComponent extends React.Component<{}, WelcomeState> {

    constructor(props) {
            super(props)
            this.state = {
                 status: "STATUS: Never Connected.",
                message: "waiting for welcome message..."
            }
        }

    componentDidMount() {
        socket.on('connect', this.onConnect());
        socket.on('event', data => this.onEvent(data));
        socket.on('disconnect', this.onDisconnect());
    }

    onConnect() {
        const status = "STATUS: Connected.";
        console.log(status);
        this.setState({
            status: status,
            message: ""
        })
    }

    onDisconnect() {
        const status = "STATUS: Disconnected.";
        console.log(status);
        this.setState({
            status: status,
            message: ""
        })
    }

    onEvent(data) {
        console.log("event:" + data);
        this.setState({
            status: "STATUS: Connected.",
            message: data.message
        })
    }

    render() {
        return (
            <div className="container">
                <h3>Status:</h3>
                {this.state.status}
                <h3>Message:</h3>
                {this.state.message}
            </div>
        )
    }
}