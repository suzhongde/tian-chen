package com.suzhongde.tianchen.service.impl;

import com.suzhongde.tianchen.dto.BaseDto;
import com.suzhongde.tianchen.entity.TraceableBaseEntity;

abstract class TraceableGeneralServiceImpl<Entity extends TraceableBaseEntity, Dto extends BaseDto> extends GeneralServiceImpl<Entity, Dto> {
    @Override
    public Dto create(Dto dto) {
        Entity entity = getMapper().toEntity(dto);
        entity.setCreatedBy(getCurrentUserEntity());
        entity.setUpdatedBy(getCurrentUserEntity());
        return getMapper().toDto(getRepository().save(entity));
    }

    @Override
    public Dto update(String id, Dto dto) {
        Entity existedEntity = getEntity(id);
        Entity entity = getMapper().updateEntity(existedEntity, dto);
        entity.setUpdatedBy(getCurrentUserEntity());
        Entity updatedEntity = getRepository().save(entity);
        return getMapper().toDto(updatedEntity);
    }
}