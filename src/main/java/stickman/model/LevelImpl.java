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
        entities = new ArrayList<Entity> ();
        Entity hero = new EntityImpl("Hero", heroX, floorHeight-size, size);
        entities.add(0,hero);
        if (cloud1x > width) cloud1x = -80;
        if (cloud2x > width) cloud2x = -80;
        if (cloud1x < -80) cloud1x = width;
        if (cloud2x < -80) cloud2x = width;
        cloud1x += cloudVelocity/60;
        cloud2x += cloudVelocity/60;
        if (left && entities.get(0).getXPos() <= 0 || left && entities.get(0).getXPos() == 280) {
            cloud1x += 1;
            cloud2x += 1;
        } else if (right && entities.get(0).getXPos() >= 400) {
            cloud1x -= 1;
            cloud2x -= 1;
        }
        Entity cloud = new EntityImpl("Cloud1", cloud1x, height - 200, size);
        Entity cloud2 = new EntityImpl("Cloud2", cloud2x, height - 230, size);
        if (left && entities.get(0).getXPos() > 0) {
            heroX -=1;
            if (entities.get(0).getXPos() > 279) {
                if (heroX == 279) {
                    heroX += 1;
                }
            }
        }
        if (right && entities.get(0).getXPos() < 400) {
            heroX += 1;
        }
        if (jump) {
            if (floorHeight < 300-size*1.2) {
                jump = false;
                desc = true;
            } else if (desc) {
                jump = false;
            } else {
                floorHeight -= 2;
            }
        }
        if (entities.get(0).getYPos() < 300-size && !jump) {
            floorHeight += 2;
            if (floorHeight >= 300) {
                floorHeight = 300;
                jump = false;
                desc = false;
            }
        }
        hero = new EntityImpl("Hero", heroX, floorHeight-size, size);
        entities.add(0,hero);
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
        jump = true;
        return true;
    }

    @Override
    public boolean moveLeft() {
        left = true;
        return true;
    }

    @Override
    public boolean moveRight() {
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
