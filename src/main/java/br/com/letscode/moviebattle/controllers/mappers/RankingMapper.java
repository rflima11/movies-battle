package br.com.letscode.moviebattle.controllers.mappers;

import br.com.letscode.moviebattle.entities.Usuario;
import br.com.letscode.moviebattle.openapi.model.PosicaoRanking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RankingMapper {

    RankingMapper INSTANCE = Mappers.getMapper(RankingMapper.class);

    @Mapping(source = "melhorScore", target = "pontuacao")
    PosicaoRanking map(Usuario usuario);

    Usuario map(PosicaoRanking posicaoRanking);

    List<PosicaoRanking> map(List<Usuario> usuarios);

}
