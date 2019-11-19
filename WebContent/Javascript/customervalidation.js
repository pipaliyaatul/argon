//Javascript for Register customer page on Admin Page

//This are regular expression strings to compared
var re = /^(?:[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])$/;
var phoneno = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;
var isValidZip = /(^\d{5}$)|(^\d{5}-\d{4}$)/;

function adminregcustomeremail()
{
	var email=document.getElementById('a_r_c_email').value;
	
	if(!(re.test(email)))
	{
		alert("Please enter valid email address");
		document.getElementById('a_r_c_email').focus();
		return false;
	}
	else 
	{
			return true;
	}
}
function ad_reg_cust_phone()
{
		
		var register_customer_phone=document.getElementById('a_r_c_phone').value;
	  	  
	  	if(!(phoneno.test(register_customer_phone)))
	  	{
			alert("Please enter valid Phone Number!");
	  		document.getElementById('a_r_c_phone').focus();
	  		return false;
		}
		else
		{
			return true;
		}
	
}
function ad_reg_cust_zipcode()
{
	 var entered_zipcode=document.getElementById('a_r_c_zipcode').value;
	 
	  	if(!(isValidZip.test(entered_zipcode)))
	  	{
			alert("Zipcode Is invalid!");
	  		document.getElementById('a_r_c_zipcode').focus();
	  		return false;
		}
		else
		{
			return true;
		}
}

function adminregcust()
{
	if(	(adminregcustomeremail() && ad_reg_cust_phone() && ad_reg_cust_zipcode() ) == true )
	{
		return true;
	}
	else
	{
		return false;	
	}
}

//This function are for update operator page validation

function adm_update_ope_email()
{
	var email=document.getElementById('update_cust_email').value;
	
	if(!(re.test(email)))
	{
		alert("Please enter valid email address");
		document.getElementById('update_cust_email').focus();
		return false;
	}
	else 
	{
			return true;
	}
}
function ad_update_operator_phone()
{
		
		var register_customer_phone=document.getElementById('update_cust_phone').value;
	  	  
	  	if(!(phoneno.test(register_customer_phone)))
	  	{
			alert("Please enter valid Phone Number!");
	  		document.getElementById('update_cust_phone').focus();
	  		return false;
		}
		else
		{
			return true;
		}
	
}

function admin_update_operator()
{
	if(	(adm_update_ope_email() && ad_update_operator_phone() ) == true )
	{
		return true;
	}
	else
	{
		return false;	
	}
}












//This javascript is for Update Retailer Page on admin Dashboard



function admin_update_retailer()
{
	var email=document.getElementById('a_r_c_email').value;
	
	if(!(re.test(email)))
	{
		alert("Please enter valid email address");
		document.getElementById('a_r_c_email').focus();
		return false;
	}
	else 
	{
			return true;
	}
}
function ad_reg_cust_phone()
{
		
		var register_customer_phone=document.getElementById('a_r_c_phone').value;
	  	  
	  	if(!(phoneno.test(register_customer_phone)))
	  	{
			alert("Please enter valid Phone Number!");
	  		document.getElementById('a_r_c_phone').focus();
	  		return false;
		}
		else
		{
			return true;
		}
	
}
function ad_reg_cust_zipcode()
{
	 var entered_zipcode=document.getElementById('a_r_c_zipcode').value;
	 
	  	if(!(isValidZip.test(entered_zipcode)))
	  	{
			alert("Zipcode Is invalid!");
	  		document.getElementById('a_r_c_zipcode').focus();
	  		return false;
		}
		else
		{
			return true;
		}
}

function adminregcust()
{
	if(	(adminregcustomeremail() && ad_reg_cust_phone() && ad_reg_cust_zipcode() ) == true )
	{
		return true;
	}
	else
	{
		return false;	
	}
}

































/*function admincustomerpageall()
{
	if(adminregcustomeremail()==true)
	{
		return true;
		
	}
	return false;
}*/