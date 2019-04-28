package com.zaytsevp.cache2kexample.api;

import com.zaytsevp.cache2kexample.api.dto.AutoDto;
import com.zaytsevp.cache2kexample.api.mapper.AutoMapper;
import com.zaytsevp.cache2kexample.model.Auto;
import com.zaytsevp.cache2kexample.model.Category;
import com.zaytsevp.cache2kexample.service.AutoService;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Pavel Zaytsev
 */
class AutoControllerTest {

    private AutoService autoService = mock(AutoService.class);

    private AutoMapper autoMapper = mock(AutoMapper.class);

    private AutoController autoController = new AutoController(autoService, autoMapper);

    @Test
    void getListByCategory() throws Exception {
        // Prepare
        Auto auto = mock(Auto.class);
        AutoDto autoDto = mock(AutoDto.class);
        List<Auto> autos = Lists.newArrayList(auto);
        when(autoService.getByCategory(any(Category.class))).thenReturn(autos);
        when(autoMapper.toDto(any(Auto.class))).thenReturn(autoDto);

        // Actual
        List<AutoDto> actualResult = autoController.getListByCategory(Category.TRUCK);

        // Assertion
        Assertions.assertThat(actualResult).containsOnly(autoDto);

        verify(autoService).getByCategory(Category.TRUCK);
        verify(autoMapper).toDto(auto);
        verifyNoMoreInteractions(autoService);
        verifyNoMoreInteractions(autoMapper);

    }

}