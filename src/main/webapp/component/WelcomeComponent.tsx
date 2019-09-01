import * as React from 'react';
import * as ReactDOM from 'react-dom';
import * as Stomp from 'stomp-websocket';
import * as SockJS from 'sockjs-client';

const LOBBY_UPDATE_AND_READ_URL = `${window.webappconfig.host}/api/lobby/update-and-read`
const SOCKET_URL = `${window.webappconfig.host}/topic/lobby-updates`

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
        var stompClient = null;

        var socket = new SockJS('/websocket');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, function (frame) {

            stompClient.subscribe(SOCKET_URL, function (data) {
                this.onEvent(data);
            });

        });
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
            message: data
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