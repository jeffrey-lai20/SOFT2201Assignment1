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
        this.height = 300;
        this.width = 640;
        this.floorHeight = 300;
        this.heroX = heroX;
        this.entities = new ArrayList<Entity> ();

        Entity hero = new EntityImpl("Hero", this.heroX, this.floorHeight-35);
        entities.add(0, hero);
        Entity cloud = new EntityImpl("Cloud1", 150, this.height-200);
        Entity cloud2 = new EntityImpl("Cloud2", 470, this.height-230);
        entities.add(1, cloud);
        entities.add(2, cloud2);

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
        this.height = 300;
        this.width = 640;
        this.floorHeight = 300;
        this.heroX = heroX;
        this.entities = new ArrayList<Entity> ();

        Entity hero = new EntityImpl("Hero", this.heroX, this.floorHeight-35);
        entities.add(0, hero);
        Entity cloud = new EntityImpl("Cloud1", 150, this.height-200);
        Entity cloud2 = new EntityImpl("Cloud2", 470, this.height-230);
        entities.add(1, cloud);
        entities.add(2, cloud2);
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

        Entity hero = new EntityImpl("Hero", this.heroX, this.floorHeight-40);
        this.entities.add(0,hero);
        return true;
    }

    @Override
    public boolean moveLeft() {
        this.heroX = this.heroX - 5;
        Entity hero = new EntityImpl("Hero", this.heroX, this.floorHeight-35);
//        this.entities.get(0).setDel();
        this.entities.add(0,hero);
        return true;
    }

    @Override
    public boolean moveRight() {
        this.heroX = this.heroX + 5;
        Entity hero = new EntityImpl("Hero", this.heroX, this.floorHeight-35);
        this.entities.add(0,hero);
        return true;
    }

    @Override
    public boolean stopMoving() {

        return true;
    }
}
