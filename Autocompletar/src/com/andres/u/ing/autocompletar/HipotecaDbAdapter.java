package com.andres.u.ing.autocompletar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
 
public class HipotecaDbAdapter {
 
   /**
    * Definimos constante con el nombre de la tabla
    */
   public static final String C_TABLA = "HIPOTECA3" ;
 
   /**
    * Definimos constantes con el nombre de las columnas de la tabla
    */
   public static final String C_COLUMNA_ID   = "_id";
   public static final String C_COLUMNA_NOMBRE = "hip_nombre";
   public static final String C_COLUMNA_SECRETARIA = "hip_secretaria";
   public static final String C_COLUMNA_OFICINA = "hip_oficina";
   public static final String C_COLUMNA_CARGO = "hip_cargo";
   public static final String C_COLUMNA_MODALIDAD = "hip_modalidad";
   public static final String C_COLUMNA_EMAIL = "hip_email";
   public static final String C_COLUMNA_TWITTER = "hip_twitter";
   public static final String C_COLUMNA_FACEBOOK = "hip_facebook";
   public static final String C_COLUMNA_YOUTUBE = "hip_youtube";
   public static final String C_COLUMNA_PAGINAWEB = "hip_paginaweb";
   public static final String C_COLUMNA_CELULAR = "hip_celular";
   public static final String C_COLUMNA_ETIQUETA = "hip_etiqueta";
   public static final String C_COLUMNA_FECHA_INGRE = "hip_fecha_ingreso";
   public static final String C_COLUMNA_TELEFONO = "hip_telefono";
   public static final String C_COLUMNA_EXTENSION = "hip_extension";
   public static final String C_COLUMNA_LINEA = "hip_linea";
   public static final String C_COLUMNA_TRAMI_SERVI = "hip_trami_servi";
   public static final String C_COLUMNA_ATENCION = "hip_atencion";
   public static final String C_COLUMNA_WHATSAPP = "hip_whatsapp";
   public static final String C_COLUMNA_PUBLICO = "hip_publico";
   public static final String C_COLUMNA_TRAMITE = "hip_trami_servi";
   public static final String C_COLUMNA_DIRECCION = "hip_direccion";
   public static final String C_COLUMNA_PROFESION = "hip_profesion";
   public static final String C_COLUMNA_FUNCION = "hip_funcion";

   
   
   
 
   private Context contexto;
   private HipotecaDbHelper dbHelper;
   private SQLiteDatabase db;
 
   /**
    * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
    */
   private String[] columnas = new String[]{ C_COLUMNA_ID, C_COLUMNA_NOMBRE, C_COLUMNA_SECRETARIA, C_COLUMNA_OFICINA, C_COLUMNA_CARGO, C_COLUMNA_MODALIDAD, C_COLUMNA_EMAIL, C_COLUMNA_TWITTER,  C_COLUMNA_FACEBOOK, C_COLUMNA_YOUTUBE, C_COLUMNA_PAGINAWEB, C_COLUMNA_CELULAR, C_COLUMNA_ETIQUETA, C_COLUMNA_FECHA_INGRE, C_COLUMNA_TELEFONO, C_COLUMNA_EXTENSION, C_COLUMNA_LINEA, C_COLUMNA_TRAMI_SERVI, C_COLUMNA_ATENCION, C_COLUMNA_WHATSAPP, C_COLUMNA_PUBLICO, C_COLUMNA_TRAMITE} ;
 
   public HipotecaDbAdapter(Context context)
   {
      this.contexto = context;
   }
 
   public HipotecaDbAdapter abrir() throws SQLException
   {
      dbHelper = new HipotecaDbHelper(contexto);
      db = dbHelper.getWritableDatabase();
      return this;
   }
   
   
   
   
   public Cursor consultarLista(String palabra){
	   Cursor salida=null;
	 
	 
	 salida=db.rawQuery("SELECT * FROM HIPOTECA3 WHERE hip_etiqueta LIKE '%"+palabra+"%'", null);
	 
	 

	  // salida=c.getString(1);
	   
	  return salida; 
   }
   
   public Cursor consultarLis(String palabra){
	   
	 Cursor salida=null;
	 
	 palabra=palabra.replace('á', 'a');
	 palabra=palabra.replace('é', 'e');
	 palabra=palabra.replace('í', 'i');
	 palabra=palabra.replace('ó', 'o');
     palabra=palabra.replace('ú', 'u');
	 
	 salida=db.rawQuery("SELECT * FROM HIPOTECA3 WHERE hip_nombre LIKE '%"+palabra.trim()+"%'", null);
	  

      
	  // salida=c.getString(1);b b
	   
	  return salida; 
   }
   
   public Cursor consultarLis2(String palabra){  
	   Cursor salida=null;
	   
	   
		
	   
	 salida=db.rawQuery("SELECT * FROM HIPOTECA3 WHERE hip_cargo LIKE '%"+palabra.trim()+"%'", null);
	  
	

	  // salida=c.getString(1);
	   
	  return salida; 
   }
   
   public Cursor consultarLis3(String palabra){
	   Cursor salida=null;
	   
	   

	 salida=db.rawQuery("SELECT * FROM HIPOTECA3 WHERE hip_secretaria LIKE '%"+palabra+"%'", null);
	  
	 

	  // salida=c.getString(1);
	   
	  return salida; 
   }
   
   
   public Cursor consultarLis4(String palabra){
	   Cursor salida=null;
	   
	   

	 salida=db.rawQuery("SELECT * FROM HIPOTECA3 WHERE hip_trami_servi LIKE '%"+palabra+"%'", null);
	  
	 

	  // salida=c.getString(1);
	   
	  return salida; 
   }
 
 
   
   
   
   public void cerrar()
   {
      dbHelper.close();
   }
 
   /**
    * Devuelve cursor con todos los registros y columnas de la tabla
    */
   public Cursor getCursor() throws SQLException
   {
      Cursor c = db.query( true, C_TABLA, columnas, null, null, null, null, null, null);
 
      return c;
   }
 
   /**
    * Devuelve cursor con todos las columnas del registro
    */
   public Cursor getRegistro(long id) throws SQLException
   {
      Cursor c = db.query( true, C_TABLA, columnas, C_COLUMNA_ID + "=" + id, null, null, null, null, null);
 
      //Nos movemos al primer registro de la consulta
      if (c != null) {
         c.moveToFirst();
      }
      return c;
   }
   
   /**
    * Inserta los valores en un registro de la tabla
    */
   public long insert(ContentValues reg)
   {
      if (db == null)
         abrir();
       
      return db.insert(C_TABLA, null, reg);
   }
   
   /**
    * Eliminar el registro con el identificador indicado
    */
   public long delete(long id)
   {
      if (db == null)
         abrir();
       
      return db.delete(C_TABLA, "_id=" + id, null);
   }
   
   /**
    * Modificar el registro
    */
   public long update(ContentValues reg)
   {
      long result = 0;
       
      if (db == null)
         abrir();
       
      if (reg.containsKey(C_COLUMNA_ID))
      {
         //
         // Obtenemos el id y lo borramos de los valores
         //
         long id = reg.getAsLong(C_COLUMNA_ID);
          
         reg.remove(C_COLUMNA_ID);
          //
         // Actualizamos el registro con el identificador que hemos extraido 
         //
         result = db.update(C_TABLA, reg, "_id=" + id, null); 
      }
      return result;
   }


   
  
}