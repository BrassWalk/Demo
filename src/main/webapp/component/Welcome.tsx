import * as React from 'react';
import * as ReactDOM from 'react-dom';
import * as Stomp from 'stomp-websocket';
import * as SockJS from 'sockjs-client';
import { Client } from '@stomp/stompjs';

const CREATE_URL = `ws://localhost:8080/app/create/db018538-70ef-4034-b319-c897f5977e15`
const MOVE_URL = `ws://localhost:8080/app/move/db018538-70ef-4034-b319-c897f5977e15`
const SOCKET_URL = `ws://localhost:8080/topic/board/db018538-70ef-4034-b319-c897f5977e15`
const SOCKET_URL2 = `ws://localhost:8080/topic/move/db018538-70ef-4034-b319-c897f5977e15`

type WelcomeState = {
    stompClient: any
    client: any
}

export default class WelcomeComponent extends React.Component<{}, WelcomeState> {

    constructor(props) {
        super(props)
        this.onCreateClick = this.onCreateClick.bind(this);
        this.onMoveClick = this.onMoveClick.bind(this);
    }

    componentDidMount() {
       const client = new Client();

       client.configure({
         brokerURL: 'ws://localhost:8080/game/websocket',
         onConnect: () => {
           console.log('onConnect');

           client.subscribe('/topic/create/db018538-70ef-4034-b319-c897f5977e15', message => {
                console.log('response from create topic!');
             console.log(message);
           });

           client.subscribe('/topic/move/db018538-70ef-4034-b319-c897f5977e15', message => {
                console.log('response from move topic!');
             console.log(message);
           });
         },

         debug: (str) => {
           console.log(new Date(), str);
         }
       });

       client.activate();

       this.setState({stompClient: null, client: client})
    }

    onCreateClick(event) {
        console.log("sending create message...");

        this.state.client.publish({destination: '/app/create/db018538-70ef-4034-b319-c897f5977e15', body: null});

        console.log("message sent...");
    }

    onMoveClick(event) {
        console.log("sending move message...");

        this.state.client.publish({destination: '/app/move/db018538-70ef-4034-b319-c897f5977e15', body: null});

        console.log("message sent...");
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