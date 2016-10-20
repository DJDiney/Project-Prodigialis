<head>
    <link href="bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/ct-paper.css" rel="stylesheet"/>
    <meta charset="UTF-8">
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <meta name="viewport" content="width=device-width, user-scalable=no">
    <link href="x_login-register modal/login-register.css" rel="stylesheet" />
    <link href="component.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>
    <script src="assets/js/custom.js"></script> 
    <script src="assets/js/jquery-1.10.2.js"></script> 
    <script src="x_login-register modal/login-register.js"></script> 
    <script src="custom-file-input.js"></script>
    <style>
        .form-group>.form-control{
            background-color:#D1D1D1;
            color:#66615B;
        }

        .form-group>.form-control:focus{
            background-color:white;
            color:#66615B;
        }	

        .form-group>.form-control::-webkit-input-placeholder {
            color: #66615B;
        }

        .form-group>.form-control:-moz-placeholder { /* Firefox 18- */
            color: #66615B;  
        }

        .form-group>.form-control::-moz-placeholder {  /* Firefox 19+ */
            color: #66615B;  
        }

        .form-group>.form-control:-ms-input-placeholder {  
            color: #66615B;  
        }

        #btnSubmit{
            border-color:#66615B;
            color:#d1d1d1;
        }



        #btnInput{
            border-color:#66615B;
            color:#66615B;
        }

        #btnInput:hover{
            background-color:#66615B;
            color:#d1d1d1;
        }

        .inputfile {
            width: 0.1px;
            height: 0.1px;
            opacity: 0;
            overflow: hidden;
            position: absolute;
            z-index: -1;
        }
    </style>

</head>

<body style="">
    <div id="navbar">
        <div id="includedContent">
            <nav class="navbar navbar-default" style="background-color:#36312B;padding-top:0px;margin-bottom:5px;padding-bottom:0px" role="navigation" id="navbar">
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
                                <a href="EnvCurriculos.html" class="btn btn-simple">Envie seu currículo</a>
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
                                        <form method="post" action="/login" accept-charset="UTF-8">
                                            <input id="email" class="form-control" type="text" placeholder="Email" name="email">
                                            <input id="password" class="form-control" type="password" placeholder="Senha" name="password">
                                            <input class="btn btn-default btn-login" type="button" value="Login" onclick="loginAjax()">
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
                                <span>Já tem uma conta?</span>
                                <a href="javascript: showLoginForm();">Login</a>
                            </div>
                        </div>        
                    </div>
                </div>
            </div>
            <div class="container">
                <h3> Enviar curriculo</h3>

                <div class="form-group" >
                    <input type="text" value=""  placeholder="Nome completo" class="form-control" />
                </div>  


                <div class="row">

                    <div class="form-group col-md-8 col-xs-12">
                        <input type="text" value=""  placeholder="Endereço" class="form-control" />
                    </div>

                    <div class="form-group col-md-2" >
                        <input type="text" value=""  placeholder="Numero" class="form-control" />
                    </div> 


                    <div class="form-group col-md-2" >
                        <input type="text" value=""  placeholder="Complemento" class="form-control" />
                    </div> 

                </div>

                <div class="row">

                    <div class="form-group col-md-4" >

                        <select class="form-control">

                            <option value="" disabled selected>Escolha um estado</option>
                            <option value="1">Minas Gerais</option>
                            <option value="2">Rio de Janeiro</option>
                            <option value="3">São Paulo</option>

                        </select>

                    </div>

                    <div class="form-group col-md-4" >

                        <select class="form-control">

                            <option value="" disabled selected>Escolha uma cidade</option>
                            <option value="1">Belo Horizonte</option>
                            <option value="2">Sabará</option>
                            <option value="3">Contagem</option>

                        </select>

                    </div>

                    <div class="form-group col-md-4" >
                        <input type="text" value=""  placeholder="CEP" class="form-control" />
                    </div> 

                </div>

                <div class="row">

                    <div class="form-group col-md-8 col-xs-12" >
                        <input type="email" value=""  placeholder="Email" class="form-control" />
                    </div> 

                    <div class="form-group col-md-4" >
                        <input type="text" value=""  placeholder="Telefone" class="form-control" />
                    </div> 

                </div>

                <div class="row">

                    <div class="input-field col-md-12 ">
                        <input type="file" name="file-7[]" id="file-7" class="inputfile inputfile-6" data-multiple-caption="{count} arquivos selecionados" multiple="">
                        <label for="file-7"><span></span> <a id="btnInput"  class="btn btn-primary"> Arquivo…</a></label>

                    </div>

                </div>

                <div class="row">



                    <div class="form-group pull-right col-md-4">
                        <form id="form1" action="" method="post">
                            <button type="submit" style="width:100%"  id="btnSubmit"  class=" btn btn-fill">
                                Enviar <i class="fa fa-paper-plane" aria-hidden="true"></i>
                            </button>
                        </form>
                    </div>
                </div>

            </div>
        </div>
</body>