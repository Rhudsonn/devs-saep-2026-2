package com.senai.makita.configuracao;

import com.senai.makita.entitys.NivelAcesso;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class Web_Configuracao {

    // Registra os interceptadores que serão executados
    // Antes do controller
    public void addInterceptors(InterceptorRegistry registry) {

        // Exige que o usuario tenha perfil ADMINISTRADOR,
        // para acessar qualquer rota iniciada por /administrador
        registry.addInterceptor(new Perfil_Interceptador(NivelAcesso.ADMINISTRADOR))
                .addPathPatterns("/administrador/**");


        // Exige que o usuário tenha perfil GERENTE
        // para acessar as rotas de gerente.
        registry.addInterceptor(new Perfil_Interceptador(NivelAcesso.GERENTE))
                .addPathPatterns("/gerente/**");


        // Exige que o usuário tenha perfil FUNCIONARIO
        // para acessar as rotas de funcionario.
        registry.addInterceptor(new Perfil_Interceptador(NivelAcesso.FUNCIONARIO))
                .addPathPatterns("/funcionario/**");
    }

}
