$(function () {


    /*-------------------------------------------------------------*/
//Header menu
//	switch(menu){
//
//	case 'About':
//		$('#about').addClass('active');
//		break;
//	case 'Contact':
//		$('#contact').addClass('active');
//		break;
////	case 'All Products':
////		$('#listProducts').addClass('active');
////		break;
////	case 'Manage Products':
////		$('#manageProducts').addClass('active');
////		break;
//	default:
//		$('#home').addClass('active');
//		$('#a_'+menu).addClass('active');
//	break;
//	}

    //dismissing the alert after 3 seconds
    var $alert = $('.alert');
    if ($alert.length) {
        setTimeout(function () {
            $alert.fadeOut('slow');
        }, 5000
                );
    }

    //bootbox class=confirmation 
    $('.confirmation').on('click', function (e) {
        console.log('confirmation');
        e.preventDefault();
        href = $(this).attr('href');
        return bootbox.confirm('Está seguro de borrar el registro?', function (result) {
            if (result) {
                window.location = href
            }
        });
    });
    
//    function activateFn (confirmed, activationUrl) {
//       console.log('value: '+confirmed);
//       console.log('value: '+activationUrl);
//        if (confirmed) {
//
//
//            //Post update person
//            //var activationUrl = window.contextRoot + '/manage/person/' + value + '/activation';
//            console.log('activationUrl: '+activationUrl);
//            $.ajax({
//                type: 'GET',
//                url: activationUrl,
//                timeout: 100000,
//                success: function (data) {
//                    console.log('ajax success');
//                    bootbox.alert(data);
//                },
//                error: function (e) {
//                    console.log('ajax error');
//                    bootbox.alert('ERROR: ' + e);
////                                        display(e);
//                }
//            });
//        } else {
//            checkbox.prop('checked', !checked);
//        }
//    }
    //bootbox class=switch
    $('.switch input[type="checkbox"]').on('change', function () {
            var checkbox = $(this);
            var checked = checkbox.prop('checked');
            var dMsg = (checked) ? 'Quiere activar' :
                    'Quiere desactivar?';
            var value = checkbox.prop('value');
                                             
//            var activationUrl = window.contextRoot + '/manage/person/' + value + '/activation';
            bootbox.confirm({
                size: 'medium',
                title: 'Activaci&oacute;n / Desactivaci&oacute;n',
                message: dMsg,
                callback: function (confirmed) {
//                        console.log('value: '+confirmed);
//                        console.log('value: '+activationUrl);
                         if (confirmed) {

                             //Post update person
                             var activationUrl = window.contextRoot + '/manage/lookupValue/' + value + '/activation';
                             console.log('activationUrl: '+activationUrl);
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
    
    //teams.jsp table
    $table = $('#teamsListTable');

    if ($table.length) {

        var jsonUrl = '';
        jsonUrl = window.contextRoot + '/json/data/admin/all/teams';

        console.log('Inside js teamsListTable');
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
                    data: 'teamId',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="'
                                + window.contextRoot
                                + '/manage/team/'
                                + data
                                + '"><i class="fas fa-edit"></i></a>';
                        return str;
                    }
                },
                {data: 'teamName'},
                {data: 'groupNumber'},              
                {data: 'leagueName'},
                {data: 'seasonName'},
                {data: 'categoryCode'},
                {data: 'trainerPerName'},
                {data: 'conceded'},
                {data: 'scores'},
                {data: 'matchesPlayed'},                
                {data: 'wins'},
                {data: 'draws'},
                {data: 'losts'},
                {data: 'points'},
                {
                    data: 'active',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        if (data) {
                            str += '<label class="switch">'
                                    + '<input type="checkbox" checked="checked" value="' + row.teamId + '"/>'
                                    + '<div class="slider round"></div></label>';
                        } else {
                            str += '<label class="switch">'
                                    + '<input type="checkbox" value="' + row.teamId + '"/>'
                                    + '<div class="slider round"></div></label>';
                        }
                        return str;
                    }
                }
            ]
        })
    }


    //activities.jsp table
    $table = $('#activitiesListTable');

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
                        str += '<a href="'
                                + window.contextRoot
                                + '/manage/activity/'
                                + data
                                + '"><i class="fas fa-edit"></i></a>';
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
            ]
        })
    }


    //trainings.jsp table
    $table = $('#trainingsListTable');

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
                        str += '<a href="'
                                + window.contextRoot
                                + '/manage/training/'
                                + data
                                + '"><i class="fas fa-edit"></i></a>';
                        return str;
                    }
                },
                {data: 'trainingName'},
                {data: 'categoryCode'},
                {data: 'weeks'},
                {data: 'days'},
                {data: 'creatorPerId'},
                {data: 'statusCode'},
                {data: 'approverPerId'},
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
            ]
        })
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
                        str += '<a href="'
                                + window.contextRoot
                                + '/manage/trainActiv/'
                                + data
                                + '"><i class="fas fa-edit"></i></a>';
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
            ]
        })
    }


});
