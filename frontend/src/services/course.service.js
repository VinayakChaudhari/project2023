import httpClient from '../http-common';

const getAll = () => {
  return httpClient.get('getAllCourses');
};

const create = (data) => {
  return httpClient.post('addCourse', data);
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
export default { getAll, create, get, update, remove };
