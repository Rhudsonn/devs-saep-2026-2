package com.senai.makita.configuracao;

import com.senai.makita.Sessao.SessaoDto;
import com.senai.makita.Sessao.SessaoUtil;
import com.senai.makita.entitys.NivelAcesso;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

// Interceptador responsável por verificar se o usuário
// está autenticado e possui o perfil necessário para acessar a rota.
public class Perfil_Interceptador implements HandlerInterceptor {

    // Perfil que será exigido para acessar determinada rota.
    private final NivelAcesso nivelAcesso;

    public Perfil_Interceptador(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }


    // Executado antes do método do Controller.
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SessaoDto sessaoDto = SessaoUtil.obterSessao(request.getSession());

        // Obtém as informações do usuário armazenadas na sessão.
        if (sessaoDto == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "É necessário estar logado!");
            return false;
        }

        // Permite que a requisição continue até o Controller.
        return true;
    }


}
