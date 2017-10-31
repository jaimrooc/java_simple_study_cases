// -------------------------------------------------------------------------------------
let promesa1 = new Promise((resolve,reject) => {
	$.getJSON( "https://www.datos.gov.co/resource/uz87-8a52.json", function( data ) {
		setTimeout(resolve, 2000, data);
		//resolve(data);
	});
});

promesa1.then((data)=>{
	let contenido = "";
	data.forEach((cicloruta)=>{
		for(propiedad in cicloruta){
			if(propiedad === "estado"){
				contenido = contenido + "<p>" + cicloruta.estado+ "</p>"; 
			}
		}
	});
	 $('#div1').html(contenido);
});

// -------------------------------------------------------------------------------------
let promesa2 = new Promise((resolve,reject) => {
	$.getJSON( "https://www.datos.gov.co/resource/uz87-8a52.json", function( data ) {
		setTimeout(resolve, 5000, data);
		//resolve(data);
	});
});

promesa2.then((data)=>{
	let contenido = "";
	data.forEach((cicloruta)=>{
		for(propiedad in cicloruta){
			if(propiedad === "nombre"){
				contenido = contenido + "<p>" + cicloruta.nombre+ "</p>"; 
			}
		}
	});
	 $('#div2').html(contenido);
});


// -------------------------------------------------------------------------------------
let promesa3 = new Promise((resolve,reject) => {
	$.getJSON( "https://www.datos.gov.co/resource/uz87-8a52.json", function( data ) {
		setTimeout(resolve, 3000, data);
		//resolve(data);
	});
});

promesa3.then((data)=>{
	let contenido = "";
	data.forEach((cicloruta)=>{
		for(propiedad in cicloruta){
			if(propiedad === "ubicacion"){
				contenido = contenido + "<p>" + cicloruta.ubicacion+ "</p>"; 
			}
		}
	});
	 $('#div3').html(contenido);
});