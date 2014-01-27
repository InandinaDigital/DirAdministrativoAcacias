package com.andres.u.ing.autocompletar;



import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Autocompletar extends Activity implements OnClickListener,OnChildClickListener{

	TextView texto, secre,dir;
	AutoCompleteTextView completar;
	ExpandableListView elv;
	ImageButton boton;
	Typeface font;
	String[] busqueda = {"certificados", "planeacion", "concejales", "predial", "secretaria","TIC", "Internet", "Digital", "Tecnología", "Acacias Vive Digital","GEL", "Gobierno en Linea", "Sysman", "Sistema de Informacion","Jefe Sistemas"};
	
	private ProgressDialog dialog;
	 //ProgressThread s = new ProgressThread();

    private static final int DIALOG2_KEY = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_autocompletar);
		
		texto = (TextView) findViewById(R.id.tvTexto);
		secre = (TextView) findViewById(R.id.tvSecretaria);
		dir = (TextView) findViewById(R.id.tvDirectorio);
		completar = (AutoCompleteTextView)findViewById(R.id.acAuto);
		//Método para ocultar el teclado
		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(completar.getWindowToken(), 0);
		//
		boton = (ImageButton) findViewById(R.id.btBuscar); 
		
		font = Typeface.createFromAsset(getAssets(), "davis.ttf");
		dir.setTypeface(font);
		
		 elv = (ExpandableListView) findViewById(R.id.exl);
		 
		 elv.setAdapter(new Adaptador(this));
		 elv.setOnChildClickListener(this);
		
		ArrayAdapter<String> lista = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, busqueda);
		completar.setAdapter(lista);
		
		boton.setOnClickListener(this);
		secre.setOnClickListener(this);
		completar.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()){
		
		case R.id.acAuto:
			
			elv.setVisibility(View.INVISIBLE);
			
			break;
		
		case R.id.tvSecretaria:
			
			elv.setVisibility(View.VISIBLE);
			
			break;
		
		
		case R.id.btBuscar:
			
		Dialog dialo = new Dialog(this);
		TextView t = new TextView (this);
		
		//Método para ocultar el teclado
		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(completar.getWindowToken(), 0);
		//
		
		 if(completar.getText().toString().equals("")){
				//dialo.setTitle("Busqueda");
			    //t.setTextColor(Color.WHITE);
				//t.setText("Campos vacios");
				//dialo.setContentView(t);
				//dialo.show();
			 
			 Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show();
			 
			}
		 
		 
		 else if(!completar.getText().toString().equals("")){
		
		dialog = ProgressDialog.show(this, "Buscando", "Por favor espere");
	
		
		
		
		Thread th = new Thread(new Runnable(){

			
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
					if(completar.getText().toString().equals("TIC") || completar.getText().toString().equals("Internet") || completar.getText().toString().equals("Digital") || completar.getText().toString().equals("Tecnología") || completar.getText().toString().equals("Acacias Vive Digital") || completar.getText().toString().equals("GEL") || completar.getText().toString().equals("Gobierno en Línea") || completar.getText().toString().equals("Sysman") || completar.getText().toString().equals("Sistema de Informacion")  || completar.getText().toString().equals("Jefe Sistemas")){
						
						
						ProgressThread();
						
					}
					

					else if(completar.getText().toString().equals("concejales")){
						
						
						ProgressThread2 ();			
					}
					
					else if(completar.getText().toString().equals("predial")){
						
						
						ProgressThread ();			
					}
					
					else{
					 if(!completar.getText().toString().equals(busqueda))
					ProgressThread3();
					 
				 }
	
		}
	
		});
	
		th.start();
		 }
		 
		}
	}
	
	
	@Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG2_KEY: {
                dialog = new ProgressDialog(this);
                dialog.setMessage("Please wait while loading...");
                return dialog;
            }
        }
        return null;
    }

	
	private int ProgressThread (){
		
				
				try {
					Thread.sleep(3000);
					dialog.dismiss();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{

					startActivity(new Intent("com.andres.u.ing.autocompletar.pagina2"));
				}
			return 2000;
			}
	
	
	private int ProgressThread2 (){
		
		
		try {
			Thread.sleep(3000);
			dialog.dismiss();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			startActivity(new Intent("com.andres.u.ing.autocompletar.pagina3"));
		}
	return 2000;
	
	
	}  
	
        private int ProgressThread3 (){
		
		
		try {
			Thread.sleep(3000);
			dialog.dismiss();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			startActivity(new Intent("com.andres.u.ing.autocompletar.conoce"));
		}
	return 2000;
	
	
	}
        
        
        public class Adaptador extends BaseExpandableListAdapter {

        	
        	Context contexto;
        	String[] padre = {"Administrativa y Financiera"};
            String[][] hijos ={
        			
        	   {"-Martín Dario Vega    CIO","-Didier Castro   Ingeniero TI ", "-Ernesto Pineda     Jefe Sistemas"}
        	  
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
        		t.setTextColor(Color.BLACK);
        		t.setTextSize(17);
        		
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
        		t.setTextColor(Color.BLACK);
        		t.setTextSize(17);
        		
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
		public boolean onChildClick(ExpandableListView parent, View v,
				int groupPosition, int childPosition, long id) {
			// TODO Auto-generated method stub
			
			if(groupPosition == 0 && childPosition == 0){
				Intent i = new Intent(this,Pagina3.class);
				startActivity(i);
		    	}
			
			if(groupPosition == 0 && childPosition == 1){
				Intent i = new Intent(this,PaginaDidier.class);
				startActivity(i);
		    	}
			if(groupPosition == 0 && childPosition == 2){
				Intent i = new Intent(this,PaginaErnesto.class);   
				startActivity(i);
		    	}
			
			return false;
		}
      
}
		


