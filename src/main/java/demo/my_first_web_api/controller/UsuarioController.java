package demo.my_first_web_api.controller;

import java.util.List;

import demo.my_first_web_api.model.Usuario;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


import demo.my_first_web_api.Repository.UsuarioRepository;

@RestController
@RequestMapping("/users") //todas as requisições existentes no controller vão iniciar com users.
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @GetMapping()
    public List<Usuario>getUser(){
        return repository.findall();
    }

    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("Username")String username){
        return repository.findByUserName(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @PostMapping()
    public void postuser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }

    @PutMapping()
    public void putuser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
}
