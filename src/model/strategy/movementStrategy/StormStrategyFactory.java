package src.model.strategy.movementStrategy;

import java.util.HashMap;
import java.util.Map;

public class StormStrategyFactory implements AbstractFactory{

    private static Map<Integer, String> stormStrategy = new HashMap<Integer, String>();

    static {
        stormStrategy.put(0, "Tour");
        stormStrategy.put(1,"Cavalier");
        stormStrategy.put(2,  "Fou");
        stormStrategy.put(7, "Tour");
        stormStrategy.put(6, "Cavalier");
        stormStrategy.put(5,  "Fou");
    }

    public MovementStrategy getMovementStrategy(String pieceType, int x){
        if(x == 4 || x==3){
            return MovementStrategyFactory.getMovementStrategy(pieceType);
        }else{
            return  MovementStrategyFactory.getMovementStrategy(stormStrategy.get(x));
        }
    }


}
