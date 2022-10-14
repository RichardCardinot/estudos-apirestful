package br.org.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.serratec.exception.EmailException;
import br.org.serratec.model.Usuario;
import br.org.serratec.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	public Usuario inserir(Usuario usuario) {
		Usuario usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());
		
		if (usuarioEncontrado != null) {
			throw new EmailException("Email já existente na base");
		}
		
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha())); // Usa o bCryptPasswordEncoder para criptografar a senha recebida no parâmetro usuario
		return usuarioRepository.save(usuario);
	}

}
