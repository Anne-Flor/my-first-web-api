package demo.my_first_web_api.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import demo.my_first_web_api.model.Usuario;

@Repository
public class UsuarioRepository {
    public void save(Usuario usuario){
        if(usuario.getId()== 0)
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
            else
            System.out.println("UPDATE - Recebendo usuário na camada de respositproio");

            System.out.println(usuario);
    }
    public void deleteById(int id){
        System.out.println("DELETE/id - Recebendo o id: %d para excluir um ");
        System.out.println(id);
    }
    public List<Usuario> findall(){
            System.out.println("LIST- Listando os usuário do sistema");
            List<Usuario> usuarios = new ArrayList<>();
            usuarios.add(new Usuario("Glaysson", "password"));
            usuarios.add(new Usuario("frank", "masterpass"));
            return usuarios;
    }

    public Usuario findById(int id){
        System.out.println(String.format("FIND/id - Receendo o id: %d para localizar um usuário", id));
        return new Usuario("Gleysson", "password");
    }
    public Usuario findByUserName(String username){
        System.out.println(String.format("FIND/username - Recebendo o username: %s para", username));
        return new Usuario("gleyson", "password");
    }

}
