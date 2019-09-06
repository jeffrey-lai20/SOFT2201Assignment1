package stickman.model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class GameEngineImpl implements GameEngine {

    private Level currentLevel;
    private Double xPos;
    private Double cloudVelocity;

    public GameEngineImpl(String jsonFile) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try {
            Object arrayObj = parser.parse(new InputStreamReader(new FileInputStream(jsonFile)));
            JSONObject stickman = (JSONObject) arrayObj;
            String stickmanSize = (String) stickman.get("stickmanSize");
            JSONObject stickmanPos = (JSONObject) stickman.get("stickmanPos");
            this.xPos = (Double) stickmanPos.get("x");
            this.cloudVelocity = (Double) stickman.get("cloudVelocity");


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
        }
        startLevel();
    }

    @Override
    public Level getCurrentLevel() {
        return this.currentLevel;
    }

    @Override
    public void startLevel() {
        this.currentLevel = new LevelImpl(xPos, cloudVelocity);
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
