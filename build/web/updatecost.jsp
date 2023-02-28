<%-- 
    Document   : home
    Created on : Jan 23, 2023, 12:44:40 AM
    Author     : Naod.A.G
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.servlet.registration.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Customer cu = (Customer) session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
  <head>
    <title>Update Cost</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <link rel="stylesheet" type="text/css" href="utill.css" />
    <link rel="stylesheet" type="text/css" href="home.css" />
    <link rel="stylesheet" type="text/css" href="profile.css" />
    <link rel="stylesheet" type="text/css" href="pay.css" />
    <link rel="stylesheet" type="text/css" href="updateCost.css" />
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
          <%@include file = "navBar.jsp" %>
          <section class="profile-body">
            <div class="profile-wrapper">
              <div class="profile-card">
              <form action="updateCost" method="post">
                <div class="profile-card-head">
                  <h1>Update Cost</h1>
                </div>
                  
                <div class="profile-card-body">
                  <div class="key">
                    <img src="./images/undraw_personal_information_re_vw8a.svg" alt="" />
                  </div>
                  <div class="value">
                      <div class="up update-one">
                        <label for="unit1" style="padding-right: 30px"
                          >Unit > 300
                        </label>
                        <input
                            type="number"
                          id="unit1"
                          placeholder="Enter Unit"
                          name="unit1"
                          required
                        />
                      </div>

                      <div class="up update-two">
                        <label
                          for="unit2"
                          style="padding-right: 55px !important"
                          >200 &leq; Unit < 300
                        </label>
                        <input
                          type="number"
                          id="unit2"
                          placeholder="Enter Unit"
                          name="unit2"
                          required
                        />
                      </div>

                      <div class="up update-three">
                        <label for="unit3" style="padding-right: 55px"
                          >100 &leq; Unit < 200
                        </label>
                        <input
                          type="number"
                          id="unit3"
                          placeholder="Enter Unit"
                          name="unit3"
                          required
                        />
                      </div>

                      <div class="up update-four">
                        <label for="unit4" style="padding-right: 50px"
                          >Unit < 100
                        </label>
                        <input
                          type="number"
                          id="unit4"
                          placeholder="Enter Unit"
                          name="unit4"
                          required
                        />
                      </div>
                  </div>
                </div>
                <div class="pay-container">
                    <div>
                        <% if (request.getAttribute("updated") != null) {%>
                            <div class="updated"><%= request.getAttribute("updated")%></div>
                        <% }%>
                    </div>
                    <button type="submit">
                      <div class="pay">
                        <p>Update Cost</p>
                      </div>
                    </button>
                </div>
               </form>
              </div>
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
