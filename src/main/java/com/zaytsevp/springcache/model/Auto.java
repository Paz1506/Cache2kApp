package com.zaytsevp.springcache.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created on 13.02.2019.
 *
 * @author Pavel Zaytsev
 */
@Data
@Builder
public class Auto {

    private String brand;

    private Category category;
}
