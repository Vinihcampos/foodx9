/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso.secondphase.foodx9.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinihcampos
 */
public class InMemoryFoodDatabase {
    
    private static volatile List<String> insideFoods = new ArrayList<>();

    /**
     * @return the insideFoods
     */
    public static List<String> getInsideFoods() {
        return insideFoods;
    }

    /**
     * @param aInsideFoods the insideFoods to set
     */
    public static void setInsideFoods(List<String> aInsideFoods) {
        insideFoods = aInsideFoods;
    }    
}
