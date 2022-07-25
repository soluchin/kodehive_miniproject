/**
 * 
 */
 
 console.log("hello world")
 console.log("")
 
 console.log("js quiz 2 nomor 4")
 
 
 var buku={
	judul: "Spring in Action",
	harga: "360979",
	penulis: "Craig Walls"
}

Object.entries(buku).forEach(
	entry =>{
		const [key,val] = entry
		console.log(key+": "+val)
	}
)
console.log("")
console.log("js quiz 3 nomor 1")
console.log(isNaN(200))
console.log(isNaN("900"))
console.log(isNaN(100.9))
console.log(isNaN("False"))


console.log("")
console.log("js quiz 3 nomor 3")
function awesomeFunction(){
	var a= 2
	var multiplyBy2= function(){
		console.log(a*2)
	}
	
}

var grand_total= eval("10*20/2")
console.log(grand_total+2)

function foo1(){
	return {
		salam: "hei"
	}
}

function foo2(){
	return {
		salam: "hei"
	}
}

console.log(foo2().salam)



const person={
	name: 'sumagusta',
	pet: {
		name:"suma"
	}
}

console.log(person.pet.name)


