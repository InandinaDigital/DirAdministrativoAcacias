package gov.co.acaciasmeta.directorioacacias;



import gov.co.acaciasmeta.adaptadores.ItemAdapter;
import gov.co.acaciasmeta.clases.Item;

import java.util.ArrayList;
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
import android.widget.ImageView;
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
				
				ImageView ivNombre= (ImageView) v.findViewById(R.id.ivNombre);
				ImageView ivCargo= (ImageView) v.findViewById(R.id.ivCargo);
				ImageView ivServicio= (ImageView) v.findViewById(R.id.ivServicio);
				ImageView ivSecretaria= (ImageView) v.findViewById(R.id.ivSecretaria);
              
				ivNombre.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						pasarActividad(1);
					}

					
				});
				
				ivCargo.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						pasarActividad(2);
					}

					
				});
				
				ivSecretaria.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						pasarActividad(3);
					}

					
				});
				
				ivServicio.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						pasarActividad(4);
					}

					
				});
				
				
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

		private void pasarActividad(int l) {
			Intent intent=new Intent(getApplicationContext(), Hipoteca.class);
			intent.putExtra("numLista", l);
			startActivity(intent);
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

	@Override
	public boolean onChildClick(ExpandableListView arg0, View arg1, int arg2,
			int arg3, long arg4) {
		// TODO Auto-generated method stub
		return false;
	}

}
