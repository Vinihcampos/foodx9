/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso.secondphase.foodx9.view;

import pso.secondphase.foodx9.processing.FoodOutProcessor;
import pso.secondphase.iox9.business.processing.Observer;
import pso.secondphase.iox9.model.IORecord;

/**
 *
 * @author vitorgreati
 */
public class FoodPanelOut extends Observer {
     public void update(FoodOutProcessor processor, Object o) {
        System.out.println("SAIU");
        System.out.println(((IORecord)o).getEntity().getIdentifier());
        System.out.println(((IORecord)o).getInstant());
    }   
}
