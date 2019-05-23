
function getAtualizar(id, nome, fabricante, valor){
	btnSubmit.innerHTML = "Atualizar";
	btnSubmit.classList.add("yellow");
	btnCancelar.style.display = "block";
	
	txtId.value = id;
	txtNome.value = nome;
	txtFabricante.value = fabricante;
	txtValor.value = valor;
}
