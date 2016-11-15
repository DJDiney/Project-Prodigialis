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
    <script src="http://code.jquery.com/jquery-latest.js">   </script>
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
    </style>



</head>

<body>
    <!--<div class="section white">
	
		<div class="row container">
		
			<h3 class="header">Situação do Processo Seletivo</h3>
			
			</br>
			
			<div class="row">
			
				<div class="input-field col s4">
					
						<select>
						
							<option value="" disabled selected>Escolha um processo</option>
							<option value="1">123 - 22</option>
							<option value="2">322 - 22</option>
							<option value="3">434 - 33</option>
							
						</select>
						
						<label>Nome do Processo Seletivo</label>
						
				</div>
				
				<div id="submit">
						
					</br>
					<button style="width:20%; margin-left:7%;" class="waves-effect waves-light btn-large" type="submit">Listar Dados
					<i class="material-icons left">list</i>
					</button>
						
				</div>
				
				<div class="left-align col-md2">
					
					<button style="width:20%;"  class="waves-effect waves-light btn-large" type="submit" name="action">Editar
					<i class="material-icons left">send</i>
					</button>
					
				</div>
			
			</div>
			
			<div class="row" id="proc" >
				
				<div class="input-field col s3">
				
					<input disable value="123 - 22" type="text" readonly class="validate">
					<label for="disabled">Nome do Processo</label>
					
				</div>
				
				<div class="input-field col s3">
				
					<input disable value="32" type="text" readonly class="validate">
					<label>Número de vagas</label>
					
				</div>
				
				<div class="input-field col s3">
				
					<input disable value="12/04/2016" readonly type="text" class="validate">
					<label>Data de Início</label>
					
				</div>
				
				<div class="input-field col s3">
				
					<input disable value="21/04/2016" readonly type="text" class="validate">
					<label>Data de Fim</label>
					
				</div>
			
			</div>
			
			<div class="row" id="pes" >
				
				
				<div class="input-field col s4">
				
					<select>
							
						<option value="" disabled selected>Escolha um curriculo</option>
						<option value="1">Jose</option>
						<option value="2">Maria</option>
						<option value="3">Heitor</option>
						
					</select>
					
					<label>Curriculos recebidos</label>
					
				</div>
				
				<div id="submit" class="left-align col-md2">
				
					<button style="width:30%; margin-left:7%;"  class="waves-effect waves-light btn-large" type="submit" name="action">Download do curriculo
					<i class="material-icons left">navigation</i>
					</button>
					
				</div>
				
			</div>

			<div class="row" id="pos">	
				
				</br>
				
				<div id="submit" class="left-align col-md2">
				
					<button style="width:30%;"  class="waves-effect waves-light btn-large" type="submit" name="action">Aprovar participação do candidato
					<i class="material-icons left">done</i>
					</button>
					
				</div>
			
				<div id="submit">
						
					</br>
					<p style="font-size:20px">Enviar email para candidato escolhido</p>
					<div class="input-field col s12">
					
						<textarea id="desc" class="materialize-textarea"></textarea>
						<label for="desc">Email</label>
						
					</div>
					</br>
					<button style="width:20%" class="waves-effect waves-light btn-large" type="submit">Enviar
					<i class="material-icons left">send</i>
					</button>
					
				</div>
			
			</div>
		
		</div>
		
    </div>-->
	
	<div class="container">
					<h3 class="header">Ver Processo Seletivo</h3>
					<div class="row">
					
						<div class="form-group col-md-10">
							
							<select class="form-control default-cursor">
							
								<option value="" disabled selected>Escolha um processo</option>
                                                                <% 
                                                                    
                                                                %>
								
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
					
					<label>Nome do Processo</label>
					<input readonly value="123 - 22"  type="text" class="form-control default-cursor">
					
				</div>
				
				<div class="form-group col-md-4 ">
					<label>Vagas de</label>
					<input readonly value="Programador"  type="text" class="form-control default-cursor">
				</div>
				
				<div class="form-group col-md-4 ">
					<label>Número de vagas</label>
					<input readonly value="32"  type="text" class="form-control default-cursor">
				</div>
			
			</div>
					
			<div class="row">
			
				<div class="form-group col-md-6 ">
					
					<label>Data de Início</label>
					<input readonly value="12/04/2016"  type="text" class="form-control default-cursor">
					
				</div>
				
				<div class="form-group col-md-6 ">
				
					<label>Data de Fim</label>
					<input readonly value="21/04/2016"  type="text" class="form-control default-cursor">
					
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
		</div>
		<hr/>
		<div class="container">
						
			<div class="row">
				<div class="form-group col-md-12">
				
					<label>Curriculos recebidos</label>
					<select class="form-control">
							
						<option value="" disabled selected>Escolha um curriculo</option>
						<option value="1">Jose</option>
						<option value="2">Maria</option>
						<option value="3">Heitor</option>
						
					</select>
					
					
				</div>
			</div>
			<div class="row">
				
				<div class="form-group col-md-12">
					<label>Nome do Candidato</label>
					<input value="José da Silva Santos" readonly type="text" class="form-control default-cursor">
				</div>
				
			</div>
			
			<div class="row">
			
				<div class="form-group col-md-8">
					<label>E-mail</label>
					<input value="jsilva@hotmail.com" type="text" readonly class="form-control default-cursor">
				</div>
				
				<div class="form-group col-md-4">
					<label>Telefone</label>
					<input value="(31)98888-8888" type="text" readonly class="form-control default-cursor">
				</div>
				
			</div>
			
			<div class="row">
			
				<div class="col-md-8">
					<label>Curriculo:</label>
				</div>
			</div>
			
			<div class="row">
				
				<div class="form-group col-md-8">
					<input value="83217428 " readonly type="text" class="form-control default-cursor">
				</div>	
				
				<div class="form-group pull-right col-md-4">
					<button  class="btn btn-fill" style="width:100%" type="submit" onclick="pesquisar()">Download
						<i class=" fa fa-list-alt"></i>
					</button>
				</div>
				
			</div>	

			<div class="row">
				<div class="form-group col-md-12">
					<label>Enviar email para candidato escolhido</label>
						<textarea placeholder="e-mail..." class="form-control"></textarea>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group pull-right col-md-4">
					<form id="form1" action="" method="post">
						<button type="submit" style="width:100%"  id="btnSubmit"  class=" btn btn-fill">
							Aprovar candidato <span class="fa fa-check" aria-hidden="true"></span>
						</button>
					</form>
				</div>
			
		</div>	
      
   
	
</body>