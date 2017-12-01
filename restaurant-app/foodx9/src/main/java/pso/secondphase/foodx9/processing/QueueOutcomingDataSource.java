/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso.secondphase.foodx9.processing;

import pso.secondphase.foodx9.server.IncomingOrdersThread;
import pso.secondphase.foodx9.server.OutcomingOrdersThread;
import pso.secondphase.iox9.business.capture.IdentityDataSource;
import pso.secondphase.iox9.exception.FailedOpeningSourceException;
import pso.secondphase.iox9.exception.InvalidDataReceivedException;

/**
 *
 * @author vitorgreati
 */
public class QueueOutcomingDataSource extends IdentityDataSource<String>{

    public QueueOutcomingDataSource(String id) {
        super(id);
    }

    @Override
    protected String _getData() throws InvalidDataReceivedException {
        if (!OutcomingOrdersThread.getInstance().getOutcomingOrdersQueue().isEmpty())
            return OutcomingOrdersThread.getInstance().getOutcomingOrdersQueue().remove();
        return null;
    }

    @Override
    protected void _setup() throws FailedOpeningSourceException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
