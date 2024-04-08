
function confirmar(id){
	var res = confirm("Deseja excluír o contato de ID: " + id + "?");
	if (res == true){
		window.location.href="Delete?idcon="+id;
	}else{
		window.alert("Então venha me mamar...");
	}
}
