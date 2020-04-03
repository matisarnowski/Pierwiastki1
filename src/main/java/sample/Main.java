package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    Scene scene1, scene2;
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label labelA = new Label("Podaj pierwszy współczynnik! ");
        GridPane.setConstraints(labelA, 1, 0);

        Label labelB = new Label("Podaj drugi współczynnik! ");
        GridPane.setConstraints(labelB, 1, 2);

        Label labelC = new Label("Podaj trzeci współczynnik! ");
        GridPane.setConstraints(labelC, 1, 4);

        TextField aInput = new TextField();
        GridPane.setConstraints(aInput, 1, 1);

        TextField bInput = new TextField();
        GridPane.setConstraints(bInput, 1, 3);

        TextField cInput = new TextField();
        GridPane.setConstraints(cInput, 1, 5);

        Dwumian dwumian = new Dwumian();

        Label label1 = new Label("Pierwiastki równania! ");
        GridPane.setConstraints(label1, 0, 0);

        Button button1 = new Button("Kliknij, aby obliczyć! ");
        GridPane.setConstraints(button1, 0, 1);
        button1.setOnAction(e -> {
            dwumian.setA(convertA(aInput));
            //System.out.println(convertA(aInput));
            dwumian.setB(convertA(bInput));
            //System.out.println(convertA(bInput));
            dwumian.setC(convertA(cInput));
            //System.out.println(convertA(cInput));

            Label label3 = new Label("Wyniki obliczeń: " + dwumian.pierwiastek() + " i delta: " + dwumian.getDelta(convertA(aInput), convertA(bInput), convertA(cInput)));
            Label label2 = new Label("(" + dwumian.getA() + ")x^2 + (" + dwumian.getB() + ") + (" + dwumian.getC() + ")");

            VBox box = new VBox(10);
            scene2 = new Scene(box, 800, 400);
            box.getChildren().addAll(label3, label2);
            box.setAlignment(Pos.CENTER);
            window.setScene(scene2);
            window.show();
        });

        scene1 = new Scene(grid, 800, 400);
        grid.getChildren().addAll(label1, labelA, aInput, labelB, bInput, labelC, cInput, button1);
        grid.setAlignment(Pos.CENTER);
        window.setTitle("Obliczamy pierwiastki rzeczywiste równania kwadratowego!");

        window.setScene(scene1);
        window.show();
    }

    public double convertA(TextField text) {
        double argument;
        try {
            argument = Double.parseDouble(text.getText());
            return argument;
        } catch (NumberFormatException exc) {
            System.out.println(exc);
            return -1;
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}