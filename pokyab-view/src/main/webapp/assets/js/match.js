    //matchs.jsp table
    var $table = $('#matchsListTable');

    if ($table.length) {

        var jsonUrl = '';
        jsonUrl = window.contextRoot + '/json/data/admin/all/matchs';

        console.log('Inside js matchsListTable');
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
            pagingType: "full_numbers",
            lengthMenu: [[10, 20, 50, -1], ['10 registros', '20 registros', '50 registros', 'Todos']],
            pageLength: 10,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'matchId',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="'+ window.contextRoot + '/manage/match/'
                                + data  + '"><i class="fas fa-edit"></i></a>';
                        return str;
                    }
                },
                {
                    data: 'matchId',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="' + window.contextRoot + '/manage/match/'
                                + data + '/delete" class="confirmation"><i class="fas fa-trash"></i></a>';
                        return str;
                    }
                },
                {data: 'homeTeamName'},
                {data: 'homeScore'},
                {data: 'awayTeamName'},
                {data: 'awayScore'},
                {data: 'leagueName'},
                {data: 'seasonName'},
                {data: 'matchDate'},
                {data: 'matchTime'}
//                {data: 'scores'},
//                {data: 'matchesPlayed'},
//                {data: 'wins'},
//                {data: 'draws'},
//                {data: 'losts'},
//                {data: 'points'},
//                {
//                    data: 'active',
//                    bSortable: false,
//                    mRender: function (data, type, row) {
//                        var str = '';
//                        if (data == "Y") {
//                            str += '<label class="switch">'
//                                    + '<input type="checkbox" checked="checked" value="' + row.matchId + '"/>'
//                                    + '<div class="slider round"></div></label>';
//                        } else {
//                            str += '<label class="switch">'
//                                    + '<input type="checkbox" value="' + row.matchId + '"/>'
//                                    + '<div class="slider round"></div></label>';
//                        }
//                        return str;
//                    }
//                }
            ],
            //Bootbox alert
            initComplete: function () {
                var api = this.api();
                api.$('.switch input[type="checkbox"]').on('change', function () {
                    var checkbox = $(this);
                    var checked = checkbox.prop('checked');
                    var dMsg = (checked) ? 'Quiere activar el equipo' :
                            'Quiere desactivar el equipo?';
                    var value = checkbox.prop('value');

                    bootbox.confirm({
                        size: 'medium',
                        title: 'Activaci&oacute;n / Desactivaci&oacute;n',
                        message: dMsg,
                        callback: function (confirmed) {
                            if (confirmed) {
                                console.log(value);
                                //Post update product
                                var activationUrl = window.contextRoot + '/manage/match/' + value + '/activation';
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
            }//Bootbox
        });
    }


