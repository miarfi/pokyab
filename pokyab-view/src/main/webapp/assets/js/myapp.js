$(function(){


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


    //persons.jsp table
    var $table = $('#personsListTable');

    if ($table.length) {

        var jsonUrl = '';
        jsonUrl = window.contextRoot + '/json/data/admin/all/persons';

        console.log('Inside js personsListTable');
        console.log('jsonUrl: ' + jsonUrl);
        $table.DataTable({
            lengthMenu: [[3, 5, 10, -1], ['3 records', '5 records', '10 records', 'All']],
            pageLength: 5,
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
                        str += '<a href="'
                                + window.contextRoot
                                + '/manage/'
                                + data
                                + '/person" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
                        return str;
                    }
                },
                {   data: 'firstName'   },
                {   data: 'lastName'    },
                {   data: 'dateOfBirth'    },
                {   data: 'genderCode'    },
                {   data: 'personType'  },
                {   data: 'startDate'    },
                {   data: 'endDate'    },
                {   data: 'active'    }
            ]
        })
    }

    //teams.jsp table
    $table = $('#teamsListTable');

    if ($table.length) {

        var jsonUrl = '';
        jsonUrl = window.contextRoot + '/json/data/admin/all/teams';

        console.log('Inside js teamsListTable');
        console.log('jsonUrl: ' + jsonUrl);
        $table.DataTable({
            lengthMenu: [[3, 5, 10, -1], ['3 records', '5 records', '10 records', 'All']],
            pageLength: 5,
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
                                + '/manage/'
                                + data
                                + '/team" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
                        return str;
                    }
                },
                {   data: 'teamName'    },
                {   data: 'groupNumber' },
                {   data: 'seasonId'    },
                {   data: 'leagueId'    },
                {   data: 'trainerPerId'    },
                {   data: 'matchesPlayed'  },
                {   data: 'wins'  },
                {   data: 'draws'  },
                {   data: 'losts'  },      
                {   data: 'points'  },
                {   data: 'active'  }
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
            lengthMenu: [[3, 5, 10, -1], ['3 records', '5 records', '10 records', 'All']],
            pageLength: 5,
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
                                + '/manage/'
                                + data
                                + '/activity" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
                        return str;
                    }
                },
                {   data: 'activityName'   },
                {   data: 'activityType'    },
                {   data: 'metricType'  },
                {   data: 'totalTime'   },
                {   data: 'uomCode' },
                {   data: 'quantityMin' },
                {   data: 'quantityMax' },
                {   data: 'active'  }
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
            lengthMenu: [[3, 5, 10, -1], ['3 records', '5 records', '10 records', 'All']],
            pageLength: 5,
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
                                + '/manage/'
                                + data
                                + '/training" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
                        return str;
                    }
                },
                {   data: 'trainingName'    },
                {   data: 'categoryCode'    },
                {   data: 'weeks'   },
                {   data: 'days'    },
                {   data: 'creatorPerId'    },
                {   data: 'statusCode'  },
                {   data: 'approverPerId'   },
                {   data: 'active'  }
            ]
        })
    }


    //trainActivities.jsp table
    $table = $('#trainActivListTable');

    if ($table.length) {

        var jsonUrl = '';
        jsonUrl = window.contextRoot + '/json/data/admin/all/trainActivities';

        console.log('Inside js trainActivListTable');
        console.log('jsonUrl: ' + jsonUrl);
        $table.DataTable({
            lengthMenu: [[3, 5, 10, -1], ['3 records', '5 records', '10 records', 'All']],
            pageLength: 5,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {   
                    data: 'trainActId'
                },
                {   data: 'activityNumber'},
                {   data: 'weeks'},
                {   data: 'days'},
                {   data: 'startTime'},
                {   data: 'endTime'},
                {   data: 'mondayFlag'},
                {   data: 'thursdayFlag'},
                {   data: 'wednesdayFlag'},
                {   data: 'tuesdayFlag'},
                {   data: 'fridayFlag'},
                {   data: 'saturdayFlag'}
            ]
        })
    }

    //lookupTypes.jsp table
    $table = $('#lookupTypesListTable');

    if ($table.length) {

        var jsonUrl = '';
        jsonUrl = window.contextRoot + '/json/data/admin/all/lookupTypes';

        console.log('Inside js lookupTypesListTable');
        console.log('jsonUrl: ' + jsonUrl);
        $table.DataTable({
            lengthMenu: [[3, 5, 10, -1], ['3 records', '5 records', '10 records', 'All']],
            pageLength: 5,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'lookupTypeId',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="'
                                + window.contextRoot
                                + '/manage/'
                                + data
                                + '/lookupType" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
                        return str;
                    }
                },
                {   data: 'lookupType'  },
                {   data: 'description' },
                {   data: 'systemFlag'  },
                {   data: 'startDate'  },
                {   data: 'endDate'  },
                {   data: 'active'  }
            ]
        })
    }
});
