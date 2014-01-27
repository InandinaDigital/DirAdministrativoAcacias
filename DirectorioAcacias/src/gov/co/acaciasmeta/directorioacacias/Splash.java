package gov.co.acaciasmeta.directorioacacias;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

public class Splash extends Activity {

	public static final int segundos = 2000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//Esto es para que salga en toda la pantalla
		//this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_splash); 
		
		Handler handler = new Handler();
		
		handler.postDelayed(iniciar(), segundos);
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
