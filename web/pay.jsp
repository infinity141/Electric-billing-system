<%-- 
    Document   : home
    Created on : Jan 23, 2023, 12:44:40 AM
    Author     : Naod.A.G
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.servlet.registration.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ResultSet rsBill = (ResultSet) request.getAttribute("resultBill");%>
<% Customer cu = (Customer) session.getAttribute("user");%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bill</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <link rel="stylesheet" type="text/css" href="utill.css" />
        <link rel="stylesheet" type="text/css" href="home.css" />
        <link rel="stylesheet" type="text/css" href="profile.css" />
        <link rel="stylesheet" type="text/css" href="pay.css" />
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
                    <%@include file = "navBarUser.jsp" %>
                    <section class="profile-body">
                        <div class="profile-wrapper">
                            <% Boolean billWasGenerated = false; %>
                            <% if (rsBill != null) { %>
                            <%
                                while (rsBill.next()) {
                                    int unit = rsBill.getInt("unit");
                                    int charge = rsBill.getInt("charge");
                                    String date = rsBill.getString("date");
                                    String status = rsBill.getString("status");
                                    int historyId = rsBill.getInt("historyId");
                                    billWasGenerated = true;
                            %> 
                            <div class="profile-card">
                                <div class="profile-card-head">
                                    <h1>Bill</h1>
                                </div>
                                <div class="profile-card-body">
                                    <div class="key">
                                        <img src="./images/undraw_credit_card_re_blml.svg" alt="" />
                                    </div>
                                    <div class="value">
                                        <div style="font-size: 30px"><p><%= cu.fullName%></p></div>
                                        <div>
                                            <p><i class="zmdi zmdi-email"></i> | <%= unit%> KW</p>
                                        </div>
                                        <div>
                                            <p><i class="zmdi zmdi-calendar"></i> | <%= date%></p>
                                        </div>
                                        <div>
                                            <p><i class="zmdi zmdi-money-box"></i> | $ <%= charge%></p>
                                        </div>
                                        <div>
                                            <p><i class="zmdi zmdi-receipt"></i> | <%= status%></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="pay-container">
                                    <form action="paymenntRedirector" method="post">
                                        <input type="hidden" value="<%= historyId%>" name="historyIdRed">
                                        <button type="submit">
                                            <div class="pay">
                                                <p>Pay Bill</p>
                                            </div>
                                        </button>
                                    </form>
                                </div>
                            </div>
                            <% } %>
                            <% }
                                if (!billWasGenerated) { %>
                            <img src="images/undraw_dreamer_re_9tua.svg" alt="alt" width="500px"/>
                            <br>
                            <h1 align ="center" ><font color = "gray" >You have no bills to pay <br> Thank you so much</font></h1>
                                <% }%>
                        </div>
                    </section>
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
