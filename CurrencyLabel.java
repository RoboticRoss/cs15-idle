package idle;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class CurrencyLabel {
  private Label label;
  private final String name;
  private int value;
  private static int numLabels = 0;

  public CurrencyLabel(Pane parent, String name, int value) {
    this.name = name;
    this.value = value;
    this.setupLabel();
    parent.getChildren().add(this.label);
  }

  private void setupLabel(){
    this.label = new Label();
    this.label.setTranslateX(Constants.LABEL_X);
    this.label.setTranslateY(Constants.LABEL_Y + numLabels*Constants.LABEL_PADDING);
    this.label.setFont(new Font("Courier New Bold", Constants.LABEL_FONT_SIZE));
    this.updateLabel();
    numLabels++;
  }

  private void updateLabel() {
    this.label.setText(this.name+": "+this.value);
  }

  public void updateValue(int value) {
    this.value = value;
    this.updateLabel();
  }
}
