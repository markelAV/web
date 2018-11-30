package app.dao;

import app.entities.Hero;

import java.util.List;

public interface HeroDao {
    int addHero(Hero hero);
    int updateHero(Hero hero);
    void removeHero(int id);
    Hero getHeroById(int id);
    public List<Hero> getAllHeroes();

}
