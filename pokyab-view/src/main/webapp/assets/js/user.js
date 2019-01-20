//users.jsp table
var $table = $('#usersListTable');

if ($table.length) {

    var jsonUrl = '';
    jsonUrl = window.contextRoot + '/json/data/admin/all/users';

    console.log('Inside js usersListTable');
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
                data: 'userId',
                bSortable: false,
                mRender: function (data, type, row) {
                    var str = '';
                    str += '<a href="' + window.contextRoot + '/manage/user/'
                            + data + '"><i class="fas fa-edit"></i></a>';
                    return str;
                }
            },
            {
                data: 'userId',
                bSortable: false,
                mRender: function (data, type, row) {
                    var str = '';
                    str += '<a href="' + window.contextRoot + '/manage/user/'
                            + data + '/delete" class="confirmation"><i class="fas fa-trash"></i></a>';
                    return str;
                }
            },
            {data: 'firstName'},
            {data: 'lastName'},
            {data: 'email'},
            {data: 'role'},
            {data: 'startDate'},
            {data: 'endDate'},
            {
                data: 'enabled',
                bSortable: false,
                mRender: function (data, type, row) {
                    var str = '';
                    if (data) {
                        str += '<label class="switch">'
                                + '<input type="checkbox" checked="checked" value="' + row.userId + '"/>'
                                + '<div class="slider round"></div>'
                                + '</label>';
                    } else {
                        str += '<label class="switch">'
                                + '<input type="checkbox" value="' + row.userId + '"/>'
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
                var dMsg = (checked) ? 'Quiere activar el usuario' :
                        'Quiere desactivar el usuario?';
                var value = checkbox.prop('value');                                            

                bootbox.confirm({
                    size: 'medium',
                    title: 'Activaci&oacute;n / Desactivaci&oacute;n',
                    message: dMsg,
                    callback: function (confirmed) {
                        if (confirmed) {
                            console.log('value: ' + value);

                            //Post update user
                            var activationUrl = window.contextRoot + '/manage/user/' + value + '/activation';
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

