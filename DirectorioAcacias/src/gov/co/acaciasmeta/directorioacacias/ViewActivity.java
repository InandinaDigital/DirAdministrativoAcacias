package gov.co.acaciasmeta.directorioacacias;



import gov.co.acaciasmeta.adaptadores.ItemAdapter;
import gov.co.acaciasmeta.clases.Item;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.TextView;

public class ViewActivity extends ActionBarActivity implements OnChildClickListener, OnItemClickListener {

	ViewPager vp;
	private vpAdapter miAdapter;	
	Typeface font;
	String nombre;
	String secretaria;
	String oficina;
	String cargo;
	String modalidad;
	String email;
	String twitter;
	String facebook;
	String youtube;
	//String paginaweb = "www.acacias-meta.gov.co";
	String celular;
	String whatsapp;
	String tel_fijo;
	String extension;
	String linea;
	String atencion;
	String horario;
	String tramite;
	
	//En lace al chat http://www.acacias-meta.gov.co/chat/
	 private DrawerLayout mDrawer;
	 private ListView mDrawerOptions;
	 //private static final String[] values = {"Facebook", "Twitter", "Youtube"};
	
	

	String[] busqueda = { "certificados", "planeacion", "concejales",
			"predial", "secretaria", "TIC", "Internet", "Digital",
			"Tecnología", "Acacias Vive Digital", "GEL", "Gobierno en Linea",
			"Sysman", "Sistema de Informacion", "Jefe Sistemas" };

	private ProgressDialog dialog;
	private ActionBarDrawerToggle mToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		//getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		//getActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		mDrawerOptions = (ListView) findViewById(R.id.left_drawer);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        
        //mDrawerOptions.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values));
        mDrawerOptions.setOnItemClickListener(this);
        
        
        
        font = Typeface.createFromAsset(getAssets(), "lauwrites.ttf");
        
        ArrayList<Item> items = new ArrayList<Item>();
        
        items.add(new Item("",R.drawable.facebook));
        
        items.add(new Item("",R.drawable.twitter2));
        
        items.add(new Item("",R.drawable.youtube_icon)); 
        
        items.add(new Item("",R.drawable.chrome2));
   
        // Sets the data behind this ListView
        this.mDrawerOptions.setAdapter(new ItemAdapter(this, items));
        
       
        
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawer,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
                ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
            	getSupportActionBar().setTitle("Alcaldía");
               // getSupportActionBar().setIcon(R.drawable.ic_drawer2);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
            	getSupportActionBar().setTitle("Síguenos");
            	//getSupportActionBar().setIcon(R.drawable.ic_drawer);
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawer.setDrawerListener(mToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
       // getSupportActionBar().setIcon(R.drawable.ic_drawer2);
        	

		vp = (ViewPager) findViewById(R.id.viewpager);
		miAdapter = new vpAdapter();
		vp.setAdapter(miAdapter);
	
		//onBackPressed();
	}
	
	
	
	 @Override
	public void onBackPressed() {
		// TODO Auto-generated method stub

				
		new AlertDialog.Builder(this)
		.setTitle("Alcaldía")
		.setMessage("   ¿Deseas cerrar la aplicación?")
		.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
			

			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		})
		
		.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			}
		}).show();
		
	}

	@Override
	    protected void onPostCreate(Bundle savedInstanceState) {
	        super.onPostCreate(savedInstanceState);
	        // Sync the toggle state after onRestoreInstanceState has occurred.
	        mToggle.syncState();
	    }
	 
	 @Override
	    public void onConfigurationChanged(Configuration newConfig) {
	        super.onConfigurationChanged(newConfig);
	        mToggle.onConfigurationChanged(newConfig);
	    }
	
	
	@Override
		public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
		   // Toast.makeText(this, "Pulsado " + values[i], Toast.LENGTH_SHORT).show();
		    //mDrawer.closeDrawers();
		    
		    if(i==0){
		    	
		    	String face = "https://www.facebook.com/AlcaldiaAcacias?fref=ts";
		    	
		    	Intent ifa = new Intent(ViewActivity.this,WebView1.class);
		    	ifa.putExtra("facebook",face);
		    	startActivity(ifa);
		    	finish();
		    	
		    }
		    
		    if(i==1){
		    	
		    	
		    	String twi = "https://twitter.com/alcaldiaAcacias";
		    	
		    	Intent ifa = new Intent(ViewActivity.this,WebView1.class);
		    	ifa.putExtra("facebook",twi);
		    	startActivity(ifa);
		    	finish();
		    	
		    }
		    
		    if(i==2){
		    	
		    	String you = "http://www.youtube.com/user/AlcaldiaAcacias";
		    	
		    	Intent ifa = new Intent(ViewActivity.this,WebView1.class);
		    	ifa.putExtra("facebook", you);
		    	startActivity(ifa);
		    	finish();
		    }
		    
		    
		    	if(i==3){
		    	
		    	String twi = "http://www.acacias-meta.gov.co";
		    	
		    	Intent ifa = new Intent(ViewActivity.this,WebView1.class);
		    	ifa.putExtra("facebook", twi);
		    	startActivity(ifa);
		    	finish();
		    }
		    
		}
	

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}



	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}



	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}



	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}



	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		// TODO Auto-generated method stub
		
		
		
		
		
		if (groupPosition == 0 && childPosition == 0) {
			
			 nombre = "Martín Dario Vega Marquez";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Acacias Vive Digital";
			 cargo = "Cio";
			 modalidad = "Contratista";
			 email = "cio@acacias.gov.co";
			 twitter = "@MartinVegaM";
			 facebook = "Llanerodigital";
			 youtube = "Llanerodigital";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "3115279477";
			 whatsapp = "3115279477";
			 tel_fijo = "6569997";
			 extension = "122";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			
			Intent i = new Intent(this, Pagina3.class);
			i.putExtra("nombre", nombre);
			i.putExtra("secretaria", secretaria);
			i.putExtra("oficina", oficina);
			i.putExtra("cargo", cargo);
			i.putExtra("modalidad", modalidad);
			i.putExtra("email", email);
			i.putExtra("twitter", twitter);
			i.putExtra("facebook", facebook);
			i.putExtra("youtube", youtube);
			//i.putExtra("paginaweb", paginaweb);
			i.putExtra("celular", celular);
			i.putExtra("whatsapp", whatsapp);
			i.putExtra("tel_fijo", tel_fijo);
			i.putExtra("extension", extension);
			i.putExtra("linea", linea);
			i.putExtra("atencion", atencion);
			i.putExtra("horario", horario);
			i.putExtra("tramite", tramite);
			startActivity(i);
			
			
		}

		if (groupPosition == 0 && childPosition == 1) {
		
			 nombre = "Didier Ahimelec Castro Castro";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Acacias Vive Digital";
			 cargo = "Ingeniero TI";
			 modalidad = "Contratista";
			 email = "didier.castro@acacias.gov.co";
			 twitter = "";
			 facebook = "AlcaldiaAcacias";
			 youtube = "AlcaldiaAcacias";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "3115472532";
			 whatsapp = "3115472532";
			 tel_fijo = "6569061";
			 extension = "106";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			
			
			Intent i = new Intent(this, Pagina3.class);
			i.putExtra("nombre", nombre);
			i.putExtra("secretaria", secretaria);
			i.putExtra("oficina", oficina);
			i.putExtra("cargo", cargo);
			i.putExtra("modalidad", modalidad);
			i.putExtra("email", email);
			i.putExtra("twitter", twitter);
			i.putExtra("facebook", facebook);
			i.putExtra("youtube", youtube);
			//i.putExtra("paginaweb", paginaweb);
			i.putExtra("celular", celular);
			i.putExtra("whatsapp", whatsapp);
			i.putExtra("tel_fijo", tel_fijo);
			i.putExtra("extension", extension);
			i.putExtra("linea", linea);
			i.putExtra("atencion", atencion);
			i.putExtra("horario", horario);
			i.putExtra("tramite", tramite);
			startActivity(i);
			
			
		}
		if (groupPosition == 0 && childPosition == 2) {
			
			 nombre = "Ernesto Pineda Dueñas";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Sistemas";
			 cargo = "Jefe de Sistemas";
			 modalidad = "Nomina";
			 email = "sistemas@acacias-meta.gov.co";
			 twitter = "@sistemas50006";
			 facebook = "AlcaldiaAcacias";
			 youtube = "AlcaldiaAcacias";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "3214904885";
			 whatsapp = "3214904885";
			 tel_fijo = "6569061";
			 extension = "106";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "Novedades impuesto predial, Estrategia Acacias Vive Digital";
			
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
			
		}
		
		
		if (groupPosition == 0 && childPosition == 3) {
			
			 nombre = "Leidy Tatiana López Urrego";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Almacén Municipal";
			 cargo = "Profesional";
			 modalidad = "Empleado Público";
			 email = "almacen@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "6569061";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "Entradas de almacen,Salidas de almacen";
			 
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);	
		}
		
		if (groupPosition == 0 && childPosition == 4) {
			
			nombre = "Luis Enrique Amaya Porras";
			 secretaria = "Administrativa y Financiera";
			 oficina = "";
			 cargo = "Celador";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);	
			 
		}
		
		if (groupPosition == 0 && childPosition == 5) {
			
			
			 nombre = "Raúl Herrera Castro";
			 secretaria = "Administrativa y Financiera";
			 oficina = "";
			 cargo = "Celador";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);		 
		}
		
		if (groupPosition == 0 && childPosition == 6) {
			
			
			nombre = "Hemel Eslava Mosquera";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Tesorería";
			 cargo = "Auxiliar";
			 modalidad = "Empleado Público";
			 email = "hemel.eslava@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);		
		}

		if (groupPosition == 0 && childPosition == 7) {
			
			 nombre = "Juan de Jesus Huintaco Rozo";
			 secretaria = "Administrativa y Financiera";
			 oficina = "";
			 cargo = "Celador";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);	
		}
		
		if (groupPosition == 0 && childPosition == 8) {
			
			 nombre = "Omar Fernando Castro Borja";
			 secretaria = "Administrativa y Financiera";
			 oficina = "";
			 cargo = "Conductor";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 0 && childPosition == 9) {
			
			 nombre = "Armando Cabrera Calderón";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Contabilidad";
			 cargo = "Profesional Universitario";
			 modalidad = "Empleado Público";
			 email = "contador@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		if (groupPosition == 0 && childPosition == 10) {
			
			 nombre = "Maria Ines Suarez Palacios";
			 secretaria = "Administrativa y Financiera";
			 oficina = "";
			 cargo = "Auxiliar de Servicios";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		if (groupPosition == 0 && childPosition == 11) {
			
			nombre = "Teresa de Jesus Sandoval Rodríguez";
			 secretaria = "Administrativa y Financiera";
			 oficina = "";
			 cargo = "Auxiliar de Servicios";
			 modalidad = "Empleado Público";
			 email = "correspondencia@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "6569109";
			 extension = "131";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 0 && childPosition == 12) {
			
			 nombre = "Cecilia Melo García";
			 secretaria = "Administrativa y Financiera";
			 oficina = "";
			 cargo = "Secretario";
			 modalidad = "Empleado Público";
			 email = "cecilia.melo@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "6569109";
			 extension = "131";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 0 && childPosition == 13) {
			
			 nombre = "Maria Nelly Saray Céspedes";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Recaudo";
			 cargo = "Auxiliar";
			 modalidad = "Empleado Público";
			 email = "fiscalizacion@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 0 && childPosition == 14) {
			
			 nombre = "Carmen Elisa Páez Pachón";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Recaudo";
			 cargo = "Auxiliar";
			 modalidad = "Empleado Público";
			 email = "carmen.paez@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 0 && childPosition == 15) {
			
			 nombre = "Blanca Cecilia Pinilla Melo";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Recaudo";
			 cargo = "Auxiliar de Servicios";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 0 && childPosition == 16) {
			
			 nombre = "Zonia Esperanza Mora Arias";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Tesorería";
			 cargo = "Tesorero General";
			 modalidad = "Empleado Público";
			 email = "tesorero@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 0 && childPosition == 17) {
			
			 nombre = "Eulalia Marín Franco";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Archivo";
			 cargo = "Profesional";
			 modalidad = "Empleado Público";
			 email = "archivo@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 0 && childPosition == 18) {
			
			 nombre = "Luz Mila Cubillos Silvestre";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Tesorería";
			 cargo = "Secretario Ejecutivo";
			 modalidad = "Empleado Público";
			 email = "mila.cubillos@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 0 && childPosition == 19) {
			
			 nombre = "Olga Lucía Olarte Morales";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Recaudo";
			 cargo = "Secretario";
			 modalidad = "Empleado Público";
			 email = "olga.olarte@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 0 && childPosition == 20) {
			
			 nombre = "Nelcy Rocío Bedoya Caicedo";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Recurso Humano";
			 cargo = "Profesional";
			 modalidad = "Empleado Público";
			 email = "recursohumano@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 0 && childPosition == 21) {
			
			 nombre = "Lilia Garzón";
			 secretaria = "Administrativa y Financiera";
			 oficina = "";
			 cargo = "Auxiliar de Servicios";
			 modalidad = "Empleado Público";
			 email = "recursohumano@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 0 && childPosition == 22) {
			
			 nombre = "Marlene Acosta Lara";
			 secretaria = "Administrativa y Financiera";
			 oficina = "";
			 cargo = "Auxiliar de Servicios";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 0 && childPosition == 23) {
			
			 nombre = "Maria Eugenia Reina páez";
			 secretaria = "Administrativa y Financiera";
			 oficina = "";
			 cargo = "Ayudante";
			 modalidad = "Empleado Público";
			 email = "maria.reina@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 0 && childPosition == 24) {
			
			 nombre = "Victor Julio Alvarez Cascante";
			 secretaria = "Administrativa y Financiera";
			 oficina = "";
			 cargo = "Celador";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 0 && childPosition == 25) {
			
			 nombre = "Leidy Yhasmin Noguera Meneses";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Secretario de Despacho";
			 cargo = "Director Operativo";
			 modalidad = "Empleado Público";
			 email = "proteccion@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 0 && childPosition == 26) {
			
			 nombre = "Jaidy Elaika Nieto";
			 secretaria = "Administrativa y Financiera";
			 oficina = "Secretario de Despacho";
			 cargo = "Sec. Administrativo y Fro.";
			 modalidad = "Empleado Público";
			 email = "financiera@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "6569997";
			 extension = "122";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 0 && childPosition == 27) {
			
			 nombre = "Lucy Yolanda Guerrero Reyes";
			 secretaria = "Administrativa y Financiera";
			 oficina = "";
			 cargo = "Auxiliar Adminitrativo";
			 modalidad = "Empleado Público";
			 email = "yolanda.guerrero@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 1 && childPosition == 0) {
			
			 nombre = "Silvio Eduardo Calderón Rodríguez";
			 secretaria = "Fomento";
			 oficina = "";
			 cargo = "Profesional";
			 modalidad = "Empleado Público";
			 email = "silvio.calderon@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 1 && childPosition == 1) {
			
			 nombre = "Wilmer Mena Peña";
			 secretaria = "Fomento";
			 oficina = "";
			 cargo = "Profesional";
			 modalidad = "Empleado Público";
			 email = "wilmer.mena@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 1 && childPosition == 2) {
			
			 nombre = "Ana Ligia Nieto González";
			 secretaria = "Fomento";
			 oficina = "";
			 cargo = "Secretario";
			 modalidad = "Empleado Público";
			 email = "ligia.nieto@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "6569997";
			 extension = "122";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 1 && childPosition == 3) {
			
			 nombre = "Marcela Patricia Bonilla Gutierrez";
			 secretaria = "Fomento";
			 oficina = "Secretario de Despacho";
			 cargo = "Secretario de Fomento y\nDesarrollo";
			 modalidad = "Empleado Público";
			 email = "fomento@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "6569997";
			 extension = "122";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 2 && childPosition == 0) {
			
			 nombre = "Humberto Alvarez Romero";
			 secretaria = "Infraestructura";
			 oficina = "";
			 cargo = "Auxiliar Administrativo";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "6569997";
			 extension = "122";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 2 && childPosition == 1) {
			
			 nombre = "Hernando Cagueño Cabrera";
			 secretaria = "Infraestructura";
			 oficina = "";
			 cargo = "Operario";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 2 && childPosition == 2) {
			
			 nombre = "Carlos Arturo Ortiz Rojas";
			 secretaria = "Infraestructura";
			 oficina = "";
			 cargo = "Conductor";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 2 && childPosition == 3) {
			
			 nombre = "Jaideir Hernán Romero Blandón";
			 secretaria = "Infraestructura";
			 oficina = "";
			 cargo = "Operario";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}

		if (groupPosition == 2 && childPosition == 4) {
			
			 nombre = "Bernardino Romero Rincón";
			 secretaria = "Infraestructura";
			 oficina = "";
			 cargo = "Operario";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 2 && childPosition == 5) {
			
			 nombre = "John Jairo Restrepo Ladino";
			 secretaria = "Infraestructura";
			 oficina = "";
			 cargo = "Profesional Universitario";
			 modalidad = "Empleado Público";
			 email = "jhon.restrepo@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 2 && childPosition == 6) {
			
			 nombre = "Armando Gomez";
			 secretaria = "Infraestructura";
			 oficina = "";
			 cargo = "Conductor";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 2 && childPosition == 7) {
			
			 nombre = "Martín Antonio Pérez Romero";
			 secretaria = "Infraestructura";
			 oficina = "";
			 cargo = "Conductor";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 2 && childPosition == 8) {
			
			 nombre = "Eudolina Romero Pérez";
			 secretaria = "Infraestructura";
			 oficina = "";
			 cargo = "Auxiliar";
			 modalidad = "Empleado Público";
			 email = "lina.romero@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 2 && childPosition == 9) {
			
			 nombre = "Rafael Fernando Parra Tolosa";
			 secretaria = "Infraestructura";
			 oficina = "";
			 cargo = "Profesional Universitario";
			 modalidad = "Empleado Público";
			 email = "rafael.parra@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 2 && childPosition == 10) {
			
			 nombre = "Jimmy Andrés Torres Castro";
			 secretaria = "Infraestructura";
			 oficina = "Secretario de Despacho";
			 cargo = "Secre. de Obras Públicos";
			 modalidad = "Empleado Público";
			 email = "infraestructura@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 3 && childPosition == 0) {
			
			 nombre = "Jairo Humberto Lozano Hernández";
			 secretaria = "Educación";
			 oficina = "Deportes";
			 cargo = "Técnico";
			 modalidad = "Empleado Público";
			 email = "deportes@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 3 && childPosition == 1) {
			
			 nombre = "Omar Hernán Guarnizo Clavijo";
			 secretaria = "Educación";
			 oficina = "";
			 cargo = "Técnico";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 3 && childPosition == 2) {
			
			 nombre = "Ximena Sarai Pastas Bustos";
			 secretaria = "Educación";
			 oficina = "";
			 cargo = "Auxiliar Administrativo";
			 modalidad = "Empleado Público";
			 email = "ximena.pastas@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 3 && childPosition == 3) {
			
			 nombre = "Hilda Janeth Rozo Gutierrez";
			 secretaria = "Educación";
			 oficina = "";
			 cargo = "Auxiliar Administrativo";
			 modalidad = "Empleado Público";
			 email = "ximena.pastas@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 3 && childPosition == 4) {
			
			 nombre = "Angélica María Correal Rico";
			 secretaria = "Educación";
			 oficina = "";
			 cargo = "Profesional Universitario";
			 modalidad = "Empleado Público";
			 email = "biblioteca@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 4 && childPosition == 0) {
			
			 nombre = "Arcenio Vargas Álvarez";
			 secretaria = "Despacho";
			 oficina = "Despacho Alcalde";
			 cargo = "Alcalde";
			 modalidad = "Empleado Público";
			 email = "alcaldia@acacias-meta.gov.co";
			 twitter = "@ArcenioVargas";
			 facebook = "AlcaldiaAcacias";
			 youtube = "AlcaldiaAcacias";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "6569939";
			 extension = "101";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 4 && childPosition == 1) {
			
			 nombre = "Rosa María Díaz Maldonado";
			 secretaria = "Despacho";
			 oficina = "Despacho Alcalde";
			 cargo = "Secretario Ejecutivo";
			 modalidad = "Empleado Público";
			 email = "rosa.diaz@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "3214904883";
			 whatsapp = "3214904883";
			 tel_fijo = "6569939";
			 extension = "101";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 4 && childPosition == 2) {
			
			 nombre = "Melba Yulieth Correal Baquero";
			 secretaria = "Despacho";
			 oficina = "";
			 cargo = "Auxiliar";
			 modalidad = "Empleado Público";
			 email = "melba.correal@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 4 && childPosition == 3) {
			
			 nombre = "María Cristina Gutierrez Candamil";
			 secretaria = "Despacho";
			 oficina = "Despacho";
			 cargo = "Profesional Universitario";
			 modalidad = "Empleado Público";
			 email = "sprivada@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 4 && childPosition == 4) {
			
			 nombre = "William Fernándo Rivera Pinzón";
			 secretaria = "Planeación";
			 oficina = "";
			 cargo = "Auxiliar";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 5 && childPosition == 0) {
			
			 nombre = "William Fernándo Rivera Pinzón";
			 secretaria = "Planeación";
			 oficina = "";
			 cargo = "Auxiliar";
			 modalidad = "Empleado Público";
			 email = "william.rivera@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 5 && childPosition == 1) {
			
			 nombre = "Doris Manrique Cabrera";
			 secretaria = "Planeación";
			 oficina = "Sisben";
			 cargo = "Técnico";
			 modalidad = "Empleado Público";
			 email = "tecsisben@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "6569109";
			 extension = "131";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "Sisben, Nivel, Puntaje Sisben";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 5 && childPosition == 2) {
			
			 nombre = "Diana Matilde Hernández Rojas";
			 secretaria = "Planeación";
			 oficina = "Urbanismo";
			 cargo = "Profesional";
			 modalidad = "Empleado Público";
			 email = "diana.hernandez@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 5 && childPosition == 3) {
			
			 nombre = "Heidy Cristina Baquero Parrado";
			 secretaria = "Planeación";
			 oficina = "";
			 cargo = "Profesional Universitario";
			 modalidad = "Empleado Público";
			 email = "heidy.baquero@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 5 && childPosition == 4) {
			
			 nombre = "Gerardo Ayala Castillo";
			 secretaria = "Planeación";
			 oficina = "Secretario de Despacho";
			 cargo = "Jefe Oficina Asesora";
			 modalidad = "Empleado Público";
			 email = "planeacion@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "Licencias, Construcción, Sisben, Estratificación";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 5 && childPosition == 5) {
			
			 nombre = "Camilo Javier Pineda Arevalo";
			 secretaria = "Planeación";
			 oficina = "";
			 cargo = "Profesional Universitario";
			 modalidad = "Empleado Público";
			 email = "bancodeproyectos@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 5 && childPosition == 6) {
			
			 nombre = "Omar Alejandro Rodríguez Pardo";
			 secretaria = "Planeación";
			 oficina = "";
			 cargo = "Profesional Universitario";
			 modalidad = "Empleado Público";
			 email = "bancodeinformacion@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "Estratificación";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 5 && childPosition == 7) {
			
			 nombre = "Jhon Henry Orjuela Gamba";
			 secretaria = "Planeación";
			 oficina = "";
			 cargo = "Técnico";
			 modalidad = "Empleado Público";
			 email = "jhon.orjuela@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 6 && childPosition == 0) {
			
			 nombre = "Nixon Frey Pérez Montero";
			 secretaria = "Gobierno";
			 oficina = "Secretaria de Despacho";
			 cargo = "Secretario de Gobierno";
			 modalidad = "Empleado Público";
			 email = "gobierno@acacias-meta.gov.co";
			 twitter = "@gobierno50006";
			 facebook = "Gobierno Acacías";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "Certificado residencia, Víctimas de la violencia, Desplazados";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 6 && childPosition == 1) {
			
			 nombre = "Esperanza Cañon Moreno";
			 secretaria = "Gobierno";
			 oficina = "Comisaría de Familia";
			 cargo = "Comisario de Familia";
			 modalidad = "Empleado Público";
			 email = "esperanza.canon@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 6 && childPosition == 2) {
			
			 nombre = "Beatriz Rojas Álvarez";
			 secretaria = "Gobierno";
			 oficina = "";
			 cargo = "Auxiliar";
			 modalidad = "Empleado Público";
			 email = "beatriz.rojas@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 6 && childPosition == 3) {
			
			 nombre = "Naydu Infante Sierra";
			 secretaria = "Gobierno";
			 oficina = "";
			 cargo = "Secretario";
			 modalidad = "Empleado Público";
			 email = "naydu.infante@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 6 && childPosition == 4) {
			
			 nombre = "Roberto Baquero Jimenez";
			 secretaria = "Gobierno";
			 oficina = "";
			 cargo = "Auxiliar";
			 modalidad = "Empleado Público";
			 email = "roberto.baquero@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 6 && childPosition == 5) {
			
			 nombre = "Germán Quevedo Gutierrez";
			 secretaria = "Gobierno";
			 oficina = "";
			 cargo = "Auxiliar Administrativo";
			 modalidad = "Empleado Público";
			 email = "german.quevedo@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 6 && childPosition == 6) {
			
			 nombre = "Sandra Milena Abello Ramos";
			 secretaria = "Gobierno";
			 oficina = "";
			 cargo = "Auxiliar";
			 modalidad = "Empleado Público";
			 email = "sandra.abello@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 6 && childPosition == 7) {
			
			 nombre = "Luz Myriam Rios Gutierrez";
			 secretaria = "Gobierno";
			 oficina = "";
			 cargo = "Inspector de Policía";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		
		if (groupPosition == 6 && childPosition == 8) {
			
			 nombre = "Nelson Rodríguez Valencia";
			 secretaria = "Gobierno";
			 oficina = "";
			 cargo = "Profesional Universitario";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 7 && childPosition == 0) {
			
			 nombre = "Myriam Celis Figueroa";
			 secretaria = "Contratación";
			 oficina = "Doac";
			 cargo = "Secretario";
			 modalidad = "Empleado Público";
			 email = "myriam.celis@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 7 && childPosition == 1) {
			
			 nombre = "Gustavo Adolfo salazar Saddy";
			 secretaria = "Contratación";
			 oficina = "Secretario de Despacho";
			 cargo = "Director Operativo";
			 modalidad = "Empleado Público";
			 email = "contratacion@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		
		if (groupPosition == 7 && childPosition == 2) {
			
			 nombre = "Oscar Eduardo Arias Tabares";
			 secretaria = "Contratación";
			 oficina = "";
			 cargo = "Asesor";
			 modalidad = "Empleado Público";
			 email = "oscar.arias@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		
		if (groupPosition == 8 && childPosition == 0) {
			
			 nombre = "Luz Marina Bolivar Calderón";
			 secretaria = "Protección";
			 oficina = "";
			 cargo = "Auxiliar";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 9 && childPosition == 0) {
			
			 nombre = "Elsy Evangelina Valenzuela Marín";
			 secretaria = "Jurídica";
			 oficina = "";
			 cargo = "Auxiliar";
			 modalidad = "Empleado Público";
			 email = "elsy.valenzuela@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 9 && childPosition == 1) {
			
			 nombre = "Roger Alexander Acero Rojas";
			 secretaria = "Jurídica";
			 oficina = "Secretario de Despacho";
			 cargo = "Jefe Oficina Asesora";
			 modalidad = "Empleado Público";
			 email = "juridica@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		
		if (groupPosition == 10 && childPosition == 0) {
			
			 nombre = "Adriana María Hernández Parada";
			 secretaria = "Salud";
			 oficina = "";
			 cargo = "Profesional";
			 modalidad = "Empleado Público";
			 email = "adriana.hernandez@acacias.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 10 && childPosition == 1) {
			
			 nombre = "Jairo Humberto Vidales Mendez";
			 secretaria = "Salud";
			 oficina = "";
			 cargo = "Técnico";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 10 && childPosition == 2) {
			
			 nombre = "Nelson Gilberto Gutierrez Vaca";
			 secretaria = "Salud";
			 oficina = "secretario de Despacho";
			 cargo = "Secretario de Salud";
			 modalidad = "Empleado Público";
			 email = "salud@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		if (groupPosition == 10 && childPosition == 3) {
			
			 nombre = "Lida Aliria Rozo Ruiz";
			 secretaria = "Salud";
			 oficina = "";
			 cargo = "Auxiliar Administrativo";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 10 && childPosition == 4) {
			
			 nombre = "Elizabeth Mora Arias";
			 secretaria = "Salud";
			 oficina = "";
			 cargo = "Auxiliar";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 10 && childPosition == 5) {
			
			 nombre = "Digna Mercedes Rodríguez Castillo";
			 secretaria = "Salud";
			 oficina = "";
			 cargo = "Auxiliar Administrativo";
			 modalidad = "Empleado Público";
			 email = "mercedez.rodriguez@acacas.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 10 && childPosition == 6) {
			
			 nombre = "Martha Elena Pinzón Forero";
			 secretaria = "Salud";
			 oficina = "";
			 cargo = "Secretario";
			 modalidad = "Empleado Público";
			 email = "martha.pinzon@acacas.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 10 && childPosition == 7) {
			
			 nombre = "Marilu Ayala Martinez";
			 secretaria = "Salud";
			 oficina = "";
			 cargo = "Auxiliar";
			 modalidad = "Empleado Público";
			 email = "";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		if (groupPosition == 10 && childPosition == 8) {
			
			 nombre = "Sandra Patricia Quevedo Castro";
			 secretaria = "Salud";
			 oficina = "";
			 cargo = "Secretario";
			 modalidad = "Empleado Público";
			 email = "aseguramiento@acacias-meta.gov.co";
			 twitter = "";
			 facebook = "";
			 youtube = "";
			//String paginaweb = "www.acacias-meta.gov.co";
			 celular = "";
			 whatsapp = "";
			 tel_fijo = "";
			 extension = "";
			 linea = "018000 112996";
			 atencion = "Si";
			 horario = "Lunes a Viernes de 7:00 a.m. a 12:00 p.m. y 2:00 p.m. a 5:00 p.m";
			 tramite = "";
			 
			 Intent i = new Intent(this, Pagina3.class);
				i.putExtra("nombre", nombre);
				i.putExtra("secretaria", secretaria);
				i.putExtra("oficina", oficina);
				i.putExtra("cargo", cargo);
				i.putExtra("modalidad", modalidad);
				i.putExtra("email", email);
				i.putExtra("twitter", twitter);
				i.putExtra("facebook", facebook);
				i.putExtra("youtube", youtube);
				//i.putExtra("paginaweb", paginaweb);
				i.putExtra("celular", celular);
				i.putExtra("whatsapp", whatsapp);
				i.putExtra("tel_fijo", tel_fijo);
				i.putExtra("extension", extension);
				i.putExtra("linea", linea);
				i.putExtra("atencion", atencion);
				i.putExtra("horario", horario);
				i.putExtra("tramite", tramite);
				startActivity(i);
		}
		
		
		return false;
	}
	
	
	

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		super.onCreateOptionsMenu(menu);
	    getMenuInflater().inflate(R.menu.pagina3, menu);
	    
     	return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		 if (mToggle.onOptionsItemSelected(item)) {
	          return true;
	        }
		
		switch (item.getItemId()) {
			
		case R.id.iAjustes:
            
			ajutesMenu();
			
			break;
			
			
		case android.R.id.home:
			
		  if (mDrawer.isDrawerOpen(mDrawerOptions)){
		               
			  mDrawer.closeDrawers();
			
		  }else{
				mDrawer.openDrawer(mDrawerOptions);
		  }
		  return true;
		}
		return super.onOptionsItemSelected(item);
		
	}

	private void ajutesMenu() {
		new AlertDialog.Builder(this)
		.setTitle("Acerca")
		.setIcon(R.drawable.marca)
		.setMessage("Versión: 1.0\n\nPorque usar las TIC para facilitarle la vida al ciudadano...\nEs la Decisión Correcta.\n\nProyecto Aplicaciones móviles para Gobierno en Línea.\n\nDesarrollado por: Fundación Tsamani 'Para el desarrollo de una ciudad del conocimiento'\n\nDesarrollador:Andrés Urrego\nProyecto Talento Digital-Min TIC-Inandina\nTwitter: @AndresUrregoC\nSkype: andres.urrego.castro1\nFacebook: Andrés Urrego C\nCelular: 3208780677")
		.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
			

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		}).show();
		
	}




	private class vpAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view == ((LinearLayout) object);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			((ViewPager) container).removeView((LinearLayout) object);
		}

		@Override
		public void finishUpdate(ViewGroup container) {
			

		}

		@SuppressWarnings("deprecation")
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub

			LayoutInflater inflater = (LayoutInflater) container.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v = null;
			switch (position) {

			case 0:

				v = inflater.inflate(R.layout.activity_autocompletar, null);
                //ImageView im = (ImageView) v.findViewById(R.id.imageView1);//esta es la nueva imagen
				

              
				
				ImageButton bt = (ImageButton) v.findViewById(R.id.ibBuscar2);
				

				bt.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						Intent bu = new Intent (ViewActivity.this, Hipoteca.class);
						startActivity(bu);
					    finish();

					}
				});

				break;

			case 1:
                
				v = inflater.inflate(R.layout.paginatres, null);

			    final SlidingDrawer sd = (SlidingDrawer) v.findViewById(R.id.slidingDrawer1);
			    final Button btA = (Button) v.findViewById(R.id.handle);
			    final TextView tv1 = (TextView) v.findViewById(R.id.tvAsi);
			    final TextView tv2 = (TextView) v.findViewById(R.id.tvTexto);
			    final ListView lv = (ListView) v.findViewById(R.id.lvLista);
			    String datos[] = {"Administrativa y Financiera", "Fomento", "Despacho", "Gobierno", "Salud", "Contratación", "Infraestructura", "Jurídica", "Educación"};
			    ArrayAdapter <String> adapter = new ArrayAdapter<String>(ViewActivity.this, android.R.layout.simple_list_item_1, datos);
			    lv.setAdapter(adapter);    
			    
			    
			    lv.setOnItemClickListener(new OnItemClickListener() {
		            @Override
		            public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
		               if(posicion == 1){
		            	   tv1.setVisibility(View.VISIBLE);
		            	   sd.close();
		               }
		            }
		        });
			   
			    
			   btA.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(btA.getText().toString().equals("Cerrar")){
						sd.close();
					}else{
						sd.open();
					}
				}
			});
			   
			   
			   tv2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					sd.close();
					tv1.setVisibility(View.VISIBLE);
				}
			});
			    
			    
			    sd.setOnDrawerOpenListener(new OnDrawerOpenListener() {
					
					@Override
					public void onDrawerOpened() {
						// TODO Auto-generated method stub
						btA.setText("Cerrar");
					}
				});
			    
			    sd.setOnDrawerCloseListener(new OnDrawerCloseListener() {
					
					@Override
					public void onDrawerClosed() {
						// TODO Auto-generated method stub
						btA.setText("Secretarías aquí");
					}
				});

				break;
				
			

			}

			((ViewPager) container).addView(v, 0);
			return v;

		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void startUpdate(ViewGroup container) {
			// TODO Auto-generated method stub

		}

		private int ProgressThread() {

			try {
				Thread.sleep(3000);
				dialog.dismiss();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
                 
				Intent i = new Intent(ViewActivity.this,Hipoteca.class);
				
				startActivity(i);
			}
			return 2000;
		}

		private int ProgressThread2() {

			try {
				Thread.sleep(3000);
				dialog.dismiss();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				startActivity(new Intent(
						"com.andres.u.ing.autocompletar.pagina3"));
			}
			return 2000;

		}

		private int ProgressThread3() {

			try {
				Thread.sleep(3000);
				dialog.dismiss();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				startActivity(new Intent(
						"com.andres.u.ing.autocompletar.conoce"));
			}
			return 2000;

		}

	}

	public class Adaptador extends BaseExpandableListAdapter {

		Context contexto;
		String[] padre = {"Administrativa y Financiera","Fomento", "Infraestructura", "Educación", "Despacho", "Planeación", "Gobierno", "Contratación", "Protección", "Jurídica", "Salud"};
		String[][] hijos = {

		        { "-Martín Dario Vega    CIO", "-Didier Castro   Ingeniero TI ","-Ernesto Pineda     Jefe Sistemas", "-Leidy Tatiana López Urrego","-Luis Enrique Amaya Porras","-Raúl Herrera Castro","-Hemel Eslava Mosquera","-Juan de Jesus Huintaco Rozo","-Omar Fernando Castro Borja", "-Armando Cabrera Calderón","-Maria Ines Suarez Palacios","-Teresa de Jesus Sandoval Rodríguez","-Cecilia Melo García","-Maria Nelly Saray Céspedes","-Carmen Elisa Páez Pachón","-Blanca Cecilia Pinilla Melo","-Zonia Esperanza Mora Arias","-Eulalia Marín Franco","-Luz Mila Cubillos Silvestre", "-Olga Lucía Olarte Morales","-Nelcy Rocío Bedoya Caicedo","-Lilia Garzón", "-Marlene Acosta Lara", "-Maria Eugenia Reina páez", "-Victor Julio Alvarez Cascante", "-Leidy Yhasmin Noguera Meneses", "-Jaidy Elaika Nieto", "-Lucy Yolanda Guerrero Reyes" },
		        {"-Silvio Eduardo Calderón Rodríguez","-Wilmer Mena Peña","-Ana Ligia Nieto González", "-Marcela Patricia Bonilla Gutierrez"},
				{"-Humberto Alvarez Romero","-Hernando Cagueño Cabrera","-Carlos Arturo Ortiz Rojas","-Jaideir Hernán Romero Blandón", "-Bernardino Romero Rincón", "-John Jairo Restrepo Ladino","-Armando Gomez", "-Martín Antonio Pérez Romero", "-Eudolina Romero Pérez", "-Rafael Fernando Parra Tolosa","-Jimmy Andrés Torres Castro"},
				{"-Jairo Humberto Lozano Hernández", "-Omar Hernán Guarnizo Clavijo", "-Ximena Sarai Pastas Bustos","-Hilda Janeth Rozo Gutierrez","-Angélica María Correal Rico"},
				{"-Arcenio Vargas Álvarez", "-Rosa María Díaz Maldonado", "-Melba Yulieth Correal Baquero","-María Cristina Gutierrez Candamil","-Luz Neida Pinzón Baracaldo"},
				{"-William Fernándo Rivera Pinzón", "-Doris Manrique Cabrera","-Diana Matilde Hernández Rojas","-Heidy Cristina Baquero Parrado", "-Gerardo Ayala Castillo", "-Camilo Javier Pineda Arevalo",  "-Omar Alejandro Rodríguez Pardo", "-Jhon Henry Orjuela Gamba"},
				{"-Nixon Frey Pérez Montero", "-Esperanza Cañon Moreno", "-Beatriz Rojas Álvarez", "-Naydu Infante Sierra","-Roberto Baquero Jimenez","-Germán Quevedo Gutierrez", "-Sandra Milena Abello Ramos","-Luz Myriam Rios Gutierrez","-Nelson Rodríguez Valencia"},
				{"-Myriam Celis Figueroa","-Gustavo Adolfo salazar Saddy","-Oscar Eduardo Arias Tabares"},
				{"-Luz Marina Bolivar Calderón"},
				{"-Elsy Evangelina Valenzuela Marín","-Roger Alexander Acero Rojas"},
				{"-Adriana María Hernández Parada","-Jairo Humberto Vidales Mendez", "-Nelson Gilberto Gutierrez Vaca","-Lida Aliria Rozo Ruiz", "-Elizabeth Mora Arias", "-Digna Mercedes Rodríguez Castillo", "-Martha Elena Pinzón Forero", "-Marilu Ayala Martinez", "-Sandra Patricia Quevedo Castro"}

		};

		public Adaptador(Context context) {
			// TODO Auto-generated constructor stub

			this.contexto = context;

		}

		@Override
		public Object getChild(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			TextView t = new TextView(contexto);
			t.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			t.setPadding(50, 0, 0, 0);
			t.setText(hijos[groupPosition][childPosition]);
			t.setTextColor(Color.WHITE);
			t.setTextSize(20);

			return t;

		}

		@Override
		public int getChildrenCount(int groupPosition) {
			// TODO Auto-generated method stub
			return hijos[groupPosition].length;
		}

		@Override
		public Object getGroup(int groupPosition) {
			// TODO Auto-generated method stub
			return groupPosition;
		}

		@Override
		public int getGroupCount() {
			// TODO Auto-generated method stub
			return padre.length;
		}

		@Override
		public long getGroupId(int groupPosition) {
			// TODO Auto-generated method stub
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			TextView t = new TextView(contexto);
			t.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			t.setPadding(50, 0, 0, 0);
			t.setText(this.padre[groupPosition]);
			t.setTextColor(Color.rgb(0, 0, 0));
			t.setTextSize(25);

			return t;
		}

		@Override
		public boolean hasStableIds() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return true;  
		}

	}

}
