package src.model.strategy.movementStrategy;

import src.shared.ActionType;

public class PionBlancMovementStrategy implements MovementStrategy{
    private static PionBlancMovementStrategy instance ;
    public static MovementStrategy newInstance() {
        if(instance == null){
            instance = new PionBlancMovementStrategy();
        }
        return instance;
    }

    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean hasMoved, ActionType actionType) {
        boolean ret = false;

        // Déplacement d'1 case en diagonale avec prise
        if (actionType == ActionType.TAKE) {
            if ((yFinal == yInit-1 && xFinal == xInit+1)
                    || (yFinal == yInit-1 && xFinal == xInit-1)) {
                ret = true;
            }

        }
        // Déplacement vertical sans prise
        // d'1 case si le pion a déjà bougé, de 2 cases sinon
        // vers le haut ou vers le bas selon sa couleur
        else {
            if ((xFinal == xInit)
                    && (Math.abs(yFinal - yInit) <= 1 ||
                    (Math.abs(yFinal - yInit) <= 2 && !hasMoved))) {

                if (yFinal - yInit < 0) {
                    ret = true;
                }

            }
        }
        return ret;
    }
}