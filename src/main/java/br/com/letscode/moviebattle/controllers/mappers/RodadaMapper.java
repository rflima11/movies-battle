package br.com.letscode.moviebattle.controllers.mappers;

import br.com.letscode.moviebattle.entities.Rodada;
import br.com.letscode.moviebattle.utils.ConstantesUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RodadaMapper {

    RodadaMapper INSTANCE = Mappers.getMapper(RodadaMapper.class);

    Rodada map(br.com.letscode.moviebattle.openapi.model.Rodada openApiModel);

    br.com.letscode.moviebattle.openapi.model.Rodada map(Rodada entity);

    @AfterMapping
    default void setMessage(@MappingTarget br.com.letscode.moviebattle.openapi.model.Rodada openApiModel, Rodada rodada) {
        openApiModel.setMessage(ConstantesUtils.getMensagemRodada(rodada.getUsuario()));
    }
}
