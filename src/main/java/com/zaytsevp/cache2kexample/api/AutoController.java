package com.zaytsevp.cache2kexample.api;

import com.zaytsevp.cache2kexample.api.dto.AutoDto;
import com.zaytsevp.cache2kexample.api.mapper.AutoMapper;
import com.zaytsevp.cache2kexample.aspect.TraceExecutionTime;
import com.zaytsevp.cache2kexample.model.Category;
import com.zaytsevp.cache2kexample.service.AutoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pavel Zaytsev
 */
@RestController
@RequestMapping("autos")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AutoController {

    private final AutoService autoService;

    private final AutoMapper autoMapper;

    @ApiOperation("Получить список авто по категории")
    @GetMapping("/list")
    @TraceExecutionTime
    public List<AutoDto> getListByCategory(@RequestParam Category category) {
        return autoService.getByCategory(category)
                          .stream()
                          .map(autoMapper::toDto)
                          .collect(Collectors.toList());
    }
}
