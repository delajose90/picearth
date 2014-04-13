package com.example.touch;
 

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.touch.ws.PicearthGetLogin;
import com.example.touch.ws.PicearthPostRegistro;


public class PruebaConsumos extends Activity {
    /** Called when the activity is first created. */
	PicearthGetLogin getLogin;
	String name, lastname, mail, nationality, Password;
	EditText etSugerencia;
	String stSugerencia;
	int error;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consumo);
        
        
        
        name = "jose";
        lastname = "de la O";
        mail = "chikyd.14@gmail.com";
        nationality = "SV";
        Password = "123456";
        
        
        new GetInfo	(mail, Password).execute();
         
    }
    
    private class GetInfo extends AsyncTask<Void, Void, Void> {

	 
		String mail, Password;

		public GetInfo(String mail, String Password) {
			 
			 this.mail			= mail; 
			 this.Password		= Password;
		}

		@Override
		protected void onPreExecute() {
			try {
				/*loading = new ProgressDialog(ClaseConsumoPrueba.this);
				loading.setMessage("Cargando");
				loading.setCancelable(false);
				loading.show();*/
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		protected Void doInBackground(Void... arg0) {

			try {
				getLogin = new PicearthGetLogin();
				getLogin.login( mail, Password);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			 error = getLogin.lerrorCode;
			 
			 if (error==0) {
				Toast.makeText(PruebaConsumos.this, "done", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(PruebaConsumos.this, "fail", Toast.LENGTH_SHORT).show();
			}
			
			

		}

	}
    
    
}