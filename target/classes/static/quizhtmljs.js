/**
 * 
 */
 
 //DOM
 
function fungsi(){
if(document.getElementById('user').value==""){
	document.getElementById('warnuser').innerHTML= "*username tidak boleh kosong"
}
else{
	document.getElementById('warnuser').innerHTML= ""
}

if(document.getElementById('pass').value==""){
	document.getElementById('warnpass').innerHTML= "*password tidak boleh kosong"
}else{
	document.getElementById('warnpass').innerHTML= ""
}

if(document.getElementById('repass').value==""){
	document.getElementById('warnrepass').innerHTML= "*re-password tidak boleh kosong"
}else{
	document.getElementById('warnrepass').innerHTML= ""
}

if(document.getElementById('namaidentitas').value==""){
	document.getElementById('warnnamaidentitas').innerHTML= "*nama sesuai identitas tidak boleh kosong"
}else{
	document.getElementById('warnnamaidentitas').innerHTML= ""
}

if(document.getElementById('namaijasah').value==""){
	document.getElementById('warnnamaijasah').innerHTML= "*nama sesuai identitas tidak boleh kosong"
}else{
	document.getElementById('warnnamaijasah').innerHTML= ""
}

if(document.getElementById('jenisidentitas').value=="kosong"){
	document.getElementById('warnjenisidentitas').innerHTML= "*harus memilih jenis identitas"
}else{
	document.getElementById('warnjenisidentitas').innerHTML= ""
}

if(document.getElementById('nomoridentitas').value==""){
	document.getElementById('warnnomoridentitas').innerHTML= "*nomor identitas tidak boleh kosong"
}else{
	document.getElementById('warnnomoridentitas').innerHTML= ""
}

if(document.getElementById('kewarganegaraan').value=="kosong"){
	document.getElementById('warnkewarganegaraan').innerHTML= "*harus memilih jenis identitas"
}else{
	document.getElementById('warnkewarganegaraan').innerHTML= ""
}
}