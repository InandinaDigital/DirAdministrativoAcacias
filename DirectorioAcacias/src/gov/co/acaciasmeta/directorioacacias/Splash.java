package gov.co.acaciasmeta.directorioacacias;

import java.io.IOException;


import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;


/**
 * Splash
 * Ventan de Inicio con el logo de la alcaldia
 * @author andres
 *
 */

public class Splash extends Activity {
	public static final int segundos = 2000;		//Tiempo que dura la Actividad en mostrarse
	private static final String TAG = "Splash";		//Etiqueta de depuracion
	private String URL="192.168.0.15";				//URL de la pagina donde se alojara la Base de datos
	private String data;							//Variable que guarda la respuesta de la Base de datos
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		//Esto es para que salga en toda la pantalla
		//this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_splash);
		Log.i(TAG, "Ingresando al Splash");			//Prueba de depuracion que la funcion se ejecuto correctamente
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); //Permite ejecutar la Actividad en versiones mayores a 3
        StrictMode.setThreadPolicy(policy); 
		Handler handler = new Handler();			//Creacion de un hilo de ejecucion
		handler.postDelayed(iniciar(), segundos);	//Tiempo de ejecucion del hilo
//		isOnline();									//Probar si tiene Internet
	}
	/**
	 * isOnline
	 * Funcion que se encarga de comprobar si se tiene acceso a Internet
	 * @return si esta conectado o no
	 */
	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null &&netInfo.isConnectedOrConnecting()) {
			Log.i(TAG,"Con acceso a Internet");
			cargarBD();
			return true;
		}
		Log.i(TAG,"Sin acceso a Internet");
		return false;
	}
	
	
	
	private void cargarBD() {
		JSONArray ja=null;
		try {
			data=httpGetData("http://"+URL+"/directorio/consultarUsuario.php");
			if(data.length()>1)
				ja=new JSONArray(data);
		} catch (JSONException e) {
			e.printStackTrace();
			Toast.makeText(getApplicationContext(), "Error recuperando la informacion del servidor, verifique su conexion a internet y vuelva a intentarlo.", Toast.LENGTH_SHORT).show();
			
		}
		try{
			Toast.makeText(getApplicationContext(), ja.getString(1), Toast.LENGTH_SHORT).show();
			for(int i=0;i<ja.length();i++){
				ja.getJSONObject(i);
			}
		} catch (Exception e) {
			
		}
		
	}
	
	public String httpGetData(String mURL) {
        String response="";
        mURL=mURL.replace(" ", "%20");
        Log.i("LocAndroid Response HTTP Threas","Ejecutando get 0: "+mURL);
        HttpClient httpclient = new DefaultHttpClient();
          
        Log.i("LocAndroid Response HTTP Thread","Ejecutando get 1");
    	HttpGet httppost = new HttpGet(mURL);
        Log.i("LocAndroid Response HTTP Thread","Ejecutando get 2");
        
        try {
	        Log.i("LocAndroid Response HTTP","Ejecutando get");
	        // Execute HTTP Post Request
	        ResponseHandler<String> responseHandler=new BasicResponseHandler();
	        response = httpclient.execute(httppost,responseHandler);
	        Log.i("LocAndroid Response HTTP",response);
    	} catch (ClientProtocolException e) {
	        Log.i("LocAndroid Response HTTP ERROR 1",e.getMessage());
    	} catch (IOException e) {
    		Log.i("LocAndroid Response HTTP ERROR 2",e.getMessage());
    	}
        return response;
    }  
	
	private Runnable iniciar(){
		Runnable res = new Runnable(){
			public void run(){
				Intent i = new Intent(Splash.this, ViewActivity.class);
				startActivity(i);
				finish();
			}
		};
		return res;
		
	}

}
