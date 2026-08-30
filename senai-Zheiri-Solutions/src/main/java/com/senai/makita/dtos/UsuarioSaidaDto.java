package com.senai.makita.dtos;

import com.senai.makita.entitys.NivelAcesso;

public record UsuarioSaidaDto(

        String nome,
        NivelAcesso nivelAcesso
) {
}
