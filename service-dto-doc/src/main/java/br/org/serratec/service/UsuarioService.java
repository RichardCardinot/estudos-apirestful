package br.org.serratec.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.serratec.dto.UsuarioDTO;
import br.org.serratec.dto.UsuarioInserirDTO;
import br.org.serratec.exception.EmailException;
import br.org.serratec.model.Usuario;
import br.org.serratec.model.UsuarioPerfil;
import br.org.serratec.repository.UsuarioPerfilRepository;
import br.org.serratec.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UsuarioPerfilRepository usuarioPerfilRepository;
	
	@Autowired
	private PerfilService perfilService;
	
	// Mudamos para o retorno ser do tipo UsuarioDTO
	public List<UsuarioDTO> listar() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		
//		 //Convertendo cada Usuario da lista usuarios para UsuarioDTO e armazenando na lista usuariosDTO
//		 for (Usuario usuario : usuarios) {
//			 usuariosDTO.add(new UsuarioDTO(usuario));
//		 }
		
		// Fazendo o mesmo que foi comentado acima, mas agora com o stream, usando a programação funcional
		// (Convertendo cada Usuario da lista usuarios para UsuarioDTO e armazenando na lista usuariosDTO)
		usuariosDTO = usuarios.stream().map(usuario -> new UsuarioDTO(usuario)).collect(Collectors.toList());
		
		return usuariosDTO; 
		
	}
	
	// Recebe no formato UsuarioInserirDTO e retorna no formato UsuarioDTO
	public UsuarioDTO inserir(UsuarioInserirDTO usuarioInserirDTO) {
		
		// Se o email já estiver sendo utilizado, retornamos a EmailException
		if (usuarioRepository.findByEmail(usuarioInserirDTO.getEmail()) != null) {
			throw new EmailException("Email já existente na base");
		}
		
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setSenha(bCryptPasswordEncoder.encode(usuarioInserirDTO.getSenha())); // Usa o bCryptPasswordEncoder para criptografar a senha recebida no parâmetro usuario
		
		usuario = usuarioRepository.save(usuario);
		
		for (UsuarioPerfil usuarioPerfil : usuarioInserirDTO.getUsuariosPerfil()) {
			usuarioPerfil.setUsuario(usuario);
			usuarioPerfil.setPerfil(perfilService.buscar(usuarioPerfil.getPerfil().getIdPerfil()));
			usuarioPerfil.setDataCriacao(LocalDate.now()); // LocalDate.now() pega a horário atual da máquina.
		}
		
		usuarioPerfilRepository.saveAll(usuarioInserirDTO.getUsuariosPerfil());
		
		return new UsuarioDTO(usuario);
		
	}

}
