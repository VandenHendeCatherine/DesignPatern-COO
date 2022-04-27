package src.model.strategy.movementStrategy;

public interface AbstractFactory {

    MovementStrategy getMovementStrategy(String pieceType, int x);
}
