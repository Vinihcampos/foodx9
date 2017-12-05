/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso.secondphase.foodx9.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pso.secondphase.foodx9.server.IncomingOrdersThread;
import pso.secondphase.foodx9.server.OutcomingOrdersThread;
import pso.secondphase.iox9.configuration.ApplicationConfiguration;
import pso.secondphase.iox9.configuration.StartableView;

/**
 *
 * @author vinihcampos
 */
public class RealTimePanel extends Application implements StartableView{
    
    //Grids
    private GridPane rootPane;
    
    //Panels
    private FoodPanelIn foodPanelIn;
    private FoodPanelOut foodPanelOut;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        foodPanelIn = (FoodPanelIn) ApplicationConfiguration.getInstance().getViews().get("in_food_panel");//new VehicleInPanel();
        foodPanelIn.init();
        
        foodPanelOut = (FoodPanelOut) ApplicationConfiguration.getInstance().getViews().get("out_food_panel");//new VehicleInPanel();
        foodPanelOut.init();
        
        //Load font
        Font.loadFont(getClass().getResource("/font/JosefinSans-Light.ttf").toExternalForm(), 20);
        
        //Init main grid
        initGrid();
        
        //Creating a scene object 
        Scene scene = new Scene(rootPane);
        
        //Defining stylesheet
        scene.getStylesheets().add(getClass().getResource("/css/realtimepanel.css").toExternalForm());
      
        //Setting title to the Stage 
        stage.setTitle("Real Time Panel"); 

        //Adding scene to the stage 
        stage.setScene(scene); 
        
        //Displaying the contents of the stage 
        stage.show(); 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
        launch(args);
    }
    
    public void initGrid(){
        //Creating a Grid Pane 
        rootPane = new GridPane();
        rootPane.setPrefSize(700, 660);
        rootPane.getStyleClass().add("root-pane");
        
        rootPane.add(foodPanelIn.getPanel(), 0, 0);
        rootPane.add(foodPanelOut.getPanel(), 1, 0);
    }

    @Override
    public void start() {
        
        IncomingOrdersThread.getInstance().setDaemon(true);
        IncomingOrdersThread.getInstance().start();
        OutcomingOrdersThread.getInstance().setDaemon(true);
        OutcomingOrdersThread.getInstance().start();
        Application.launch("");
        
    }
    
}
