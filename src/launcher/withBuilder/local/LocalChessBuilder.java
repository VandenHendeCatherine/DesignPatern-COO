package src.launcher.withBuilder.local;

import src.controller.localControler.ControllerLocal;
import src.launcher.withBuilder.AbstractChessBuilder;
import src.launcher.withBuilder.ChessBuilder;
import src.launcher.withBuilder.ViewData;
import src.model.Model;
import src.view.View;

public class LocalChessBuilder extends AbstractChessBuilder implements ChessBuilder {

	public LocalChessBuilder() {
		super();
	}

	@Override
	public void buildModel() {

		this.chessModel = new Model();
	}

	@Override
	public void buildControler() {

		this.chessController = new ControllerLocal();
	}

	@Override
	public void buildView() {

		if (this.chessController != null) {
			this.chessGUI = new View(this.chessController);
		}
	}

	@Override
	public ViewData getViewData() {
		
		return new ViewData(this.chessGUI,
				"Chessgame en mode local - Avec Builder - Version élèves",
				500);
	}
}