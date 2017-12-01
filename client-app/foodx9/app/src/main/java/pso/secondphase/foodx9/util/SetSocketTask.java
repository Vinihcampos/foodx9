package pso.secondphase.foodx9.util;

import android.os.AsyncTask;

import java.io.IOException;

import pso.secondphase.foodx9.client.TCPconnection;
import pso.secondphase.foodx9.client.UDPconnection;

/**
 * Created by vinihcampos on 26/06/17.
 */

public class SetSocketTask extends AsyncTask<String, String, Boolean> {
    @Override
    protected Boolean doInBackground(String... params) {
        try {
            new UDPconnection(Integer.valueOf(params[0]), params[1]);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean result){
        //TCPconnection.setIsConnected(result);
    }
}
