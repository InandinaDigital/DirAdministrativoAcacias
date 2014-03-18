package gov.co.acaciasmeta.bd;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class baseDatos extends SQLiteOpenHelper {
	private static int version = 3;
	private static CursorFactory factory = null;
	public static String TAG="baseDatos";
	public baseDatos(Context context, String name) {
		super(context, name, factory, version);
	}	   
	   
	@Override
	public void onCreate(SQLiteDatabase db) {
		

		  db.execSQL( "CREATE TABLE directorio3(" +
		             " _id INTEGER PRIMARY KEY," +
		             " hip_nombre TEXT NOT NULL, " +
		             "  apellido TEXT, "+
		             " hip_secretaria TEXT, " +
		             " hip_fecha_ingreso TEXT, " +
		             " hip_oficina TEXT," + 
		             " hip_direccion TEXT," + // nuevo
		             " hip_cargo TEXT," +
		             " hip_profesion TEXT," +  //nuevo
		             " hip_funcion TEXT," +    //nuevo
		             " hip_modalidad TEXT," +
		             " hip_email TEXT," +           
		             " hip_twitter TEXT," +
		             " hip_facebook TEXT," +
		             " hip_youtube TEXT," +
		             " hip_paginaweb TEXT," +
		             " hip_etiqueta TEXT," +
		             " hip_telefono TEXT," +
		             " hip_extension TEXT," +
		             " hip_linea TEXT," +
		             " hip_trami_servi TEXT," +
		             " hip_atencion TEXT," +
		             " hip_publico TEXT," +           
		             " hip_whatsapp TEXT," +
		             " hip_celular TEXT)" );
		    
	    	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	 
	 
	 
/****
 * consuta los funcionarios existentes
 * 
 * 
 * 	
 * @return ArrayListas<Funcionario> 
 */
	public Cursor consultarFuncionarios(){
    
		

    
	SQLiteDatabase db = this.getWritableDatabase();
	String[] campos = new String[] {"*"};
	Cursor c = db.query("directorio3", campos, null, null, null, null, null);
	 /*
	if(c.moveToFirst()) {

		do {
			
			Funcionario f=new Funcionario();
			f.id=c.getString(0);
			f.nombre=c.getString(1);
			f.apellido=c.getString(2);
			f.secretaria=c.getString(3);
			f.fecha_ingreso=c.getString(4);
			f.oficina=c.getString(5);
			f.direccion=c.getString(6);
			f.cargo=c.getColumnName(7);
			f.profesion=c.getColumnName(8);
			f.funcion=c.getColumnName(9);
			
			f.modalidad=c.getColumnName(10);
			f.email=c.getColumnName(11);
			f.twitter=c.getColumnName(12);
			f.facebook=c.getColumnName(13);
			f.youtube=c.getColumnName(14);
			f.paginaweb=c.getColumnName(15);
			f.etiqueta=c.getColumnName(16);
			f.telefono=c.getColumnName(17);
			f.extension=c.getColumnName(18);
			f.linea=c.getColumnName(19);
			
			f.trami_servi=c.getColumnName(20);
			f.atencion=c.getColumnName(21);
			f.publico=c.getColumnName(22);
			f.whatsapp=c.getColumnName(23);
			f.celular=c.getColumnName(24);
			
			
			
			lista.add(f);  
	          
	     } while(c.moveToNext());
	
	}
    
	*/    
    
    
	return c;
	}
	
	
	
	   
	/**
	 * actualizar los nuevo datos
	 * 
	 * @param lista ArrayList<Funcionario> lista de los funcionarios
	 * @return boolean si fue exitoso o no 
	 */
	public boolean actualizarDatosFuncionarios(JSONArray lista){
		boolean salida=true;
	
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("delete FROM directorio3");
		
		
		/*
		for(Funcionario f:lista)
		{
			String miSql="INSERT INTO directorio3 (id,nombre) VALUES ("
					+""+f.id+","
					+" '"+f.nombre+"')";
			
			db.execSQL(miSql);
			
		}
		*/
		
		for(int i=0;i<lista.length();i++)
		{
			
		
			
			String miSql="";
			try {
				JSONObject fila=lista.getJSONObject(i);
				
				miSql = "INSERT INTO directorio3 (_id,hip_nombre,            " +
						"apellido, " +
					     " hip_secretaria , " +
			             " hip_fecha_ingreso , " +
			             " hip_oficina ," + 
			             " hip_direccion ," + // nuevo
			             " hip_cargo ," +
			             " hip_profesion ," +  //nuevo
			             " hip_funcion ," +    //nuevo
			             " hip_modalidad ," +
			             " hip_email ," +           
			             " hip_twitter ," +
			             " hip_facebook ," +
			             " hip_youtube ," +
			             " hip_paginaweb ," +
			             " hip_etiqueta ," +
			             " hip_telefono ," +
			             " hip_extension ," +
			             " hip_linea ," +
			             " hip_trami_servi ," +
			             " hip_atencion ," +
			             " hip_publico ," +           
			             " hip_whatsapp ," +
			             " hip_celular " +
					     	" ) VALUES ("
						+" '"+fila.getString("id")+"',"
						+" '"+fila.getString("nombre")+"',"
						+" '"+fila.getString("apellido")+"',"
						+" '"+fila.getString("secretaria")+"',"
						+" '"+fila.getString("fecha_ingreso")+"',"
						+" '"+fila.getString("oficina")+"',"
						+" '"+fila.getString("direccion")+"',"
						+" '"+fila.getString("cargo")+"',"
						+" '"+fila.getString("profesion")+"',"
						+" '"+fila.getString("funcion")+"',"
						+" '"+fila.getString("modalidad")+"',"
						+" '"+fila.getString("email")+"',"
						+" '"+fila.getString("twitter")+"',"
						+" '"+fila.getString("facebook")+"',"
						+" '"+fila.getString("youtube")+"',"
						+" '"+fila.getString("paginaweb")+"',"
						+" '"+fila.getString("etiqueta")+"',"
						+" '"+fila.getString("telefono")+"',"
						+" '"+fila.getString("extension")+"',"
						+" '"+fila.getString("linea")+"',"
						+" '"+fila.getString("trami_servi")+"',"
						+" '"+fila.getString("atencion")+"',"
						+" '"+fila.getString("publico")+"',"
						+" '"+fila.getString("whatsapp")+"',"
						+" '"+fila.getString("celular")+"')";
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				salida=false;
				e.printStackTrace();
			}
			
			
			if(!miSql.equals(""))
				db.execSQL(miSql);
			Log.e(TAG,"...... sele .. "+miSql);
		}
		
		db.close();
		
		return salida;
	} 
	

}
