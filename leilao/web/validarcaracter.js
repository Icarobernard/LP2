
function validar(dom,tipo){
	switch(tipo){
		case'numero':var regex=/[A-Za-z]/g;break;
		case'texto':var regex=/\d/g;break;
	}
	dom.value=dom.value.replace(regex,'');
}
