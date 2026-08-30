package com.senai.makita.Sessao;

import com.senai.makita.entitys.NivelAcesso;

public record SessaoDto(

        Long usuarioId,
        String nome,
        NivelAcesso nivelAcesso

) {}
