const formulario = document.querySelector("form");
const Icliente = document.querySelector("#txtCliente");
const Iitens = document.querySelector("#txtItens");
const Ivalor = document.querySelector("#txtValor");
const Iid = document.querySelector("#idSeletor");

function cadastrarPedido() {
    fetch("http://localhost:8080/api/pedidos",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                cliente: Icliente.value,
                itens: Iitens.value,
                valor: Ivalor.value, 
            })
        })
        .then(function(res) {console.log(res)})
        .catch(function(res) {console.log(res)})
};

function deletarPedido() {
    const id = Iid.value;

    if(!id){
        alert("ID vazio ou não encontrado!")
        return;
    }

    fetch(`http://localhost:8080/api/pedidos/${id}`,
        {
            method: "DELETE"
        })
        .then(function(res) {
            console.log(res)
            alert(`Pedido ${id} excluido com sucesso`)
        })
        .catch(function(res) {console.log(res)})
};

function limparCampos() {
    Icliente.value = "";
    Iitens.value = "";
    Ivalor.value = "";
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    cadastrarPedido();
    limparCampos();
});