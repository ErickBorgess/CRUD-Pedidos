document.addEventListener("DOMContentLoaded", () => {
    const params = new URLSearchParams(window.location.search);
    const id = params.get("id");
    if (id) fetchDetalhes(id);
});

function fetchDetalhes(id) {
    fetch(`http://localhost:8080/pedidos/${id}`)
        .then(response => response.json())
        .then(data => {
            const lista = document.getElementById("lista-itens");
            lista.innerHTML = "";
            data.itens.forEach(item => {
                const li = document.createElement("li");
                li.textContent = `${comanda.descricao} - R$ ${comanda.valorTotal}`;
                lista.appendChild(li);
            });
        });
}

function fecharComanda() {
    const params = new URLSearchParams(window.location.search);
    const id = params.get("id");
    if (!id) return;

    fetch(`http://localhost:8080/${id}/fechar`, { method: "PUT" })
        .then(() => window.location.href = "comandasIA.html");
}