import axios from 'axios';
import { useState } from 'react';
import { Link, Navigate, useNavigate, useParams } from 'react-router-dom';
// import { useEffect } from 'react/cjs/react.development';
import { useEffect } from 'react';
import courseService from '../services/course.service';


const AddCourse = (props) => {
  const [courseName, setCourseName] = useState('');
  const [description, setDescription] = useState('');
  

  const navigate = useNavigate();
  const { id } = useParams();

  const saveCourse = (c) => {
    c.preventDefault();

    const course = {
      courseName,
      description,
    };
    if (id) {
      //update
      courseService
        .update(course)
        .then((response) => {
          console.log('Course data updated successfully', response.data);
          // history.push('/');
        })
        .catch((error) => {
          alert(error.response.status);
          console.log('Error code ' + error);
          console.log('Something went wrong', error.response.data);
        });
    } else {
      //create
      courseService
        .create(course)
        .then((response) => {
          console.log('course added successfully', response.data);
        //  history.push('/category');
          navigate("/admincourse");
          // <Link to='/category'>Back to List</Link>
        })
        .catch((error) => {
          console.log('something went wroing' + error.response);
          navigate("/adminLoginAgain");
        });
    }
  };

  useEffect(() => {
    if (id) {
      courseService
        .get(id)
        .then((course) => {
          setCourseName(course.data.firstName);
          setDescription(course.data.lastName);
  
        })
        .catch((error) => {
          console.log('Something went wrong', error);
        });
    }
  }, []);
  return (
    <div className='container'>
      <div>......</div>
      <div>......</div>
      <div>......</div>
      <div>......</div>
      <h3>Add Course</h3>
      <hr />
      <form>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='courseName'
            value={courseName}
            onChange={(c) => setCourseName(c.target.value)}
            placeholder='Enter course name'
          />
        </div>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='description'
            value={description}
            onChange={(c) => setDescription(c.target.value)}
            placeholder='Enter last name'
          />
        </div>
        
        <div>
          <button onClick={(c) => saveCourse(c)} className='btn btn-primary'>
            Save Or Update
          </button>
          
        </div>

        
       </form>
       <hr />
       <Link to='/admincourse'>Back to List</Link>
     </div>
  );
};

export default AddCourse;
