package com.senai.makita.controllers;

import com.senai.makita.Sessao.SessaoDto;
import com.senai.makita.Sessao.SessaoUtil;
import com.senai.makita.dtos.LoginDto;
import com.senai.makita.services.Autenticar_Usuario_Service;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Autenticacao_Controller {

    private final Autenticar_Usuario_Service autenticar_usuario_service;


    public Autenticacao_Controller(Autenticar_Usuario_Service autenticar_usuario_service) {
        this.autenticar_usuario_service = autenticar_usuario_service;
    }



    @PostMapping("/login")
    public String login(@Valid LoginDto loginDto, HttpSession session, RedirectAttributes attributes){

        try {
            SessaoDto sessaoDto = autenticar_usuario_service.autenticar(loginDto);
            SessaoUtil.registrarSessao(session, sessaoDto);



            return switch (sessaoDto.nivelAcesso()){
                case ADMINISTRADOR -> "redirect:/home";
                case GERENTE -> "redirect:/home";
                case FUNCIONARIO -> "redirect:/home";
            };

        }catch (Exception e){
            attributes.addFlashAttribute("erro", e.getMessage());
            return "redirect:/login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
        SessaoUtil.removerSessao(session);
        return "redirect:/login";
    }




}
