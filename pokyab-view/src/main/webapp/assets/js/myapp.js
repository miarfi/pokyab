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
        }, 5000 );
    }

    //bootbox class=confirmation 
    $('.confirmation').on('click', function (e) {
        console.log('confirmation');
        e.preventDefault();
        href = $(this).attr('href');
        return bootbox.confirm('Está seguro de borrar el registro?', function (result) {
            if (result) {
                window.location = href;
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

//        var activationUrl = window.contextRoot + '/manage/person/' + value + '/activation';
        bootbox.confirm({
            size: 'medium',
            title: 'Activaci&oacute;n / Desactivaci&oacute;n',
            message: dMsg,
            callback: function (confirmed) {
                console.log('confirmed: '+confirmed);
                console.log('value: '+value);
                if (confirmed) {

                    //Post activate
                    var activationUrl = window.contextRoot + '/manage/'+window.currentPage+'/' + value + '/activation';
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
                            //display(e);
                        }
                    });
                } else {
                    checkbox.prop('checked', !checked);
                }
            }
        });
    });        

});