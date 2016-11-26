$(document).ready(function () {
	$('#ArquivoProva').change(function () {
		var filename = $('#ArquivoProva').val();
		$('#DirArquivoProva').html(filename);
	});
	
	$('#ArquivoGabarito').change(function () {
		var filename = $('#ArquivoGabarito').val();
		$('#DirArquivoGabarito').html(filename);
	});
	
	$('#AddSpecs').click(function(){
                var count = $('#counter').val();
		var spec = $('#NewSpec').val();
		if(spec == '' || spec == null || spec == ' '){}
		else{
			$("#SpecsList").append('<li name=spec"'+count+'" class="list-group-item">'+spec+'<button  class="btn btn-danger btn-circle btn-simple pull-right btn-deleter"><i class="fa fa-times" style="vertical-align:center"></i></button></li>');
                        $('#NewSpec').val("");
                        $('#counter').val(parseInt(count) + 1);
		}
	});
	
	$('#SpecsList').on('click', '.btn-deleter', function() {
		$(this).parent().remove();
	});
	$('#file-7').change(function () {
		var filename = $('#file-7').val();
		$('#Filename').html(filename);
	});
});