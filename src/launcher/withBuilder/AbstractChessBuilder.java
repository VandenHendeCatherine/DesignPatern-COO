package src.launcher.withBuilder;



import src.controller.ChessController;
import src.controller.ChessControllerModel;
import src.controller.ChessControllerView;
import javafx.scene.Parent;
import src.view.ChessView;
import src.model.ChessModel;

public abstract class AbstractChessBuilder implements ChessBuilder {

	protected ChessModel chessModel = null;
	protected ChessController chessController = null;
	protected Parent chessGUI = null;

	public AbstractChessBuilder() {
		super();
	}

	@Override
	public abstract void buildModel() ;

	@Override
	public abstract void buildControler();

	@Override
	public abstract void buildView();
	
	@Override
	public abstract ViewData getViewData() ;
	

	//////////////////////////////////////////////////////////////////////////////
	// Initialisation de la view et du model avec lesquels le controler va communiquer
	// en fonction des actions effectuées sur le model, 
	// le controler invoquera des méthodes de la view pour qu'elle se mette à jour
	// et inversement
	//////////////////////////////////////////////////////////////////////////////

	@Override
	public void setMediator() {
		if(this.chessController != null) {
			if (this.chessModel != null) {
				((ChessControllerModel) this.chessController).setModel(this.chessModel);
			}
			if (this.chessGUI != null) {
				((ChessControllerView) this.chessController).setView((ChessView) this.chessGUI);
			}
		}
	}

}

