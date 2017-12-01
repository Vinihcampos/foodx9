/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso.secondphase.foodx9.view;

import pso.secondphase.foodx9.server.IncomingOrdersThread;
import pso.secondphase.foodx9.server.OutcomingOrdersThread;
import pso.secondphase.iox9.configuration.StartableView;

/**
 *
 * @author vitorgreati
 */
public class MainView implements StartableView {

    @Override
    public void start() {
        IncomingOrdersThread.getInstance().setDaemon(true);
        IncomingOrdersThread.getInstance().start();
        OutcomingOrdersThread.getInstance().setDaemon(true);
        OutcomingOrdersThread.getInstance().start();
    }
    
}
