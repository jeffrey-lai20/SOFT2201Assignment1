package stickman.model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class GameEngineImpl implements stickman.model.GameEngine {

    private Level currentLevel;
    private Double xPos;

    public GameEngineImpl(String jsonFile) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try {
            Object arrayObj = parser.parse(new InputStreamReader(new FileInputStream(jsonFile)));
            JSONObject stickman = (JSONObject) arrayObj;
            String stickmanSize = (String) stickman.get("stickmanSize");
            JSONObject stickmanPos = (JSONObject) stickman.get("stickmanPos");
            xPos = (Double) stickmanPos.get("x");
            Double cloudVelocity = (Double) stickman.get("cloudVelocity");


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
    }

    @Override
    public Level getCurrentLevel() {
        return this.currentLevel;
    }

    @Override
    public void startLevel() {
        Level start = new LevelImpl(xPos);

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

    @Override
    public void tick() {

    }
}
