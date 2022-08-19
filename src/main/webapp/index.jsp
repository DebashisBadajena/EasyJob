<%-- 
    Document   : index.jsp
    Created on : 08-Jun-2022, 10:40:22 PM
    Author     : Deb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>EasyJob Home</title>

        <link rel="stylesheet" href="CSS\style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <script src="https://kit.fontawesome.com/cf9057e802.js" crossorigin="anonymous"></script>


    </head>
    <body>
        <div class="nav-div">
            <nav>
                <a href="MainController?name=home"><h1 class="logo">EASY<span style="color: #fc2718;">JOB</span></h1></a>

                <div>
                    <ul> 
                        <li><a href="#service">Services</a></li>
                        <li><a href="#about-us">About Us</a></li>
                        <li><a href="#contact-us">Contact Us</a></li>
                        <a class="sign-up" href="MainController?name=signUp">Sign Up</a>
                        <a class="login" href="MainController?name=logIn">Log In</a>


                    </ul>
                </div>
            </nav>


        </div>


        <section class="welcome-section">
            <div class="landing-text">
                <h1>Find Your Next<br>Dream <span style="color: #fc2718;font-weight: bold;">Job</span> </h1>


            </div>
            <div class="search-area">

                <div class="reg-button">
                    <a href="MainController?name=signUp"><p style="text-decoration: none;">Register Now</p></a>
                </div>

            </div>

        </section>

        <section id="service">
            <div>
                <h1>Our Services</h1>
            </div>
            <div class="post-item-container">
                <h2>Posting <span style="color: #fc2718;">Jobs</span></h2>
                <div class="post-item">
                    <p>
                        Lorem ipsum dolor sit amet consectetur 
                        adipisicing elit. Dolor temporibus 
                        aspernatur placeat harum, quis 
                        exercitationem eius! Laboriosam
                        repudiandae nam, sit vel maxime
                        excepturi, corporis amet quibusdam
                        quaerat architecto repellendus saepe 
                        impedit velit? Ex, cum hic quibusdam
                        illum iure eaque obcaecati ipsam
                        voluptatibus unde sint quisquam 
                        eos amet nisi, ab pariatur.
                    </p>

                    <img src="src\job-post.png">
                </div>

            </div>

            <div class="search-item-container">
                <div class="search-heading-div">

                    <h2><span style="color: #fc2718;">Searching</span> jobs</h2>
                </div>
                <div class="search-item">
                    <img src="src\job-search2.png">
                    <p>
                        Lorem ipsum dolor sit amet consectetur 
                        adipisicing elit. Dolor temporibus 
                        aspernatur placeat harum, quis 
                        exercitationem eius! Laboriosam
                        repudiandae nam, sit vel maxime
                        excepturi, corporis amet quibusdam
                        quaerat architecto repellendus saepe 
                        impedit velit? Ex, cum hic quibusdam
                        illum iure eaque obcaecati ipsam
                        voluptatibus unde sint quisquam 
                        eos amet nisi, ab pariatur.
                    </p>
                </div>
            </div>

        </section>

        <section id="about-us">
            <div>
                <h1>About <span style="color: #fc2718;">Us</span></h2>
            </div>    
            <div class="about-us-container">
                <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Dolorum voluptate consectetur corporis? Voluptatum officiis nobis eligendi quos ullam animi! Commodi asperiores, optio quae sunt excepturi id dolores quisquam nihil aperiam eligendi, nostrum cumque dolor impedit totam quo, tempora neque labore quia maiores quos debitis? Pariatur magnam similique unde laudantium vero.</p>
            </div>

        </section>
        <section id="contact-us">
            <div>
                <h1>Contact <span style="color: #fc2718;">Us</span></h2>
            </div>
            <div class="icon">

                <a class="fb"  href="https://www.facebook.com/" target="_blank"><i class="fa-brands fa-facebook"></i></a>
                <a class="insta" href="https://www.instagram.com" target="_blank"><i class="fa-brands fa-instagram-square"></i></a>
                <a class="linkedin" href="https://www.linkedin.com" target="_blank"><i  class="fa-brands fa-linkedin"></i></a>
            </div>

        </section>
    </body>
</html>