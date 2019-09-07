package stickman.model;

import com.sun.scenario.effect.impl.hw.ShaderSource;

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
    private double size;
    private boolean desc;



    public LevelImpl (double heroX, double cloudVelocity, String stickmanSize) {

        if (stickmanSize.equalsIgnoreCase("tiny")) {
            size = 20;
        } else if (stickmanSize.equalsIgnoreCase("normal")) {
            size = 35;
        } else if (stickmanSize.equalsIgnoreCase("large")) {
            size = 50;
        } else if (stickmanSize.equalsIgnoreCase("giant")) {
            size = 70;
        } else {
            System.err.println("Incorrect stickman size input from JSON File.");
            System.exit(1);
        }
        this.height = 300;
        this.width = 640;
        this.floorHeight = 300;
        this.heroX = heroX;
        this.cloudVelocity = cloudVelocity;
        this.entities = new ArrayList<Entity> ();

        this.cloud1x = 150;
        this.cloud2x = 500;

        Entity hero = new EntityImpl("Hero", this.heroX, this.floorHeight-size, size);
        entities.add(0, hero);
        Entity cloud = new EntityImpl("Cloud1", cloud1x, this.height-200, size);
        Entity cloud2 = new EntityImpl("Cloud2", cloud2x, this.height-230, size);
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
        Entity hero = new EntityImpl("Hero", this.heroX, this.floorHeight-size, size);
        this.entities.add(0,hero);
        if (cloud1x > width) this.cloud1x = -80;
        if (cloud2x > width) this.cloud2x = -80;
        if (cloud1x < -80) this.cloud1x = width;
        if (cloud2x < -80) this.cloud2x = width;
        cloud1x += cloudVelocity/60;
        cloud2x += cloudVelocity/60;
        if (left && entities.get(0).getXPos() <= 0 || left && entities.get(0).getXPos() == 280) {
//            this.cloudVelocity -= 2;

            cloud1x += 1;
            cloud2x += 1;
        } else if (right && entities.get(0).getXPos() >= 400) {
//            this.cloudVelocity += 2;
            cloud1x -= 1;
            cloud2x -= 1;
        }
        Entity cloud = new EntityImpl("Cloud1", this.cloud1x, this.height - 200, size);
        Entity cloud2 = new EntityImpl("Cloud2", this.cloud2x, this.height - 230, size);
        if (left && entities.get(0).getXPos() > 0) {
            this.heroX -=1;
            if (this.entities.get(0).getXPos() > 279) {
                if (this.heroX == 279) {

                    this.heroX += 1;
                }
            }

        }
        if (right && entities.get(0).getXPos() < 400) {
            this.heroX += 1;
        }
        if (jump) {
            if (this.floorHeight < 300-size*1.2) {
                this.jump = false;
                this.desc = true;
            } else if (desc) {
                this.jump = false;
            } else {
                this.floorHeight -= 2;
            }
        }
        entities.add(1, cloud);
        entities.add(2, cloud2);
        if (entities.get(0).getYPos() < 300-size && !jump) {
            this.floorHeight += 2;
            if (this.floorHeight >= 300) {
                this.floorHeight = 300;
                this.jump = false;
                this.desc = false;
            }
        }
        hero = new EntityImpl("Hero", this.heroX, this.floorHeight-size, size);
        this.entities.add(0,hero);

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
//        if (entities.get(0).getYPos() == this.floorHeight-entities.get(0).getHeight()) {
//            jump = false;
//            return true;
//        }
        this.jump = true;


        return true;
    }

    @Override
    public boolean moveLeft() {
//        if (entities.get(0).getXPos() <= 0) {

//            left = false;
//            return true;
//        }
        this.left = true;
        return true;
    }

    @Override
    public boolean moveRight() {
//        if (entities.get(0).getXPos() >= 640) {

//            right = false;
//            return true;
//        }
//        this.heroX = this.heroX + 5;
//        Entity hero = new EntityImpl("Hero", this.heroX, this.floorHeight-35);
//        this.entities.add(0,hero);
        this.right = true;
        return true;
    }

    @Override
    public boolean stopMoving() {
        this.left = false;
        this.right = false;
        return true;

    }
}
