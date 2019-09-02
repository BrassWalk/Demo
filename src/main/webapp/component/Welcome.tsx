import * as React from 'react';
import * as ReactDOM from 'react-dom';
import * as Stomp from 'stomp-websocket';
import * as SockJS from 'sockjs-client';

const CREATE_URL = `ws://localhost:8080/app/create/db018538-70ef-4034-b319-c897f5977e15`
const MOVE_URL = `ws://localhost:8080/app/move/db018538-70ef-4034-b319-c897f5977e15`
const SOCKET_URL = `ws://localhost:8080/topic/board/db018538-70ef-4034-b319-c897f5977e15`
const SOCKET_URL2 = `ws://localhost:8080/topic/move/db018538-70ef-4034-b319-c897f5977e15`

type WelcomeState = {
    stompClient: any
}

export default class WelcomeComponent extends React.Component<{}, WelcomeState> {

    constructor(props) {
        super(props)
        this.onCreateClick = this.onCreateClick.bind(this);
        this.onMoveClick = this.onMoveClick.bind(this);
    }

    onCreateClick(event) {
        console.log("sending create message...");

        this.state.stompClient.send(CREATE_URL, {priority: 9}, {});

        console.log("message sent...");
    }

    onMoveClick(event) {
        console.log("sending move message...");

        this.state.stompClient.send(MOVE_URL, {priority: 9}, {});

        console.log("message sent...");
    }

    componentDidMount() {
        const socket = new SockJS('/game');
        const stompClient = Stomp.over(socket);

        stompClient.heartbeat.incoming = 100;
        stompClient.heartbeat.outgoing = 100;

        stompClient.debug = function(str) {
            console.log('stomp debug - ' + str);
        };

        stompClient.connect({}, function (frame) {

            stompClient.subscribe(SOCKET_URL, data => {
                console.log("event 1..");
                this.onEvent(data);
            });

            stompClient.subscribe(SOCKET_URL2, data => {
                console.log("event 2..");
                this.onEvent(data);
            });
        });

        this.setState({ stompClient: stompClient });
    }

    onConnect() {
        const status = "STATUS: Connected.";
        console.log(status);
    }

    onDisconnect() {
        const status = "STATUS: Disconnected.";
        console.log(status);
    }

    onEvent(data) {
        console.log("event:" + data);
    }

    render() {
        return (
            <div className="container">
                 <button className="send btn btn-default" onClick={this.onCreateClick}>
                      SEND CREATE
                 </button>
                 <button className="send btn btn-default" onClick={this.onMoveClick}>
                       SEND MOVE
                  </button>
            </div>
        )
    }
}