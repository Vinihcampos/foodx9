/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso.secondphase.foodx9.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pso.secondphase.foodx9.processing.FoodOutProcessor;
import pso.secondphase.iox9.business.processing.Observer;
import pso.secondphase.iox9.model.IORecord;

/**
 *
 * @author vitorgreati
 */
public class FoodPanelOut extends Observer {
    
    //Grid
    GridPane foodOut;
    
    //Labels
    Label titleOut;
    
    public FoodPanelOut(){
    }
    
    public void init(){        
        //Init grids
        initGrid();
        
        //Init labels
        initLabels();
    }
    
     public void update(FoodOutProcessor processor, Object o) {
        System.out.println("SAIU");
        System.out.println(((IORecord)o).getEntity().getIdentifier());
        System.out.println(((IORecord)o).getInstant());
    }   
     
    private void initGrid(){
        foodOut = new GridPane();
        foodOut.setPrefSize(350, 650);
        foodOut.getStyleClass().add("gridpane-right");
    }
    
    private void initLabels(){
        Rectangle bar = new Rectangle(350, 4);  
        bar.setArcWidth(6);  
        bar.setArcHeight(6);  
        bar.setFill(Color.rgb(142,68,173));
        
        titleOut = new Label("Exit");
        titleOut.getStyleClass().add("title");
        VBox vBox = new VBox(titleOut, bar);  
        vBox.setSpacing(2);  
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10,10,10,10));
        foodOut.add(vBox, 0, 0);
    }
    
    public GridPane getPanel(){
        return this.foodOut;
    }
}
