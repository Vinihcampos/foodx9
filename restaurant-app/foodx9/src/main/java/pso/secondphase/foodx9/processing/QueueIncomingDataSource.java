/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso.secondphase.foodx9.processing;

import pso.secondphase.foodx9.server.IncomingOrdersThread;
import pso.secondphase.foodx9.util.InMemoryFoodDatabase;
import pso.secondphase.iox9.business.capture.IdentityDataSource;
import pso.secondphase.iox9.exception.FailedOpeningSourceException;
import pso.secondphase.iox9.exception.InvalidDataReceivedException;

/**
 *
 * @author vitorgreati
 */
public class QueueIncomingDataSource extends IdentityDataSource<String>{

    public QueueIncomingDataSource(String id) {
        super(id);
    }

    @Override
    protected String _getData() throws InvalidDataReceivedException {
        if (!IncomingOrdersThread.getInstance().getIncomingOrdersQueue().isEmpty()){
            InMemoryFoodDatabase.getInsideFoods().add(IncomingOrdersThread.getInstance().getIncomingOrdersQueue().peek());
            return IncomingOrdersThread.getInstance().getIncomingOrdersQueue().remove();
        }
        return null;
    }

    @Override
    protected void _setup() throws FailedOpeningSourceException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
