package com.zaytsevp.cache2kexample.repository;

import com.zaytsevp.cache2kexample.model.Auto;
import com.zaytsevp.cache2kexample.model.Category;

import java.util.List;

/**
 * @author Pavel Zaytsev
 */
public interface AutoRepository {

    List<Auto> getByCategory(Category category);
}
