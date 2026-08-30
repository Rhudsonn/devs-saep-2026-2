package com.senai.makita.mappers;

import com.senai.makita.dtos.UsuarioSaidaDto;
import com.senai.makita.entitys.UsuarioEntity;


public class Usuario_Mapper {


    //Converte Entity em Dto
    public static UsuarioSaidaDto entityParaDto(UsuarioEntity usuarioEntity) {
        return new UsuarioSaidaDto(
                usuarioEntity.getNome(),
                usuarioEntity.getNivelAcesso()
        );
    }



}
