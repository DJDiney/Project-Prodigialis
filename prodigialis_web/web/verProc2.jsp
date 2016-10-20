<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="./Sobre_files/icon" rel="stylesheet">
	<link href="./Sobre_files/css" rel="stylesheet" type="text/css">
	<link type="text/css" rel="stylesheet" href="./Sobre_files/materialize.min.css" media="screen,projection">
	<script type="text/javascript" src="./Sobre_files/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="./Sobre_files/materialize.min.js"></script>
	<script src="./Sobre_files/init.js"></script>
	
</head>

<body style="font-family:Oswald">
	
		<div class="row container">
		
			<h3 class="header">Ver Processo Seletivo</h3>
			
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
				
				<div class="left-align col-md2">
						
					</br>
					<button style="width:20%; margin-left:7%;" class="waves-effect waves-light btn-large" type="submit" onclick="pesquisar()">Listar Dados
					<i class="material-icons left">list</i>
					</button>
						
				</div>
				
			
			</div>
			
			<div class="row" id="proc" >
				
				</br>
				
				<div class="input-field col s3">
				
					<input disable value="123 - 22" id="disabled" type="text" class="validate">
					<label for="disabled">Nome do Processo</label>
					
				</div>
				
				<div class="input-field col s3">
				
					<input disable value="32" id="disabled" type="text" class="validate">
					<label for="disabled">Número de vagas</label>
					
				</div>
				
				<div class="input-field col s3">
				
					<input disable value="12/04/2016" id="disabled" type="text" class="validate">
					<label for="disabled">Data de Início</label>
					
				</div>
				
				<div class="input-field col s3">
				
					<input disable value="21/04/2016" id="disabled" type="text" class="validate">
					<label for="disabled">Data de Fim</label>
					
				</div>
			
			</div>
			
			<div class="row">
			
				<div id="submit" class="left-align col-md4">
				
					<button style="width:30%"  class="waves-effect waves-light btn-large" onclick="window.location.href=EnvCurriculos.html">Inscrever no Processo
					<i class="material-icons left">person_pin</i>
					</button>
					
				</div>
				
			</div>
		
		</div>
		
    </div>
	
</body>