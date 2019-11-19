
function setEndTime()
{
	var a = parseInt(document.getElementById('shift_start_time').value);
	var b=':00:00';
	document.getElementById('shift_end_time').value = a + 8 + b;
	
}

function myFunction() 
{
	document.getElementById('demo').value= Date();
}
function validateEmail()
{
	var re = /^(?:[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])$/;	
	var entered_email=document.getElementById('email_id').value;
	
	if(!(re.test(entered_email)))
		{
		alert("Please enter valid email address");
		document.getElementById('email_id').focus();
		return false;
		}
		else
		{
			return true;
		}
}
function checkPhone()
{
  var phoneno = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;
  var entered_phone=document.getElementById('phone').value;
  	  
  	if(!(phoneno.test(entered_phone)))
  	{
		alert("Please enter valid Phone Number!");
  		document.getElementById('phone').focus();
  		return false;
	}
	else
	{
		return true;
	}
}
function MailandPhoneValidate() 
{
	  if (!( validateEmail() && checkPhone() )) 
		{
		  	return false;
		 }
	  else
		{
	  		return true;
		}
}


//This Javascript is for RegisterRetailer page

function checkcontact1()
{
	var phoneno = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;
	  var entered_contact1=document.getElementById('rr_contact1').value;
	  var entered_contact2=document.getElementById('rr_contact2').value;
	  	 
	  	if(!(phoneno.test(entered_contact1)))
	  	{
			alert("Please enter valid Contact1 ");
	  		document.getElementById('rr_contact1').focus();
	  		return false;
		}
	  	else if(!(phoneno.test(entered_contact2)))
	  	{
	  		alert("Please enter valid Contact2");
	  		document.getElementById('rr_contact2').focus();
	  		return false;
	  		
	  	}
		else
		{
			return true;
		}
}
function checkzipcode()
{
	 var entered_zipcode=document.getElementById('rr_zipcode').value;
	 var isValidZip = /(^\d{5}$)|(^\d{5}-\d{4}$)/;
	 	
	  	if(!(isValidZip.test(entered_zipcode)))
	  	{
			alert("Zipcode Is invalid!");
	  		document.getElementById('rr_zipcode').focus();
	  		return false;
		}
		else
		{
			return true;
		}
}


function RegisterRetailerPageValidation() 
{
	
	  if ((checkcontact1()   && checkzipcode() ) === true )
		{
		  	return true;
		 }
	  else
		{
	  		return false;
		}
}









