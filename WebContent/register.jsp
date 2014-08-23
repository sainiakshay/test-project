<html lang="en"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Smart Healthcare</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-login.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>

    <style>
        .bbody {
        display: table;
        width: 100%;
        height: auto;
        padding: 100px 0;
        color: #002952;
        background-image:url('img/healthcareblurred.jpg');
        background-color:#cccccc;
        background-image: url(img/healthcare-pr.jpg) no-repeat bottom center scroll;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        background-size: cover;
        -o-background-size: cover;
        }   
        
        .footerclass{
			  position: relative;
			  margin-top: -50px; /* negative value of footer height */
			  clear:both;
			  padding-top:20px;
			  text-align:center;
		}
        .navb {
        	margin-bottom: 0;
    		border-bottom: 1px solid rgba(255,255,255,.3);
		    text-transform: uppercase;
		    font-family: Montserrat,"Helvetica Neue",Helvetica,Arial,sans-serif;
		    font-weight: bolder;
		    color: #002952;
		    background-color: #000;
		    letter-spacing:1px;
		    font-size:14px;
        } 
    </style>

	<script type="text/javascript">
		function checkPass()
		{
		    //Store the password field objects into variables ...
		    var pass1 = document.getElementById('pass1');
		    var pass2 = document.getElementById('pass2');
		    
		    //Set the colors we will be using ...
		    var goodColor = "#66cc66";
		    var badColor = "bisque";
		    //Compare the values in the password field 
		    //and the confirmation field
		    if(pass1.value == pass2.value){
		        //The passwords match. 
		        //Set the color to the good color and inform
		        //the user that they have entered the correct password 
		        pass2.style.backgroundColor = goodColor;
		    }else{
		        //The passwords do not match.
		        //Set the color to the bad color and
		        //notify the user.
		        pass2.style.backgroundColor = badColor;
		        
		    }
		}  
		
	</script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
	<nav class="navb navbar-custom navbar-fixed-top" role="navigation" style="background-color:white; color:#002952; font-weight:bolder; font-size:14px;">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
                <a href="index.html"><img src="Smart Health Logo Final.PNG" width="242px" height="50px"></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="http://10.189.244.195:8080/MedicalPredictionApp/index.html#about">About</a>
                    </li>
                    <li class="page-scroll">
                        <a href="http://10.189.244.195:8080/MedicalPredictionApp/index.html#contact">Contact</a>
                    </li>
                    <li class="page-scroll">
                        <a href="login.jsp">Login</a>
                    </li>
                    <li class="page-scroll">
                        <a href="register.jsp">Register</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
	
    <div class="container thisbackground bbody" style="height:100%">

      <form class="form-signin" role="form"  action="http://10.189.244.195:8080/MedicalPredictionApp/register" method="post" style="padding-top:80px;">
        <h2 class="form-signin-heading" style="color:white";>Please register</h2>
        <input type="text" name="userName" class="form-control" placeholder="Name" required="" autofocus="">
        <input type="email" name="email" class="form-control" placeholder="Email address" required="" autofocus="">
        <input type="password" id="pass1" name="password" class="form-control" placeholder="Password" required="" autofocus="" style="margin-bottom:0px";>
        <input type="password" id="pass2" class="form-control" placeholder="Confirm Password" required="" onkeyup="checkPass(); return false;">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-bottom:10px";>Register</button>
        <a href="/MedicalPredictionApp/login.jsp" style="color:#002952";>Already have an account?</a>
      </form>

    </div> <!-- /container -->
    
    <footer>
	 	<div class="footerclass container content-section text-center" style="padding-bottom:0px;">
	            <p style="font-size:15px;">Copyright © 2014, smarthealthcare-env.elasticbeanstalk.com</p>
	    </div>
	</footer>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  

</body></html>