package com.zaytsevp.cache2kexample.api.dto;

import com.zaytsevp.cache2kexample.model.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Pavel Zaytsev
 */
@Getter
@Setter
@ApiModel("Авто")
public class AutoDto {

    @ApiModelProperty("Марка")
    private String brand;

    @ApiModelProperty("Категория")
    private Category category;
}
