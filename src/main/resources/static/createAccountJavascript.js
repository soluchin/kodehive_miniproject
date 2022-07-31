/**
 * 
 */
 
 function otherFunction(){
	if(document.getElementById('collegeid').value!="1"){
		document.getElementById('collegename').style.display = "none";
	}else{
	document.getElementById('collegename').style.display= "block";
	}
}

function send(){
	var accountinfo={
		email: $("#email").val(),
		password: $("#password").val(),
		firstname: $("#firstname").val(),
		lastname: $("#lastname").val(),
		genderid: parseInt($("input[type='radio'][name='gender']:checked").val()),
		collegeid: parseInt($("#collegeid").val()),
		collegename: $("#collegename").val(),
		gradyear: parseInt($("#gradyear").val()),
		contact: $("#contact").val()
	}
	
	$.ajax({
            url: 'api/createaccount',
            type: 'post',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(accountinfo),
            success: function(resultData) { alert("Save Complete") }
        });
    console.log(JSON.stringify(accountinfo))
    return false;
}