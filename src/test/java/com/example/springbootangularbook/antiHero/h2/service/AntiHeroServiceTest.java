package com.example.springbootangularbook.antiHero.h2.service;

import com.example.springbootangularbook.antiHero.entity.AntiHeroEntity;
import com.example.springbootangularbook.antiHero.repository.AntiHeroRepository;
import com.example.springbootangularbook.antiHero.service.AntiHeroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AntiHeroServiceTest {

    @Mock
    private AntiHeroRepository antiHeroRepository;

    @InjectMocks
    private AntiHeroService underTest;

    @Test
    void canAddAntiHero() {
        //given
        AntiHeroEntity antiHeroEntity = new AntiHeroEntity(
                UUID.randomUUID(),
                "Venom",
                "Lakandula",
                "Tondo",
                "Datu of Tondo",
                new SimpleDateFormat("dd-mm-yyyy HH:mm:ss z").format(new Date())
        );
        //when
        underTest.addAntiHero(antiHeroEntity);

        //then
        ArgumentCaptor<AntiHeroEntity> antiHeroDtoArgumentCaptor = ArgumentCaptor.forClass(AntiHeroEntity.class);

        verify(antiHeroRepository).save(antiHeroDtoArgumentCaptor.capture());
        AntiHeroEntity captureAntiHero = antiHeroDtoArgumentCaptor.getValue();

        assertThat(captureAntiHero).isEqualTo(antiHeroEntity);
    }
}
