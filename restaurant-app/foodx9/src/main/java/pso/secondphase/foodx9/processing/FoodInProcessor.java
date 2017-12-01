/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso.secondphase.foodx9.processing;

import pso.secondphase.iox9.business.processing.EntityProcessor;
import pso.secondphase.iox9.business.processing.EntityRecognizer;
import pso.secondphase.iox9.dao.EntityDAO;
import pso.secondphase.iox9.dao.IORecordDAO;
import pso.secondphase.iox9.exception.InvalidEntityException;
import pso.secondphase.iox9.model.Entity;
import pso.secondphase.iox9.model.IORecordType;
import pso.secondphase.iox9.model.ModelAbstractFactory;

/**
 *
 * @author vitorgreati
 */
public class FoodInProcessor extends EntityProcessor<String> {

    public FoodInProcessor(IORecordType ioType, ModelAbstractFactory modelAbstractFactory, EntityRecognizer entityRecognizer, EntityDAO entityDAO, IORecordDAO ioDAO) {
        super(ioType, modelAbstractFactory, entityRecognizer, entityDAO, ioDAO);
    }

    @Override
    protected boolean validate(Entity entity) throws InvalidEntityException {
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void populateSpecificValues(String idt, Entity entity) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void collect(Entity entity) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
