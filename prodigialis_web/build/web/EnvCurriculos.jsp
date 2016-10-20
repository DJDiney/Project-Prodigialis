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
    <script>
        $('#file-7').change(function () {
            var filename = $('#file-7').val();
            $('#Filename').html(filename);
        });
        ​

    </script>	
    <script src="x_login-register modal/login-register.js"></script>
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

<body>
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

            <div class="input-field col-md-12">
                <input type="file" name="file-7[]" id="file-7" style="display:hidden" class="inputfile inputfile-6" data-multiple-caption="{count} arquivos selecionados" multiple="">
                <label for="file-7" class="width">
                    <a id="btnInput"  class="btn btn-fill" style="padding-left:60px;padding-right:60px;"> Arquivo…</a> 
                    <span id="Filename"></span>
                </label>

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