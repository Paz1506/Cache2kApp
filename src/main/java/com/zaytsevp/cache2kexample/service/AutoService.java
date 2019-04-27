package com.zaytsevp.cache2kexample.service;

import com.zaytsevp.cache2kexample.model.Auto;
import com.zaytsevp.cache2kexample.model.Category;

import java.util.List;

/**
 * @author Pavel Zaytsev
 */
public interface AutoService {

    List<Auto> getByCategory(Category category);
}
