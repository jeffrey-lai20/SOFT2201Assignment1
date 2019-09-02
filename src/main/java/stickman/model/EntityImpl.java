package stickman.model;

public class EntityImpl implements Entity {
    double xPos;
    double yPos;
    double height;
    double width;
    Layer layer;

    public EntityImpl() {
        this.xPos = 0;
        this.yPos = 0;
        this.height = 0;
        this.width = 0;
    }
    @Override
    public String getImagePath() {
        return "file:resources/ch_stand1.png";
    }

    @Override
    public double getXPos() {
        return this.xPos;
    }

    @Override
    public double getYPos() {
        return this.yPos;
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
    public Layer getLayer() {
        this.layer = Layer.FOREGROUND;
        return this.layer;
    }
}
