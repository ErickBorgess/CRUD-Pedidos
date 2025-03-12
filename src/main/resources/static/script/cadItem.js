const formulario = document.querySelector("form");
const Inome = document.querySelector("#txtNome");
const Ivalor = document.querySelector("#txtValor");
const Iid = document.querySelector("#idSeletor");

function cadastrarItem() {
    fetch("http://localhost:8080/estoque",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            credentials: "include",
            body: JSON.stringify({
                nomeItem: Inome.value,
                preco: Ivalor.value, 
            })
        })
        .then(function(res) {console.log(res)})
        .catch(function(res) {console.log(res)})
};

function deletarItem() {
    const id = Iid.value;

    if(!id){
        alert("ID vazio ou não encontrado!")
        return;
    }

    fetch(`http://localhost:8080/estoque/${id}`,
        {
            method: "DELETE"
        })
        .then(function(res) {
            console.log(res)
            alert(`Item ${id} excluido com sucesso`)
        })
        .catch(function(res) {console.log(res)})
};

function atualizarPedido() {
    
}

function limparCampos() {
    Inome.value = "";
    Ivalor.value = "";
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    cadastrarItem();
    limparCampos();
});