package com.shopmaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@ResponseBody
@Controller
public class ProductosController {
    @GetMapping("/api/productos")
    public List<Producto> productos() {
        // 1. Creamos la lista vacía
        List<Producto> lista = new ArrayList<>();

        // 2. Fabricamos la ropa de ShopMaster y la metemos a la lista
        lista.add(new Producto(1, "Camiseta Premium", 85000.0));
        lista.add(new Producto(2, "Pantalón Denim", 45000.0));
        lista.add(new Producto(3, "Chaqueta Térmica", 120000.0));

        // 3. Devolvemos la lista limpia en formato JSON
        return lista;
    }

}

