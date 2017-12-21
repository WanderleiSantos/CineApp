$(function () {
    $(".btn-danger").click(function (e) {
        e.preventDefault();
        var id = this.id;
        var nome = this.name;

        $("#deleteModal .modal-body input[type=hidden]").val(id);
        $("#deleteModal .modal-body span").text(nome);
        $("#deleteModal").modal('show');
    });

    $("#deleteModal .modal-footer button").click(function (e) {

        e.preventDefault();

        var id = $(".modal-body input[type=hidden]").val();
        var url = "/cineapp/horarios/delete/"+id;
        var rowNo = "#row-" + id;
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        $.ajax({
            url: url,
            type: 'GET',
            beforeSend: function (xhr) {

                xhr.setRequestHeader(header, token);

                var loading = "<span><em>Excluindo</em>&nbsp;<i class='glyphicon glyphicon-refresh icon-refresh-animate'></i></span>";
                $('#deleteModal .modal-header h4').after(loading);

            },

            success: function(data) {

                console.log(data);

                $('#deleteModal .modal-header span').empty();
                $('#deleteModal').modal('hide');

                $(rowNo).animate({ opacity: 0.0 }, 400, function () {
                    $(rowNo).remove();
                });

            },

            complete: function () {
                $("#divInfo").empty();
                $("#divInfo").addClass("alert alert-danger");
                $("#divInfo").html("<em> Excluido com Sucesso </em>");
            }
        });
    });


  /* $("#form-salvar1").submit(function (e) {
       e.preventDefault();
       var token = $("meta[name='_csrf']").attr("content");
       var header = $("meta[name='_csrf_header']").attr("content");
       var form_data = $(this).serialize();

       $.ajax({
           url: "/cineapp/horarios/save",
           type: 'POST',
           data: form_data,
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

   });*/

});