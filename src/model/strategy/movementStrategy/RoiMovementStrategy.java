package src.model.strategy.movementStrategy;

import src.shared.ActionType;

public class RoiMovementStrategy implements MovementStrategy{
    private static RoiMovementStrategy instance;
    public static MovementStrategy newInstance() {
        if(instance == null){
            instance = new RoiMovementStrategy();
        }
            return instance;
    }

    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean hasMoved, ActionType actionType) {
       boolean ret = false;
        // cas général
        if ((Math.abs(yFinal - yInit) <= 1)
                && (Math.abs(xFinal - xInit) <= 1)) {
            ret = true;
        }

        // Cas du roque
        // TODO : implémenter
        return ret;
    }
}