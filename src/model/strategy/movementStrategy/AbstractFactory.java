package src.model.strategy.movementStrategy;

public interface AbstractFactory {

    public abstract MovementStrategy getMovementStrategy(String pieceType, int x);
}
