package stickman.model;

public class EntityImpl implements Entity {
    String entityName;
    boolean del = false;
    double xPos;
    double yPos;
    double height;
    double width;
    Layer layer;


    public EntityImpl (String entityName, double xPos, double yPos) {
        this.entityName = entityName;
        this.xPos = xPos;
        this.yPos = yPos;
        if (entityName.equals("Hero")) {
            this.height = 35;
            this.width = 0;
        } else if (entityName.contains("Cloud")) {
            this.height = 0;
            this.width = 0;
        }
    }
    @Override
    public String getImagePath() {
         if (entityName.equals("Hero") ) {
             return "ch_stand1.png";
         } else if (entityName.equals("Cloud1")) {
             return "cloud_1.png";
         } else if (entityName.equals("Cloud2")) {
             return "cloud_2.png";
         }
        return null;

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
