$(function() {

    $("#btnAdicionar").click(function (e) {
        e.preventDefault();
        adicionarHorario();
    });

    $("#btnSalvar").click(function (event) {
        event.preventDefault();
        salvarDados();
    });

});

function adicionarHorario() {

    var corpoTabela = $("#table-temp").find("tbody");

    var fecha = $("#fecha").val();
    var hora = $("#hora").val();
    var preco = $("#precio").val();
    var peliculaID = $("#idPelicula option:selected").val();
    var peliculaNome = $("#idPelicula option:selected").text();
    var salaNome = $("#sala option:selected").text();

    var linha = novaLinha(fecha, hora, preco, peliculaID, peliculaNome, salaNome);
    corpoTabela.append(linha);

}

function novaLinha(fecha, hora, preco, peliculaid, peliculanome, salanome) {

    var linha = $("<tr>");
    linha.attr('id', peliculaid);

    var colunaPelicula = $("<td>").text(peliculanome);
    var colunaFecha = $("<td>").text(fecha);
    var colunaHora = $("<td>").text(hora);
    var colunapreco = $("<td>").text(preco);
    var colunaSala = $("<td>").text(salanome);


    linha.append(colunaPelicula);
    linha.append(colunaFecha);
    linha.append(colunaHora);
    linha.append(colunaSala);
    linha.append(colunapreco);


    return linha;
}

function salvarDados() {
    //"{id:'" + $(this).attr('id') + "'}"
    var tbl = $('#table-temp tr:has(td)').map(function() {
        var $td =  $('td', this);
        return {
            pelicula: $(this).attr('id') ,
            fecha: $td.eq(1).text(),
            hora: $td.eq(2).text(),
            sala:$td.eq(3).text(),
            precio: $td.eq(4).text()
        }
    }).get();

    console.log(tbl);
    var jsonObjs = JSON.stringify(tbl);
    console.log(jsonObjs);

    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $.ajax({
        url: "/cineapp/horarios/saveAjax",
        type: 'POST',
        data: jsonObjs,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },

        success: function(data) {

            $('#form-salvar').each(function() {
                this.reset();
            });

            $('#modalCadastro').modal('hide');

            $("#divInfo").empty();
            $("#divInfo").addClass("alert alert-success");
            $("#divInfo").html("<em> Horário cadastrado com Sucesso </em>");

        },

        complete: function () {
        }
    });
}