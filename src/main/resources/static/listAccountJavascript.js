/**
 * 
 */
 
 
 
$(document).ready(function(){
	$.ajax({
		url: 'listallaccount',
		type: 'get',
		dataType: 'html'
		})
	})
	
function searchbyskill(){
	var skillarray=[]
	$("input[type='checkbox'][name='selectskills']:checked"
		).each(function(){
			skillarray.push(parseInt($(this).val()))
		})
	var info={
		integers:skillarray
	}
	
	$.ajax({
            url: 'listaccountbyskill',
            type: 'post',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(info),
            success: function(response) {
				console.log(response)
			},
			error: function(response) {
				console.log(response)
				
			}
        });
    return false;
}

function deletedata(id){
	var dlt={
		id: id
	}
	console.log(dlt)
	$.ajax({
		url: "api/deletedatabyuserid",
		type: "get",
		data: dlt,
		success:function(response){
			window.location.reload();
		}
	})
	return false
}