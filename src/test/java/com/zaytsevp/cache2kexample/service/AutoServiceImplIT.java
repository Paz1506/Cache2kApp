package com.zaytsevp.cache2kexample.service;

import com.zaytsevp.cache2kexample.model.Category;
import com.zaytsevp.cache2kexample.repository.AutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

/**
 * @author Pavel Zaytsev
 */
@SpringBootTest
@ExtendWith({SpringExtension.class})
class AutoServiceImplIT {

    @Autowired
    @Qualifier("cacheManager")
    private CacheManager cacheManager;

    @Autowired
    private AutoService autoService;

    @SpyBean
    private AutoRepository autoRepository;

    @BeforeEach
    void setUp() {
        cacheManager.getCache("autos").evict(Category.TRUCK);
    }

    @Test
    void getByCategory() throws Exception {
        // Actual
        for (int i = 0; i < 10; i++) {
            autoService.getByCategory(Category.TRUCK);
        }

        // wait expire cache
        Thread.sleep(3000);

        autoService.getByCategory(Category.TRUCK);

        // Assertion
        verify(autoRepository, times(2)).getByCategory(Category.TRUCK);
        verifyNoMoreInteractions(autoRepository);
    }
}