import axios from 'axios'

const HOST = 'http://localhost:8080'
const HELLO_API_URL = `${HOST}/hello`

class HelloConnector {

    getWelcomeMessage() {
        return axios.get(`${HELLO_API_URL}`);
    }
}

export default new HelloConnector()