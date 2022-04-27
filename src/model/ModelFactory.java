package src.model;

import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import src.model.noStrategy.pieces.ChessPieceModel;
import src.model.noStrategy.pieces.PieceModelFactory;
import src.model.strategy.movementStrategy.AbstractFactory;
import src.model.strategy.movementStrategy.NormalStrategyFactory;
import src.model.strategy.movementStrategy.StormStrategyFactory;
import src.shared.GameMode;
import src.shared.ModelCoord;
import src.shared.PieceSquareColor;

public class ModelFactory {

	public static ObjectProperty<PieceSquareColor> beginColor = new SimpleObjectProperty<PieceSquareColor>(PieceSquareColor.WHITE);
	public static IntegerProperty nbLigne = new SimpleIntegerProperty(8);
	public static IntegerProperty nbColonne = new SimpleIntegerProperty(8);
	public static ObjectProperty<GameMode> gameMode = new SimpleObjectProperty<GameMode>(GameMode.NORMAL);
	public static NormalStrategyFactory normalStrategyFactory = new NormalStrategyFactory();
	public static StormStrategyFactory stormStrategyFactory = new StormStrategyFactory();

	public final static ObjectProperty<GameMode> gameModeProperty() {		
		return gameMode;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	//
	// fabriques des pièces
	//
	///////////////////////////////////////////////////////////////////////////////////////

	public static List<ChessPieceModel> createPieceModelList() {

		return PieceModelFactory.createPieceModelList();
	}

	public static ChessPieceModel createPiece(PieceSquareColor pieceCouleur, String type, ModelCoord pieceModelCoord){
		return PieceModelFactory.createPiece(pieceCouleur, type, pieceModelCoord);
	}

	
	//////////////////////////////////////////////////////////////////////////////////////
	//
	// Controle des coordonnées
	//
	///////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @return true si les coordonnées passées en paramètre sont dans les limites du
	 *         plateau
	 */
	public static boolean coordonnees_valides(ModelCoord coord) {
		boolean ret = false;
		if (coord != null) {
			int x = coord.getCol() - 'a';
			int y = 8 - coord.getLigne();
			ret = (x <= nbColonne.get() - 1) && (x >= 0) && (y <= nbLigne.get()) && (y >= 0);
		}
		return ret;
	}

	public static AbstractFactory getFactory() {
		if(gameMode.get().equals(GameMode.STORM)){
			return stormStrategyFactory;
		}
		return normalStrategyFactory;
	}

}
