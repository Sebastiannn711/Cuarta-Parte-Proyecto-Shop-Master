const contenedorCatalogo = document.querySelector("#catalogo");
const estadoCatalogo = document.querySelector("#estado-catalogo");

fetch("/api/productos")
    .then((response) => {
        if (!response.ok) {
            throw new Error("No fue posible consultar los productos.");
        }
        return response.json();
    })
    .then((productos) => {
        if (!Array.isArray(productos) || productos.length === 0) {
            estadoCatalogo.textContent = "No hay productos disponibles.";
            return;
        }

        productos.forEach((producto) => {
            const tarjeta = document.createElement("article");
            tarjeta.className = "producto-card";

            const nombre = document.createElement("h3");
            nombre.textContent = producto.nombre;

            const precio = document.createElement("p");
            precio.className = "producto-precio";
            precio.textContent = new Intl.NumberFormat("es-CO", {
                style: "currency",
                currency: "COP",
                maximumFractionDigits: 0
            }).format(producto.precio);

            tarjeta.append(nombre, precio);
            contenedorCatalogo.append(tarjeta);
        });

        estadoCatalogo.textContent = `Productos disponibles: ${productos.length}`;
    })
    .catch(() => {
        estadoCatalogo.textContent = "No se pudo cargar el catálogo. Intenta de nuevo más tarde.";
    });
