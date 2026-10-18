package com.shopmaster;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    // Cambiamos la ruta para que coincida EXACTO con el action de tu formulario viejo
    @PostMapping("/ValidarIngreso")
    public String login(
            @RequestParam("campoUsuario") String usuarioRecibido,
            @RequestParam("campoContrasena") String claveRecibida
    ) {
        // Validamos con tus datos reales del Servlet
        if (usuarioRecibido != null && usuarioRecibido.equals("admin") &&
                claveRecibida != null && claveRecibida.equals("1234")) {

            return "¡Autenticación satisfactoria! Bienvenido Administrador al sistema ShopMaster.";
        } else {
            return "Error en la autenticación: Usuario o contraseña incorrectos. Intente de nuevo.";
        }
    }
}
