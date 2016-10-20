<head>


</head>

<body style="font-family:Oswald">


    <div class="section white">

        <div class="row container">

            <h3 class="header">Criar Novo Processo Seletivo</h3>

            </br>

            <div class="row">

                <div class="input-field col s12">

                    <input id="nome_proc" type="text" class="validate">
                    <label for="nome_proc">Nome do Processo</label>

                </div>

            </div>

            <div class="row">

                <div class="input-field col s12">

                    <textarea id="desc" class="materialize-textarea"></textarea>
                    <label for="desc">Descrição</label>

                </div>

            </div>

            <div class="row">

                <div class="input-field col s3">

                    <input id="n_vagas" type="text" class="validate">
                    <label for="n_vagas">Número de vagas</label>

                </div>

                <div class="input-field col s2" style="margin-left:2%">

                    <label for="data_ini">Data de início</label>
                    </br></br>
                    <input type="data_ini" class="datepicker">


                </div>

                <div class="input-field col s2">

                    <label for="data_fim">Data de fim</label>
                    </br></br>
                    <input type="data_fim" class="datepicker">


                </div>

            </div>

            <div class="row">

                <div id="submit" class="left-align col-md4">

                    </br></br>
                    <button style="width:30%"  class="waves-effect waves-light btn-large" type="submit" name="action">Criar
                        <i class="material-icons left">playlist_add</i>
                    </button>

                </div>

            </div>

        </div>

    </div>
</body>