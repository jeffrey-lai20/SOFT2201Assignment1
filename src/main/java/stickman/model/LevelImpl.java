package stickman.model;

import java.util.List;
import java.util.ArrayList;

public class LevelImpl implements Level {

    private double height;
    private double width;
    private double floorHeight;
    private double heroX;
    private List<Entity> entities;

    public LevelImpl (double height, double width, double floorHeight, double heroX) {
        this.height = height;
        this.width = width;
        this.floorHeight = floorHeight;
        this.heroX = heroX;
    }

    public LevelImpl (double heroX) {
        this.height = 400;
        this.width = 640;
        this.floorHeight = 250;
        this.heroX = heroX;
        List<Entity> ent = new ArrayList<Entity> ();
        Entity hero = new EntityImpl();
        ent.add(hero);
        this.entities = ent;
    }

    @Override
    public List<Entity> getEntities() {
        return this.entities;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public void tick() {
        //This is the way the view tells te model to update - it is the trigger that is sent to the model
        //each frame. The level should react to this event.
    }

    @Override
    public double getFloorHeight() {
        return this.floorHeight;
    }

    @Override
    public double getHeroX() {
        return this.heroX;
    }

    @Override
    public boolean jump() {
        return false;
    }

    @Override
    public boolean moveLeft() {
        return false;
    }

    @Override
    public boolean moveRight() {
        return false;
    }

    @Override
    public boolean stopMoving() {
        return false;
    }
}
