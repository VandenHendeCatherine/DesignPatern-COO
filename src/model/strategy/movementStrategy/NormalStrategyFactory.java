package src.model.strategy.movementStrategy;


public class NormalStrategyFactory implements AbstractFactory{

    public MovementStrategy getMovementStrategy(String pieceType, int x){
        return MovementStrategyFactory.getMovementStrategy(pieceType);
    }


}
