package src.view;


import javafx.scene.paint.Color;

public class ResetCommand implements  Command{

    private PaintStyle paintStyle;
    private Color white;
    private Color black;

    public ResetCommand(PaintStyle paintStyle, Color white, Color black) {
        this.paintStyle = paintStyle;
        this.white = white;
        this.black = black;
    }

    @Override
    public void execute() {
        GuiConfig.paintStyle.set(paintStyle);
        GuiConfig.whiteSquareColor.set(white);
        GuiConfig.blackSquareColor.set(black);
    }
}
;
