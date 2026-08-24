package com.senai.makita.Sessao;

import jakarta.servlet.http.HttpSession;

public class SessaoUtil {



    // Nome da variavel que vamos usar para armazenar os dados da sessão.
    private static final String USUARIO_LOGADO = "usuarioLogado";



    private SessaoUtil() {}



    // Metodo para registrar o usuario, (nome e ID) na sessão.
    public static void registrarSessao(HttpSession session, SessaoDto sessaoDto) {
        session.setAttribute(USUARIO_LOGADO, sessaoDto);
    }



    // Metodo para obter o usuario (nome e ID) na sessão.
    public static SessaoDto obterSessao(HttpSession session) {
        Object usuarioLogado = session.getAttribute(USUARIO_LOGADO);

        if (usuarioLogado == null) {
            return null;
        }

        // Cast explicito para converter Object em SessaoDto
        return (SessaoDto) usuarioLogado;
    }


    // Metodo para remover usuario da sessão.
    public static void removerSessao(HttpSession session) {
        session.removeAttribute(USUARIO_LOGADO);
        session.invalidate();
    }



}
