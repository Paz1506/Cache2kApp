package com.zaytsevp.cache2kexample.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author Pavel Zaytsev
 */
@Data
@Builder
@ToString
public class Auto {

    private String brand;

    private Category category;
}
