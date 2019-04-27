package com.zaytsevp.cache2kexample.api.mapper;

import com.zaytsevp.cache2kexample.api.dto.AutoDto;
import com.zaytsevp.cache2kexample.model.Auto;
import org.mapstruct.Mapper;

/**
 * @author Pavel Zaytsev
 */
@Mapper
public interface AutoMapper {
    AutoDto toDto(Auto auto);
}
