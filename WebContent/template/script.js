
function getAtualizar(id, nome, fabricante, valor){
	let btnSubmit = document.getElementById("btnSubmit");
	let txtNome = document.getElementById("txtNome");
	let txtFabricante = document.getElementById("txtFabricante");
	let txtValor = document.getElementById("txtValor");
	
	btnSubmit.innerHTML = "Atualizar";
	document.getElementById("btnSubmit").classList.add("red");
	document.getElementById("btnCancelar").style.display = "block";
	document.getElementById("txtNome").value = nome;
	document.getElementById("txtFabricante").value = fabricante;
	document.getElementById("txtValor").value = valor;
	document.getElementsByTagName("form").action = "AtualizarProduto";
}