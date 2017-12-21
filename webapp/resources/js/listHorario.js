$(function() {

    $("#form-preparar").submit(function (e) {

        e.preventDefault();
        console.log("submit");

        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        var form_data = $(this).serialize();

        $.ajax({
            url: "/cineapp/horarios/listaHorarios",
            type: 'POST',
            data: form_data,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },

            success: function(data) {
                console.log(data);
                adicionarHorario();
            },

            complete: function () {
            }
        });

    });

    $("#btnSalvar").click(function (event) {
        event.preventDefault();

        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        $.ajax({
            url: "/cineapp/horarios/salvarListaHorarios",
            type: 'GET',
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },

            success: function(data) {

                $('#form-preparar').each(function() {
                    this.reset();
                });

                $('#modalCadastro').modal('hide');

                $("#divInfo").empty();
                $("#divInfo").addClass("alert alert-success");
                $("#divInfo").html("<em> Horários cadastrados com Sucesso! </em>");

            },

            complete: function () {
            }
        });

    });

});

function adicionarHorario() {

    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

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