import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
        grid.add(scenetitle, 0, 0, 1, 1);


        Label redLabel = new Label("Red");
        grid.add(redLabel, 0, 1);

        TextField redTextField = new TextField();
        grid.add(redTextField, 1, 1,1,1);

        Label redLabel2 = new Label("Red");
        grid.add(redLabel2, 0, 6);

        TextField redTextField2 = new TextField();
        grid.add(redTextField2, 1, 6);

        Label blueLabel = new Label("Blue");
        grid.add(blueLabel, 0, 2);

        TextField blueTextField = new TextField();
        grid.add(blueTextField, 1, 2);

        Label blueLabel2 = new Label("Blue");
        grid.add(blueLabel2, 0, 7);

        TextField blueTextfield2 = new TextField();
        grid.add(blueTextfield2, 1, 7);

        Label greenlabel = new Label("Green");
        grid.add(greenlabel, 0, 3);

        TextField greenTextField = new TextField();
        grid.add(greenTextField, 1, 3);

        Label greenLabel2 = new Label("Green");
        grid.add(greenLabel2, 0, 8);
        TextField greenTextField2 = new TextField();
        grid.add(greenTextField2, 1, 8);


        Button btn = new Button("Mix Colour");
        HBox hbBnt = new HBox(10);
        hbBnt.setAlignment(Pos.BOTTOM_RIGHT);
        hbBnt.getChildren().add(btn);
        grid.add(hbBnt, 0, 20);

        Button btn2 = new Button("Number of grey");
        HBox hbBnt2 = new HBox(10);
        hbBnt2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBnt2.getChildren().add(btn2);
        grid.add(hbBnt2, 1, 20);

        Button btn3 = new Button("Number of Colours");
        HBox hbBnt3 = new HBox(10);
        hbBnt3.setAlignment(Pos.BOTTOM_RIGHT);
        hbBnt3.getChildren().add(btn3);
        grid.add(hbBnt3, 2, 20);

        Button btn4 = new Button("All Colours");
        HBox hbBnt4 = new HBox(10);
        hbBnt4.setAlignment(Pos.BOTTOM_RIGHT);
        hbBnt4.getChildren().add(btn4);
        grid.add(hbBnt4, 3, 20);

        Rectangle rect = new Rectangle(50, 50);
        rect.setFill(Color.rgb(0, 0, 0));
        grid.add(rect, 2, 2);

        Rectangle rect1 = new Rectangle(50, 50);
        rect1.setFill(Color.rgb(0, 0, 0));
        grid.add(rect1, 2, 7);

        Label newColour = new Label("New Colour");
        grid.add(newColour, 0, 12);

        Rectangle rect2 = new Rectangle(50, 50);
        rect2.setFill(Color.rgb(0, 0, 0));
        grid.add(rect2, 2, 12);

        TextArea output = new TextArea();
        grid.add(output,0 , 22,5,3);

        ComboBox comboBox = new ComboBox<>();
        








        Scene scene = new Scene(grid, 1200, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                try {

                    Integer red = Integer.parseInt(redTextField.getText());
                    Integer blue = Integer.parseInt(blueTextField.getText());
                    Integer green = Integer.parseInt(greenTextField.getText());

                    Integer red1 = Integer.parseInt(redTextField2.getText());
                    Integer blue1 = Integer.parseInt(blueTextfield2.getText());
                    Integer green1 = Integer.parseInt(greenTextField2.getText());

                    Colour colour = new Colour(red, green, blue);
                    Colour colour1 = new Colour(red1, green1, blue1);


                    rect.setFill(Color.rgb(red, green, blue));

                    rect1.setFill(Color.rgb(red1, green1, blue1));
                    colourPalette.mixColours(colour, colour1);
                    rect2.setFill(Color.rgb(colour1.getRed(),colour1.getGreen(),colour1.getGreen()));

                    colourPalette.addColour(colour1);



                } catch (Exception e) {
                    output.appendText("Caught Exception:" + e.getMessage()+"\n");
                    

                }

            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                output.clear();

                output.appendText("There are"+" "+ colourPalette.getNumberOfGreyColours()+ " "+" grey colours in the colourpalette"+"\n");

            }

            ;

        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                output.clear();
                output.appendText("There are"+" "+colourPalette.numberOfColours()+" "+"colours in the colourpalette"+"\n");
            }

        });

        btn4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                output.clear();

                output.appendText(colourPalette.getColor()+"\n");
            }

        });

    }

}
















