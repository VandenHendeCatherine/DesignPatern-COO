package src.model.strategy.movementStrategy;

import src.shared.ActionType;

public class FouMovementStrategy implements MovementStrategy{
    private static FouMovementStrategy instance ;
    public static MovementStrategy newInstance() {
        if(instance==null){
            instance = new FouMovementStrategy();
        }
        return instance;
    }

    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean hasMoved, ActionType actionType) {
        return Math.abs(yFinal - yInit) == Math.abs(xFinal - xInit);
    }
}
