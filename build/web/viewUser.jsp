<%-- Document : home 
     Created on : Jan 23, 2023, 12:44:40 AM 
     Author : Naod.A.G
--%> 
<%@page import="java.sql.ResultSet"%> 
<%@page import="com.servlet.registration.Customer"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<% ResultSet rs = (ResultSet) request.getAttribute("resultSet");%>
<% Customer cu = (Customer) session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <link rel="stylesheet" type="text/css" href="utill.css" />
        <link rel="stylesheet" type="text/css" href="home.css" />
        <link
            rel="stylesheet"
            href="fonts/material-icon/css/material-design-iconic-font.min.css"
            />

        <meta name="robots" content="noindex, follow" />
    </head>
    <body>
        <div class="limiter">
            <section class="table">
                <div class="container-table100">
                    <% request.setAttribute("hasSearch", true);
                           %>
                    <%@include file = "navBar.jsp" %>
                    <div class="wrap-table100">
                        <div class="table100">
                            <% if (rs != null) { %>
                            <table>
                                <thead>
                                    <tr class="table100-head">
                                        <th class="column1">User ID</th>
                                        <th class="column2">Full Name</th>
                                        <th class="column3">Address</th>
                                        <th class="column4">Email</th>
                                        <th class="column5">Phone Number</th>
                                        <th class="column7">Gender</th>
                                        <th class="column0">Role</th>
                                        <th class="column8">Del</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% while (rs.next()) {
                                            String fullName = rs.getString("fullName");
                                            String address = rs.getString("address");
                                            String email = rs.getString("email");
                                            String phoneNumber = rs.getString("phoneNumber");
                                            String password = rs.getString("password");
                                            String gender = rs.getString("gender");
                                            Boolean approved = rs.getBoolean("approved");
                                            String role = rs.getString("role");
                                            int userId = rs.getInt("userId");%>
                                    <tr>
                                        <td class="column1"><%= userId%></td>
                                        <td class="column2"><%= fullName%></td>
                                        <td class="column3"><%= address%></td>
                                        <td class="column4"><%= email%></td>
                                        <td class="column5"><%= phoneNumber%></td>
                                        <td class="column7"><%= gender%></td>
                                        <td class="column0"><%= role%></td>
                                        <td class="column8">
                                            <a href="deleteUser?id=<%= userId%>">
                                                <i class="zmdi zmdi-close-circle"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <% } %>
                                </tbody>
                            </table>
                            <% }%>
                        </div>
                    </div>
                </div>
            </section>
        </div>

        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>

        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <script src="vendor/select2/select2.min.js"></script>

        <script src="js/main.js"></script>

        <script
            async
            src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"
        ></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag() {
                dataLayer.push(arguments);
            }
            gtag("js", new Date());

            gtag("config", "UA-23581568-13");
        </script>
        <script
            defer
            src="https://static.cloudflareinsights.com/beacon.min.js/vaafb692b2aea4879b33c060e79fe94621666317369993"
            integrity="sha512-0ahDYl866UMhKuYcW078ScMalXqtFJggm7TmlUtp0UlD4eQk0Ixfnm5ykXKvGJNFjLMoortdseTfsRT8oCfgGA=="
            data-cf-beacon='{"rayId":"78e0b1403ba74f6a","token":"cd0b4b3a733644fc843ef0b185f98241","version":"2022.11.3","si":100}'
            crossorigin="anonymous"
        ></script>
    </body>
</html>
