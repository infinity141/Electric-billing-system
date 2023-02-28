<%-- 
    Document   : billGenerated
    Created on : Jan 23, 2023, 12:44:40 AM
    Author     : Naod.A.G
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.servlet.registration.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ResultSet rsHistory = (ResultSet) request.getAttribute("resultHistory");%>
<% Customer cu = (Customer) session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Bill Report</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <link rel="stylesheet" type="text/css" href="utill.css" />
        <link rel="stylesheet" type="text/css" href="home.css" />
        <link rel="stylesheet" type="text/css" href="historyUser.css" />
        <link rel="stylesheet" type="text/css" href="billGenerated.css" />
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
                    <% request.setAttribute("hasSearch", true); %>
                    <%@include file = "navBar.jsp" %>
                    <div class="wrap-table100">
                        <div class="table100">
                            <% if (rsHistory != null) { %> 
                            <table>
                                <thead>
                                    <tr class="table100-head">
                                        <th class="column1">User ID</th>
                                        <th class="column2">Full Name</th>
                                        <th class="column3">Address</th>
                                        <th class="column4">Unit (KW)</th>
                                        <th class="column5">Amount ($)</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        while (rsHistory.next()) {
                                            int userId = rsHistory.getInt("userId");
                                            String fullName = rsHistory.getString("fullName");
                                            String address = rsHistory.getString("address");
                                            int unit = rsHistory.getInt("unit");
                                            int charge = rsHistory.getInt("charge");
                                    %> 
                                    <tr>
                                        <td class="column1"><%= userId%></td>
                                        <td class="column2"><%= fullName%></td>
                                        <td class="column3"><%= address%></td>
                                        <td class="column4"><%= unit%></td>
                                        <td class="column5"><%= charge%></td>
                                    </tr>
                                    <% } %> 
                                </tbody>
                            </table>
                            <% } %> 
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
