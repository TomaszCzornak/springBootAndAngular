package com.example.springbootangularbook.AntiHeroH2ServiceTest;

import com.example.springbootangularbook.antiHero.entity.AntiHeroEntity;
import com.example.springbootangularbook.antiHero.repository.AntiHeroRepository;
import com.example.springbootangularbook.antiHero.service.AntiHeroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class AntiHeroH2ServiceTest {

    @Autowired
    private AntiHeroRepository repo;
    private AntiHeroService service;

    @BeforeEach
    public void setUp() {
        service = new AntiHeroService(repo);
    }

    @Test
    public void shouldFindAllHero() {
        AntiHeroEntity antiHero = new AntiHeroEntity();
        antiHero.setFirstName("Eddie");
        antiHero.setLastName("Brock");
        antiHero.setHouse("MCU");

        service.addAntiHero(antiHero);

        Iterable<AntiHeroEntity> antiHeroList = service.findAllAntiHeroes();
        AntiHeroEntity savedAntiHero = antiHeroList.iterator().next();

        assertThat(savedAntiHero).isNotNull();
    }

    @Test
    public void shouldAddAntiHero() {
        AntiHeroEntity antiHero = new AntiHeroEntity();
        antiHero.setFirstName("Eddie");
        antiHero.setLastName("Brock");
        antiHero.setHouse("MCU");

        service.addAntiHero(antiHero);

        Iterable<AntiHeroEntity> antiHeroList = service.findAllAntiHeroes();
        AntiHeroEntity savedAntiHero = antiHeroList.iterator().next();

        assertThat(antiHero).isEqualTo(savedAntiHero);
    }

    @Test
    public void shouldUpdateAntiHero() {
        AntiHeroEntity antiHero = new AntiHeroEntity();
        antiHero.setFirstName("Eddie");
        antiHero.setLastName("Brock");
        antiHero.setHouse("MCU");

        AntiHeroEntity savedAntiHero = service.addAntiHero(antiHero);

       savedAntiHero.setHouse("San Francisco");
       service.updateAntiHero(savedAntiHero.getId(),savedAntiHero);

       AntiHeroEntity foundAntiHero = service.findAntiHeroById(savedAntiHero.getId());

       assertThat(foundAntiHero.getHouse()).isEqualTo("San Francisco");

    }


}
