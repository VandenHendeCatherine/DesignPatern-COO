package src.model.noStrategy.pieces;

import src.model.ModelFactory;
import src.shared.ActionType;
import src.shared.ModelCoord;
import src.shared.PieceSquareColor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractPion extends AbstractPiece {

    /**
     * @param pieceSquareColor
     * @param coord
     */
    public AbstractPion(PieceSquareColor pieceSquareColor, ModelCoord coord) {
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
    public List<ModelCoord> getMoveItinerary(ModelCoord finalCoord) {
        int yFinal = 8 - finalCoord.getLigne();
        List<ModelCoord> ret = Collections.emptyList();
        if (this.getY()==yFinal-2 || this.getY()==yFinal+2){
            ret = new LinkedList<ModelCoord>();

            int yEtape = (this.getY() + yFinal) / 2;			// Y est la ligne entre départ et arrivée
            ModelCoord coordEtape = new ModelCoord((char)('a'+this.getX()), (8-yEtape));	// et X est dans la même colonne

            ret.add(coordEtape);
        }
        return ret;
    }

    @Override
    public ActionType doMove(ModelCoord finalCoord){
        ActionType ret = ActionType.UNKNOWN;
        ret = super.doMove(finalCoord);

        if(this.getY() == ModelFactory.nbLigne.get()-1 || this.getY() == 0) {
            ret = ActionType.PROMOTION;
        }
        return ret;
    }
   }
