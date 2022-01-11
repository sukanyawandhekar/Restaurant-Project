/**
 * 
 */
 
 		 function send()
		 {
			
			var name=document.getElementById("nameId").value;
			var password=document.getElementById("pass").value;
			var email=document.getElementById("email").value;
			var mob=document.getElementById("mob").value;
			
			
			var flag=0;
			
			if(name=="" || email=="" || mob=="")
			{
			alert("please enetr values");
			}
 
 