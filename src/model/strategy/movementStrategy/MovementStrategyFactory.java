package src.model.strategy.movementStrategy;


import src.shared.GameMode;

import java.util.HashMap;
import java.util.Map;

import static src.model.ModelFactory.gameMode;

/**
 * @author francoiseperrin
 *
 */
public class MovementStrategyFactory {


	/**
	 * private pour ne pas instancier d'objets
	 */
	private MovementStrategyFactory() {

	}
	private static Map<String, MovementStrategy> mapStrategy = new HashMap<String, MovementStrategy>();
	private static Map<Integer, MovementStrategy> stormStrategy = new HashMap<Integer, MovementStrategy>();

	static {	
		mapStrategy.put("Tour", TourMovementStrategy.newInstance());
		mapStrategy.put("Cavalier", CavalierMovementStrategy.newInstance());
		mapStrategy.put("Fou",  FouMovementStrategy.newInstance());
		mapStrategy.put("Reine", ReineMovementStrategy.newInstance());
		mapStrategy.put("Roi", RoiMovementStrategy.newInstance());
		mapStrategy.put("PionBlanc", PionBlancMovementStrategy.newInstance());
		mapStrategy.put("PionNoir", PionNoirMovementStrategy.newInstance());

		stormStrategy.put(0, TourMovementStrategy.newInstance());
		stormStrategy.put(1, CavalierMovementStrategy.newInstance());
		stormStrategy.put(2,  FouMovementStrategy.newInstance());
		stormStrategy.put(7, TourMovementStrategy.newInstance());
		stormStrategy.put(6, CavalierMovementStrategy.newInstance());
		stormStrategy.put(5,  FouMovementStrategy.newInstance());
	}


	public static MovementStrategy getMovementStrategy(String pieceType){
		return mapStrategy.get(pieceType);		
	}

	public static MovementStrategy getMovementStrategy(int x){
		return stormStrategy.get(x);
	}

	/**
	 * Test unitaires
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(MovementStrategyFactory.getMovementStrategy("PionNoir"));
	}

	

}