package com.mais.cadastro_usuario.business;

import org.springframework.stereotype.Service;
import com.mais.cadastro_usuario.infrastructure.entitys.Usuario;
import com.mais.cadastro_usuario.infrastructure.repository.UsuarioRepository;

@Service

public class UsuarioService {
    
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("E-mail não encontrado")
        );
    }

    public void deletarUsuarioPorEmail( String email){
        repository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
        .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())

        .name(usuario.getName() != null ? usuario.getName() : usuarioEntity.getName())

        .id(usuarioEntity.getId())
        .build();

        repository.saveAndFlush(usuarioAtualizado);
    }
}
