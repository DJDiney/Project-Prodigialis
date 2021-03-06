

<head>

    <link href="bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/ct-paper.css" rel="stylesheet"/>
    <meta charset="ISO-8859-1">
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <meta name="viewport" content="width=device-width, user-scalable=no">
    <link href="x_login-register modal/login-register.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>
    <script src="assets/js/custom.js"></script> 
    <script src="assets/js/jquery-1.10.2.js"></script> 
    <script src="x_login-register modal/login-register.js" type="text/javascript"></script>
    <script src="x_login-register modal/bootstrap3/js/bootstrap.js" type="text/javascript"></script>
    <script src="assets/js/ct-paper.js"></script> 
    <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
    <script >
        function validarCamposLogin() {
            var frm = document.frmLogin;
            var nome = frm.email.value;
            var senha = frm.password.value;

            if (nome == "") {
                alert("Por Favor, preencha o campo de email!");
                frm.nome.focus();
                return false;
            } else if (senha == "") {
                alert("Favor, preencha o campo senha!");
                frm.senha.focus();
                return false;
            } else {
                caminhourl = "/ServletWeb?acao=Logar";
                document.frmLogin.action = caminhourl;
                window.document.frmLogin.submit();
                return true;
            }
        }
        $(window).scroll(function () {
            if ($(window).scrollTop() >= 300) {
                $('.navbar').css('padding-top', '0px');
                $('.navbar').css('padding-bottom', '0px');
                $('.navbar').css('background-color', '#36312B');

            } else {
                $('.navbar').css('background', 'transparent');
                $('.navbar').css('padding-top', '10px');
                $('.navbar').css('padding-bottom', '10px');
            }
        });
    </script>
    <script>
    </script>
    <script>
        $(window).scroll(function () {
            if ($(window).scrollTop() >= 300) {
                document.getElementById('imgNavBlur').style.opacity = "1";
            }
            else {
                document.getElementById('imgNavBlur').style.opacity = "0";
            }
        });
    </script>
</head>

<body>
    <div id="navbar">
        <div id="includedContent">
            <nav class="navbar navbar-fixed-top navbar-ct-transparent" role="navigation" id="navbar">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" >
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" style="color:#D1D1D1" href="#">Prodigialis RH</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="navigation-example-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="Saiba.html" class="btn btn-simple">Sobre a empresa</a>
                            </li>
                            <li>
                                <a href="EnvCurriculos.html" class="btn btn-simple">Envie seu curr�culo</a>
                            </li>
                            <li>
                                <a target="_blank" data-toggle="modal" href="javascript:void(0)" onclick="openLoginModal();" class="btn btn-primary">Log-in</a>
                            </li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-->
            </nav>
            <div class="modal fade login" id="loginModal">
                <div class="modal-dialog login animated">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Fazer log-in com:</h4>
                        </div>
                        <div class="modal-body">  
                            <div class="box">
                                <div class="content">
                                    <div class="social">
                                        <a class="circle github" href="/auth/github">
                                            <i class="fa fa-github fa-fw"></i>
                                        </a>
                                        <a id="google_login" class="circle google" href="/auth/google_oauth2">
                                            <i class="fa fa-google-plus fa-fw"></i>
                                        </a>
                                        <a id="facebook_login" class="circle facebook" href="/auth/facebook">
                                            <i class="fa fa-facebook fa-fw"></i>
                                        </a>
                                    </div>
                                    <div class="division">
                                        <div class="line l"></div>
                                        <span>ou</span>
                                        <div class="line r"></div>
                                    </div>
                                    <div class="error"></div>
                                    <div class="form loginBox">
                                        <form name="frmLogin" method="post" accept-charset="UTF-8">
                                            <input id="email" class="form-control" type="text" placeholder="Email" name="email">
                                            <input id="password" class="form-control" type="password" placeholder="Senha" name="password">
                                            <input class="btn btn-default btn-login" type="button" value="Login" onclick="validarCamposLogin()">
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="box">
                                <div class="content registerBox" style="display:none;">
                                    <div class="form">
                                        <form method="post" html="{:multipart=>true}" data-remote="true" action="/register" accept-charset="UTF-8">
                                            <input id="email" class="form-control" type="text" placeholder="Email" name="email">
                                            <input id="password" class="form-control" type="password" placeholder="Senha" name="password">
                                            <input id="password_confirmation" class="form-control" type="password" placeholder="Repita a senha" name="password_confirmation">
                                            <input class="btn btn-default btn-register" type="submit" value="Criar conta" name="commit">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <div class="forgot login-footer">
                                <span>Deseja 
                                    <a href="javascript: showRegisterForm();">criar uma conta</a>
                                    ?</span>
                            </div>
                            <div class="forgot register-footer" style="display:none">
                                <span>J� tem uma conta?</span>
                                <a href="javascript: showLoginForm();">Login</a>
                            </div>
                        </div>        
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="blurred-container" style>
        <div class="img-src" id="imgNav" style="background-image: url('imagens/bg2.jpg')"></div>
        <div class="img-src blur" id="imgNavBlur"  style="opacity: 0; background-image: url('imagens/bg2_blur.jpg');"></div>
        <div class="text-center" style="padding-top:15%"></div>
    </div>
    
<div class="main">
    <div class="container" style="max-width:800px; padding-top:10px">
        <h1 class="text-center" style="color:black">Prodigialis RH<br><small class="subtitle" style="font-family:Grand Hotel">Diga-l�!</small></h1> 

        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>   
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

        <!--     end extras -->        
    </div>
    <footer class="footer" style="background-color:#36312B;color:#d1d1d1;text-align:center;padding-top:30px;padding-bottom:30px;">
        <div class="container">
            <div>Prodigialis RH<span>  ?  </span>Trabalho de conclus�o de curso</div>
            <div>Centro Federal de Educa��o Tecnol�gica de Minas Gerais</div>
            <div>J� nos conhece? Conhe�a a <a href="" style="color:#777;">staff</a></div>
            <div>Publicado sob a licen�a de <a href="http://www.creative-tim.com/license" style="color:#777;">Creative Tim</a></div>
        </div>
    </footer>
        
</div>
</body>