package application;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
	private Button calcButton;
	private Slider distanceSlider;
	
	@Override
	public void start(Stage primaryStage) {
		
			GridPane gridPane = new GridPane(); 
			Scene scene = new Scene(gridPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			
		    Font font =  Font.font( "Arial",FontWeight.BOLD, 12); 
		     
			enterDistace = new Label("Enter Hamming Dist:");
			enterDistace.setFont(font);
			  
			
			final Font fontN =  Font.font( "Arial", 12);

			distanceSlider = new Slider(1,4,1);
			distanceSlider.setMajorTickUnit(1);
			distanceSlider.setMinorTickCount(0);
			distanceSlider.setShowTickLabels(true);
			distanceSlider.setSnapToTicks(true);
			distanceSlider.valueProperty().addListener(
		           new ChangeListener<Number>() { 

					 public void changed(ObservableValue <? extends Number >  
                     observable, Number oldValue, Number newValue)
           { 

						 distanceInput.setText(String.valueOf(newValue.intValue()));
							distanceInput.setFont(fontN);
           } 
		             });;
			
			distanceInput = new TextField(); 
			distanceInput.setPrefColumnCount(8);
			distanceInput.setText("1");
			distanceInput.setFont(fontN);
			distanceInput.setEditable(false);
			distanceInput.setFocusTraversable(false);
		

			
			 gridPane.setPadding(new Insets(10, 10, 10, 10));
		      gridPane.setHgap(0);                            
		      gridPane.setVgap(10);          

			gridPane.add(enterDistace, 0, 0);
		    gridPane.add(distanceInput, 1, 0);	
		    gridPane.add(distanceSlider, 0, 1);

			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hamming Distance");
			primaryStage.show();		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
