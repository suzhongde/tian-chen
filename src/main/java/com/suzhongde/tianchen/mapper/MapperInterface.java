package com.suzhongde.tianchen.mapper;

import com.suzhongde.tianchen.dto.BaseDto;
import com.suzhongde.tianchen.entity.BaseEntity;
import org.mapstruct.MappingTarget;

public interface MapperInterface<Entity extends BaseEntity, Dto extends BaseDto> {
    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    Entity updateEntity(@MappingTarget Entity entity, Dto dto);
}