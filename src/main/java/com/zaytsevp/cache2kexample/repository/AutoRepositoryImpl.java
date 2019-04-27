package com.zaytsevp.cache2kexample.repository;

import com.google.common.collect.Lists;
import com.zaytsevp.cache2kexample.model.Auto;
import com.zaytsevp.cache2kexample.model.Category;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pavel Zaytsev
 */
@Repository
public class AutoRepositoryImpl implements AutoRepository {

    @Override
    public List<Auto> getByCategory(Category category) {
        simulateSlowService();

        return generateRandomAuto().stream()
                                   .filter(auto -> auto.getCategory().equals(category))
                                   .collect(Collectors.toList());
    }

    /** It's bad, need only for example */
    private void simulateSlowService() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    /** generate random autos */
    private List<Auto> generateRandomAuto() {
        List<Auto> autos = Lists.newArrayList();

        for (Category category : Category.values()) {
            for (int i = 0; i < 10; i++) {
                autos.add(Auto.builder()
                              .brand("Auto_" + RandomString.make())
                              .category(category)
                              .build());
            }
        }

        return autos;
    }
}
