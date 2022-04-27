package src.model.strategy.movementStrategy;

import src.shared.ActionType;

public class ReineMovementStrategy implements MovementStrategy{
    private static ReineMovementStrategy instance;
    public static MovementStrategy newInstance() {
        if(instance == null){
            instance = new ReineMovementStrategy();
        }
        return instance;
    }

    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean hasMoved, ActionType actionType) {
        return isAlgoDiagOk(xInit, yInit, xFinal, yFinal) || isAlgoLigneOk(xInit, yInit, xFinal, yFinal);
    }

    private boolean isAlgoDiagOk(int xInit, int yInit,int xFinal, int yFinal) {

        return Math.abs(yFinal - yInit) == Math.abs(xFinal - xInit);
    }

    private boolean isAlgoLigneOk(int xInit, int yInit,int xFinal, int yFinal) {

        return (yFinal == yInit) || (xFinal == xInit);
    }
}