<%@ page import="com.criminal_record_management.entities.Users" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crime Records Management System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/index.css">
    <style>
        /* Added CSS for Login and Register links */
        .user-auth a:hover {
            color: blue !important;
        }
    </style>
</head> 
<body>
<% Users u =(Users) session.getAttribute("currentUser"); %>
    <header>
        <div class="logo">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Seal_of_Karnataka.svg/800px-Seal_of_Karnataka.svg.png" alt="CRMS Logo" width="90" height="80">
        </div>
        <nav>
            <ul>
                <li><a href="#" style="text-decoration: none; color: white ; padding: 10px 20px; transition: all 0.3s ease;" onmouseover="this.style.backgroundColor='lightgray'; this.style.borderRadius='5px'; this.style.boxShadow='0 0 5px rgba(0, 0, 0, 0.2)'" onmouseout="this.style.backgroundColor=''; this.style.borderRadius=''; this.style.boxShadow=''">Home</a></li>
                <!-- Updated link for "Crimes" to point to crimes.html -->
                <li><a href="crimes.jsp" style="text-decoration: none; color: white; padding: 10px 20px; transition: all 0.3s ease;" onmouseover="this.style.backgroundColor='lightgray'; this.style.borderRadius='5px'; this.style.boxShadow='0 0 5px rgba(0, 0, 0, 0.2)'" onmouseout="this.style.backgroundColor=''; this.style.borderRadius=''; this.style.boxShadow=''">Crimes</a></li>
                <li><a href="fir.jsp" style="text-decoration: none; color: white; padding: 10px 20px; transition: all 0.3s ease;" onmouseover="this.style.backgroundColor='lightgray'; this.style.borderRadius='5px'; this.style.boxShadow='0 0 5px rgba(0, 0, 0, 0.2)'" onmouseout="this.style.backgroundColor=''; this.style.borderRadius=''; this.style.boxShadow=''">FIRs</a></li>
                <li><a href="criminals.jsp" style="text-decoration: none; color: white; padding: 10px 20px; transition: all 0.3s ease;" onmouseover="this.style.backgroundColor='lightgray'; this.style.borderRadius='5px'; this.style.boxShadow='0 0 5px rgba(0, 0, 0, 0.2)'" onmouseout="this.style.backgroundColor=''; this.style.borderRadius=''; this.style.boxShadow=''">Criminals</a></li>
                <li><a href="complaints.jsp" style="text-decoration: none; color: white; padding: 10px 20px; transition: all 0.3s ease;" onmouseover="this.style.backgroundColor='lightgray'; this.style.borderRadius='5px'; this.style.boxShadow='0 0 5px rgba(0, 0, 0, 0.2)'" onmouseout="this.style.backgroundColor=''; this.style.borderRadius=''; this.style.boxShadow=''">Complaints</a></li>
            </ul>
        </nav>
        
        <div class="user-auth">
            <a href="<%= (u != null) ? "logout.jsp" : "login.jsp" %>"><%= (u != null) ? "Logout" : "Login" %></a> / <a href="register.jsp">Register</a>
        </div>
    </header>
    <main>
        <!-- Bootstrap Carousel -->
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="https://lifebeyondnumbers.b-cdn.net/wp-content/uploads/2019/01/National-Emblem-of-India.jpg" class="d-block w-100" alt="Image 1" width="150" height="510">
                </div>
                <div class="carousel-item">
                    <img src="https://static.vecteezy.com/system/resources/thumbnails/022/596/287/small/judge-gavel-with-justice-lawyers-having-team-meeting-at-law-firm-in-background-concepts-of-law-generative-ai-photo.jpg" class="d-block w-100" alt="Image 2" width="150" height="510">
                </div>
                <div class="carousel-item">
                    <img src="https://images.unsplash.com/photo-1589829545856-d10d557cf95f?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8bGF3fGVufDB8fDB8fHww" class="d-block w-100" alt="Image 3" width="150" height="510">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <section class="banner">
            <marquee><h1>Welcome to the Crime Records Management System</h1></marquee>
            <p>Keep track of crimes, FIRs, criminals, and complaints.</p>
            <a href="#" class="btn">Get Started</a>
        </section>
        
    </main>
    <footer>
        <div class="contact-info">
            <p>Contact us: info@crms.com</p>
        </div>
        <div class="legal">
            <a href="#">Terms of Service</a> | <a href="#">Privacy Policy</a>
        </div>
        <div class="legal">
            <a href="#">About Us</a>
        </div>
    </footer>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
