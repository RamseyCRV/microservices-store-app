$('document').ready(function(){

    $('table #deleteCatalogBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr("href");
        $("#confirmDeleteCatalogBtn").attr('href', href);
        $('#deleteCatalogModal').modal();
    });

    $('table #updateCatalogBtn').on('click', function(event){

        event.preventDefault();
        var href = $(this).attr("href");

        $.get(href, function(catalog, status){
            $('#updateCatalogId').val(catalog.id);
            $('#updateCatalogName').val(catalog.name);
        });

        $('#updateCatalogModal').modal();
    });
});

