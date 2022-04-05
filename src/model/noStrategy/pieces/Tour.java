package src.model.noStrategy.pieces;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import src.shared.ActionType;
import src.shared.ModelCoord;
import src.shared.PieceSquareColor;

/**
 * @author francoise.perrin - Alain BECKER
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 */
public class Tour extends AbstractPiece {
	/**
	 * @param pieceSquareColor
	 * @param coord
	 */
	public Tour(PieceSquareColor pieceSquareColor, ModelCoord coord) {
		super(pieceSquareColor, coord);
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
	public boolean isAlgoMoveOk(ModelCoord finalCoord, ActionType actionType) {
		int xFinal = finalCoord.getCol() -'a';
		int yFinal = 8 - finalCoord.getLigne();
		boolean ret = false;
		
		if ((yFinal == this.getY()) || (xFinal == this.getX())) {
			ret = true;
		}
		return ret;
	}

	@Override
	public List<ModelCoord> getMoveItinerary(ModelCoord finalCoord) {
		int xFinal = finalCoord.getCol() -'a';
		int yFinal = 8 - finalCoord.getLigne();
		List<ModelCoord> ret = Collections.emptyList(); 

		// on vérifie que les coordonnées finales sont compatibles 
		//avec l'algo de déplacement 
		if (this.isAlgoMoveOk(finalCoord, null)) {

			ret = new LinkedList<ModelCoord>();
			int xVector = xFinal - this.getX();
			int yVector = yFinal - this.getY();
			
			// mouvement sur l'axe des X (y fixe)
			if (xVector != 0) { 
				
				int step = (int) Math.signum(xVector); 	// déplacement par pas de +1 ou -1
				for (int x = this.getX() + step ; x != xFinal ; x += step) {
					ret.add(new ModelCoord((char)('a'+x), (8-this.getY()))); 
				}
			} 
			// mouvement sur l'axe des Y (x fixe)
			else {			
				int step = (int) Math.signum(yVector);	// déplacement par pas de +1 ou -1
				for (int y = this.getY() + step ; y != yFinal ; y += step) {
					ret.add(new ModelCoord((char)('a'+this.getX()), (8-y))); 
				}
			}
		}
		return ret;
	}
	
}
