<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.criminal_record_management.helper.ConnectionProvider" %>
<%@ page import="com.criminal_record_management.entities.Message" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FIR Records Management System</title>
    <!-- Add the link to fir.css here -->
    <link rel="stylesheet" href="css/fir.css">
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Your custom CSS styles */
        body {
            font-family: Arial, sans-serif;
        }

        #fir-section {
            margin-top: 50px;
        }

        .table-responsive {
            margin-bottom: 20px;
        }

        .add-btn {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <% Message m1 = (Message) session.getAttribute("msg");
       if(m1 != null) { %>
           <div class="alert alert-success" role="alert">
               <%= m1.getContent() %>
           </div>
           <% session.removeAttribute("msg"); %>
    <% } %>
    
    <section id="fir-section">
        <div class="container">
            <h2 class="text-center">Manage FIR Records</h2>
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>S.No</th>
                            <th>Date of FIR</th>
                            <th>Complainant Name</th>
                            <th>Fir's PoliceName</th>
                            <th>Incident Date</th>
                            <th>Incident Time</th>
                            <th>Location</th>
                            <th>Incident Description</th>
                            <th>Accused Details</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            Connection con = null;
                            Statement stmt = null;
                            ResultSet rs = null;
                            try {
                                con = ConnectionProvider.getConnection();
                                stmt = con.createStatement();
                                String query = "SELECT * FROM fir";
                                rs = stmt.executeQuery(query);
                                int count = 1;
                                while (rs.next()) {
                        %>
                                    <tr>
                                        <td><%= count++ %></td>
                                        <td><%= rs.getString("date_of_fir") %></td>
                                        <td><%= rs.getString("complainant_name") %></td>
                                        <td><%= rs.getString("police_name") %></td>
                                        <td><%= rs.getString("incident_date") %></td>
                                        <td><%= rs.getString("incident_time") %></td>
                                        <td><%= rs.getString("location") %></td>
                                        <td><%= rs.getString("incident_description") %></td>
                                        <td><%= rs.getString("accused_details") %></td>
                                        <td>
                                            <button class="btn btn-primary edit-btn" style="font-size: 14px;"><a href="editfir.jsp?firid=<%= rs.getInt("firid") %>" style="color: white; text-decoration: none;">Edit</a></button>
                                            
                                            <button class="btn btn-danger delete-btn" onclick="deleteFIR('<%= rs.getString("firid") %>')">Delete</button>

                                        </td>
                                    </tr>
                        <% 
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            } finally {
                                // Close resources in finally block
                                try {
                                    if (rs != null) rs.close();
                                    if (stmt != null) stmt.close();
                                    if (con != null) con.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
            <div class="text-center">
                <button class="btn btn-success add-btn" onclick="redirectToEdit('add')">Add FIR</button>
            </div>
        </div>
    </section>

    <!-- Add Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <script>
    // Function to redirect to edit_fir.jsp or add_fir.jsp based on action
    function redirectToEdit(action, firId) {
    if (action === 'edit') {
        // Redirect to the edit_fir.jsp page with the FIR ID as a query parameter
        window.location.href = "editfir.jsp?firid=" + firId;
    } else if (action === 'add') {
        window.location.href = "add_fir.jsp";
    }
}

    // Function to delete a FIR record
    function deleteFIR(firId) {
        if (confirm("Are you sure you want to delete this FIR record?")) {
            // Redirect to the servlet responsible for deleting the FIR record
            window.location.href = "delete_fir?firid=" + firId;
        }
    }
</script>
</body>
</html>
