package src.model.noStrategy.pieces;

import java.util.Collections;
import java.util.List;

import src.shared.ActionType;
import src.shared.ModelCoord;
import src.shared.PieceSquareColor;


/**
 * @author francoise.perrin - Alain BECKER
 * * Inspiration Jacques SARAYDARYAN, Adrien GUENARD
 */
public class Roi extends AbstractPiece {
	
	//private boolean isCastling;
	
	/**
	 * @param pieceSquareColor
	 * @param coord
	 */
	public Roi( PieceSquareColor pieceSquareColor, ModelCoord coord) {
		super(pieceSquareColor, coord);
		
	//	this.isCastling = false;
	}
	@Override
	public ModelCoord getCoord() {
		return getCoord();
	}

	@Override
	public PieceSquareColor getCouleur() {
		return getCouleur();
	}
	
	@Override
	public List<ModelCoord> getMoveItinerary(ModelCoord finalCoord) {
		List<ModelCoord> ret = Collections.emptyList(); 

		// on vérifie que les coordonnées finales sont compatibles 
		//avec l'algo de déplacement  dans le cas du roque
		if (this.isAlgoMoveOk(finalCoord, null)) {
			// ToDo
		}
		return ret;
	}
	
}
