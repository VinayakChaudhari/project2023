const About = (props) => {
    return (
        <>

            <div id="aboutContainer">
                <h2>About the Educare</h2>
                <p id="about">As the Indian Education System is facing so many problems,
                 we need to come up with effective solutions so 
                 it improves and creates a brighter future for students.
                  We can start by focusing on the skill development of the
                   students. The schools and colleges must not only focus on
                    the ranks and grades but on the analytical and creative 
                    skills of children. </p>


                <h2>Our Beliefs</h2>

                <div class="beliefs">
                    <div class="image">
                        <img src="Images/belief-image1.svg" alt=""/>
                    </div>
                    <div class="content">
                        <h3> 24*7 Help </h3>
                        <p>This service is availe for 24*7. Kindly use our service anytime when you want help. </p>
                    </div>
                </div>


                <div class="beliefs">
                    <div class="image">
                        <img src="Images/belief-image2.svg" alt=""/>
                    </div>
                    <div class="content">
                        <h3>You learn best by actually building </h3>
                        <p>The Odin Project curriculum is full of projects that will help you build a
                            strong portfolio of work on GitHub to fill out your resume. </p>
                    </div>
                </div>


                <div class="beliefs">
                    <div class="image">
                        <img src="Images/belief-image3.svg" alt=""/>
                    </div>
                    <div class="content">
                        <h3>Motivation is fueled by working with others </h3>
                        <p>We're committed to connecting students together so they can stay motivated
                            and learn faster. </p>
                    </div>
                </div>


                <div class="beliefs">
                    <div class="image">
                        <img src="Images/belief-image4.svg" alt=""/>
                    </div>
                    <div class="content">
                        <h3>Open source is best </h3>
                        <p>Our curriculum and website are available on GitHub and we encourage students
                            to actually contribute to the project itself! </p>
                    </div>
                </div>
            </div>
        </>
    );
}
export default About;