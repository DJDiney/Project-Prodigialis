<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Bootstrap Vertical Tabs</title>
        <link href="bootstrap3/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/ct-paper.css" rel="stylesheet"/>
        <link href="x_login-register modal/login-register.css" rel="stylesheet" />
        <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>
        <script src="assets/js/custom.js"></script> 
        <script src="assets/js/jquery-1.10.2.js"></script> 
        <script src="x_login-register modal/login-register.js" type="text/javascript"></script>
        <script src="x_login-register modal/bootstrap3/js/bootstrap.js" type="text/javascript"></script>
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
        <link href="login-register.css" rel="stylesheet" />
        <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    </head>

    <body>
        <div class="nav-tabs-navigation">
            <div class="nav-tabs-wrapper">
                <ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
                    <li class="active"><a href="#home" data-toggle="tab">Home</a></li>
                    <li><a href="#profile" data-toggle="tab">Profile</a></li>
                    <li><a href="#messages" data-toggle="tab">Messages</a></li>
                </ul>
            </div>
        </div>
        <div id="my-tab-content" class="tab-content text-center">
            <div class="tab-pane active" id="home">
                <p>Here is information about home.</p>
            </div>
            <div class="tab-pane" id="profile">
                <p>Here is your profile.</p>
            </div>
            <div class="tab-pane" id="messages">
                <p>Here are your messages.</p>
            </div>
        </div>
    </body>
</html>