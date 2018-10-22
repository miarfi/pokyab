$(function(){	
	
	
/*-------------------------------------------------------------*/
//Header menu
	switch(menu){
	
	case 'About': 
		$('#about').addClass('active');
		break;
	case 'Contact': 
		$('#contact').addClass('active');
		break;
	case 'All Products': 
		$('#listProducts').addClass('active');
		break;		
	case 'Manage Products': 
		$('#manageProducts').addClass('active');
		break;	
	default: 
		$('#home').addClass('active');
		$('#a_'+menu).addClass('active');
	break;
	}


//var products =[
//	
//	['1', 'ABC'],
//	['2', 'CYX'],
//	['3', 'PQR'],
//	['4', 'MNO']
//]



});
