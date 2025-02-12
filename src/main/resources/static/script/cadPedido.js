const formulario = document.querySelector("form");
const Icliente = document.querySelector("#txtCliente");
const Iitens = document.querySelector("#txtItens");
const Ivalor = document.querySelector("#txtValor");

function cadastrarPedido() {
    fetch("http://localhost:8080/api/pedidos",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                nome: Icliente.value,
                itens: Iitens.value,
                valor: Ivalor.value, 
            })
        })
        .then(function(res) {console.log(res)})
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