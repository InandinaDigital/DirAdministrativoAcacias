package gov.co.acaciasmeta.directorioacacias;

import gov.co.acaciasmeta.clases.HipotecaDbAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 
public class HipotecaFormulario extends Activity {
    
   private HipotecaDbAdapter dbAdapter;
    private Cursor cursor; 
    
   //
    // Modo del formulario
    //
   private int modo ;
    
   //
   // Identificador del registro que se edita cuando la opción es MODIFICAR
   //
   private long id ;
    
   //
   // Elementos de la vista
   //
   private TextView nombre;
   private TextView secretaria;
   private TextView oficina;
   private TextView cargo;
   private TextView modalidad;
   private TextView email;
   private TextView twitter;
   private TextView facebook;
   private TextView youtube;
   private TextView paginaweb;
   private TextView celular;
   private TextView etiquet;
   private TextView whatsapp;
   private TextView tel_fijo;
   private TextView extension;
   private TextView linea;
   private TextView atencion;
   private TextView publico;
   private TextView tramite;
   
    
   private Button boton_guardar;
   private Button boton_cancelar;
 
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_hipoteca_formulario);
      
      
      Intent intent = getIntent();
      Bundle extra = intent.getExtras();
      
      
 
      if (extra == null) return;
       
      //
      // Obtenemos los elementos de la vista
      //
      nombre = (TextView) findViewById(R.id.nombre);
      secretaria = (TextView) findViewById(R.id.secretaria);
      oficina = (TextView) findViewById(R.id.oficina);
      cargo = (TextView) findViewById(R.id.cargo);
      modalidad = (TextView) findViewById(R.id.modalidad);
      email = (TextView) findViewById(R.id.email);
      twitter = (TextView) findViewById(R.id.twitter);
      facebook = (TextView) findViewById(R.id.facebook);
      youtube = (TextView) findViewById(R.id.youtube);
      paginaweb = (TextView) findViewById(R.id.paginaweb);
      celular = (TextView) findViewById(R.id.celular);
      etiquet = (TextView) findViewById(R.id.etiqueta);
      whatsapp = (TextView) findViewById(R.id.whatsapp);
      tel_fijo = (TextView) findViewById(R.id.tel_fijo);
      extension = (TextView) findViewById(R.id.extension);
      linea = (TextView) findViewById(R.id.linea);
      atencion = (TextView) findViewById(R.id.atencion); 
      publico = (TextView) findViewById(R.id.publico);
      tramite = (TextView) findViewById(R.id.tramite);
      
      
      boton_guardar = (Button) findViewById(R.id.boton_guardar);
      boton_cancelar = (Button) findViewById(R.id.boton_cancelar);
       
      //
      // Creamos el adaptador  
      //
      dbAdapter = new HipotecaDbAdapter(this);
      dbAdapter.abrir();
       
      //
      // Obtenemos el identificador del registro si viene indicado
      //
      if (extra.containsKey(HipotecaDbAdapter.C_COLUMNA_ID))
      {
         id = extra.getLong(HipotecaDbAdapter.C_COLUMNA_ID);
         consultar(id);
      }
       
      //
      // Establecemos el modo del formulario
      //
      establecerModo(extra.getInt(Hipoteca.C_MODO));
       
      //
      // Definimos las acciones para los dos botones
      //
      boton_guardar.setOnClickListener(new View.OnClickListener() {
          
         @Override
         public void onClick(View v)
         {
            guardar();
         }
      });
       
      boton_cancelar.setOnClickListener(new View.OnClickListener() {
          
         @Override
         public void onClick(View v)
         {
            cancelar(); 
         }
      });
       
   }
    
   private void establecerModo(int m)
   {
      this.modo = m ;
       
      if (modo == Hipoteca.C_VISUALIZAR)
      {
         this.setTitle(nombre.getText().toString());
         this.setEdicion(false);
      }
      else if (modo == Hipoteca.C_CREAR)
      {
         this.setTitle(R.string.hipoteca_crear_titulo);
         this.setEdicion(true);
      }
      else if (modo == Hipoteca.C_EDITAR)
      {
         this.setTitle(R.string.hipoteca_editar_titulo);
         this.setEdicion(true);
      }
   }
    
   private void consultar(long id)
   {
      //
      // Consultamos el centro por el identificador
      //
      cursor = dbAdapter.getRegistro(id);
       
      nombre.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_NOMBRE)));
      secretaria.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_SECRETARIA)));
      oficina.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_OFICINA)));
      cargo.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_CARGO)));
      modalidad.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_MODALIDAD)));
      email.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_EMAIL)));
      twitter.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_TWITTER)));
      facebook.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_FACEBOOK)));
      youtube.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_YOUTUBE)));
      paginaweb.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_PAGINAWEB)));
      celular.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_CELULAR)));
      etiquet.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_ETIQUETA)));
      whatsapp.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_WHATSAPP)));
      tel_fijo.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_TELEFONO)));
      extension.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_EXTENSION)));
      linea.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_LINEA)));
      atencion.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_ATENCION)));
      publico.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_PUBLICO)));
      tramite.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_TRAMITE)));

   }
    
   private void setEdicion(boolean opcion)
   {
      /**nombre.setEnabled(opcion);
      secretaria.setEnabled(opcion);
      oficina.setEnabled(opcion);
      cargo.setEnabled(opcion);
      modalidad.setEnabled(opcion);
      email.setEnabled(opcion);
      twitter.setEnabled(opcion);
      facebook.setEnabled(opcion);
      youtube.setEnabled(opcion);
      paginaweb.setEnabled(opcion);
      celular.setEnabled(opcion);
      etiquet.setEnabled(opcion);**/
   }
    
   private void guardar()
   {
      //
      // Obtenemos los datos del formulario
      // 
      ContentValues reg = new ContentValues();
       
      //
      // Si estamos en modo edición añadimos el identificador del registro que se utilizará en el update
      //
      if (modo == Hipoteca.C_EDITAR)
         reg.put(HipotecaDbAdapter.C_COLUMNA_ID, id);
       
      reg.put(HipotecaDbAdapter.C_COLUMNA_NOMBRE, nombre.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_SECRETARIA, secretaria.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_OFICINA, oficina.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_CARGO, cargo.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_MODALIDAD, modalidad.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_EMAIL, email.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_TWITTER, twitter.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_FACEBOOK, facebook.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_YOUTUBE, youtube.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_PAGINAWEB, paginaweb.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_CELULAR, celular.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_ETIQUETA, etiquet.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_WHATSAPP, whatsapp.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_TELEFONO, tel_fijo.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_EXTENSION, extension.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_LINEA, linea.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_ATENCION, atencion.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_PUBLICO, publico.getText().toString());
      reg.put(HipotecaDbAdapter.C_COLUMNA_TRAMITE, tramite.getText().toString());
      
       
      if (modo == Hipoteca.C_CREAR)
      {
         dbAdapter.insert(reg);
         Toast.makeText(HipotecaFormulario.this, R.string.hipoteca_crear_confirmacion, Toast.LENGTH_SHORT).show();
      }
      else if (modo == Hipoteca.C_EDITAR)
      {
         Toast.makeText(HipotecaFormulario.this, R.string.hipoteca_editar_confirmacion, Toast.LENGTH_SHORT).show();
         dbAdapter.update(reg);
      }
       
      //
      // Devolvemos el control
      //
      setResult(RESULT_OK);
      finish();
   }
    
   private void cancelar()
   {
      setResult(RESULT_CANCELED, null);
      finish();
   }
   
   //Esto es el menú para editar y eliminar informacion de la base de datos
   
  // @Override
  // public boolean onCreateOptionsMenu(Menu menu) {
 
    //  menu.clear();
        
     // if (modo == Hipoteca.C_VISUALIZAR)
       //  getMenuInflater().inflate(R.menu.hipoteca_formulario_ver, menu);
       
      //else
       //  getMenuInflater().inflate(R.menu.hipoteca_formulario_editar, menu);
       
     // return true;
  // }
   
 //  @Override
  // public boolean onMenuItemSelected(int featureId, MenuItem item) {
       
    //  switch (item.getItemId())
     // {
      //   case R.id.menu_eliminar:
       //     borrar(id);
        //    return true;
             
       //  case R.id.menu_cancelar:
       //     cancelar();
         //   return true;
             
        // case R.id.menu_guardar:
        //    guardar();
        //    return true;
             
        // case R.id.menu_editar:
        //    establecerModo(Hipoteca.C_EDITAR);
        //    return true;
     // }
       
      //return super.onMenuItemSelected(featureId, item);
  // }
   
   
   //Hasta aquí va
   
   
   private void borrar(final long id)
   {
      /**
       * Borramos el registro con confirmación
       */
      AlertDialog.Builder dialogEliminar = new AlertDialog.Builder(this);
       
      dialogEliminar.setIcon(android.R.drawable.ic_dialog_alert);
      dialogEliminar.setTitle(getResources().getString(R.string.hipoteca_eliminar_titulo));
      dialogEliminar.setMessage(getResources().getString(R.string.hipoteca_eliminar_mensaje));
      dialogEliminar.setCancelable(false);
       
      dialogEliminar.setPositiveButton(getResources().getString(android.R.string.ok), new DialogInterface.OnClickListener() {
 
         public void onClick(DialogInterface dialog, int boton) {
            dbAdapter.delete(id);
            Toast.makeText(HipotecaFormulario.this, R.string.hipoteca_eliminar_confirmacion, Toast.LENGTH_SHORT).show();
            /**
             * Devolvemos el control
             */
            setResult(RESULT_OK);
            finish();
         }
      });
       
      dialogEliminar.setNegativeButton(android.R.string.no, null);
       
      dialogEliminar.show();
       
   }
   
  
   
}