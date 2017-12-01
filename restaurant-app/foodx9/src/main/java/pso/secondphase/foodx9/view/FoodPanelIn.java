/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso.secondphase.foodx9.view;

import pso.secondphase.foodx9.processing.FoodInProcessor;
import pso.secondphase.iox9.business.processing.Observer;
import pso.secondphase.iox9.model.IORecord;

/**
 *
 * @author vitorgreati
 */
public class FoodPanelIn extends Observer {
    
    public void update(FoodInProcessor processor, Object o) {
        System.out.println("ENTROU");
        System.out.println(((IORecord)o).getEntity().getIdentifier());
        System.out.println(((IORecord)o).getInstant());
    }
    
}
