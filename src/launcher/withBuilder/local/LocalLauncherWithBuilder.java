package src.launcher.withBuilder.local;

import src.launcher.withBuilder.AbstractLauncher;
import src.launcher.withBuilder.ChessBuilder;

/**
 * @author francoise.perrin
 * Lance l'exécution d'un jeu d'échec en mode local.
 *

 */
public  class LocalLauncherWithBuilder extends AbstractLauncher {

	
	protected  ChessBuilder createChessBuilder() {
		
		return new LocalChessBuilder();	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LocalLauncherWithBuilder.launch();
	}

	
}
