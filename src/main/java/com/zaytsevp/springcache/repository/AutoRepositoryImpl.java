package com.zaytsevp.springcache.repository;

import com.zaytsevp.springcache.model.Auto;
import com.zaytsevp.springcache.model.Category;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created on 13.02.2019.
 *
 * @author Pavel Zaytsev
 */
public class AutoRepositoryImpl implements AutoRepository {

    @Override
    @Cacheable("autos")
    public Auto getByCategory(Category category) {
        simulateSlowService();
        return Auto.builder()
                   .brand("Test" + category.name() + "Brand")
                   .category(category)
                   .build();
    }

    // It's bad, need only for example
    private void simulateSlowService() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
