package src.model.noStrategy.pieces;

import src.shared.ActionType;
import src.shared.ModelCoord;
import src.shared.PieceSquareColor;


/**
 * @author francoise.perrin - Alain BECKER
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD*
 */
public class PionBlanc extends AbstractPion {

	/**
	 * @param couleur
	 * @param coord
	 */
	public PionBlanc(PieceSquareColor couleur, ModelCoord coord) {
		super(couleur, coord);

	}

	/* (non-Javadoc)
	 * @see model.AbstractPiece#isAlgoMoveOk(ModelCoord , ActionType )
	 * Return true si le déplacement est possible vers la case de destination
	 */
	@Override
	public boolean isAlgoMoveOk(ModelCoord finalCoord, ActionType actionType) {
		int xFinal = finalCoord.getCol() -'a';
		int yFinal = 8 - finalCoord.getLigne();
		boolean ret = false;

		// Déplacement d'1 case en diagonale avec prise
		if (actionType == ActionType.TAKE) {
				if ((yFinal == this.getY()-1 && xFinal == this.getX()+1) 
						|| (yFinal == this.getY()-1 && xFinal == this.getX()-1)) {
					ret = true;
				}

		}
		// Déplacement vertical sans prise  
		// d'1 case si le pion a déjà bougé, de 2 cases sinon
		// vers le haut ou vers le bas selon sa couleur
		else {
			if ((xFinal == this.getX())
					&& (Math.abs(yFinal - this.getY()) <= 1 || 
					(Math.abs(yFinal - this.getY()) <= 2 && !this.hasMoved()))) {

				if (yFinal - this.getY() < 0) {
					ret = true;
				}
				
			}
		}
		return ret;
	}


}
