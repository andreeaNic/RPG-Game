package strategies;

import entities.Hero;
import entities.Monster;
import entities.Treasure;
import factories.TreasureFactory;

public class DefenseStrategy implements Strategy {



    private Hero hero;

    public DefenseStrategy(Hero hero) {
        this.hero = hero;
    }

    @Override
	public void attack(Monster m) {

	    // TODO implement me

        boolean found = false;
        Treasure foundTreasure = TreasureFactory.getInstance().createTreasure();

        for (Treasure treasure : hero.getInventory()) {
            if (treasure.getDamageType().equals(hero.getDamageType())) {
                found = true;
                foundTreasure = treasure;
                break;
            }
        }

        System.out.println("HP Initial: " + hero.getHP());

        if (!found) {
            hero.setHP(hero.getHP() + hero.getBaseHpBoost());
        } else {
            hero.setHP(hero.getHP() + foundTreasure.getBoostHp() + hero.getBaseHpBoost());
        }

        System.out.println("HP Final: " + hero.getHP());

        m.setHP(m.getHP() - hero.getBaseDamage());

	    /*	Attack algorithm
			if hero type weapon found boost HP with treasure.getHpBoost() + hero.getBaseHpBoost()
				else boost HP with getBaseHpBoost()
			Do a basic attack on the monster -> hero.getBaseDamage()
			--> In order to find the weapon, iterate through the inventory of the hero.
	    */
	}

}
