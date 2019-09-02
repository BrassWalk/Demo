import * as React from 'react';
import * as ReactDOM from 'react-dom';
import * as SockJS from 'sockjs-client';
import { Client } from '@stomp/stompjs';

type WelcomeState = {
    client: any
    userUuid: string
    userName: string
    userNameSent: boolean
    users: Set<String>
}

export default class WelcomeComponent extends React.Component<{}, WelcomeState> {

    constructor(props) {
        super(props)

        this.onClick = this.onClick.bind(this);
        this.onChange = this.onChange.bind(this);

        this.state = {
            client: null,
            userUuid: this.guid(),
            userName: null,
            userNameSent: false,
            users: new Set()
        }
    }

    render() {
        console.log(this.state.users)
let array = Array.from(this.state.users);
let test = [];

         array.forEach(function(item){
           test.push(<li key="item"> {item} </li>);
         });

        return (
            <div className="container">
                 <p>My UserId: {this.state.userUuid}</p>
                 <p>My UserName: {this.state.userName}</p>
                 <input
                       type="text"
                       disabled={this.state.userNameSent}
                       className="add-item__input"
                       value={this.state.userName}
                       onChange={this.onChange}
                       placeholder='username here...'
                 />
                 <button
                    disabled={this.state.userNameSent}
                    className="send btn btn-default"
                    onClick={this.onClick}>
                      REGISTER
                 </button>
<ul>
{ test }
</ul>
            </div>
        )
    }

    onClick(event) {
        this.setState({ userNameSent: true })
        this.state.client.publish({destination: '/app/user/create/' + this.state.userUuid, body: null});
    }

    onChange(event) {
        this.setState({ userName: event.target.value })
    }

    componentDidMount() {
       const client = new Client();

       client.configure({
         brokerURL: 'ws://localhost:8080/game/websocket',
         onConnect: () => {
           client.subscribe('/topic/user/create', message => {
             const users = this.state.users;
             users.add(JSON.parse(message.body).userName);
             this.setState({ users: users })
           });
         }
       });

       client.activate();

       this.setState({ client: client })
    }

    guid() {
      function s4() {
        return Math.floor((1 + Math.random()) * 0x10000)
          .toString(16)
          .substring(1);
      }
      return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
        s4() + '-' + s4() + s4() + s4();
    }
}