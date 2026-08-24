package com.senai.makita.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Indica ao Spring que esta classe contém configurações do sistema
//e definições de Beans que devem ser gerenciados pelo container IoC.
@Configuration
public class Security_Configuracao {

    //Declara um Bean do Spring para a criptografia de senhas.
    //O Spring gerencia este objeto e o injeta onde for solicitado.
    //@return Uma instância de BCryptPasswordEncoder para codificar e validar senhas.
    @Bean
    public PasswordEncoder passwordEncoder() {
        //Retorna o algoritmo BCrypt com o fator de custo/força padrão (10 log rounds).
        // Isso gera um hash seguro contendo o salt e o custo embutidos.
        return new BCryptPasswordEncoder();
    }


}
