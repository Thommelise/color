import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class main extends Application {

    static ColourPalette colourPalette = new ColourPalette();

   public static void main(String[] args) {

      Colour colour1 = new Colour(10, 20, 30);
      Colour colour2 = new Colour(25, 42, 56);
      Colour colour3 = new Colour(55, 55, 55);
      Colour colour4 = new Colour(22, 22, 22);


      colourPalette.addColour(colour1);
      colourPalette.addColour(colour2);
      colourPalette.addColour(colour3);
      colourPalette.addColour(colour4);

      colourPalette.mixColours(3, new Colour(22, 22, 22));

      System.out.println(colourPalette.toString());

      System.out.println(colourPalette.numberOfColours());
      launch();
   }

   @Override
   public void start(Stage primaryStage) {
       System.out.println();
      primaryStage.setTitle("Welcome to JavaFX");

      GridPane grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setHgap(10);
      grid.setVgap(10);
      grid.setPadding(new Insets(25, 25, 25, 25));

       Text scenetitle = new Text("Pick Colour");
       scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
       grid.add(scenetitle, 0, 0, 2, 1);

       ComboBox comboBox = new ComboBox(); {
           for (int i=0; i <colourPalette.getColor().size(); i++){
               comboBox.getItems().add(colourPalette.getColor().get(i));
           }
       }
       grid.add(comboBox,1,4 );

       Label redLabel = new Label("Red");
       grid.add(redLabel, 0, 1);

       TextField redTextField = new TextField();
       grid.add(redTextField, 1, 1);

       Label blueLabel = new Label("Blue");
       grid.add(blueLabel, 0, 2);

       TextField blueTextField = new TextField();
       grid.add(blueTextField, 1, 2);

       Label greenlabel = new Label("Green");
       grid.add(greenlabel, 0, 3);

       TextField greenTextField = new TextField();
       grid.add(greenTextField, 1, 3);

       Button btn = new Button("Mix Colour");
       HBox hbBnt = new HBox(10);
       hbBnt.setAlignment(Pos.BOTTOM_RIGHT);
       hbBnt.getChildren().add(btn);
       grid.add(hbBnt, 1, 20);

       ColorPicker colorPicker = new ColorPicker();
       colorPicker.setValue(Color.CORAL);
       grid.add(colorPicker, 1, 30);

       Rectangle Rect = new Rectangle();



       Scene scene = new Scene(grid, 600, 675);
       primaryStage.setScene(scene);
       primaryStage.show();

       btn.setOnAction(new EventHandler<ActionEvent>() {

           @Override
           public void handle(ActionEvent event) {

               try {

                   Integer red = Integer.parseInt(redTextField.getText());
                   Integer blue = Integer.parseInt(blueTextField.getText());
                   Integer green = Integer.parseInt(greenTextField.getText());
                   Colour colour = new Colour(red, green, blue);
                   colourPalette.addColour(colour);
                   Integer result1 = Integer.valueOf(red);



               } catch (Exception e) {
                   System.err.println("Caught Exception:" + e.getMessage());

               }

           }
       });

   }

}














