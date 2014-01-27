package com.andres.u.ing.autocompletar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class PaginaDidier extends Activity implements OnClickListener {

	ImageButton ib,ib2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pagina_didier);
		
		ib = (ImageButton) findViewById(R.id.imageButton2);
		ib2 = (ImageButton) findViewById(R.id.imageButton3);
		ib.setOnClickListener(this);
		ib2.setOnClickListener(this);
		
	}

	/**@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
		
		Intent i = new Intent(this, ViewActivity.class);
		startActivity(i);
		finish();
	}**/
	
	/**@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.autocompletar, menu);
		
		return true;
	}**/


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId()){
		
		case R.id.itHome:
		
          Intent i = new Intent(this,ViewActivity.class);
          startActivity(i);
          finish();
			
			break;
			
		
		}
		
		return false;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		  
		case R.id.imageButton3:
			
			Intent i = new Intent(this,Pagina3.class);
			startActivity(i);
			finish();
			
			
			break;
			
		case R.id.imageButton2:
			
			Intent is = new Intent(this,PaginaErnesto.class);
			startActivity(is);
			finish();
			
			break;
		
		}
		
	}

	

}
