
$(document).ready(function(){
    
//persons.jsp table
var $table = $('#personsListTable');

if ($table.length) {

    var jsonUrl = '';
    jsonUrl = window.contextRoot + '/json/data/admin/all/persons';

    console.log('Inside js personsListTable');
    console.log('jsonUrl: ' + jsonUrl);
    $table.DataTable({
        "language": {
            "loadingRecords": "Cargando...",
            "lengthMenu": "Mostrar _MENU_ por p&aacute;gina",
            "zeroRecords": "No se encontraron datos",
            "info": "Mostrar p&aacute;gina _PAGE_ de _PAGES_",
            "infoEmpty": "Ning&uacute;n registro disponible",
            "infoFiltered": "(filtro de _MAX_ total registros)",
            "search": "Buscar",
            "paginate": {
                "first": "Primero",
                "last": "Ultimo",
                "next": "Siguiente",
                "previous": "Anterior"
            }
        },
        lengthMenu: [[10, 20, 50, -1], ['10 registros', '20 registros', '50 registros', 'Todos']],
        pageLength: 10,
        ajax: {
            url: jsonUrl,
            dataSrc: ''
        },
        columns: [
            {
                data: 'personId',
                bSortable: false,
                mRender: function (data, type, row) {
                    var str = '';
                    str += '<a href="' + window.contextRoot + '/manage/person/'+ data + '"'
                            +' title="'+window.commonATitleEdit+'"><i class="fas fa-edit"></i></a>';
                    return str;
                }
            },
            {
                data: 'personId',
                bSortable: false,
                mRender: function (data, type, row) {
                    var str = '';
                    str += '<a href="' + window.contextRoot + '/manage/person/'+ data + '/delete"'
                            +' title="'+ window.commonATitleDelete+'" class="confirmation"><i class="fas fa-trash"></i></a>';
                    return str;
                }
            },
            {data: 'firstName'},
            {data: 'lastName'},
            {data: 'currentAge'},
            {data: 'genderCode'},
            {data: 'personType'},
            {data: 'startDate'},
            {data: 'endDate'},
            {
                data: 'active',
                bSortable: false,
                mRender: function (data, type, row) {
                    var str = '';
                    if (data == 'Y') {
                        str += '<label class="switch">'
                                + '<input type="checkbox" checked="checked" value="' + row.personId + '"/>'
                                + '<div class="slider round"></div>'
                                + '</label>';
                    } else {
                        str += '<label class="switch">'
                                + '<input type="checkbox" value="' + row.personId + '"/>'
                                + '<div class="slider round"></div>'
                                + '</label>';
                    }
                    return str;
                }
            }
        ]
        ,
        //Bootbox alert
        initComplete: function () {
            var api = this.api();
            api.$('.switch input[type="checkbox"]').on('change', function () {
                var checkbox = $(this);
                var checked = checkbox.prop('checked');
                var dMsg = (checked) ? 'Quiere activar la persona' :
                        'Quiere desactivar la persona?';
                var value = checkbox.prop('value');                                            

                bootbox.confirm({
                    size: 'medium',
                    title: 'Activaci&oacute;n / Desactivaci&oacute;n',
                    message: dMsg,
                    callback: function (confirmed) {
                        if (confirmed) {
                            console.log('value: ' + value);

                            //Post update person
                            var activationUrl = window.contextRoot + '/manage/person/' + value + '/activation';
                            console.log('activationUrl: ' + activationUrl);
                            $.ajax({
                                type: 'GET',
                                url: activationUrl,
                                timeout: 100000,
                                success: function (data) {
                                    console.log('ajax success');
                                    bootbox.alert(data);
                                },
                                error: function (e) {
                                    console.log('ajax error');
                                    bootbox.alert('ERROR: ' + e);
//                                        display(e);
                                }
                            });
                        } else {
                            checkbox.prop('checked', !checked);
                        }
                    }
                });
            });
            
            //bootbox class=confirmation 
            api.$('.confirmation').on('click', function (e) {
                console.log('confirmation');
                e.preventDefault();
                href = $(this).attr('href');
                return bootbox.confirm('Está seguro de borrar el registro?', function (result) {
                    if (result) {
                        window.location = href;
                    }
                });
            });
        }
    });
}


//$table = $('#contactPointsListTable');
//
//if ($table.length) {
//
//    console.log('Inside js personsListTable');
//    console.log('jsonUrl: ' + jsonUrl);
//    $table.DataTable({
////        "pagingType": "numbers",
//        "language": {
//            "loadingRecords": "Cargando...",
//            "lengthMenu": "Mostrar _MENU_ por p&aacute;gina",
//            "zeroRecords": "No se encontraron datos",
//            "info": "Mostrar p&aacute;gina _PAGE_ de _PAGES_",
//            "infoEmpty": "Ning&uacute;n registro disponible",
//            "infoFiltered": "(filtro de _MAX_ total registros)",
//            "search": "Buscar",
//            "paginate": {
//                "first": "Primero",
//                "last": "Ultimo",
//                "next": "Siguiente",
//                "previous": "Anterior"
//            }
//        },        
//        lengthMenu: [[10, 20, 50, -1], ['10 registros', '20 registros', '50 registros', 'Todos']],
//        pageLength: 10
//    });
//}

    console.log('Antes de tooltip');
    
    $('[data-toggle="tooltip"]').tooltip();    
//    var actions = $("table td:last-child").html();    
    $("table tbody tr").find(".add, .undo").toggle();
        
    // Append table with add row form on add new button click
    $(".add-new").click(function () {
        console.log('En add-new');
        $(this).attr("disabled", "disabled");
        var index = $("table tbody tr:last-child").index();
        var row = '<tr>' +
                '<td><a href="#" class="add" title="Guardar" data-toggle="tooltip">' +
                '<i class="fas fa-save"></i></a>' +
//                '</td><td>'+
                '<a href="#" class="edit" title="Editar" data-toggle="tooltip">' +
                '<i class="fas fa-edit"></i></a>' +                               
//                '</td><td>'+
                '<a href="#" class="delete" title="Borrar" data-toggle="tooltip">' +
                '<i class="fas fa-trash"></i></a>' +
//                '</td><td>'+                
                '<a href="#" class="undo" title="Cancelar" data-toggle="tooltip">' +
                '<i class="fas fa-undo"></i></a></td>' +                 
//                '<td><input type="text" class="form-control" name="contactType" id="contactType"></td>' +
                '<td><input type="text" class="form-control" name="useType" id="useType"></td>' +
                '<td><input type="text" class="form-control" name="contactValue" id="contactValue"></td>' +
//                '<td><input type="text" class="form-control" name="primaryByType" id="primaryByType"></td>' +
//                '<td></td>' +
//                '<td>' + actions + '</td>' +
                '</tr>';
        $("table").append(row);
        $("table tbody tr").eq(index + 1).find(".edit, .undo").toggle();
        $('[data-toggle="tooltip"]').tooltip();
    });

    // Add row on add button click
    $(document).on("click", ".add", function () {
        console.log('En click add');
        var href = $(this).attr('href');
        $(this).removeAttr("href");
        console.log('href: ' + href);
        var empty = false;
        var input = $(this).parents("tr").find('input[type="text"]');
//        var jsonData = '"ownerTableId: "1", ownerTableName : "PERSON"';var jsonData = '"ownerTableId: "1", ownerTableName : "PERSON"';
        
        var dataArray = {
//            "ownerTableId" : 1,
//            "ownerTableName" : "PERSON"
        };
        dataArray = {"ownerTableId" : 1};
        dataArray[ "ownerTableName"] = "PERSON" ;
        dataArray[ "contactType"] = "PHONE" ;
        
        input.each(function () {
            var val = $(this).val();
            var name = $(this).attr('name');
            console.log('val:'+val+ ' name:'+name);
            
//            jsonData = jsonData + ',' + name + ' : "'+val+'"';                                    
            dataArray[name] = val;  


            if (!$(this).val()) {
                $(this).addClass("error");
                empty = true;
            } else {
                $(this).removeClass("error");
            }
        });
        $(this).parents("tr").find(".error").first().focus();
        
        if (!empty) {
//            console.log('Antes de POST cp.add: '+jsonData);
            //Call Post Add ContactPoint    
            var activationUrl = window.contextRoot + '/manage/contactPoint/';
            if (href === "#") {
                //activationUrl = window.contextRoot + '/manage/contactPoint/';
                dataArray["contactPointId"] = href;
            }
//            else {
//                activationUrl = href;
//            }            
            console.log('contextRoot: ' + window.contextRoot);
            console.log('activationUrl: ' + activationUrl);
            $.ajax({
                type: 'GET',
                url: activationUrl,
                timeout: 100000,
//                data: { ownerTableId: "1", ownerTableName : "PERSON" 
//                    , contactType : "PHONE", useType : "PERSONAL", contactValue : "123456"} ,
//                dataType: 'json',
                data: dataArray,
                success: function (data) {
                    console.log('ajax success');
                    bootbox.alert(data);
                },
                error: function (e) {
                    console.log('ajax error');
                    bootbox.alert('ERROR: ' + e);
//                      display(e);
                }
            });
            
            //ToDo mover a la parte de success
            input.each(function () {
                $(this).parent("td").html($(this).val());
            });
            $(this).parents("tr").find(".add, .edit").toggle();
            $(".add-new").removeAttr("disabled");
        }
    });


    // Edit row on edit button click
    $(document).on("click", ".edit", function () {
        console.log('En click edit');
        $(this).parents("tr").find("td:not(:first-child):not(:last-child)").each(function () {
            $(this).html('<input type="text" class="form-control" value="' + $(this).text() + '">');
        });
        $(this).parents("tr").find(".add, .edit, .delete").toggle();
        $(this).parents("tr").find(".undo").show();
        $(".add-new").attr("disabled", "disabled");
    });


    // Undo row on undo button click
    $(document).on("click", ".undo", function () {
        console.log('En click undo');
        $(this).parents("tr").find("td:not(:first-child):not(:last-child)").each(function () {
            console.log('log'+$(this).find("input").val());
            $(this).html($(this).find("input").val());
        });
        $(this).parents("tr").find(".add, .undo").toggle();
        $(this).parents("tr").find(".edit, .delete").show();
        $(".add-new").removeAttr("disabled");
    });

//    // Delete row on delete button click
//    $(document).on("click", ".delete", function () {
//        console.log('En click delete');
//        //ToDo Llamar fn borrado
//        $(this).parents("tr").remove();
//        $(".add-new").removeAttr("disabled");
//        //
//    });

    //
    // Delete row on delete button click
    $(document).on("click", ".delete", function (e) {
        console.log('En click delete');               
        href = $(this).attr('href');        
        console.log('href: ' + href);        
        tr = $(this).parents("tr");
         e.preventDefault();
        
        bootbox.confirm('Está seguro de borrar el registro?', function (result) {
            if (result) {                                
                //
                //GET delete contactPoint                
                if (href !== '#') {
                    //var activationUrl = window.contextRoot + '/manage/contactPoint/' + value + '/delete';
                    //console.log('activationUrl: ' + href);
                    $.ajax({
                        type: 'GET',
                        url: href,
                        timeout: 100000,
                        success: function (data) {
                            console.log('ajax success');
                            bootbox.alert(data);
                        },
                        error: function (e) {
                            console.log('ajax error');
                            bootbox.alert('ERROR: ' + e);
                            //display(e);
                        }
                    });
                }       
                
                //Remove parent.tr
                console.log('remove tr');                          
                //$(this).parents("tr").remove();//falla dentro de fn
                tr.remove();
                $(".add-new").removeAttr("disabled");
            }
        });
    });
 });
    