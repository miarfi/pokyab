

$(function () {

    //Autocomplete
    var activationUrl = window.contextRoot + '/lookupValues';      
    console.log('activationUrl: ' + activationUrl);

    $('#activityType').autocomplete({
        minLength: 1,
        delay: 500,
        //define callback to format results
        source: function (request, response) {
            console.log('Autocomplete ');
            var activityType = $("#activityType").val();
            console.log('activityType: ' + activityType);
            $.ajax({
                type: 'GET',
                url: activationUrl,
                timeout: 100000,
                dataType: "json",//No makes diff
                data: {
                    maxRows: 50,
                    startsWith: request.activityType,//activityType,//No makes diff
                    'lookupType':'ACTIVITY_TYPE',
                    'meaning':activityType
                },
                success: function (data) {
                    console.log('ajax success'+data);
                    console.log('length: '+data.length);
                    response($.map(data, function (item) {
                        return {
                            label: item.meaning ,
                            value: item.lookupCode 
                        };
                    }));
                },
                error: function (xhr, ajaxOptions, thrownError){
                    console.log('1 '+xhr);
                    console.log('1 '+thrownError);
                }
            });            

        }

    });


    //trainings.jsp table
    var $table = $('#trainingsListTable');

    if ($table.length) {

        var jsonUrl = '';
        jsonUrl = window.contextRoot + '/json/data/admin/all/trainings';

        console.log('Inside js trainingsListTable');
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
                    data: 'trainingId',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="' + window.contextRoot + '/manage/training/'
                                + data+ '"><i class="fas fa-edit"></i></a>';
                        return str;
                    }
                },
                {
                    data: 'trainingId',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="' + window.contextRoot + '/manage/training/'
                                + data + '/delete" class="confirmation"><i class="fas fa-trash"></i></a>';
                        return str;
                    }
                },
                {data: 'trainingName'},
                {data: 'categoryCode'},
                {data: 'weeks'},                
                {data: 'creatorPerId'},
                {data: 'statusCode'},
                {data: 'approverPerId'},
                {data: 'startDate'},
                {
                    data: 'active',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        if (data) {
                            str += '<label class="switch">'
                                    + '<input type="checkbox" checked="checked" value="' + row.trainingId + '"/>'
                                    + '<div class="slider round"></div></label>';
                        } else {
                            str += '<label class="switch">'
                                    + '<input type="checkbox" value="' + row.trainingId + '"/>'
                                    + '<div class="slider round"></div></label>';
                        }
                        return str;
                    }
                }
            ],
            //Bootbox alert
            initComplete: function () {
                var api = this.api();
                api.$('.switch input[type="checkbox"]').on('change', function () {
                    var checkbox = $(this);
                    var checked = checkbox.prop('checked');
                    var dMsg = (checked) ? 'Quiere activar el catalogo' :
                            'Quiere desactivar el catalogo?';
                    var value = checkbox.prop('value');

                    bootbox.confirm({
                        size: 'medium',
                        title: 'Activaci&oacute;n / Desactivaci&oacute;n',
                        message: dMsg,
                        callback: function (confirmed) {
                            if (confirmed) {
                                console.log(value);
                                //Post update product
                                var activationUrl = window.contextRoot + '/manage/training/' + value + '/activation';
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


    //activities.jsp table
    var $table = $('#activitiesListTable');

    if ($table.length) {

        var jsonUrl = '';
        jsonUrl = window.contextRoot + '/json/data/admin/all/activities';

        console.log('Inside js activitiesListTable');
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
                    data: 'activityId',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="' + window.contextRoot + '/manage/activity/'
                                + data + '"><i class="fas fa-edit"></i></a>';
                        return str;
                    }
                },
                {
                    data: 'activityId',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="' + window.contextRoot + '/manage/activity/'
                                + data + '/delete" class="confirmation"><i class="fas fa-trash"></i></a>';
                        return str;
                    }
                },
                {data: 'activityName'},
                {data: 'activityType'},
                {data: 'metricType'},
                {data: 'totalTime'},
                {data: 'uomCode'},
                {data: 'quantityMin'},
                {data: 'quantityMax'},
                {data: 'startDate'},
                {
                    data: 'active',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        if (data) {
                            str += '<label class="switch">'
                                    + '<input type="checkbox" checked="checked" value="' + row.activityId + '"/>'
                                    + '<div class="slider round"></div></label>';
                        } else {
                            str += '<label class="switch">'
                                    + '<input type="checkbox" value="' + row.activityId + '"/>'
                                    + '<div class="slider round"></div></label>';
                        }
                        return str;
                    }
                }
            ],
            //Bootbox alert
            initComplete: function () {
                var api = this.api();
                api.$('.switch input[type="checkbox"]').on('change', function () {
                    var checkbox = $(this);
                    var checked = checkbox.prop('checked');
                    var dMsg = (checked) ? 'Quiere activar el catalogo' :
                            'Quiere desactivar el catalogo?';
                    var value = checkbox.prop('value');

                    bootbox.confirm({
                        size: 'medium',
                        title: 'Activaci&oacute;n / Desactivaci&oacute;n',
                        message: dMsg,
                        callback: function (confirmed) {
                            if (confirmed) {
                                console.log(value);
                                //Post update product
                                var activationUrl = window.contextRoot + '/manage/activity/' + value + '/activation';
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


    //trainActivities.jsp table
    $table = $('#trainActivListTable');

    if ($table.length) {

        var jsonUrl = '';
        jsonUrl = window.contextRoot + '/json/data/admin/all/' + window.trainingId + '/trainActivities';

        console.log('Inside js trainActivListTable');
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
                    data: 'trainActId',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="'+ window.contextRoot + '/manage/trainingActivity/'
                                + data + '"><i class="fas fa-edit"></i></a>';
                        return str;
                    }
                },
                {
                    data: 'trainActId',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="' + window.contextRoot + '/manage/trainingActivity/'
                                + data + '/delete" class="confirmation"><i class="fas fa-trash"></i></a>';
                        return str;
                    }
                },
                {data: 'startTime'},
                {data: 'endTime'},
                {data: 'activityNumber'},
                //  
                {data: 'activityName'},
                {data: 'metricType'},
                {data: 'totalTime'},
                {data: 'uomCode'},
                {data: 'quantityMin'},
                {data: 'quantityMax'},
                //
                {data: 'mondayFlag'},
                {data: 'thursdayFlag'},
                {data: 'wednesdayFlag'},
                {data: 'tuesdayFlag'},
                {data: 'fridayFlag'},
                {data: 'saturdayFlag'}
            ],
            //Bootbox alert
            initComplete: function () {
                var api = this.api();

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

});