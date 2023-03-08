import { useEffect, useState } from 'react';
import { Link ,useParams,useNavigate} from 'react-router-dom';
import courseService from '../services/course.service';
import studentService from '../services/student.service';
import SubjectBookSuccessfully from './SubjectBookSuccessfully';

import {PersonCircle,Trash} from "react-bootstrap-icons";
// import employeeService from '../services/employee.service';

// import { Link } from 'react-router-dom';

// const Category = (props) => {
//     return (
//         <>
            {/* <div class="productSection0">
                <div class="slider">
                    <div class="slide-viewer">
                        <div class="slide-group">
                            <div class="slide slide-1">
                                <img src="Images/slide-1.jpg" alt="slide_01" />
                            </div>
                            <div class="slide slide-2">
                                <img src="Images/slide-2.jpg" alt="slide_02" />
                            </div>
                            <div class="slide slide-3">
                                <img src="Images/slide-3.png" alt="slide_03" />
                            </div>
                            <div class="slide slide-4">
                                <img src="Images/slide-4.jpg" alt="slide_04" />
                            </div>
                        </div>
                    </div>
                    <div class="slide-buttons"></div>
                </div>
            </div> */}

            {/* <div class="productSection1">
                <div class="main_container">
                    <div class="vertical_sec">
                        <div class="horizontal_sec">
                            <div class="box" id="box1">
                                <h3>Data Science</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea!
                                    Cum sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                            </div>
                            <div class="box" id="box2">
                                <h3>Business</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea!
                                    Cum sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                            </div>
                        </div>
                        <div class="horizontal_sec">
                            <div class="box" id="box3">
                                <h3>Computer Science</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea!
                                    Cum sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                            </div>
                            <div class="box" id="box4">
                                <h3>Information Tech</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea!
                                    Cum sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                            </div>
                        </div>
                    </div>
                    <div class="vertical_sec">
                        <div class="box" id="box5">
                            <h3>Personal Development</h3>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea! Cum
                                sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                        </div>
                    </div>
                </div>
            </div> */}




const Student = (props) => {
  const [courses, setCourses] = useState([]);
  const [bookMsg, setBookMsg] = useState("");


  // const [tempEmp, setTempemp] = useState([]);
const navigate=useNavigate();
 let [subjectsuccessfullyFlag,setSubjectbooksuccessfullyFlag]=useState(false);
  let [studentFlag,setStudentFlag]=useState(true);
  let [logoutFlag,setlogoutFlag]=useState(false);

  const [cartOb, setCartOb] = useState({latitude:"",longitude:"",catId:"",userId:props.studentId});
  
  let [studId,setStudId]=useState(props.studentId);
  let [studName,setStudName]=useState("");
//  let [productBookedDetails,setProductBookedDetails]=useState("");
  const { id } = useParams();

  const init = () =>{
    courseService
      .getAll()
      .then((response) => {
        console.log('Printing course data', response.data);
        setCourses(response.data);
        console.log("printing id of student"+props.studentId);
        // setTempemp(response.data);
        console.warn(response.data);
      })
      .catch((error) => {
        console.log('Something went wrong', error);
      });
  };



  const initUser = () =>{
    studentService
      .get(props.studentId)
      .then((response) =>{
        console.log('Printing student data', response.data.firstName);
       
        console.log("printing id of student"+props.studentId);
        setStudName(response.data.firstName);
        console.warn(response.data);
      })
      .catch((error) => {
        console.log('Something went wrong', error);
      });
  };

  useEffect(() => {
    setStudId(props.studentId);
    init();
   initUser();
  }, []);

  

  const handleDelete = (id) => {
    console.log('Printing id', id);
    courseService
      .remove(id)
      .then((response) => {
        console.log(' deleted successfully', response.data);
        init();
      })
      .catch((error) => {
        console.log('Something went wrong', error);
      });
  };

  const handleUpdate=(course)=>{
    console.log("course to update ",course);
   
  }

//add to caart 

const addStudentToCart = () =>{

studentService
        .bookSubject(cartOb)
        .then((response) => {
          console.log(' ', response.data);
          setBookMsg(response.data);
       //   setProductBookedDetails(response.data);
        //  history.push('/category');
        //  navigate("/productbooksuccessfully");
          setSubjectbooksuccessfullyFlag(true);
          setStudentFlag(false);
          // <Link to='/category'>Back to List</Link>
        })
        .catch((error) => {
          console.log('something went wroing' + error.response);
        //  navigate("/adminLoginAgain");
        });


      }


     const goTOStudent=()=>{
      setSubjectbooksuccessfullyFlag(false);
      setStudentFlag(true);
     }


     const handleAddSubject = (catId) =>{

      // fetching geolocation
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showposition, showerror);
        console.log("after gelocation")

    } else {

        console.log("geolocation is not supported");
    }

    function showposition(position) {
      
     console.log("AuthorFirstName "+position.coords.AuthorFirstName);
     cartOb.AuthorFirstName=position.coords.AuthorFirstName;
     console.log("AuthorLastName "+position.coords.AuthorLastName);
     cartOb.AuthorLastName=position.coords.AuthorLastName;
     cartOb.studId=studId;
     console.log(cartOb);


     // calling add method

  addStudentToCart();

  }

  function showerror(err) {
      
     console.log("error "+err);
  }


     }

     const seeLogout=()=>{
      console.log("inside logout");
      setlogoutFlag(true);
     }

     const logout=()=>{
      console.log("inside logout");
      navigate("/studentlogin");
      window.location.reload();
     }





  return (
    <div className='container'>
        <div>.....</div>
        <div>.....</div>
        <div>.....</div>
        <div>.....</div>
        
        {/* <table cellspacing="100px" align="center">
            <tr><td>a</td><td>b</td><td>c</td></tr>
        </table> */}

<div><PersonCircle onClick={()=>seeLogout()}></PersonCircle>&nbsp;&nbsp;{studName}</div>
{logoutFlag?(<div>
  {/* <Link to='/customerlogin'>Logout</Link> */}
  <button type="submit" id="subl" onClick={()=>logout()}>Logout</button>
        </div>):""}
{studentFlag?(<div>
           
       

  
        <h1>WELCOME TO THE Student PAGE</h1>
      <h1>List of Course</h1>
      <hr />
      <div>
        <Link to='/add' className='btn btn-primary mb-2'>
          
        </Link>
        <table className='table table-bordered table-striped' align="center">
          <thead className='thead-dark'>
            <tr>
              <th>Id</th>
              <th>Course Name</th>
              <th>Description</th>
             
              <th colSpan={3}>Actions</th>
            </tr>
          </thead>
          <tbody>
            {courses.map((course) => (
              <tr key={course.id}>
                <td>{course.id}</td>
                <td>{course.courseName}</td>
                <td>{course.description}</td>
                
                <td>
                  {/* <Link
                    className='btn btn-info'
                    to={`/employees/edit/${category.id}`}
                  >
                    Update
                  </Link> */}

                {/* <button
                    className='btn btn-danger ml-2'
                    onClick={() => {
                      handleUpdate(category);
                    }}
                  >
                    Update
                  </button> */}

                {/* <Link
                    className='btn btn-info'
                    to={`/updateCategory/${category.id}`}
                  >
                    UpdateCategory
                  </Link> */}

                </td>

                {/* <td>
                  <Link
                    className='btn btn-info'
                    to={`/uploadImage/${employee.id}`}
                  >
                    Image Upload
                  </Link>
                </td> */}
                <td>
                  {/* <button
                    className='btn btn-danger ml-2'
                    onClick={() => {
                      handleDelete(category.id);
                    }}
                  >
                    Delete
                  </button> */}
                  </td>
                  <td>
                  <button
                    className='btn btn-danger ml-2'
                    onClick={() => {
                      handleAddSubject(course.id)
                    }}
                  >
                    Book Subject
                  </button>


                </td>
                <td>
                  
                </td>
              </tr>
             
            ))}
          </tbody>
                    <tr><td></td><td>
                      {/* <button
                    className='btn btn-danger ml-2'
                    onClick={() => {
                      // handleDelete(category.id);
                    }}
                  >
                    Add
                  </button> */}

                {/* <Link
                    className='btn btn-info'
                    to={`/addCategory`}
                  >
                        addCategory
                  </Link> */}

                  </td></tr>
          
        </table>
      </div>

      </div>):
      
      // <ProductBookSuccessfully  ></ProductBookSuccessfully>
                  <div>
                    <h1>!! subjectBookedDetails !!</h1>
                       <h1> {bookMsg} </h1>
      <button type="submit" id="sub" name="sub" onClick={()=>goTOStudent()}>Go to STUDENT HOME page</button>
</div>
      }


    </div>
  )
}

export default Student;





//             <div>.....</div>
//             <div>.....</div>

//             <div class="productSection2">
//             <div></div>
//                 <div class="productGrid">
                    
//                     <div class="product">
//                         <div class="image">
//                             <img src="Images/mysql.svg" alt=""/>
//                         </div>
//                         <div class="description">
//                             <h3>MySQL</h3>
//                             <p>By Sir Nishat Kumar</p>
//                             <h2 class="price">$500</h2>
//                             <a href="" class="buy">Buy Now</a>
//                             <a href="" class="add">Add to Cart</a>
//                         </div>
//                     </div>
//                     <div class="product">
//                         <div class="image">
//                             <img src="Images/html-css.svg" alt=""/>
//                         </div>
//                         <div class="description">
//                             <h3>Html & CSS</h3>
//                             <p>By Sir Nishat Kumar</p>
//                             <h2 class="price">$500</h2>
//                             <a href="" class="buy">Buy Now</a>
//                             <a href="" class="add">Add to Cart</a>
//                         </div>
//                     </div>
//                     <div class="product">
//                         <div class="image">
//                             <img src="Images/js.svg" alt=""/>
//                         </div>
//                         <div class="description">
//                             <h3>JS</h3>
//                             <p>By Sir Nishat Kumar</p>
//                             <h2 class="price">$500</h2>
//                             <a href="" class="buy">Buy Now</a>
//                             <a href="" class="add">Add to Cart</a>
//                         </div>
//                     </div>
//                 </div>
//             </div>
//         </>
//     );
// }
// export default Category;























// import { Link } from 'react-router-dom';
// import { useState } from 'react';
// import adminService from '../services/admin.service ';
// // import { Navigate } from 'react-router-dom';
// import { useNavigate } from 'react-router-dom';


// const Customer = (props) => {
 

//     return (
//         <>
//             <div>.....</div>
//             <div>.....</div>
//             <div>.....</div>
//             <div>.....</div>
//             <h1>Welcome to the customer Page</h1>
//             <div>....</div>
//         <h1>Hello Customer </h1>
        

        

//         </>
//     );
// }
// export default Customer;