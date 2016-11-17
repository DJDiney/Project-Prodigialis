<%@page import="br.cefetmg.inf.prodigialis.controller.Login"%>
<%@page import="br.cefetmg.inf.prodigialis.model.dao.impl.ProcessoSeletivoDAO"%>
<%@page import="br.cefetmg.inf.prodigialis.model.dao.impl.CandidatoDAO"%>
<%@page import="br.cefetmg.inf.prodigialis.model.dao.impl.EstadoDAO"%>
<%@page import="br.cefetmg.inf.prodigialis.model.dao.impl.CidadeDAO"%>
<%@page import="br.cefetmg.inf.prodigialis.model.domain.Estado"%>
<%@page import="br.cefetmg.inf.prodigialis.model.domain.Cidade"%>
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
    <script>
        function formatar(mascara, documento){
          var i = documento.value.length;
          var saida = mascara.substring(0,1);
          var texto = mascara.substring(i)

          if (texto.substring(0,1) != saida){
                    documento.value += texto.substring(0,1);
          }

        }
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
         MAIN.createRelatedSelector(document.querySelector('#estado') );

         //countries
         MAIN.createRelatedSelector
             (   document.querySelector('#estado')           // from select element
                ,document.querySelector('#cidade')      // to select element
                ,{                                               // values object 
                  <% 
                       EstadoDAO est = new EstadoDAO();
                       java.util.ArrayList<Estado> estados = est.listarTodos();
                       for(int i=0;i<estados.size();i++){                                    
                   %>      
                     <%=estados.get(i).getUf()%>:[<%for(int j=0;j<estados.get(i).getCidades().size();j++){%>'<%=estados.get(i).getCidades().get(j).getNom_cid()%>'<%if(j != estados.get(i).getCidades().size()-1){%> ,<%}%><%}%>]<%if(i != estados.size()-1){%> ,<%}%>
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

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="navigation-example-2">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="Saiba.html" class="btn btn-simple">Sobre a empresa</a>
                            </li>
                            <li>
								
								<div class="dropdown"><%CandidatoDAO daofunc = new CandidatoDAO();  %>

								  <button class="btn btn-simple dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
									
									<i class="fa fa-user-circle fa-1x" aria-hidden="true"></i><span><%=daofunc.consultarPorEmail((String)request.getSession().getAttribute("email")).getNom_cand()%></span>

									<span class="caret"></span>

								  </button>

								  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">

									<li role="presentation"><a role="menuitem" tabindex="-1" href="#">InformaçaÃµes da conta</a></li>

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
                    <li class="active"><a href="#VerProc" data-toggle="tab">Ver Processo</a></li>
                    <li><a href="#EnvCurr" data-toggle="tab">Enviar Curriculo</a></li>
                </ul>
            </div>
        </div>
        <div id="my-tab-content" class="tab-content">
            <div class="tab-pane active" id="VerProc">
				<div class="container">
					<h3 class="header">Ver Processo Seletivo</h3>
					<div class="row">
					
						<div class="form-group col-md-10">
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
							<select class="form-control" id="processo" onchange="ajaxUpdate()">
							
								<option value="" disabled selected>Escolha um processo</option>
								<% 
                                                                    ProcessoSeletivoDAO dao = new ProcessoSeletivoDAO();
                                                                    java.util.ArrayList<ProcessoSeletivo> lista = dao.listarTodos();
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
							<button  class="btn btn-fill" style="width:100%" type="submit" onclick="pesquisar()">Listar Dados
							<i class=" fa fa-list-alt"></i>
							</button>
								
						</div>
						
					
					</div>
					
		</div>
		
					<hr/>
                <form id="form1" action="ServletWeb?" method="post">
                    <input type="hidden" name="acao" id="acao" value="enviaCur"/>
                    <input type="hidden" name="email" id="email" value="<%=request.getSession().getAttribute("email")%>"/>
                    <div class="container">	
			
			<div class="row" id="proc" >
				
				<div class="form-group col-md-4 ">
					
					<label for="disabled">Código do Processo</label>
					<input  value="Nome" name="cod" id="cod" type="text" class="form-control">
					
				</div>
				
				<div class="form-group col-md-4 ">
					<label for="disabled">Vagas de</label>
					<input disable value="Cargo" name="vaga" id="vaga" type="text" class="form-control">
				</div>
				
				<div class="form-group col-md-4 ">
					<label for="disabled">Número de vagas</label>
					<input disable value="Nº de Vagas" name="nvaga" id="nvaga" type="text" class="form-control">
				</div>
			
			</div>
					
			<div class="row">
			
				<div class="form-group col-md-6 ">
					
					<label for="disabled">Data de Início</label>
					<input disable value="Início" name="datin" id="datin" type="text" class="form-control">
					
				</div>
				
				<div class="form-group col-md-6 ">
				
					<label for="disabled">Data de Fim</label>
					<input disable value="Final" name="datfim" id="datfim" type="text" class="form-control">
					
				</div>
			
			</div>
					
			<div class="row">
				<div class="form-group col-md-12 ">
					<label id="Specs" data-toggle="collapse" data-target="#demo">EspecificaÃ§Ãµes  </label><i id="Caret" class="fa fa-caret-right CaretRight" aria-hidden="true"></i>
					<div id="demo" class="collapse">
						<ul class="list-group">
							<li class="list-group-item">EspecificaÃ§Ã£o 1</li>
							<li class="list-group-item">EspecificaÃ§Ã£o 2</li>
							<li class="list-group-item">EspecificaÃ§Ã£o 3</li>
							<li class="list-group-item">EspecificaÃ§Ã£o 4</li>
							<li class="list-group-item">EspecificaÃ§Ã£o 5</li>
							<li class="list-group-item">EspecificaÃ§Ã£o 6</li>
						</ul>
					</div>
				</div>
			</div>

			
			<div class="row">
			
				<div class="form-group pull-right col-md-4">
					
						<button type="submit" style="width:100%"  id="btnSubmit"  class=" btn btn-fill">
							Enviar <span class="fa fa-check" aria-hidden="true"></span>
						</button>
					
				</div>
				
			</div>
			
                    </div>
                </form>
		
	</div>
            
			<div class="tab-pane" id="EnvCurr">
                <div class="container">
					<h3> Enviar curriculo</h3>

					<div class="form-group" >
						<input type="text" value=""  placeholder="Nome completo" class="form-control" />
					</div>  


					<div class="row">

						<div class="form-group col-md-8 ">
							<input type="text" value=""  placeholder="Endereço" class="form-control" />
						</div>

						<div class="form-group col-md-2" >
							<input type="text" value=""  placeholder="CPF" OnKeyPress="formatar('###.###.###-##', this)" class="form-control" />
						</div> 


						<div class="form-group col-md-2" >
							<input type="text" value=""  placeholder="RG" OnKeyPress="formatar('##-###.###.###', this)" class="form-control" />
						</div> 

					</div>

					<div class="row">

						<div class="form-group col-md-4" >

							<select class="form-control" id="estado">

								<option value="" disabled selected>Escolha um estado</option>
								<%  
                                                                    EstadoDAO daos = new EstadoDAO();
                                                                    java.util.ArrayList<Estado> listas = daos.listarTodos();
                                                                    for(int i=0;i<listas.size();i++){                                    
                                                                %>
                                                                <option value="<%= listas.get(i).getUf()%>"><%= listas.get(i).getUf()%></option>
                                                                <%
                                                                    }
                                                                %>

							</select>

								<!--<div id="estado" class="wrapper-dropdown estado" tabindex="1">
									<span>Estado</span>
									<ul class="select-dropdown">
										<li><a href="#"><i class="icon-envelope icon-large"></i>Minas Gerais</a></li>
										<li><a href="#"><i class="icon-truck icon-large"></i>Rio de Janeiro</a></li>
										<li><a href="#"><i class="icon-plane icon-large"></i>São Paulo</a></li>
									</ul>
								</div>-->
							
						</div>

						<div class="form-group col-md-4" >

							<select class="form-control" id="cidade">

							</select>

							<!--<div id="cidade" class="wrapper-dropdown estado" tabindex="1">
								<span>Cidade</span>
								<ul class="select-dropdown">
									<li><a href="#"><i class="icon-envelope icon-large"></i>Belo Horizonte</a></li>
									<li><a href="#"><i class="icon-truck icon-large"></i>Sabará</a></li>
									<li><a href="#"><i class="icon-plane icon-large"></i>Contagem</a></li>
								</ul>
							</div>-->
						</div>

						<div class="form-group col-md-4" >
							<input type="text" value=""  placeholder="Celular" OnKeyPress="formatar('##-#####-####', this)" class="form-control" />
						</div> 

					</div>

					<div class="row">

						<div class="form-group col-md-8 col-xs-12" >
							<input type="email" value="<%=request.getSession().getAttribute("email")%>"  placeholder="Email" class="form-control" />
						</div> 

						<div class="form-group col-md-4" >
							<input type="text" value=""  placeholder="Telefone Fixo" OnKeyPress="formatar('##-####-####', this)" class="form-control" />
						</div> 

					</div>

					<div class="row">

						<div class="form-group col-md-12" >
							<input type="file" name="file-7[]" id="file-7" style="display:hidden" class="inputfile inputfile-6" data-multiple-caption="{count} arquivos selecionados" multiple="">
							<label for="file-7" class="width" >
								<a id="btnInput"  class="btn btn-fill" style="padding-left:60px;padding-right:60px;"> Arquivo</a> 
								<span id="Filename"></span>
							</label>

						</div>

					</div>

					<div class="row">
						<div class="form-group pull-right col-md-4">
							<form id="form1" action="" method="post">
								<button type="submit" style="width:100%"  id="btnSubmit"  class=" btn btn-fill">
									Enviar <span class="fa fa-paper-plane" aria-hidden="true"></span>
								</button>
							</form>
						</div>
					</div>

				</div>
			</div>
            </div>
        </div>


    </div>




    <footer class="footer" style="background-color:#36312B;color:#d1d1d1;text-align:center;padding-top:30px;padding-bottom:30px;">
        <div class="container">
            <div>Prodigialis RH<span>  ·  </span>Trabalho de conclusão de curso</div>
            <div>Centro Federal de Educação Tecnológica de Minas Gerais</div>
            <div>Já nos conhece? Conheça a <a href="" style="color:#777;">staff</a></div>
            <div>Publicado sob a licença de <a href="http://www.creative-tim.com/license" style="color:#777;">Creative Tim</a></div>
        </div>
    </footer>
</body>