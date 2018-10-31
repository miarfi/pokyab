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
                    data: 'personId'
                },
                {
                    data: 'firstName'
                },
                {
                    data: 'lastName'
                },
                {
                    data: 'personType'
                },
                {
                    data: 'emailAddress'
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
            lengthMenu: [[3, 5, 10, -1], ['3 records', '5 records', '10 records', 'All']],
            pageLength: 5,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'activityId'
                },
                {
                    data: 'activityName'
                },
                {
                    data: 'activityType'
                },
                {
                    data: 'metricType'
                },
                {
                    data: 'totalTime'
                },
                {
                    data: 'uomCode'
                },
                {
                    data: 'quantityMin'
                },
                {
                    data: 'quantityMax'
                },
                {
                    data: 'active'
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
            lengthMenu: [[3, 5, 10, -1], ['3 records', '5 records', '10 records', 'All']],
            pageLength: 5,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'trainingId'
                },
                {
                    data: 'trainingName'
                },
                {
                    data: 'categoryCode'
                },
                {
                    data: 'weeks'
                },
                {
                    data: 'days'
                },
                {
                    data: 'creatorPerId'
                },
                {
                    data: 'statusCode'
                },                
                {
                    data: 'approverPerId'
                }
                ,
                {
                    data: 'active'
                }
            ]
        })
    }


});
