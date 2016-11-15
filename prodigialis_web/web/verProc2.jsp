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
			$('#Specs').click(function(){
				$('#Caret').toggleClass('CaretDown CaretRight');
				
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
		
		
		#Caret{
			transition:  ease-in 0.2s;
		}
		
		.CaretDown{
			-webkit-transform:rotate(90deg);
		}
		
		.CaretRight{
			-webkit-transform:rotate(0deg);
		}
		 
    </style>



</head>

<body>
	
		<div class="container">
					<h3 class="header">Ver Processo Seletivo</h3>
					<div class="row">
					
						<div class="form-group col-md-10">
							
							<select class="form-control">
							
								<option value="" disabled selected>Escolha um processo</option>
								<!--<option value="1">123 - 22</option>
								<option value="2">322 - 22</option>
								<option value="3">434 - 33</option>-->
								
							</select>
							
							<!--<div id="d1" class="wrapper-dropdown" tabindex="1">
									<span>Processo...</span>
									<ul class="select-dropdown">
										<li><a href="#"><i class="icon-envelope icon-large"></i>123 - 22</a></li>
										<li><a href="#"><i class="icon-truck icon-large"></i>322 - 22</a></li>
										<li><a href="#"><i class="icon-plane icon-large"></i>434 - 33</a></li>
									</ul>
								</div>-->
						
						</div>
						
						<div class="form-group col-md-2 ">
							<button  class="btn btn-fill" style="width:100%" type="submit" onclick="pesquisar()">Listar Dados
							<i class=" fa fa-list-alt"></i>
							</button>
								
						</div>
						
					
					</div>
					
		</div>
		
					<hr/>
		<div class="container">	
			
			<div class="row" id="proc" >
				
				<div class="form-group col-md-4 ">
					
					<label for="disabled">Nome do Processo</label>
					<input disable value="123 - 22" id="disabled" type="text" class="form-control">
					
				</div>
				
				<div class="form-group col-md-4 ">
					<label for="disabled">Vagas de</label>
					<input disable value="Programador" id="disabled" type="text" class="form-control">
				</div>
				
				<div class="form-group col-md-4 ">
					<label for="disabled">N򭥲o de vagas</label>
					<input disable value="32" id="disabled" type="text" class="form-control">
				</div>
			
			</div>
					
			<div class="row">
			
				<div class="form-group col-md-6 ">
					
					<label for="disabled">Data de Ino</label>
					<input disable value="12/04/2016" id="disabled" type="text" class="form-control">
					
				</div>
				
				<div class="form-group col-md-6 ">
				
					<label for="disabled">Data de Fim</label>
					<input disable value="21/04/2016" id="disabled" type="text" class="form-control">
					
				</div>
			
			</div>
					
			<div class="row">
				<div class="form-group col-md-12 ">
					<label id="Specs" data-toggle="collapse" data-target="#demo">Especificações  </label><i id="Caret" class="fa fa-caret-right CaretRight" aria-hidden="true"></i>
					<div id="demo" class="collapse">
					<ul class="list-group">
						<li class="list-group-item">Especificação 1</li>
						<li class="list-group-item">Especificação 2</li>
						<li class="list-group-item">Especificação 3</li>
						<li class="list-group-item">Especificação 4</li>
						<li class="list-group-item">Especificação 5</li>
						<li class="list-group-item">Especificação 6</li>
					</ul>
					</div>
					
					
				</div>
			</div>
			
			<div class="row">
			
				<div class="form-group pull-right col-md-4">
					<form id="form1" action="" method="post">
						<button type="submit" style="width:100%"  id="btnSubmit"  class=" btn btn-fill">
							Enviar <span class="fa fa-check" aria-hidden="true"></span>
						</button>
					</form>
				</div>
				
			</div>
			
		</div>
	
</body>