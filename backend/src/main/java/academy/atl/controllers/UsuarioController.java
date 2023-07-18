package academy.atl.controllers;

import academy.atl.models.Usuario;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class UsuarioController {

    // Lista de usuarios dinámica
    static List<Usuario> usuarios = new ArrayList<>();

    // Usuarios de ejemplo (al iniciar la app)
    static {
        usuarios.add(new Usuario(25,"Lucas", "Moy", "1234567", "lucas@moy.com"));
        usuarios.add(new Usuario(26,"Juan", "Perez", "1234568", "juan@perez.com"));
        usuarios.add(new Usuario(27,"Ana", "Smith", "1234569", "ana@smith.com"));
        usuarios.add(new Usuario(28,"Maria", "Martinez", "1234570", "maria@martinez.com"));
        usuarios.add(new Usuario(29,"Pedro", "Rodriguez", "1234571", "pedro@rodriguez.com"));
        usuarios.add(new Usuario(30,"Luis", "Gonzalez", "1234572", "luis@gonzalez.com"));
    }

    // Obtener todos los usuarios
    @GetMapping("/api/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    // Eliminar un usuario por si ID
    @DeleteMapping("/api/usuarios/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {
        usuarios.removeIf(user -> Objects.equals(id, user.getId()));
    }

    // Ruta de prueba
    @PostMapping("/api/usuarios")
    public void crearUsuario(@PathVariable Usuario usuario) {
        usuarios.add(usuario);
    }
}
