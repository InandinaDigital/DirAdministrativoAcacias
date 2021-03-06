package gov.co.acaciasmeta.directorioacacias;


import gov.co.acaciasmeta.adaptadores.HipotecaCursorAdapter;
import gov.co.acaciasmeta.clases.HipotecaDbAdapter;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
 
public class Hipoteca extends ListActivity implements OnClickListener{
 

    Spinner sp;


	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
		
		Intent t = new Intent(this,ViewActivity.class);
		startActivity(t);
		t.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		finish();
		return;
	}


	public static final String C_MODO  = "modo" ;
	 public static final int C_VISUALIZAR = 551 ;
	 public static final int C_CREAR = 552 ;
	 public static final int C_EDITAR = 553 ;
	 public static final int C_ELIMINAR = 554 ;
	 
	
	 private static final String LOGTAG = "LogsAndroid";
	 
 
	private HipotecaDbAdapter dbAdapter;
    private Cursor cursor;
    private HipotecaCursorAdapter hipotecaAdapter ;
    private ListView lista;
    private EditText  txtPalabraBus;
    private Button buTodos;
    private ImageButton atras;
    private ImageButton bus;
    private ListActivity base=this;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_hipoteca);
       
        
       lista = (ListView) findViewById(android.R.id.list);
       bus = (ImageButton) findViewById(R.id.n1);
       buTodos = (Button) findViewById(R.id.todos);
       txtPalabraBus=(EditText)findViewById(R.id.palabra);
       sp = (Spinner) findViewById(R.id.spinner1);
       
       String valores[] = {"Selecciona una opc�on","Nombre","Cargo","Secretaria","Servicio y/o Tr�mite"};
       sp.setAdapter(new ArrayAdapter<String>(this, R.layout.textview_spinner, valores));
       sp.setSelection(getIntent().getIntExtra("numLista", 0));
       dbAdapter = new HipotecaDbAdapter(this);
       dbAdapter.abrir();
        
       consultar();
       
       
 
       
       //Log.e(LOGTAG,dbAdapter.consultarLista() );
       registerForContextMenu(this.getListView());
       //bus.setOnKeyListener(this);
      	
       
       
       bus.setOnClickListener(this);
       buTodos.setOnClickListener(this);
       
    txtPalabraBus.addTextChangedListener(new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			
		
		// TODO Auto-generated method stub
            String palabra=txtPalabraBus.getText().toString();
			
			Cursor c = dbAdapter.consultarLista(palabra);
			
			if(c!=null)
			{
				cursor=c;
				startManagingCursor(cursor);
			    hipotecaAdapter = new HipotecaCursorAdapter(base, cursor);
			    lista.setAdapter(hipotecaAdapter);
			
			}	
			
			
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			
			cursor = dbAdapter.getCursor();
		      startManagingCursor(cursor);
		      hipotecaAdapter = new HipotecaCursorAdapter(Hipoteca.this, cursor);
		      lista.setAdapter(hipotecaAdapter);
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			cursor = dbAdapter.getCursor();
		      startManagingCursor(cursor);
		      hipotecaAdapter = new HipotecaCursorAdapter(Hipoteca.this, cursor);
		      lista.setAdapter(hipotecaAdapter);
		}
	});	
    }
    
    
 
    
    


  private void consultar()
   {
      cursor = dbAdapter.getCursor();
      startManagingCursor(cursor);
      hipotecaAdapter = new HipotecaCursorAdapter(this, cursor);
      lista.setAdapter(hipotecaAdapter);
   }
 
//   @Override
 //  public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
   //   getMenuInflater().inflate(R.menu.hipoteca, menu);
    //  return true;
  // }
 
   //@Override
  // public boolean onMenuItemSelected(int featureId, MenuItem item)
   //{
     // Intent i;
       
     // switch (item.getItemId())
     // {
       //  case R.id.menu_crear:
       //     i = new Intent(Hipoteca.this, HipotecaFormulario.class);
         //   i.putExtra(C_MODO, C_CREAR);
          //  startActivityForResult(i, C_CREAR);
           // return true;
     // }
     // return super.onMenuItemSelected(featureId, item);
   //}
   
   void visualizar(long id)
   {
      // Llamamos a la Actividad HipotecaFormulario indicando el modo visualizaci�n y el identificador del registro
      Intent i = new Intent(Hipoteca.this, HipotecaFormulario.class);
      i.putExtra(C_MODO, C_VISUALIZAR);
      i.putExtra(HipotecaDbAdapter.C_COLUMNA_ID, id);
 
      startActivityForResult(i, C_VISUALIZAR);
   }
 
   @Override
   protected void onListItemClick(ListView l, View v, int position, long id)
   {
      super.onListItemClick(l, v, position, id);
 
      visualizar(id);
   }
   
   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data)
   {
      //
      // Nos aseguramos que es la petici�n que hemos realizado
      //
      switch(requestCode)
      {
         case C_CREAR:
            if (resultCode == RESULT_OK)
               consultar();
             
         case C_VISUALIZAR:
            if (resultCode == RESULT_OK)
               consultar();
             
         default:
            super.onActivityResult(requestCode, resultCode, data);
      }
   }
   
   
   private void borrar(final long id)
   {
      //
      // Borramos el registro y refrescamos la lista
      //
      AlertDialog.Builder dialogEliminar = new AlertDialog.Builder(this);
       
      dialogEliminar.setIcon(android.R.drawable.ic_dialog_alert);
      dialogEliminar.setTitle(getResources().getString(R.string.hipoteca_eliminar_titulo));
      dialogEliminar.setMessage(getResources().getString(R.string.hipoteca_eliminar_mensaje));
      dialogEliminar.setCancelable(false);
       
      dialogEliminar.setPositiveButton(getResources().getString(android.R.string.ok), new DialogInterface.OnClickListener() {
    
         public void onClick(DialogInterface dialog, int boton) {
            dbAdapter.delete(id);
            Toast.makeText(Hipoteca.this, R.string.hipoteca_eliminar_confirmacion, Toast.LENGTH_SHORT).show();
            consultar();            
         }
      });
       
      dialogEliminar.setNegativeButton(android.R.string.no, null);
       
      dialogEliminar.show();
   }
   
   @Override
   public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
      super.onCreateContextMenu(menu, v, menuInfo);
       
      menu.setHeaderTitle(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_NOMBRE)));
      menu.add(Menu.NONE, C_VISUALIZAR, Menu.NONE, R.string.menu_visualizar);
      menu.add(Menu.NONE, C_EDITAR, Menu.NONE, R.string.menu_editar);
      menu.add(Menu.NONE, C_ELIMINAR, Menu.NONE, R.string.menu_eliminar);
   }
   
   @Override
   public boolean onContextItemSelected(MenuItem item) {
       
      AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
      Intent i;
       
      switch(item.getItemId())
      {
         case C_ELIMINAR:
            borrar(info.id);
            return true;
          
         case C_VISUALIZAR:
            visualizar(info.id);
            return true;
             
         case C_EDITAR:
            i = new Intent(Hipoteca.this, HipotecaFormulario.class);
            i.putExtra(C_MODO, C_EDITAR);
            i.putExtra(HipotecaDbAdapter.C_COLUMNA_ID, info.id);
             
            startActivityForResult(i, C_EDITAR);
            return true;
       }
       return super.onContextItemSelected(item);
   }






@Override
public void onClick(View v) {
	
	
	if(v==bus)
	{
		
		if(txtPalabraBus.getText().toString().equals("")){
			
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(txtPalabraBus.getWindowToken(), 0);
			
			Toast.makeText(this, "Campos Vac�os", Toast.LENGTH_SHORT).show();
		}else{
		
		if(sp.getSelectedItemPosition() == 1 ){
			
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(txtPalabraBus.getWindowToken(), 0);
			
			String palabra=txtPalabraBus.getText().toString();
			
			Cursor c = dbAdapter.consultarLis(palabra);
			
			if(c!=null)
			{
				cursor=c;
				startManagingCursor(cursor);
			    hipotecaAdapter = new HipotecaCursorAdapter(this, cursor);
			    lista.setAdapter(hipotecaAdapter);
			
			}
			
		}else if(sp.getSelectedItemPosition() == 2){
			 
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(txtPalabraBus.getWindowToken(), 0);
			
			String palabra=txtPalabraBus.getText().toString();
			
			Cursor c = dbAdapter.consultarLis2(palabra);
			
			if(c!=null)
			{
				cursor=c;
				startManagingCursor(cursor);
			    hipotecaAdapter = new HipotecaCursorAdapter(this, cursor);
			    lista.setAdapter(hipotecaAdapter);
			
			}
			
			
		}else if(sp.getSelectedItemPosition() == 3){
			
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(txtPalabraBus.getWindowToken(), 0);
			
			String palabra=txtPalabraBus.getText().toString();
			
			Cursor c = dbAdapter.consultarLis3(palabra);
			
			if(c!=null)
				
			{
				cursor=c;
				startManagingCursor(cursor);
			    hipotecaAdapter = new HipotecaCursorAdapter(this, cursor);
			    lista.setAdapter(hipotecaAdapter);
			}
			
		}else if(sp.getSelectedItemPosition() == 4){
			
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(txtPalabraBus.getWindowToken(), 0);
			
			String palabra=txtPalabraBus.getText().toString();
			
			Cursor c = dbAdapter.consultarLis4(palabra);
			
			if(c!=null)
				
			{
				cursor=c;
				startManagingCursor(cursor);
			    hipotecaAdapter = new HipotecaCursorAdapter(this, cursor);
			    lista.setAdapter(hipotecaAdapter);
			}
			
		}else{
		
		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(txtPalabraBus.getWindowToken(), 0);
		
		String palabra=txtPalabraBus.getText().toString();
		
		Cursor c = dbAdapter.consultarLista(palabra);
		
		if(c!=null)
		{
			cursor=c;
			startManagingCursor(cursor);
		    hipotecaAdapter = new HipotecaCursorAdapter(this, cursor);
		    lista.setAdapter(hipotecaAdapter);
		
		}
	  }
	}
}
	else if(v==buTodos){
		consultar();
		
	}
	

}


@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
     switch (keyCode) {
     case KeyEvent.KEYCODE_MENU:
        /* Sample for handling the Menu button globally */
        return true;
     }
     
     if (keyCode == KeyEvent.KEYCODE_BACK) {
		    onBackPressed();

		}

		return super.onKeyDown(keyCode, event);
}
}