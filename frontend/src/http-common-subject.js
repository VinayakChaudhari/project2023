import axios from 'axios';

export default axios.create({
  baseURL: 'http://localhost:8080/subject/',
  headers: {
    'Content-Type': 'application/json',
  },
});
