/**
 * 
 */

function Validar(){
	const Nome = FRM_Contato.Nome.value;
	const N_Phone = FRM_Contato.Phone.value;
	if (Nome === ""){
		alert("PREENCHA O CAMPO NOME...");
		FRM_Contato.Nome.focus();
		return false;
	}else if(N_Phone === ""){
		alert("PREENCHA O CAMPO NUMERO DE TELEFONE...");
		FRM_Contato.Phone.focus();
		return false;
	}else{
		document.forms["FRM_Contato"].submit();
	}
}
	
 