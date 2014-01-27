package com.andres.u.ing.autocompletar;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewClient extends WebViewClient {
	
	public boolean shouldOverrideUrlLading(WebView v, String url){
		
		v.loadUrl(url);
		
		return true;
	}

}
