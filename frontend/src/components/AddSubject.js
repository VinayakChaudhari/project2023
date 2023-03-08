import axios from 'axios';
import { useState } from 'react';
import { Link, Navigate, useNavigate, useParams } from 'react-router-dom';
// import { useEffect } from 'react/cjs/react.development';
import { useEffect } from 'react';
import subjectService from '../services/subject.service';


const AddSubject = (props) => {
  const [subjectName, setsubjectName] = useState('');
  const [AuthorFirstName, setAuthorFirstName] = useState('');
  const [AuthorLastName, setAuthorLastName] = useState('');
  const [description, setDescription] = useState('');
  const [inStock, setInStock] = useState('');
  

  const navigate = useNavigate();
  const { id } = useParams();

  const saveSubject = (p) => {
    p.preventDefault();

    const subject = {
      subjectName,
      AuthorFirstName,
      AuthorLastName,
      description,
      inStock,
    };
    if (id) {
      //update
      subjectService
        .update(subject)
        .then((response) => {
          console.log('subject data updated successfully', response.data);
          // history.push('/');
        })
        .catch((error) => {
          alert(error.response.status);
          console.log('Error code ' + error);
          console.log('Something went wrong', error.response.data);
        });
    } else {
      //create
      subjectService
        .create(subject,props.courseId)
        .then((response) => {
          console.log('subject added successfully', response.data);
        //  history.push('/category');
        //  navigate("/adminproduct");
          props.refreshSubjects();
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
      subjectService
        .get(id)
        .then((course) => {
          setsubjectName(course.data.firstName);
          setDescription(course.data.lastName);
  
        })
        .catch((error) => {
          console.log('Something went wrong', error);
        });
    }
  }, []);

const backToSubjects=()=>{
  props.refreshSubjects();
}


  return (
    <div className='container'>
      {/* <div>......</div>
      <div>......</div>
      <div>......</div>
      <div>......</div> */}
      <h3>Add Subject</h3>
      <hr />
      <form>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='subjectName'
            value={subjectName}
            onChange={(p) => setsubjectName(p.target.value)}
            placeholder='Enter couses name'
          />
        </div>

        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='AuthorFirstName'
            value={AuthorFirstName}
            onChange={(p) => setAuthorFirstName(p.target.value)}
            placeholder='Enter AuthorFirstName'
          />
        </div>


        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='AuthorLastName'
            value={AuthorLastName}
            onChange={(p) => setAuthorLastName(p.target.value)}
            placeholder='Enter AuthorLastName'
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

        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='instock'
            value={inStock}
            onChange={(c) => setInStock(c.target.value)}
            placeholder='Enter instock'
          />
        </div>
        
        <div>
          <button onClick={(p) => saveSubject(p)} className='btn btn-primary'>
            Save Or Update
          </button>
          
        </div>

        
       </form>
       <hr />
       <button onClick={(p) => backToSubjects(p)} className='btn btn-primary'>
            Back To Subjects
          </button>
       {/* <Link to='/adminproduct'>Back to List</Link> */}

       
     </div>
  );
};

export default AddSubject;
