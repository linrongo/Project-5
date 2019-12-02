package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	private Label enterDistace;     
	  
	private TextField distanceInput;  
	
	
	@Override
	public void start(Stage primaryStage) {
		
			GridPane gridPane = new GridPane(); 
			Scene scene = new Scene(gridPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			 gridPane.setPadding(new Insets(10, 10, 10, 10));
		      gridPane.setHgap(1);                            
		      gridPane.setVgap(10);          

		   
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
