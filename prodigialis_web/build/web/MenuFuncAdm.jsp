<%@page import="br.cefetmg.inf.prodigialis.controller.Login"%>
<%@page import="br.cefetmg.inf.prodigialis.model.dao.impl.ProcessoSeletivoDAO"%>
<%@page import="br.cefetmg.inf.prodigialis.model.dao.impl.FuncionarioDAO"%>
<%@page import="br.cefetmg.inf.prodigialis.model.domain.ProcessoSeletivo"%>

<%  Character cod = (Character)request.getSession().getAttribute("codUsuario");
    if(cod != '0'){
        request.getSession().setAttribute("codUsuario", null);
    }
    Login.validarSessao(request,response);%>


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
    <script>
        //<![CDATA[
        window.onload=function(){
        /*
         -------------------------------------------------------
         syntax 
         MAIN.createRelatedSelector(
            from   -> the filtering element           
            to     -> the element for filtered options
            obj    -> An object containing the options per
                      option of the filtering (from) element
            [sort] -> optional sorting method for sorting
                      of the complete or filtered options list
         --------------------------------------------------------
        */
        
        //create the interdepent selectors
        function initSelectors(){
         // next 2 statements should generate error message, see console
         MAIN.createRelatedSelector(); 
         MAIN.createRelatedSelector(document.querySelector('#processo') );

         //countries
         MAIN.createRelatedSelector
             (   document.querySelector('#processo')           // from select element
                ,document.querySelector('#curriculos')      // to select element
                ,{                                               // values object 
                  <% 
                       ProcessoSeletivoDAO dao = new ProcessoSeletivoDAO();
                       java.util.ArrayList<ProcessoSeletivo> lista = dao.listarTodos();
                       for(int i=0;i<lista.size();i++){                                    
                   %>      
                     <%=lista.get(i).getNome()%>:[<%for(int j=0;j<lista.get(i).getParticipantes().size();j++){%>'<%=lista.get(i).getParticipantes().get(j).getNroInscricao()%>'<%if(j != lista.get(i).getParticipantes().size()-1){%> ,<%}%><%}%>]<%if(i != lista.size()-1){%> ,<%}%>
                   <%
                       }
                   %> }
              ,function(a,b){return a>b ? 1 : a<b ? -1 : 0;}   // sort method
         );
        }

        //create MAIN namespace
        (function(ns){ // don't pollute the global namespace

         function create(from, to, obj, srt){
          if (!from) {
                 throw CreationError('create: parameter selector [from] missing');
          }
          if (!to) {
                 throw CreationError('create: parameter related selector [to] missing');
          }
          if (!obj) {
                 throw CreationError('create: related filter definition object [obj] missing');
          }

          //retrieve all options from obj and add it
          obj.all = (function(o){
             var a = [];
             for (var l in o) {
               a = /array/i.test (o[l].constructor) ? a.concat(o[l]) : a;
             }
             return a.sort(srt);
          }(obj));
         // initialize and populate to-selector with all
          populator.call( from
                          ,null
                          ,to
                          ,obj
                          ,srt
          );

          // assign handler    
          from.onchange = populator;

          function initStatics(fn,obj){
           for (var l in obj) {
               if (obj.hasOwnProperty(l)){
                   fn[l] = obj[l];
               }
           }
           fn.initialized = true;
          }

         function populator(e, relatedto, obj, srt){
            ajaxUpdate();
            var self = populator;
            if (!self.initialized) {
                initStatics(self,{optselects:obj,optselectsall:obj.all,relatedTo:relatedto,sorter:srt || false});
            }

            if (!self.relatedTo){
                throw 'not related to a selector';
            }
            // populate to-selector from filter/all
            var optsfilter = this.selectedIndex < 1
                           ? self.optselectsall 
                           : self.optselects[this.options[this.selectedIndex].firstChild.nodeValue]
               ,cselect = self.relatedTo
               ,opts = cselect.options;
            if (self.sorter) optsfilter.sort(self.sorter);
            opts.length = 0;
            for (var i=0;i<optsfilter.length;i+=1){
                opts[i] = new Option(optsfilter[i],i);
            }
          }
         }

         // custom Error
         function CreationError(mssg){
             return {name:'CreationError',message:mssg};
         }

         // return the create method with some error handling   
         window[ns] = { 
             createRelatedSelector: function(from,to,obj,srt) {
                  try { 
                      if (arguments.length<1) {
                         throw CreationError('no parameters');
                      } 
                      create.call(null,from,to,obj,srt); 
                  } 
                  catch(e) { console.log('createRelatedSelector ->',e.name,'\n'
                                           + e.message +
                                           '\ncheck parameters'); }
                }
         };    
        }('MAIN'));
        //initialize
        initSelectors();
        }//]]> 
    </script>
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
            z-index: -12;
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
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        function ajaxUpdate(){
            var e = document.getElementById("processo");
            var par = e.options[e.selectedIndex].value;
            var tag = new XMLHttpRequest();
            tag.onreadystatechange = function(){
               if(tag.readyState == 4){
                    if(tag.status == 200){
                        obj = JSON.parse(tag.responseText);
                        document.getElementById("cod").value = obj[0];
                        document.getElementById("vaga").value = obj[1];
                        document.getElementById("nvaga").value = obj[2];
                        document.getElementById("datin").value = obj[3];
                        document.getElementById("datfim").value = obj[4];
                        document.getElementById("curriculos").value = 0;
                        document.getElementById("nomcand").value = '';
                        document.getElementById("email").value = '';
                        document.getElementById("tel").value = '';
                        document.getElementById("curcode").value = '';
                        //var resp = array();
                        //resp.push(item);
                    }else{
                    }
                }
            };
            
            tag.open("POST", "AjaxServlet");
            tag.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            tag.send("acao=dadosProcesso&id=" + par);
        }
    </script>
    <script>
        function curUpdate(){
            var e = document.getElementById("curriculos");
            var par = e.options[e.selectedIndex].text;
            var tag = new XMLHttpRequest();
            tag.onreadystatechange = function(){
               if(tag.readyState == 4){
                    if(tag.status == 200){
                        obj = JSON.parse(tag.responseText);
                        document.getElementById("nomcand").value = obj[0];
                        document.getElementById("email").value = obj[1];
                        document.getElementById("tel").value = obj[2];
                        document.getElementById("curcode").value = obj[3];
                        //var resp = array();
                        //resp.push(item);
                    }else{
                        alert("ruim");
                    }
                }
            };
            
            tag.open("POST", "AjaxServlet");
            tag.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            tag.send("acao=dadosCurriculo&id=" + document.getElementById("curriculos").options[e.selectedIndex].text);
        }
    </script>
</head>

<body>


    <div id="navbar">
        <div id="includedContent">
            <nav class="navbar navbar-default" style="background-color:#36312B;padding-top:0px;margin-bottom:5px;padding-bottom:0px" role="navigation" id="navbar">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" style="color:#D1D1D1" href="#">Prodigialis RH</a>
                    </div>


                    <div class="collapse navbar-collapse" id="navigation-example-2">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="Saiba.jsp" class="btn btn-simple">Sobre a empresa</a>
                            </li>
                            <li>
                                <div class="dropdown"><%FuncionarioDAO daofunc = new FuncionarioDAO();  %>

								  <button class="btn btn-simple dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
									
									<i class="fa fa-user-circle fa-1x" aria-hidden="true" id="nomeuser"></i><span><%=daofunc.consultarPorEmail((String)request.getSession().getAttribute("email")).getNom_fun()%></span>

									<span class="caret"></span>

								  </button>

								  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">

									<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Informações da conta</a></li>

									<li role="presentation" class="divider"></li>

									<li role="presentation"><a href="index.jsp" tabindex="-1" role="menuitem">Sair</a></li>

								  </ul>

								</div>
                            </li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-->
            </nav>
        </div>  
    </div>

    <div class="main">
        <div class="nav-tabs-navigation">
            <div class="nav-tabs-wrapper">
                <ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
                    <li class="active"><a href="#CriarProcesso" data-toggle="tab">Criar processo</a></li>
                    <li><a href="#AcompanharProcesso"  data-toggle="tab">Acompanhar processo</a></li>
                    <li><a href="#verCurriculo" data-toggle="tab">Ver curriculos</a></li>
                     <li><a href="#AprovadosPendentes"  data-toggle="tab">Aprovações Pendentes</a></li>
                </ul>
            </div>
        </div>
        <div id="my-tab-content" class="tab-content">
            <div class="tab-pane" id="AprovadosPendentes">
                <div class="container">
                    <div class="row">

                            <h3 class="header">Aprovações de Contratação Pendentes</h3>

                    </div>
                    <div class="row">
                            <div class="form-group col-md-12">
                                    <ul class="list-group" id="SpecsList">
                                      <li class="list-group-item">Cras justo odio<button  class="btn btn-danger btn-circle btn-simple pull-right btn-deleter"><i class="fa fa-times" style="vertical-align:center"></i></button></li>
                                    </ul>
                            </div>
                    </div>
                </div>
                    
            </div>
            <div class="tab-pane active" id="CriarProcesso">
				    <div class="container">

						<div class="row">

							<h3 class="header">Criar Novo Processo Seletivo</h3>
							
						</div>
                                                <form id="form1" action="ServletWeb?" method="post">
                                                <input type="hidden" name="acao" id="acao" value="criaProcesso"/>
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
                                                        <script>
                                                                function addSpec(){
                                                                    var txt = document.getElementById("NewSpec").value;
                                                                    if(txt != ""){
                                                                        var li = document.createElement("li");
                                                                        li.setAttribute("class","list-group-item");
                                                                        li.innerHTML = txt;
                                                                        document.getElementById("SpecsList").appendChild(li);
                                                                        document.getElementById("NewSpec").value = "";
                                                                    }
                                                                    
                                                                }
                                                        </script>
							<div class="form-group col-sm-1" style="padding-left:0px;text-align:left">
								<button type="button" onclick="addSpec()"  id="AddSpecs" class="btn btn-success btn-circle btn-simple pull-right" style="text-align:left"><i class="fa fa-plus adicionar" style="vertical-align:center;text-align:left"></i></button>
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
									<button style="width:100%"  type="submit" name="action" class="btn btn-fill ">Criar Processo
									  <i class="fa fa-plus" ></i> 
									</button>

							</div>

						</div>

					</div>

				</div>
            <div class="tab-pane" id="AcompanharProcesso">
				
				<div class="container">
					<h3 class="header">Ver Processo Seletivo</h3>
					<div class="row">
					
						<div class="form-group col-md-10">
							
							<select class="form-control default-cursor" id="processo">
                                                                
								<option value="0" disabled selected>Escolha um processo</option>
								<% 
                                                                    for(int i=0;i<lista.size();i++){                                    
                                                                %>
                                                                <option value="<%= lista.get(i).getCodProcesso()%>"><%= lista.get(i).getNome()%></option>
                                                                <%
                                                                    }
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
							<button  class="btn btn-fill" style="width:100%"  onclick="ajaxUpdate()">Listar Dados
							<i class=" fa fa-list-alt"></i>
							</button>
								
						</div>
						
					
					</div>
					
				</div>
				
							<hr/>
				<div class="container">	
					
					<div class="row" id="proc" >
						
						<div class="form-group col-md-4 ">
							
							<label>Código do Processo</label>
							<input readonly value="Código do Processo"  type="text" class="form-control default-cursor" id="cod">
							
						</div>
						
						<div class="form-group col-md-4 ">
							<label>Vagas de</label>
							<input readonly value="Cargo oferecido"  type="text" class="form-control default-cursor" id="vaga">
						</div>
						
						<div class="form-group col-md-4 ">
							<label>Número de vagas</label>
							<input readonly value="Nº de vagas"  type="text" class="form-control default-cursor" id="nvaga">
						</div>
					
					</div>
							
					<div class="row">
					
						<div class="form-group col-md-6 ">
							
							<label>Data de Início</label>
							<input readonly value="Início"  type="text" class="form-control default-cursor" id="datin">
							
						</div>
						
						<div class="form-group col-md-6 ">
						
							<label>Data de Fim</label>
							<input readonly value="Fim"  type="text" class="form-control default-cursor" id="datfim">
							
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
                                                        
							<label>Número de Inscrição</label>
							<select class="form-control" id="curriculos" onmouseover="curUpdate()">	
                                                        </select>
							
							
						</div>
					</div>
					<div class="row">
						
						<div class="form-group col-md-12">
							<label>Nome do Candidato</label>
							<input value="" readonly type="text" class="form-control default-cursor" id="nomcand">
						</div>
						
					</div>
					
					<div class="row">
					
						<div class="form-group col-md-8">
							<label>E-mail</label>
							<input value="" type="text" readonly class="form-control default-cursor" id="email">
						</div>
						
						<div class="form-group col-md-4">
							<label>Telefone</label>
							<input value="" type="text" readonly class="form-control default-cursor"id="tel">
						</div>
						
					</div>
					
					<div class="row">
					
						<div class="col-md-8">
							<label>Curriculo:</label>
						</div>
					</div>
					
					<div class="row">
						
						<div class="form-group col-md-8">
							<input value=" " readonly type="text" class="form-control default-cursor" id="curcode">
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
				</div>
			</div>
            <div class="tab-pane" id="verCurriculo">
	
					<div class="container">
						<h3 class="header">Ver CurrÃ­culo</h3>
						<div class="row">
							<div class="form-group col-md-8">
								<input placeholder="Codigo do candidato" id="disabled" type="text" class="form-control">
							</div>
							<div class="form-group pull-right col-md-4">
								<form id="form1" action="" method="post">
									<button  class="btn btn-fill" style="width:100%" type="submit" onclick="pesquisar()">Pesquisar</button>
								</form>
							</div>
						</div>			
					</div>
					
					<hr/>
					
					<div class="container" style="padding-bottom:40px">
					
						<div class="row">
							
							<div class="form-group col-md-12">
								<label>Nome do Candidato</label>
								<input value="JosÃ© da Silva Santos" readonly type="text" class="form-control default-cursor">
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
									<i class=" fa fa-download"></i>
								</button>
							</div>
							
						</div>	
					
						
						<div class="row" style="padding-top:30px">
								
							<div class="form-group col-md-12">
								<button  class="btn btn-fill" style="width:100%" type="submit" onclick="pesquisar()">Solicitar ContrataÃ§Ã£o
									<span class="fa fa-check" aria-hidden="true"></span>
								</button>
							</div>	
								
						</div>
					
				</div>
        </div>

        
    </div>
	</div>
    <footer class="footer" style="background-color:#36312B;color:#d1d1d1;text-align:center;padding-top:30px;padding-bottom:30px;">
        <div class="container">
            <div>Prodigialis RH<span>  Â·  </span>Trabalho de conclusÃ£o de curso</div>
            <div>Centro Federal de EducaÃ§Ã£o TecnolÃ³gica de Minas Gerais</div>
            <div>JÃ¡ nos conhece? ConheÃ§a a <a href="" style="color:#777;">staff</a></div>
            <div>Publicado sob a licenÃ§a de <a href="http://www.creative-tim.com/license" style="color:#777;">Creative Tim</a></div>
        </div>
    </footer>
</body>