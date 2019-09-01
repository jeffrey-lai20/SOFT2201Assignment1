package stickman.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GameEngineImpl implements stickman.model.GameEngine {

    private Level currentLevel;


    public GameEngineImpl(String jsonFile) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try {
            JSONArray array= (JSONArray) parser.parse(new FileReader(jsonFile));
//            Object arrayObj = parser.parse(new InputStreamReader(new FileInputStream(jsonFile)));
//            JSONArray array = (JSONArray) arrayObj;
            for (Object obj:array) {
                JSONObject stickman = (JSONObject) obj;
                String stickmanSize = (String) stickman.get("stickmanSize");
                double stickmanPos = (double) stickman.get("stickmanPos");
                double cloudVelocity = (double) stickman.get("cloudVelocity");

                if (!(stickmanSize.equals("tiny") || stickmanSize.equals("normal") ||
                    stickmanSize.equals("large") || stickmanSize.equals("giant"))) {
                    System.err.println("Unexpected stickman size from JSON file.");
                    System.exit(1);
                }
                if (stickmanPos < 0 || cloudVelocity < 0) {
                    System.err.println("Unexpected negative value from JSON file found.");
                    System.exit(1);
                }
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
        Level start = new LevelImpl();

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
