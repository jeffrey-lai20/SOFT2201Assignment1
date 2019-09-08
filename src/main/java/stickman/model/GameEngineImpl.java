package stickman.model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;

/**
 * GameEngineImpl implements the interface GameEngine.
 * It provides the core functionality for the game and initialises it.
 * Functionality includes movement of the hero and updating the frame
 * of the game. The game is initalised with input of a JSON file.
 */
public class GameEngineImpl implements GameEngine {
    private Level currentLevel;
    private double xPos;
    private double cloudVelocity;
    private String stickmanSize;

    /**
     * Constructor to initialise the game, taking in the JSON filename
     * as a String parameter. Reads the variable information from the
     * JSON file and starts the level with appropriate values.
     * @param jsonFile
     */
    public GameEngineImpl(String jsonFile) {
        JSONParser parser = new JSONParser();
        try {
            Object arrayObj = parser.parse(new InputStreamReader(new FileInputStream(jsonFile)));
            JSONObject stickman = (JSONObject) arrayObj;
            this.stickmanSize = (String) stickman.get("stickmanSize");
            JSONObject stickmanPos = (JSONObject) stickman.get("stickmanPos");
            this.xPos = (double) stickmanPos.get("x");
            this.cloudVelocity = (double) stickman.get("cloudVelocity");

            if (!(stickmanSize.equals("tiny") || stickmanSize.equals("normal") ||
                stickmanSize.equals("large") || stickmanSize.equals("giant"))) {
                System.err.println("Unexpected stickman size from JSON file.");
                System.exit(1);
            }

            if (xPos < 0 || cloudVelocity < 0) {
                System.err.println("Unexpected negative value from JSON file found.");
                System.exit(1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        startLevel();
    }

    @Override
    public Level getCurrentLevel() {
        return this.currentLevel;
    }

    @Override
    public void startLevel() {
        this.currentLevel = new LevelImpl(xPos, cloudVelocity, stickmanSize);
    }

    @Override
    public boolean jump() {
        this.currentLevel.jump();
        return true;
    }

    @Override
    public boolean moveLeft() {
        this.currentLevel.moveLeft();
        return true;
    }

    @Override
    public boolean moveRight() {
        this.currentLevel.moveRight();
        return true;
    }

    @Override
    public boolean stopMoving() {
        this.currentLevel.stopMoving();
        return true;
    }

    @Override
    public void tick() {
    this.currentLevel.tick();
    }
}
