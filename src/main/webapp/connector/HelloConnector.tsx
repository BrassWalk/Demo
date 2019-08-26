import axios from 'axios'

const HELLO_API_URL = `${window.webappconfig.host}/hello`

class HelloConnector {

    getWelcomeMessage() {
        return axios.get(`${HELLO_API_URL}`);
    }
}

export default new HelloConnector()