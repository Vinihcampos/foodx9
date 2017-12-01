/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso.secondphase.foodx9.processing;

import pso.secondphase.iox9.business.processing.EntityRecognizer;

/**
 *
 * @author vitorgreati
 */
public class FoodNumberRecognizer implements EntityRecognizer<String> {

    @Override
    public String recognize(String idt) {
        if (idt != null) {
            return idt.split(";")[0];
        }
        return null;
    }
    
}
