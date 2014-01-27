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

public class PaginaErnesto extends Activity implements OnClickListener {

	ImageButton ib;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pagina_ernesto);
		
		ib = (ImageButton) findViewById(R.id.imageButton4);
		ib.setOnClickListener(this);
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
		
		Intent i = new Intent(this,PaginaDidier.class);
		startActivity(i);
		finish();
	}

	
}
