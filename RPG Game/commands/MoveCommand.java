package commands;

import entities.Hero;

public class MoveCommand implements Command {

    private Hero hero;
    private Hero.Direction direction;

    public MoveCommand(Hero hero, Hero.Direction direction) {
        this.hero = hero;
        this.direction = direction;
    }

    @Override
    public void undo() {
        switch (direction) {
            case E:
                hero.move(Hero.Direction.W);
                break;
            case W:
                hero.move(Hero.Direction.E);
                break;
            case N:
                hero.move(Hero.Direction.S);
                break;
            case S:
                hero.move(Hero.Direction.N);
                break;
            default:
                break;
        }
    }

    @Override
    public void execute() {

        hero.move(direction);
    }

}
