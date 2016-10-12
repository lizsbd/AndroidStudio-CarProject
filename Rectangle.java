import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.stage.Stage;

public class Rectangle extends Application {
@Override 
public void start(Stage stage) {


TextInputDialog ask = new TextInputDialog();
ask.setTitle("Rectangle Height");
ask.setContentText("Enter the height of the rectangle");
Optional<String> height = ask.showAndWait();
int height1 = Integer.parseInt(height.get());

TextInputDialog ask1 = new TextInputDialog();
ask1.setTitle("Rectangle Width");
ask1.setContentText("Enter the width of the rectangle");
Optional<String> width = ask1.showAndWait();
int width1 = Integer.parseInt(width.get());

int perimeter = (height1 + width1) *2;
int area = height1 * width1;


Alert p = new Alert(Alert.AlertType.INFORMATION);
p.setTitle("Perimeter");
p.setContentText("The perimeter of the rectangle is " + perimeter );
p.showAndWait();

Alert a = new Alert(Alert.AlertType.INFORMATION);
a.setTitle("Area");
a.setContentText("The are of the rectangle is " + area);
a.showAndWait();

}
}
