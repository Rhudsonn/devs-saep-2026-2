package com.senai.makita.controllers.produto;

import com.senai.makita.Sessao.SessaoDto;
import com.senai.makita.Sessao.SessaoUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageProdutoController {

    // Metodo produto para acessar produto sera publico, mais para algumas funcionalidades sera exigido altorização.
    @GetMapping("/produto")
    public String produto(HttpSession session){

            SessaoDto sessaoDto = SessaoUtil.obterSessao(session);

            if (sessaoDto == null) {
                return "redirect:/login";
            }

        return "/produto";
    }

}
