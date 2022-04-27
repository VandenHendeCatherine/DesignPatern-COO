package src.model.strategy.movementStrategy;

import src.shared.ActionType;

public class TourMovementStrategy implements MovementStrategy{
    private static TourMovementStrategy instance;
    public static MovementStrategy newInstance() {
        if(instance == null){
            instance = new TourMovementStrategy();
        }
        return instance;
    }

    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean hasMoved, ActionType actionType) {
        return (yFinal == yInit) || (xFinal == xInit);
    }
}
