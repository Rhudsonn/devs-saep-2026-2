package com.senai.makita.services;

import com.senai.makita.Sessao.SessaoDto;
import com.senai.makita.configuracao.Security_Configuracao;
import com.senai.makita.dtos.LoginDto;
import com.senai.makita.entitys.NivelAcesso;
import com.senai.makita.entitys.Status;
import com.senai.makita.repositorys.UsuarioRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class Autenticar_Usuario_Service {


    private final UsuarioRepository usuarioRepository;
    private final Security_Configuracao security_Configuracao;

    public Autenticar_Usuario_Service(UsuarioRepository usuarioRepository, Security_Configuracao security_Configuracao) {
        this.usuarioRepository = usuarioRepository;
        this.security_Configuracao = security_Configuracao;
    }

    // Metodo de realizar login.
    public SessaoDto autenticar(LoginDto loginDto) throws BadRequestException {

        // Busca no banco o usuário pelo e-mail informado no login.
        // O retorno é um Optional<UsuarioEntity>, ou seja, pode vir vazio
        // caso não exista nenhum usuário cadastrado com esse e-mail.
        return usuarioRepository.findByEmail(loginDto.email())

        // Verifica se o usuário está ATIVO no sistema.
        // Se estiver INATIVO (ou outro status diferente), o filter
        // descarta o Optional, tornando-o vazio, e o fluxo cai no orElseThrow.
        .filter(usuarioEntity -> usuarioEntity.getStatus() == Status.ATIVO)

        // Compara a senha digitada (texto puro) com o hash salvo no banco.
        // O PasswordEncoder faz a criptografia da senha digitada e verifica
        // se ela corresponde ao hash armazenado (matches retorna true/false).
        .filter(usuarioEntity -> security_Configuracao.passwordEncoder().matches(loginDto.senha(), usuarioEntity.getSenha()))

        // Se passou pelos dois filtros acima (usuário ativo + senha correta),
        // monta o SessaoDto com os dados que serão salvos na sessão:
        // Id do usuário, nome do usuário e o nível de acesso dele
        // (ADMINISTRADOR, GERENTE ou FUNCIONARIO), que já vem gravado no banco.
                .map(usuarioEntity -> new SessaoDto(
                        usuarioEntity.getId(),
                        usuarioEntity.getNome(),
                        usuarioEntity.getNivelAcesso()
                ))



        // Implementar o Bloqueio de status INATIVO a logar (Gerente e Funcionario).*************



        //Se o e-mail não existir, ou a senha estiver incorreta lanço um erro.
                .orElseThrow(() -> new com.senai.makita.excecoes.BadRequestException("E-mail ou senha inválido!"));

    }

}
