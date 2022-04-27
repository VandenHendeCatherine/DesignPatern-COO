package src.model.strategy.movementStrategy;

import src.shared.ActionType;

public class CavalierMovementStrategy implements MovementStrategy{
    private static CavalierMovementStrategy instance;
    public static MovementStrategy newInstance() {
        if(instance == null){
            instance = new CavalierMovementStrategy();
        }
        return instance;
    }

    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean hasMoved, ActionType actionType) {
        boolean ret = false;
            if ((Math.abs(xFinal - xInit) + Math.abs(yFinal - yInit)) == 3) {

                if ((Math.abs(xFinal - xInit) < 3) && (Math.abs(yFinal - yInit) < 3)) {
                    ret = true;
                }
            }

        return ret;
    }
}
