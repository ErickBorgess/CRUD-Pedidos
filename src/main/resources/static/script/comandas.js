function load() {
    fetch("http://localhost:8080/api/pedidos")
        .then(response => response.json())
        .then(pedidos => {
            const container = document.querySelector("#pedidos-container");
            container.innerHTML = "";
            let i = 1

            pedidos.map(pedido => {
                const card = document.createElement("div")
                card.classList.add("card")

                const nome = document.createElement("h2")
                nome.textContent = "MESA "+i
                const cliente = document.createElement("h3")
                cliente.textContent = "Cliente: "+pedido.cliente
                const itens = document.createElement("h3")
                itens.textContent = "Itens: "+pedido.itens
                const valor = document.createElement("h3")
                valor.textContent = "Valor: "+pedido.valor

                card.appendChild(nome)
                card.appendChild(cliente)
                card.appendChild(itens)
                card.appendChild(valor)

                container.appendChild(card)
                ++i
            })
        })
}


document.addEventListener("DOMContentLoaded", () => {
    load();
    setInterval(5);
});