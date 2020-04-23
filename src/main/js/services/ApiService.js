import axios from 'axios';

const SESSIONS_API_BASE_URL = '/sessions';

const CSRF_TOKEN = document.cookie.match(new RegExp(`XSRF-TOKEN=([^;]+)`))[1];
const instance = axios.create({
    headers: { "X-XSRF-TOKEN": CSRF_TOKEN }
});

class ApiService {

    fetchSessions() {
        return instance.get(SESSIONS_API_BASE_URL);
    }

    fetchSessionsById(sessionsId) {
        return instance.get(SESSIONS_API_BASE_URL + '/' + sessionsId);
    }

    deleteSessions(sessionsId) {
        return instance.delete(SESSIONS_API_BASE_URL + '/' + sessionsId);
    }

    addSessions(sessions) {
        return instance.post(""+SESSIONS_API_BASE_URL, sessions);
    }

    editSessions(sessions) {
        return instance.put(SESSIONS_API_BASE_URL + '/' + sessions.id, sessions);
    }

}

export default new ApiService();