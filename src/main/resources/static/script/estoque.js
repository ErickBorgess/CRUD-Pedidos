document.addEventListener("DOMContentLoaded", () => {
    fetchEstoque();
});

function fetchEstoque() {
    fetch("http://localhost:8080/estoque")
        .then(response => response.json())
        .then(data => {
            const lista = document.getElementById("lista-produtos");
            lista.innerHTML = "";
            data.forEach(produto => {
                const li = document.createElement("li");
                li.textContent = `${produto.nomeItem} - R$ ${produto.preco}`;
                lista.appendChild(li);
            });
        });
}

function novoProduto() {
    const nome = prompt("Nome do produto:");
    const preco = parseFloat(prompt("Preço do produto:"));
    if (!nome || isNaN(preco)) return;

    fetch("http://localhost:8080/estoque", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ nomeItem: nome, preco: preco })
    }).then(() => fetchEstoque());
}