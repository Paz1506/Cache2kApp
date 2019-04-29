package com.zaytsevp.cache2kexample.service;

import com.zaytsevp.cache2kexample.model.Auto;
import com.zaytsevp.cache2kexample.model.Category;
import com.zaytsevp.cache2kexample.repository.AutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pavel Zaytsev
 */
@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {

    private final AutoRepository autoRepository;

    @Override
    @Cacheable(cacheManager = "cacheManager", cacheNames = "autos", key = "#category", unless = "#result == null || #result.size() == 0")
    public List<Auto> getByCategory(Category category) {
        if (category == null) throw new IllegalArgumentException("Null category!");

        return autoRepository.getByCategory(category);
    }
}
