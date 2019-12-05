package application;
	
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	
	private Label enterDistace;       
	private TextField distanceInput;  
	private Button showStation;
	private Slider distanceSlider;
	private TextArea stationList;
	private Label compare;
	private ComboBox<String> stid;
	private Button calculateHD;
	private Label dist0;
	private Label dist1;
	private Label dist2;
	private Label dist3;
	private Label dist4;
	private TextField HDresult0;
	private TextField HDresult1;
	private TextField HDresult2;
	private TextField HDresult3;
	private TextField HDresult4;
	private Button addStation;
	private TextField stationInput;
	private TextArea stationLetterAvg;
	private Label bonus;
	private Button extra;
	private Button back;
	@Override
	public void start(Stage primaryStage) throws IOException {
			GridPane gridPane = new GridPane(); 
			Scene scene = new Scene(gridPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		// font for labels
		    Font font =  Font.font( "Arial",FontWeight.BOLD, 12); 
		// enter distace label
			enterDistace = new Label("Enter Hamming Dist:");
			enterDistace.setFont(font);
			  
		// font for text field
			final Font fontN =  Font.font( "Arial", 12);
		// slider of hamming distace to choose from
			distanceSlider = new Slider(1,4,2);
			distanceSlider.setMajorTickUnit(1);
			distanceSlider.setMinorTickCount(0);
			distanceSlider.setShowTickLabels(true);
			distanceSlider.setSnapToTicks(true);
			distanceSlider.setShowTickMarks(true);
		// show result on the text field
			distanceSlider.valueProperty().addListener(
		           new ChangeListener<Number>() { 
					 public void changed(ObservableValue <? extends Number >  
                     observable, Number oldValue, Number newValue){ 
					  // display new value on the text field
						 distanceInput.setText(String.valueOf(newValue.intValue()));
							distanceInput.setFont(fontN);
					 } 
		    });
		    
		// text field of distance input              
			distanceInput = new TextField(); 
			distanceInput.setPrefColumnCount(8);
			distanceInput.setText("2");
			distanceInput.setFont(fontN);
			distanceInput.setEditable(false);
			distanceInput.setFocusTraversable(false);
			
	// MesoStaion and HammingDist
		MesoStationInfos stations = new MesoStationInfos();	
		HammingDist HDstation = new HammingDist();
		
		// ArrayList of all original stations
			ArrayList<String> list = stations.getStationList();
		// ComboBox of all stations as option
			stid = new ComboBox<String>(FXCollections.observableArrayList(list));
		  // set default option to NRMN
			stid.setValue("NRMN");
		// text area of stations with chosen distance
			
			stationList = new TextArea();
			stationList.setPrefColumnCount(8);

		// show station button
			showStation = new Button("Show Station");
			showStation.setFont(font);
		  // when clicked, show all stations with the chosen amount of hamming distance
			showStation.setOnAction(new EventHandler<ActionEvent>() {		
					@Override
					public void handle(ActionEvent click) {
					  // set HashMap of the stations and their hamming distace from the chosen stid of the ComboBox
						HDstation.setHammingList(stid.getValue());
					  // display result on the text area
						stationList.setText(HDstation.getsameDist((int)distanceSlider.getValue()));		
					}	
			});
			
		// label for the ComboBox of all stations
			compare = new Label("Compare with:");
			compare.setFont(font);
			
		// labels for text field of HDresults
			dist0 = new Label("Distance 0");
			dist0.setFont(font);
			dist1 = new Label("Distance 1");
			dist1.setFont(font);
			dist2 = new Label("Distance 2");
			dist2.setFont(font);
			dist3 = new Label("Distance 3");
			dist3.setFont(font);
			dist4 = new Label("Distance 4");
			dist4.setFont(font);
		// result text fields of calculate HD button
			HDresult0 = new TextField();
			HDresult0.setEditable(false);
			HDresult1 = new TextField();
			HDresult1.setEditable(false);
			HDresult2 = new TextField();
			HDresult2.setEditable(false);
			HDresult3 = new TextField();
			HDresult3.setEditable(false);
			HDresult4 = new TextField();
			HDresult4.setEditable(false);
		
		// calculate hd Button	
			calculateHD = new Button("Calculate HD");
			calculateHD.setFont(font);
		  // when clicked get result and display on HDresults text fields
			calculateHD.setOnAction(new EventHandler<ActionEvent>() {			
				@Override
				public void handle(ActionEvent click) {
				  // set HashMap of stations and their hamming distance from the chosen stid
					HDstation.setHammingList(stid.getValue());
				  // get array of results
				  	int[] dist = HDstation.sameDist();
				  // write the result out into text fields
					HDresult0.setText(String.valueOf((dist[0])));
					HDresult1.setText(String.valueOf((dist[1])));
					HDresult2.setText(String.valueOf((dist[2])));
					HDresult3.setText(String.valueOf((dist[3])));
					HDresult4.setText(String.valueOf((dist[4])));
				}	
		});
			
		//Bonus label
			bonus = new Label("List of all stations and their letter average");
			bonus.setFont(font);
		// bonus text Area of all stations and its letter average
			stationLetterAvg = new TextArea(stations.toString());
			stationLetterAvg.setPrefColumnCount(20);
			
		// text field to write station name to add to the list
			stationInput = new TextField("ZERO");
			stationInput.setEditable(true);
			
		// add station Button
			addStation = new Button("Add Station");
			addStation.setFont(font);
			// when clicked add station ID to the list od stations
			addStation.setOnAction(new EventHandler<ActionEvent>() {			
				@Override
				public void handle(ActionEvent click) {
				  // add station to HashMap (prevent repeat)
					stations.addStation(stationInput.getText());
			   	  // reset comboBox of stations
					stid.setItems(FXCollections .observableArrayList(stations.getStationList()));
				  // write output in the bonus text area
					stationLetterAvg.setText(stations.toString());
				}	
			});
			
		// bonus button
			extra = new Button("If we finish, can I Click for Meme? ( ͡° ͜ʖ ͡°)");
			extra.setFont(font);			
			
		// set padding and gaps of the grid pane
			gridPane.setPadding(new Insets(10, 10, 10, 10));
		      gridPane.setHgap(20);                            
		      gridPane.setVgap(20);      
		      
		  // add enter distance label and textfield that reads the value of the slider
			gridPane.add(enterDistace, 0, 0);
		    gridPane.add(distanceInput, 1, 0);
		  // add slider of distance
		    gridPane.add(distanceSlider,0,1,2,2);
		  // add show station button and the text area of the result
		    gridPane.add(showStation, 0, 3);
		    gridPane.add(stationList, 0, 4,2,1);
		  // add label and drop down list of all stations
		    gridPane.add(compare, 0, 5);
		    gridPane.add(stid, 1, 5);
		  // add button to show the calculation
		    gridPane.add(calculateHD, 0, 6);
		  // add label and result of number of station with certain Hamming distance  
		    gridPane.add(dist0, 0, 7);
		    gridPane.add(dist1, 0, 8);
		    gridPane.add(dist2, 0, 9);
		    gridPane.add(dist3, 0, 10);
		    gridPane.add(dist4, 0, 11);
		    gridPane.add(HDresult0, 1, 7);
		    gridPane.add(HDresult1, 1, 8);
		    gridPane.add(HDresult2, 1, 9);
		    gridPane.add(HDresult3, 1, 10);
		    gridPane.add(HDresult4, 1, 11);
		  // add Add Station option		    
		    gridPane.add(addStation, 0, 12);
		    gridPane.add(stationInput, 1, 12);
		  // add bonus section
		    gridPane.add(bonus, 2, 0, 2, 1);
		    gridPane.add(stationLetterAvg, 2, 1, 1, 11);
			gridPane.add(extra, 2, 12, 2, 1);
		
		//set scene, title and get primary stage to show
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hamming Distance");
			primaryStage.show();			
		// Bonus stage with picture
			Stage window = primaryStage;
			StackPane pane = new StackPane();
		// Image
			Image meme = new Image("File:Joker.jpg");
			ImageView iv = new ImageView(meme);
		// Back button	
			back = new Button("Click to go back");
			back.setFont(font);
		// add elements to bonus scene
			pane.getChildren().add(iv);
			pane.getChildren().add(back);

			Scene Bonus = new Scene(pane,853,480);
		// go to bonus scene when extra button is click
			extra.setOnAction(e -> window.setScene(Bonus));
		// go back to the main scene when back button is clicked
			back.setOnAction(e -> window.setScene(scene));
		// set title of bonus scene and show it
			window.setTitle("Me right now");
			window.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
