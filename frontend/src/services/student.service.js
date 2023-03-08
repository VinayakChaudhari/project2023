import httpClient from '../http-common-student';

const getAll = () => {
  return httpClient.get('');
};


const create = (data) => {
  return httpClient.post('saveStudentdetails',+ data);
};

const bookSubject = (data) => {
  return httpClient.post('addCartItem', data);
};


const forgetPassword = (email) => {
  return httpClient.post('forgetPassword', email);
};

const loginStudent = (data) => {
  return httpClient.post('signin', data);
};

const get = (id) => {
  return httpClient.get(`${id}`);
};

const update = (data) => {
  return httpClient.put('', data);
};

const remove = (id) => {
  return httpClient.delete(`deleteCourse/${id}`);
};

export default { getAll, create, get, update, remove, loginStudent, bookSubject,forgetPassword };
