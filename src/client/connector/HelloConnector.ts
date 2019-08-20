import axios from 'axios'

const HOST = 'http://zacharyallen.us-west-2.elasticbeanstalk.com'
const HELLO_API_URL = `${HOST}/hello`

class HelloConnector {

    getWelcomeMessage() {
        return axios.get(`${HELLO_API_URL}`);
    }
}

export default new HelloConnector()