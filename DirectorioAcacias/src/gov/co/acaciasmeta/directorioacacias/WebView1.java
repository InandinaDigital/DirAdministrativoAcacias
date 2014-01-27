package gov.co.acaciasmeta.directorioacacias;

import gov.co.acaciasmeta.clases.ViewClient;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class WebView1 extends Activity{

	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
		
		Intent i = new Intent(this, ViewActivity.class);
		startActivity(i);
		finish();
	}

	WebView wb;
	Bundle b;
	String pal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		//LiveConnectivityManager.singleton(this).addObserver(this); Para comprobar la conectividad
		
		wb = (WebView) findViewById(R.id.webView1);
		b = getIntent().getExtras();
		pal = b.getString("facebook");
		
		wb.loadUrl(pal);
		wb.setWebViewClient(new ViewClient());
		wb.getSettings().setJavaScriptEnabled(true);
		wb.getSettings().setLoadWithOverviewMode(true);
		wb.getSettings().setUseWideViewPort(true);
			
	}
	
	/**Para comprobar la conectividad
	
	 @Override
	    protected void onStart() {
	        super.onStart();
	        LiveConnectivityManager.singleton(this).addObserver(this);
	    }

	    //@Override
	    public void manageNotification(boolean connectionEnabled) {

	        TextView textView = (TextView) findViewById(R.id.description_text); 
	        textView.setText(connectionEnabled ? "Enabled" : "Disabled");
	    }

	    @Override
	    protected void onPause() {
	        super.onPause();
	        LiveConnectivityManager.singleton(this).removeObserver(this);
	    }

    **/

}
