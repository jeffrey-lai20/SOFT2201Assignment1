package stickman.model;

public class EntityImpl implements Entity {
    double xPos;
    double yPos;
    double height;
    double width;
    Layer layer;
    public EntityImpl() {

    }
    @Override
    public String getImagePath() {
        return null;
    }

    @Override
    public double getXPos() {
        return 0;
    }

    @Override
    public double getYPos() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public Layer getLayer() {
        return null;
    }
}
