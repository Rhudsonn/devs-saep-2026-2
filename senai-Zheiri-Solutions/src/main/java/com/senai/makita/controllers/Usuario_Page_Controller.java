package com.senai.makita.controllers;

import com.senai.makita.Sessao.SessaoDto;
import com.senai.makita.Sessao.SessaoUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Usuario_Page_Controller {

    @GetMapping("/")
    public String index(){
        return "redirect:/login";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
        SessaoUtil.removerSessao(session);
        return "redirect:/login";
    }

    //Home publica
    //HttpSession session como parâmetro — sem isso o controller não tem acesso a nada que foi guardado no login.
    @GetMapping("/home")
    public String home(HttpSession session, Model model){

        SessaoDto sessaoDto = SessaoUtil.obterSessao(session);

        if (sessaoDto == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuario", sessaoDto);

        return "home"; // aponta pro template em templates/admin/home.html
    }


}
