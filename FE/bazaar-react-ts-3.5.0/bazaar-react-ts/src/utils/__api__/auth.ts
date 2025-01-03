import axios from 'axios';

const API_URL = 'https://example.com/api/auth';

interface AuthResponse {
    token: string;

}

interface AuthCredentials {
    email: string;
    password: string;
}

 const authenticate = async (credentials: AuthCredentials): Promise<AuthResponse> => {
    try {
        const response = await axios.post<AuthResponse>(API_URL, credentials);
        return response.data;
    } catch (error) {
        throw new Error(error.response?.data?.message || 'Authentication failed');
    }
};
export default { authenticate };