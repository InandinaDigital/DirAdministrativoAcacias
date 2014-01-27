package gov.co.acaciasmeta.directorioacacias;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.view.MenuItem;

import android.widget.TextView;

public class Pagina3 extends ActionBarActivity{

	/**@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
		
		Intent i = new Intent(this, ViewActivity.class);
		startActivity(i);
		finish();
	}**/
	
	
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
	   
	   
	   
	   
	    String nombre1;
		String secretaria1;
		String oficina1;
		String cargo1;
		String modalidad1;
		String email1;
		String twitter1;
		String facebook1;
		String youtube1;
		String paginaweb1;
		String celular1;
		String whatsapp1;
		String tel_fijo1;
		String extension1;
		String linea1;
		String atencion1;
		String horario1;
		String tramite1;
		
		Bundle bd;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hipoteca_formulario);
			
		  
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
	      
	      
	      
	      bd = getIntent().getExtras();
	      
	         nombre1 = bd.getString("nombre");
			 secretaria1 = bd.getString("secretaria");
			 oficina1 = bd.getString("oficina");
			 cargo1 = bd.getString("cargo");
			 modalidad1 = bd.getString("modalidad");
		     email1 = bd.getString("email");
			 twitter1 = bd.getString("twitter");
			 facebook1 = bd.getString("facebook");
			 youtube1 = bd.getString("youtube");
			 paginaweb1 = bd.getString("paginaweb");
		     celular1 = bd.getString("celular");
			 whatsapp1 = bd.getString("whatsapp");
			 tel_fijo1 = bd.getString("tel_fijo");
			 extension1 = bd.getString("extension");
			 linea1 = bd.getString("linea");
			 atencion1 = bd.getString("atencion");
			 horario1 = bd.getString("horario");
			 tramite1 = bd.getString("tramite");

			 getSupportActionBar().setTitle(nombre1);
			 //Insertamos los datos obtenidos
			 
			  nombre.setText(nombre1);
			  secretaria.setText(secretaria1);
			  oficina.setText(oficina1);
			  cargo.setText(cargo1);
			  modalidad.setText(modalidad1);
			  email.setText(email1);
			  twitter.setText(twitter1);
			  facebook.setText(facebook1);
			  youtube.setText(youtube1);
			  
			  //pagina web
		        paginaweb.setText(
		            Html.fromHtml(
		                "<a href=\"http://www.acacias-meta.gov.co\"><strong>www.acacias-meta.gov.co</strong></a>"
		                ));
		        paginaweb.setMovementMethod(LinkMovementMethod.getInstance());
		        
			  
			  //celular
			  if(celular1.equals("")){
			  
				  celular.setText("");
				  
			  }else if(!celular.equals("")){
				  SpannableString ss = new SpannableString(celular1);

		            ss.setSpan(new StyleSpan(Typeface.BOLD), 0, 10,
		                      Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		            ss.setSpan(new URLSpan("tel:"+celular1), 0, 10,
		                       Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		            celular.setText(ss);
		            //t4.setTextSize(18);
		            celular.setMovementMethod(LinkMovementMethod.getInstance());
			  }
			  
			  whatsapp.setText(whatsapp1);
			  tel_fijo.setText(tel_fijo1);
			  extension.setText(extension1);
			  linea.setText(linea1);
			  atencion.setText(horario1);
			  publico.setText(atencion1);
			  tramite.setText(tramite1);
			 
		
		//TextView t3 = (TextView) findViewById(R.id.textView21);
        //t3.setText(
         //   Html.fromHtml(
          //      "<a href=\"http://www.fundaciontsamani.org\">www.fundaciontsamani.org</a>"
           //     ));
        //t3.setMovementMethod(LinkMovementMethod.getInstance());
        
        
        
          //SpannableString ss2 = new SpannableString(celular1);

            //ss.setSpan(new StyleSpan(Typeface.BOLD), 15, 25,
             //         Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //ss.setSpan(new URLSpan("tel:3115279477"), 15, 25,
             //          Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //TextView t4 = (TextView) findViewById(R.id.textView23);
            //t4.setText(ss2);
            //t4.setTextSize(18);
            //t4.setMovementMethod(LinkMovementMethod.getInstance());

	}

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




}
