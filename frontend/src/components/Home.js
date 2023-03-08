import { Link } from 'react-router-dom';

const Home = (props) => {
    return (
        <>

            <header>
                <h2>Education is a key to Victory & Freedom from all the Forces</h2>
                {/* <p>Our full stack curriculum is supported by a passionate open source community.</p>
                <p>Remove your fresher's tag, join Industrial Training program now.</p> */}
                <Link to="/products" class="button">Let's Get Started</Link>
            </header>

            <main>
                <div id="section0">
                    <img src="Images/background1.jpg" height="500px" width="1000px" alt="header"  />
                </div>
                <div id="section1">
                    <div class="section1-heading" id="products">
                        {/* <h2>Product Description</h2>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ut itaque
                            rem nulla quas incidunt sint Id quo sed iure iste ipsam, vitae accusantium
                            voluptates iusto libero doloribus perferendis.</p> */}
                            <div></div>
                    </div>
                    <div class="card-view">
                        {/* <div class="card">
                            <img src="Images/book.svg" alt="Learn" />
                            <h2>Learn</h2>
                            <p>Learn from a curriculum with the best curated online tutorials, blogs, and courses.</p>
                        </div> */}
                        <div class="card">
                            <img src="Images/pc.svg" alt="Build" />
                            <h2>Motivation</h2>
                            <p>Some of the brightest mind can be found On the
                                 last benches of the classroom."</p>
                        </div>
                        <div class="card">
                            <img src="Images/connect.svg"  alt="Connect" />
                            <h2>Connect</h2>
                            <p>Education is the passport to the future, for tomorrow belongs to those who prepare for it today.</p>
                        </div>
                    </div>
                </div>
              
            </main>

        </>
    );
}
export default Home;
