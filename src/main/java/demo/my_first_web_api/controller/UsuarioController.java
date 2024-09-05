package demo.my_first_web_api.controller;

import java.util.List;

import demo.my_first_web_api.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import demo.my_first_web_api.Repository.UsuarioRepository;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @GetMapping("/users")
    public List<Usuario>getUser(){
        return repository.findall();
    }
}
