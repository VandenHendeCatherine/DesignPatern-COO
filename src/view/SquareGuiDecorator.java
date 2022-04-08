package src.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import src.shared.GUICoord;

public class SquareGuiDecorator extends BorderPane implements ChessSquareGui {

    private SquareGui squareGui;

    public SquareGuiDecorator(SquareGui squareGui) {
        this.squareGui = squareGui;
        changeListener();
        paint();
    }

    private void changeListener() {
        GuiConfig.paintStyle.addListener(new ChangeListener<PaintStyle>() {
             @Override
             public void changed(ObservableValue<? extends PaintStyle> observable, PaintStyle oldValue, PaintStyle newValue) {
                 if(newValue!=null){
                     paint();
                 }
             }
         }
        );
        GuiConfig.blackSquareColor.addListener(new ChangeListener<Color>() {
            @Override
            public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
                if(newValue!=null){
                    paint();
                }
            }
        });
        GuiConfig.whiteSquareColor.addListener(new ChangeListener<Color>() {
            @Override
            public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
                if(newValue!=null){
                    paint();
                }
            }
        });
    }

    @Override
    public GUICoord getCoord() {
        return squareGui.getCoord();
    }

    @Override
    public void resetColor(boolean isLight) {
        squareGui.resetColor(isLight);
        paint();

    }

    @Override
    public void paint() {
        squareGui.paint();
        this.setBackground(squareGui.getBackground());
        this.setBorder(squareGui.getBorder());
    }
}
