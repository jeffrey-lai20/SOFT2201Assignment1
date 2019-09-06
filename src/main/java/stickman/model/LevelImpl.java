package stickman.model;

import java.util.List;
import java.util.ArrayList;

public class LevelImpl implements Level {

    private double height;
    private double width;
    private double floorHeight;
    private double heroX;
    private double cloudVelocity;
    private List<Entity> entities;

    private double cloud1x;
    private double cloud2x;
    private boolean left;
    private boolean right;
    private boolean jump;


    public LevelImpl (double heroX, double cloudVelocity) {
        this.height = 300;
        this.width = 640;
        this.floorHeight = 300;
        this.heroX = heroX;
        this.cloudVelocity = cloudVelocity;
        this.entities = new ArrayList<Entity> ();

        this.cloud1x = 150;
        this.cloud2x = 400;

        Entity hero = new EntityImpl("Hero", this.heroX, this.floorHeight-35);
        entities.add(0, hero);
        Entity cloud = new EntityImpl("Cloud1", cloud1x, this.height-200);
        Entity cloud2 = new EntityImpl("Cloud2", cloud2x, this.height-230);
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
        this.entities = new ArrayList<Entity> ();
        Entity hero = new EntityImpl("Hero", this.heroX, this.floorHeight-35);
        if (cloud1x > width) this.cloud1x = 0;
        if (cloud2x > width) this.cloud2x = 0;
        cloud1x += cloudVelocity;
        cloud2x += cloudVelocity;
        Entity cloud = new EntityImpl("Cloud1", this.cloud1x, this.height - 200);
        Entity cloud2 = new EntityImpl("Cloud2", this.cloud2x, this.height - 230);
        this.entities.add(0,hero);
        if (left) {
            this.heroX -=2;
        }
        if (right) {
            this.heroX += 2;
        }
        if (jump) {
            this.floorHeight -= 2;
            if (this.floorHeight < 250) this.jump = false;
        }
        hero = new EntityImpl("Hero", this.heroX, this.floorHeight-35);
        this.entities.add(0,hero);
        entities.add(1, cloud);
        entities.add(2, cloud2);
//        System.out.println(entities.get(0).getYPos()+" "+jump);
        if (entities.get(0).getYPos() < 265 && !jump) {
            this.floorHeight += 2;
            hero = new EntityImpl("Hero", this.heroX, this.floorHeight-35);
            this.entities.add(0,hero);
        } else if (entities.get(0).getYPos() > 265){
            this.floorHeight = 300;
            hero = new EntityImpl("Hero", this.heroX, this.floorHeight-35);
            this.entities.add(0,hero);
        }
    }

    @Override
    public double getFloorHeight() {
        return this.floorHeight;
    }

    @Override
    public double getHeroX() {
//        System.out.println(this.heroX);
        return this.heroX;
    }

    @Override
    public boolean jump() {

//        Entity hero = new EntityImpl("Hero", this.heroX, this.floorHeight-40);
//        this.entities.add(0,hero);
        jump = true;
        return true;
    }

    @Override
    public boolean moveLeft() {
//        this.heroX = this.heroX - 5;
//        Entity hero = new EntityImpl("Hero", this.heroX, this.floorHeight-35);
//        this.entities.add(0,hero);
        left = true;
        return true;
    }

    @Override
    public boolean moveRight() {
//        this.heroX = this.heroX + 5;
//        Entity hero = new EntityImpl("Hero", this.heroX, this.floorHeight-35);
//        this.entities.add(0,hero);
        right = true;
        return true;
    }

    @Override
    public boolean stopMoving() {
        left = false;
        right = false;
        return true;

    }
}
