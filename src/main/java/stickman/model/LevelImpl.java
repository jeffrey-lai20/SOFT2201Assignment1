package stickman.model;

import java.util.List;

public class LevelImpl implements Level {

    private double height;
    private double width;
    private double floorHeight;
    private double heroX;

    public LevelImpl (double height, double width, double floorHeight, double heroX) {
        this.height = height;
        this.width = width;
        this.floorHeight = floorHeight;
        this.heroX = heroX;
    }

    public LevelImpl (double heroX) {
        this.height = 400;
        this.width = 640;
        this.floorHeight = 0;
        this.heroX = heroX;
    }

    @Override
    public List<Entity> getEntities() {
        return null;
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
