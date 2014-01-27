package com.andres.u.ing.autocompletar;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Pagina2 extends Activity implements OnClickListener{

	TextView t,a,b,ti;
	Typeface font;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pagina2);
		
		t = (TextView) findViewById(R.id.tvPagina2);
		a = (TextView) findViewById(R.id.tvDidier);
		b = (TextView) findViewById(R.id.tvErnesto);
		ti = (TextView) findViewById(R.id.tvtitulo);
 		
		font = Typeface.createFromAsset(getAssets(), "COMICBD.TTF");
		
		
		ti.setText("Estas personas te pueden ayudar con lo que buscas o solicitas:");
		ti.setTypeface(font);
		
		t.setOnClickListener(this);
		a.setOnClickListener(this);
		b.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		
		case R.id.tvPagina2:
			
			Intent i = new Intent(this, Pagina3.class);
			startActivity(i);
			
			break;
			
		case R.id.tvDidier:
			
			Intent a = new Intent(this, PaginaDidier.class);
			startActivity(a);
			
			break;
			
		case R.id.tvErnesto:
			
			Intent b = new Intent(this, PaginaErnesto.class);
			startActivity(b);
			
			break;
			
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.autocompletar, menu);
		
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId()){
		
		case R.id.itHome:
		
          Intent i = new Intent(this,ViewActivity.class);
          startActivity(i);
			
			break;
			
		
		}
		
		return false;
	}


}
