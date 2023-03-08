import httpClient from '../http-common-subject';

const getAll = (id) => {
  return httpClient.get(`getAllSubjects/${id}`);
};

const create = (data,catId) => {
  return httpClient.post(`addSubject/${catId}`, data);
};

const get = (id) => {
  return httpClient.get(`${id}`);
};

const update = (data) => {
  return httpClient.put('', data);
};

const remove = (id) => {
  return httpClient.delete(`deleteSubject/${id}`);
};
export default { getAll, create, get, update, remove };
