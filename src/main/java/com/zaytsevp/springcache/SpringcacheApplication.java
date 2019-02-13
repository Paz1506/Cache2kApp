package com.zaytsevp.springcache;

import com.zaytsevp.springcache.model.Category;
import com.zaytsevp.springcache.repository.AutoRepository;
import com.zaytsevp.springcache.repository.AutoRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Example: https://spring.io/guides/gs/caching/
 */
@EnableCaching
@Configuration
@EnableAutoConfiguration
public class SpringcacheApplication {

    @Slf4j
    @Configuration
    static class Runner implements CommandLineRunner {

        @Autowired
        private AutoRepository autoRepository;

        @Override
        public void run(String... args) throws Exception {
            log.info("Fetching autos ...");

            log.info("Category ligthweight -->" + autoRepository.getByCategory(Category.LIGHTWEIGHT));
            log.info("Category universal -->" + autoRepository.getByCategory(Category.UNIVERSAL));
            log.info("Category truck -->" + autoRepository.getByCategory(Category.TRUCK));

            log.info("Category ligthweight -->" + autoRepository.getByCategory(Category.LIGHTWEIGHT));
            log.info("Category universal -->" + autoRepository.getByCategory(Category.UNIVERSAL));
            log.info("Category truck -->" + autoRepository.getByCategory(Category.TRUCK));

            log.info("Category ligthweight -->" + autoRepository.getByCategory(Category.LIGHTWEIGHT));
            log.info("Category universal -->" + autoRepository.getByCategory(Category.UNIVERSAL));
            log.info("Category truck -->" + autoRepository.getByCategory(Category.TRUCK));
        }
    }

    @Bean
    public AutoRepository autoRepository() {
        return new AutoRepositoryImpl();
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("autos");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringcacheApplication.class, args);
    }

}

