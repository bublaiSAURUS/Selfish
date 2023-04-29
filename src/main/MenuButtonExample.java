import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Shows a simple JavaFX MenuButton - and prints a text when a menu item from the button is selected.
 */
public class MenuButtonExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static final int WIDTH  = 888;
    private static final int HEIGHT = 663;
    @Override
    public void start(Stage primaryStage) {
        //First, simple example of creating a MenuButton
        MenuItem menuItem1 = new MenuItem("Enter Number of Players");
        MenuItem menuItem2 = new MenuItem("Enter Player Names");
        MenuItem menuItem3 = new MenuItem("Start Game");

        menuItem1.setOnAction((event) -> { System.out.println("MenuItem1 activated"); });
        menuItem2.setOnAction((event) -> { System.out.println("MenuItem2 activated"); });
        menuItem3.setOnAction((event) -> { System.out.println("MenuItem3 activated"); });

        MenuButton menuButton = new MenuButton("Play", null, menuItem1, menuItem2, menuItem3);


        //second, more elaborate example of how a MenuButton can be created, and configured via setter methods
        MenuButton menuButton2 = new MenuButton();
        menuButton2.setText("More");

        MenuItem menuItem2_1 = new MenuItem("How to Play");
        MenuItem menuItem2_2 = new MenuItem("Exit");
        //MenuItem menuItem2_3 = new MenuItem("Action 3");

        menuItem2_1.setOnAction((event) -> { System.out.println("MenuItem2_1 activated"); });
        menuItem2_2.setOnAction((event) -> { System.out.println("MenuItem2_2 activated"); });
        //menuItem2_3.setOnAction((event) -> { System.out.println("MenuItem2_3 activated"); });

        menuButton2.getItems().add(menuItem2_1);
        menuButton2.getItems().add(menuItem2_2);
        //menuButton2.getItems().add(menuItem2_3);

        ImageView imageView = new ImageView(new Image(getClass().getResource("background.jpg").toExternalForm()));
        //ImageView imageView = new ImageView(new Image(getClass().getResource("res/iqsteps.png").toExternalForm()));
        imageView.setFitWidth(WIDTH);
        imageView.setFitHeight(HEIGHT-100);

        VBox vbox = new VBox(menuButton, menuButton2, imageView);
        Scene scene = new Scene(vbox);
        //addBackground();
        primaryStage.setScene(scene);
        primaryStage.setWidth (WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setTitle("Selfish Space Edition 2D");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}