package com.zaytsevp.springcache.repository;

import com.zaytsevp.springcache.model.Auto;
import com.zaytsevp.springcache.model.Category;

/**
 * Created on 13.02.2019.
 *
 * @author Pavel Zaytsev
 */
public interface AutoRepository {

    Auto getByCategory(Category category);
}
