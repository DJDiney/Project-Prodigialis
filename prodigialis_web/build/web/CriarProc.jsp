<<<<<<< HEAD
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/ct-paper.css" rel="stylesheet"/>
    <meta charset="UTF-8">
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css">
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="x_login-register modal/bootstrap3/js/bootstrap.js" type="text/javascript"></script>
    <meta name="viewport" content="width=device-width, user-scalable=no">
    <script src="assets/js/ct-paper.js"></script>
	
    <!--jQuery custom-->
	<script src="assets/js/custom.js"></script>
	
	<!--Estilos customizados-->
     <link href="assets/css/custom.css" rel="stylesheet"/>

</head>

<body>


    <div class="container">

        <div class="row">

            <h3 class="header">Criar Novo Processo Seletivo</h3>

            </br>

            <div class="row">

                <div class="form-group col-md-6">
					
					<label>Nome do Processo</label>
                    <input id="nome_proc" type="text" class="form-control default-cursor">
                    

                </div>
				
				<div class="form-group col-md-6">
					
					<label>Número de vagas</label>
                    <input id="n_vagas" type="text" class="form-control default-cursor">
                    

                </div>

                
				
				

            </div>
			
			<div class="row">
				
				
				
				<div class="form-group col-md-6">
                    <label>Data de início</label>
                    <input type="text" id="data_ini" class="form-control default-cursor">
                </div>

                <div class="form-group col-md-6">

                    <label>Data de fim</label>
                    <input type="text" id="data_fim" class="form-control default-cursor">

                </div>
			
			
			</div>

            <div class="row">

                <div class="form-group col-md-12">
					
					<label>Descrição</label>
                    <textarea id="desc" class="form-control" style="height:150px"></textarea>
                    

                </div>

            </div>
			
			<div class="row">
				<label>Especificações</label>
			</div>
			<div class="row">
				<div class="form-group  col-sm-11" style="padding-right:0px">
					<input id="NewSpec" type="text" class="form-control">
				</div>
				<div class="form-group col-sm-1" style="padding-left:0px;text-align:left">
					<button  id="AddSpecs" class="btn btn-success btn-circle btn-simple pull-right" style="text-align:left"><i class="fa fa-plus adicionar" style="vertical-align:center;text-align:left"></i></button>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<ul class="list-group" id="SpecsList">
					  <!--<li class="list-group-item">Cras justo odio	<button  class="btn btn-danger btn-circle btn-simple pull-right btn-deleter"><i class="fa fa-times" style="vertical-align:center"></i></button></li>
					  -->
					</ul>
				</div>
			</div>
			
			<div class="row">
				<label>Prova</label>
				<div class="form-group col-md-12" >
					<input type="file" name="file-7[]" id="ArquivoProva" style="display:hidden" class="inputfile inputfile-6" data-multiple-caption="{count} arquivos selecionados" multiple="">
					<label for="ArquivoProva" class="width" >
						<a id="btnInput"  class="btn btn-fill" style="padding-left:60px;padding-right:60px;"> Prova</a> 
						<span id="DirArquivoProva"></span>
					</label>

				</div>

			</div>
			
			<div class="row">
				<div class="form-group col-md-12" >
					<input type="file" name="file-7[]" id="ArquivoGabarito" style="display:hidden" class="inputfile inputfile-6" data-multiple-caption="{count} arquivos selecionados" multiple="">
					<label for="ArquivoGabarito" class="width" >
						<a id="btnInput"  class="btn btn-fill" style="padding-left:60px;padding-right:60px;"> Gabarito</a> 
						<span id="DirArquivoGabarito"></span>
					</label>

				</div>

			</div>
			
			

            <div class="row">

                <div id="submit" class="form-group col-md-4 pull-right ">
					<form id="form1" action="" method="post">
						<button style="width:100%"  type="submit" name="action" class="btn btn-fill ">Criar Processo
						  <i class="fa fa-plus" ></i> 
						</button>
					</form>

                </div>

            </div>

        </div>

    </div>
=======
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/ct-paper.css" rel="stylesheet"/>
    <meta charset="UTF-8">
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css">
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>
    <script src="assets/js/custom.js"></script> 
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="x_login-register modal/bootstrap3/js/bootstrap.js" type="text/javascript"></script>
    <meta name="viewport" content="width=device-width, user-scalable=no">
    <script src="assets/js/ct-paper.js"></script>
    <script>
        $(document).ready(function () {
			$('#file-7').change(function () {
				var filename = $('#file-7').val();
				$('#Filename').html(filename);
			});
			
			$('#AddSpecs').click(function(){
				var spec = $('#NewSpec').val();
				$("#SpecsList").append('<li class="list-group-item">'+spec+'<button  class="btn btn-danger btn-circle btn-simple pull-right btn-deleter"><i class="fa fa-times" style="vertical-align:center"></i></button></li>');

			});
			
			$('#SpecsList').on('click', '.btn-deleter', function() {
				$(this).parent().remove();
			});
		});
		
    </script>
    <script src="x_login-register modal/login-register.js"></script>
    <style>
	
		form-group>.form-control{
			background-color:#D1D1D1;
			color:#66615B;
			}
			
		.form-group>.form-control:focus{
			background-color:white;
			color:#66615B;
			}	
			
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
        }

		#btnInput{
            border-color:#66615B;
        }
		
		#btnSubmit:hover{
            border-color:#333;
        }


        #btnInput:hover{
            border-color:#333;
        }

        .inputfile {
            width: 0.1px;
            height: 0.1px;
            opacity: 0;
            overflow: hidden;
            position: absolute;
            z-index: -1;
        }
		
		.main{
			z-index:0;
		}
		
		html {
		  position: relative;
		}
		body {
		  /* Margin bottom by footer height */
		  margin-bottom: 150px;
		}
		.footer {
		  position: absolute;
		  bottom: 0;
		  width: 100%;
		  /* Set the fixed height of the footer here */
		  height: 150px;
		}
		 
		input[readonly].default-cursor {
			cursor: default;
		}
		
		#Caret{
			transition:  ease-in 0.2s;
		}
		
		.CaretDown{
			-webkit-transform:rotate(90deg);
		}
		
		.CaretRight{
			-webkit-transform:rotate(0deg);
		}
		
		.fa-times:hover{
			color:#c50000; 
		}
		
		.btn-circle{
			 position: relative;
			padding: 0;
			margin: 0;
			
			background: transparent;
			color: inherit;
			font-size: 16px;
			border: none;
			outline: none;
			text-align: center;
			display: inline-block;
			box-sizing: border-box;
		}
		
		.btn-success{
			font-size:20px;
			width:41px;
			height:41px;
		}
		
		.fa-times{
			color:#66615b;
			align:center;
			vertical-align:center;
			width: 100%;
			transition: 0.1s ease-in;
		}
		
		.adicionar:hover{
			color:#42A084;
			
		}
		
		.adicionar{
			vertical-align:center;
			width: 100%;
		}
    </style>

</head>

<body>


    <div class="container">

        <div class="row">

            <h3 class="header">Criar Novo Processo Seletivo</h3>

            </br>

            <div class="row">

                <div class="form-group col-md-6">
					
					<label>Nome do Processo</label>
                    <input id="nome_proc" type="text" class="form-control default-cursor">
                    

                </div>
				
				<div class="form-group col-md-6">
					
					<label>Número de vagas</label>
                    <input id="n_vagas" type="text" class="form-control default-cursor">
                    

                </div>

                
				
				

            </div>
			
			<div class="row">
				
				
				
				<div class="form-group col-md-6">
                    <label>Data de início</label>
                    <input type="text" id="data_ini" class="form-control default-cursor">
                </div>

                <div class="form-group col-md-6">

                    <label>Data de fim</label>
                    <input type="text" id="data_fim" class="form-control default-cursor">

                </div>
			
			
			</div>

            <div class="row">

                <div class="form-group col-md-12">
					
					<label>Descrição</label>
                    <textarea id="desc" class="form-control" style="height:150px"></textarea>
                    

                </div>

            </div>
			
			<div class="row">
				<label>Especificações</label>
			</div>
			<div class="row">
				<div class="form-group  col-sm-11" style="padding-right:0px">
					<input id="NewSpec" type="text" class="form-control">
				</div>
				<div class="form-group col-sm-1" style="padding-left:0px;text-align:left">
					<button  id="AddSpecs" class="btn btn-success btn-circle btn-simple pull-right" style="text-align:left"><i class="fa fa-plus adicionar" style="vertical-align:center;text-align:left"></i></button>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<ul class="list-group" id="SpecsList">
					  <!--<li class="list-group-item">Cras justo odio	<button  class="btn btn-danger btn-circle btn-simple pull-right btn-deleter"><i class="fa fa-times" style="vertical-align:center"></i></button></li>
					  -->
					</ul>
				</div>
			</div>
			
			<div class="row">
				<label>Prova</label>
				<div class="form-group col-md-12" >
					<input type="file" name="file-7[]" id="file-7" style="display:hidden" class="inputfile inputfile-6" data-multiple-caption="{count} arquivos selecionados" multiple="">
					<label for="file-7" class="width" >
						<a id="btnInput"  class="btn btn-fill" style="padding-left:60px;padding-right:60px;"> Arquivo</a> 
						<span id="Filename"></span>
					</label>

				</div>

			</div>
			
			

            <div class="row">

                <div id="submit" class="form-group col-md-4 pull-right ">
					<form id="form1" action="" method="post">
						<button style="width:100%"  type="submit" name="action" class="btn btn-fill ">Criar Processo
						  <i class="fa fa-plus" ></i> 
						</button>
					</form>

                </div>

            </div>

        </div>

    </div>
>>>>>>> origin/master
</body>