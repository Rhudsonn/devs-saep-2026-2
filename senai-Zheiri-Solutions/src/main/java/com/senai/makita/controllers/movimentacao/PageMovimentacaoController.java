package com.senai.makita.controllers.movimentacao;

import com.senai.makita.Sessao.SessaoDto;
import com.senai.makita.Sessao.SessaoUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageMovimentacaoController {

    @GetMapping("/movimentacao")
    public String movimentacao(HttpSession session) {

        SessaoDto sessaoDto = SessaoUtil.obterSessao(session);

        if (sessaoDto == null) {
            return "redirect:/login";
        }
        return "movimentacao";
    }

}
