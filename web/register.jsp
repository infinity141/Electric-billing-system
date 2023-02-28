<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Register</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Register</h2>
                                                    <% if (request.getAttribute("error") != null) { %>
                                                        <div class="register-error"><%= request.getAttribute("error") %></div>
                                                    <% } %>
						<form action="register" method="post" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> 
                                                                        <input type="text" placeholder="Enter your name" name="fullName" required>
							</div>
                                                        <div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-home"></i></label> 
                                                                        <input type="text" placeholder="City, Wereda, Home number" name="address" required>
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> 
                                                                <input type="email" placeholder="Enter your email" name="email" required>
							</div>
							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-phone"></i></label>
								<input type="text" placeholder="Enter your number"name="phoneNumber" required>
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> 
                                                                <input type="password" placeholder="Enter your password" name="password" required>
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" placeholder="Confirm your password" name="passwordConfirmation" required>
							</div>
							<div class="gender-details">
                                                            <input type="radio" name="gender" value="Male" id="dot-1">
                                                          <input type="radio" name="gender" value="Female" id="dot-2">
                                                          <span class="gender-title">Gender</span>
                                                          <div class="category">
                                                            <label for="dot-1">
                                                            <span class="dot one"></span>
                                                            <span class="gender">Male</span>
                                                          </label>
                                                          <label for="dot-2">
                                                            <span class="dot two"></span>
                                                            <span class="gender">Female</span>
                                                          </label>
                                                          </div>
                                                        </div>
                                                        <div class="gender-details">
                                                            <input type="radio" name="role" value="Admin" id="dot-3">
                                                          <input type="radio" name="role" value="Customer" id="dot-4">
                                                          <span class="gender-title">Role</span>
                                                          <div class="category">
                                                            <label for="dot-3">
                                                            <span class="dot three"></span>
                                                            <span class="gender">Admin</span>
                                                          </label>
                                                          <label for="dot-4">
                                                            <span class="dot four"></span>
                                                            <span class="gender">Customer</span>
                                                          </label>
                                                          </div>
                                                        </div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="login" class="signup-image-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>



</body>
</html>