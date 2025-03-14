const nomeComanda = document.querySelector("#nomeComanda")

document.addEventListener("DOMContentLoaded", () => {
    fetchComandas();
});

function fetchComandas() {
    fetch("http://localhost:8080/pedidos")
        .then(response => response.json())
        .then(data => {
            const lista = document.getElementById("lista-comandas");
            lista.innerHTML = "";
            data.forEach(comanda => {
                const li = document.createElement("li");
                li.textContent = `${comanda.descricao} - R$ ${comanda.valorTotal}`;
                li.addEventListener("click", () => abrirComanda(comanda.idComanda));
                lista.appendChild(li);
            });
        });
}

function abrirComanda(id) {
    window.location.href = `detalhes-comandas.html?id=${id}`;
}

function novaComanda() {
    fetch("http://localhost:8080/pedidos", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ descricao: nomeComanda.value, valorTotal: 0 })
    }).then(() => fetchComandas());
}
