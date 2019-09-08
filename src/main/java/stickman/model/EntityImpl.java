package stickman.model;

/**
 * EntityImpl implements the interface Entity. It provides information for
 * an entity. These entities can be a hero or a cloud. Details about its
 * coordinates and size are stored. The visual depiction is also handled
 * where the appropriate image is set to an entity.
 */
public class EntityImpl implements Entity {
    private String entityName;
    private double xPos;
    private double yPos;
    private double height;
    private double width;
    private Layer layer;

    /**
     * Constructor to set initial coordinates and size of the entity.
     * @param entityName
     * @param xPos
     * @param yPos
     * @param size
     */
    public EntityImpl (String entityName, double xPos, double yPos, double size) {
        this.entityName = entityName;
        this.xPos = xPos;
        this.yPos = yPos;
        if (entityName.equals("Hero")) {
            this.height = size;
            this.width = size;
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
