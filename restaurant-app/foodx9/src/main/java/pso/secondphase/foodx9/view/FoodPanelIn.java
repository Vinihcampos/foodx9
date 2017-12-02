/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso.secondphase.foodx9.view;

import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pso.secondphase.foodx9.processing.FoodInProcessor;
import pso.secondphase.iox9.business.processing.Observer;
import pso.secondphase.iox9.model.Entity;
import pso.secondphase.iox9.model.IORecord;

/**
 *
 * @author vitorgreati
 */
public class FoodPanelIn extends Observer {
    
    //Grid
    GridPane foodIn;
    
    //Labels
    private Label titleIn;
    
    //Observable lists
    private ObservableList<Entity> entities;    
    //ListViews
    private ListView<Entity> listViewEntities;
    
    public FoodPanelIn(){        
    }
    
    public void init(){
        //Init grids
        initGrid();
        
        //Init Labels
        //initLabels();
        
        //Init List
        initListView();
    }
    
    public void update(FoodInProcessor processor, Object o) {
        System.out.println("ENTROU");
        System.out.println(((IORecord)o).getEntity().getIdentifier());
        System.out.println(((IORecord)o).getEntity().getAttrs().get("preco").value);
        System.out.println(((IORecord)o).getInstant());
        
        Platform.runLater(() -> {
            if(entities.size() == 9){
                entities.remove(8);
                entities.add(0, ((IORecord)o).getEntity());
            }else{
                entities.add(0, ((IORecord)o).getEntity());
            }
        });
        
    }
    
    private void initGrid(){
        foodIn = new GridPane();
        foodIn.setPrefSize(350, 650);
        foodIn.getStyleClass().add("gridpane-left");
    }
    
    private void initLabels(){
        Rectangle bar = new Rectangle(350, 4);  
        bar.setArcWidth(6);  
        bar.setArcHeight(6);  
        bar.setFill(Color.rgb(142,68,173));
        
        titleIn = new Label("Entrance");
        titleIn.getStyleClass().add("title");
        VBox vBox = new VBox(titleIn, bar);  
        vBox.setSpacing(2);  
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10,10,10,10));
        foodIn.add(vBox, 0, 0);
    }
    
    private void initListView(){
        entities = FXCollections.observableArrayList();
        listViewEntities = new ListView<>(entities);
        listViewEntities.getStyleClass().add("list-foods");
        
        Label ln = new Label("Entrada");
        ln.getStyleClass().add("title");
        Rectangle barn = new Rectangle(350, 4);  
        barn.setArcWidth(6);  
        barn.setArcHeight(6);  
        barn.setFill(Color.rgb(142,68,173));
        
        VBox vboxn = new VBox(ln, barn, listViewEntities);
        vboxn.setSpacing(20);  
        vboxn.setAlignment(Pos.CENTER);
        vboxn.setPadding(new Insets(10,10,0,10));
        
        listViewEntities.setCellFactory((ListView<Entity> n) -> {
            ListCell<Entity> cell = new ListCell<Entity>(){
                @Override
                protected void updateItem(Entity n, boolean bln){
                    super.updateItem(n, bln);
                    if (n != null) {                        
                        String msg = "";
                        msg += "Food: " + n.getIdentifier() + "\n";
                        msg += "Price: " + String.valueOf(n.getAttrs().get("preco").value);
                        setText(msg);        
                        Image data = new Image(getClass().getResource("/img/" + n.getIdentifier() + ".png").toExternalForm(), 90, 90, true, true);
                        setGraphic(new ImageView(data));
                        getStyleClass().remove("legal");
                        getStyleClass().add("legal");
                    } else {
                        setText("");
                    }
                };
            };
            return cell;
        });
        
        foodIn.add(vboxn, 0, 0);
    }
    
    public GridPane getPanel(){
        return this.foodIn;
    }
}
