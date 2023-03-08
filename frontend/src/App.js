import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from './components/Home';
import About from './components/About';
import Login from './components/Login';
import Signup from './components/Signup';
import Subjects from "./components/Subjects";
import ProfileEditInfo from "./components/ProfileEditInfo";
import ProfileCourses from "./components/ProfileCourses";
import ProfileSettings from "./components/ProfileSettings";
import SendPassword from "./components/SendPassword";
import ForgotPassword from "./components/ForgotPassword";
import AdminCourse from "./components/AdminCourse";
import AddCourse from "./components/AddCourse";
import UpdateCourse from "./components/UpdateCourse copy";
import LoginFailed from "./components/LoginFailed";

import Header from './components/Header';
import Footer from './components/Footer';
import Student from "./components/Student";
import StudentLogin from "./components/StudentLogin";
import SubjectBookSuccessfully from "./components/SubjectBookSuccessfully";
import AdminLogin from "./components/AdminLogin";
import AdminSubject from "./components/AdminSubject";
import AddSubject from "./components/AddSubject";

function App() {
  return (
    <BrowserRouter>
      <Header/>
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route exact path="/about" element={<About />} />
        <Route exact path="/login" element={<Login />} />
        <Route exact path="/signup" element={<Signup />} />
        <Route exact path="/subjects" element={<Subjects/>} />
        <Route exact path="/profile" element={<ProfileEditInfo />} />
        <Route exact path="/profile/courses" element={<ProfileCourses />} />
        <Route exact path="/profile/settings" element={<ProfileSettings />} />
        
        <Route exact path="/sendPassword" element={<SendPassword />} />
        <Route exact path="/forgotPassword" element={<ForgotPassword />} />
        <Route exact path="/admincourse" element={<AdminCourse />} />
        <Route exact path="/addCourse" element={<AddCourse />} />
        <Route exact path="/updateCourse" element={<UpdateCourse />} />
        <Route exact path="/loginFailed" element={<LoginFailed />} />
        <Route exact path="/studentlogin" element={<StudentLogin />} />
        
        <Route exact path="/student" element={<Student />} />
        
        <Route exact path="/subjectbooksuccessfully" element={<SubjectBookSuccessfully />} />
        <Route exact path="/adminlogin" element={<AdminLogin />} />
        <Route exact path="/adminsubject" element={<AdminSubject />} />
        <Route exact path="/addsubject" element={<AddSubject />} />
        


      </Routes>
      <Footer/>
    </BrowserRouter>
  );
}

export default App;