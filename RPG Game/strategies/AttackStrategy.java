package strategies;

import entities.Hero;
import entities.Monster;
import entities.Treasure;
import factories.TreasureFactory;

public class AttackStrategy implements Strategy {



    private Hero hero;

    public AttackStrategy(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void attack(Monster m) {



        int multiplier = 1;
        Treasure foundTreasure = TreasureFactory.getInstance().createTreasure();

        for (Treasure treasure : hero.getInventory()) {
            if (treasure.getDamageType().equals(hero.getDamageType())) {
                multiplier = 3;
                foundTreasure = treasure;
                break;
            }
        }

        if (multiplier == 1) {
            for (Treasure treasure : hero.getInventory()) {
                if (treasure.getDamageType().equals(m.getWeakness())) {
                    multiplier = 2;
                    foundTreasure = treasure;
                    break;
                }
            }
        }

        if (multiplier == 1) {
            m.setHP(m.getHP() - hero.getBaseDamage());
        } else {
            m.setHP(m.getHP() - multiplier * foundTreasure.getDmg());
        }

	    /*	Attack algorithm
			if hero type weapon found use it (x3 weapon damage)
				else if counter weapon found use it (x2 weapon damage)
				else basic attack (no bonus)
			--> In order to find the weapon, iterate through the inventory of the hero.
	    */
    }

}
