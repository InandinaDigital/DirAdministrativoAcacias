package gov.co.acaciasmeta.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 
public class HipotecaDbHelper extends SQLiteOpenHelper {
 
   private static int version = 3;
   private static String name = "HipotecaDb2" ;
   private static CursorFactory factory = null;
 
   public HipotecaDbHelper(Context context)
   {
      super(context, name, factory, version);
   }
 
   @Override
   public void onCreate(SQLiteDatabase db)
   {
      Log.i(this.getClass().toString(), "Creando base de datos");
    
      db.execSQL( "CREATE TABLE HIPOTECA3(" +
             " _id INTEGER PRIMARY KEY," +
             " hip_nombre TEXT NOT NULL, " +
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
    
      db.execSQL( "CREATE UNIQUE INDEX hip_nombre ON HIPOTECA3(hip_nombre ASC)" );
    
      Log.i(this.getClass().toString(), "Tabla HIPOTECA3 creada");
    
      /*
       * Insertamos datos iniciales
       */
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(1,'Martin Dario Vega Marquez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(2,'Didier Ahimelec Castro Castro')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(3,'Ernesto Pineda Dueñas')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(4,'Leidy Tatiana Lopez Urrego')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(5,'Luis Enrique Amaya Porras')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(6,'Raul Herrera Castro ')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(7,'Silvio Eduardo Calderon Rodriguez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(8,'Hemel Eslava Mosquera')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(9,'Wilmer Mena Peña')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(10,'Humberto Alvarez Romero')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(11,'Hernando Cagueño Cabrera')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(12,'Juan de Jesus Huintaco Rozo')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(13,'Carlos Arturo Ortiz Rojas')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(14,'Jaideir Hernan Romero Blandon')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(15,'Jairo Humberto Lozano Hernandez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(16,'Bernandino Romero Rincón')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(17,'Arcenio Vargas Alvarez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(18,'Omar Fernando Castro Borja')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(19,'William Fernando Rivera Pinzón')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(20,'Nixon Frey Perez Montero')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(21,'John Jairo Restrepo Ladino')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(22,'Omar Hernán Guarnizo Clavijo')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(23,'Armando Gomez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(24,'Armando Cabrera Calderon')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(25,'Maria Ines Suarez Palacios')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(26,'Teresa de Jesus Sandoval Rodriguez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(27,'Doris Manrique Cabrera')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(28,'Ana Ligia Nieto Gonzales')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(29,'Cecilia Melo García')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(30,'Maria Nelly Saray Céspedes')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(31,'Esperanza Cañon Moreno')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(32,'Carmen Elisa Páez Pachón')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(33,'Blanca Cecilia Pinilla Melo')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(34,'Zonia Esperanza Mora Arias')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(35,'Myriam Celis Figueroa')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(36,'Luz Marina Bolivar Calderon')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(37,'Eulalia Marin Franco')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(38,'Rosa Maria Diaz Maldonado')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(39,'Elsy Evangelina Valenzuela Marin')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(40,'Beatriz Rojas Alvarez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(41,'Luz Mila Cubillos Silvestre')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(42,'Naydu Infante Sierra')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(43,'Adriana Maria Hernandez parada')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(44,'Olga Lucia Olarte Morales')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(45,'Melba Yulieth Correal Baquero')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(46,'Nelcy Rocio Bedoya Caicedo')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(47,'Lilia Garzon')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(48,'Marlene Acosta Lara')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(49,'Maria Eugenia Reina Páez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(50,'Victor Julio Alvarez Cascante')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(51,'Martin Antonio Perez Romero')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(52,'Roberto Baquero Jimenez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(53,'German Quevedo Gutierrez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(54,'Ximena Sarai Pastas Bustos')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(55,'Jenny Patricia Rios Gutierrez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(56,'Leidy Yhasmin Noguera Meneses')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(57,'Jaidy Elaika Nieto')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(58,'Maria Cristina Gutierrez Candamil')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(59,'Eudolina Romero Perez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(60,'Lucy Yolanda Guerrero Reyes')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(61,'Hilda Janeth Rozo Gutierrez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(62,'Sandra Milena Abello Ramos')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(63,'Angelica Maria Correal Rico')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(64,'Diana Matilde Hernandez Rojas')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(65,'Marcela Patricia Bonilla Gutierrez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(66,'Heidy Cristina Baquero Parrado')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(67,'Luz Neida Pinzon Baracaldo')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(68,'Luz Myriam Rios Gutierrez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(69,'Nelson Rodriguez Valencia')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(70,'Rafael Fernando Parra Tolosa')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(71,'Gustavo Adolfo Salazar Saddy')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(72,'Gerardo Ayala Castillo')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(73,'Camilo Javier Pineda Arevalo')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(74,'Omar Alejandro Rodriguez Pardo')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(75,'Jimmy Andres Torres Castro')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(76,'Roger Alexander Acero')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(77,'Jhon Henry Orjuela Gamba')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(78,'Oscar Eduardo Arias Tabares')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(79,'Jairo Humberto Vidales Mendez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(80,'Nelson Gilberto Gutierrez Vaca')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(81,'Lida Aliria Rozo Ruiz')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(82,'Elizabeth Mora Arias')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(83,'Digna Mercedez Rodriguez Castillo')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(84,'Martha Elena Pinzón Forero')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(85,'Marilu Ayala Martinez')");
      db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(86,'Sandra Patricia Quevedo Castro')");
   
    
      Log.i(this.getClass().toString(), "Datos iniciales HIPOTECA3 insertados");
    
      Log.i(this.getClass().toString(), "Base de datos creada");
      
      
   // Aplicamos las sucesivas actualizaciones
      upgrade_2(db);
      upgrade_3(db);

   }
 
   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
   {
    
	   // Actualización a versión 2
	    if (oldVersion <= 2)
	    {
	        upgrade_2(db);
	    }
	    
	    if (oldVersion <= 3)
	    {
	        upgrade_3(db);
	    }
    
   }



   private void upgrade_3(SQLiteDatabase db) {
	// TODO Auto-generated method stub
	   db.execSQL("INSERT INTO HIPOTECA3(_id, hip_nombre) VALUES(87,'Carlos Andres Urrego Castro')");
}

private void upgrade_2(SQLiteDatabase db)
   {
       //
       // Upgrade versión 2: definir algunos datos de ejemplo
       //
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y financiera'," +
                   "             hip_oficina = 'Acacias Vive Digital'," +
                   "             hip_cargo = 'CIO'," +
                   "             hip_modalidad = 'Contratista'," +
                   "             hip_email = 'cio@acacias.gov.co'," +
                   "             hip_twitter = '@MartinVegaM'," +
                   "             hip_facebook = 'Llanerodigital'," +
                   "             hip_youtube = 'Llanerodigital'," +
                   "             hip_paginaweb = 'www.fundaciontsamani.org'," +
                   "             hip_celular = '3115279477'," +
                   "             hip_telefono = '6569997'," +
                   "             hip_extension = '122'," +
                   "             hip_whatsapp = '3115279477'," +
                   "             hip_linea = '018000 112996'," +
                   "             hip_publico = 'Si'," +
                   "             hip_etiqueta = 'TIC, Internet, Digital, Tecnologia, Acacias Vive Digital'," +
                   "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                        " WHERE _id = 1");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y financiera'," +
               "             hip_oficina = 'Acacias Vive Digital'," +
               "             hip_cargo = 'Ingeniero TI'," +
               "             hip_modalidad = 'Contratista'," +
               "             hip_email = 'didier.castro@acacias.gov.co'," +
               "             hip_facebook = 'AlcaldiaAcacias'," +
               "             hip_youtube = 'AlcaldiaAcacias'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_celular = '3115472532'," +
               "             hip_whatsapp = '3115472532'," +
               "             hip_linea = '018000 112996'," +
               "             hip_telefono = '6569061'," +
               "             hip_extension = '106'," +
               "             hip_publico = 'Si'," +
               "             hip_etiqueta = 'TIC, Internet, Digital, Tecnologia, Acacias Vive Digital,GEL, Gobierno en Linea, Sysman, Sistema de Informacion'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 2");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y financiera'," +
               "             hip_oficina = 'Sistemas'," +
               "             hip_cargo = 'Jefe de Sistemas'," +
               "             hip_modalidad = 'Nomina'," +
               "             hip_email = 'sistemas@acacias-meta.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_celular = '3214904885'," +
               "             hip_facebook = 'AlcaldiaAcacias'," +
               "             hip_twitter = '@sistemas50006'," +
               "             hip_whatsapp = '3214904885'," +
               "             hip_telefono = '6569061'," +
               "             hip_extension = '106'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_trami_servi = 'Novedades impuesto predial, Estrategia Acacias Vive Digital'," +
               "             hip_etiqueta = 'TIC, Internet, Digital, Tecnologia, Acacias Vive Digital,GEL, Gobierno en Linea, Sysman, Sistema de Informacion'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 3");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y financiera'," +
               "             hip_oficina = 'Almacén Municipal'," +
               "             hip_cargo = 'Profesional'," +
               "             hip_modalidad = 'Empleado Publico'," +
               "             hip_email = 'almacen@acacias-meta.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_telefono = '6469160'," +
               "             hip_publico = 'Si'," +
               "             hip_trami_servi = 'Entradas de almacén, Salidas de almacén'," +
               "             hip_etiqueta = 'Almacenista, entradas, salidas, entrega, compras'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 4");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y financiera'," +
               "             hip_cargo = 'Celador'," +
               "             hip_modalidad = 'Empleado Público'," +        
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_etiqueta = 'celador, celadores, atencion, publico'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 5");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y financiera'," +
               "             hip_cargo = 'Celador'," +
               "             hip_modalidad = 'Empleado Público'," +        
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_etiqueta = 'celador, celadores, atencion, publico'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 6");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Fomento'," +
               "             hip_cargo = 'Profesional'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'silvio.calderon@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 7");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y Financiera'," +
    		   "             hip_oficina = 'Tesorería'," +
               "             hip_cargo = 'Auxiliar'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'hemel.eslava@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 8");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Fomento'," +
               "             hip_cargo = 'Profesional'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'wilmer.mena@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 9");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Infraestructura'," +
               "             hip_cargo = 'Auxiliar Administrativo'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 10");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Infraestructura'," +
               "             hip_cargo = 'Operario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_etiqueta = 'conductor,maquinaria'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 11");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y Financiera'," +
               "             hip_cargo = 'Celador'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_etiqueta = 'celador, celadores, atencion, publico'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 12");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Infraestructura'," +
               "             hip_cargo = 'Conductor'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_etiqueta = 'conductor,maquinaria'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 13");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Infraestructura'," +
               "             hip_cargo = 'Operario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 14");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Educación'," +
    		   "             hip_oficina = 'Deportes'," +
               "             hip_cargo = 'Técnico'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'deportes@acacias-meta.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_etiqueta = 'Deportes, villa olimpica, coliseo, recreacion'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 15");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Infraestructura'," +
               "             hip_cargo = 'Operario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 16");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Despacho'," +
    		   "             hip_oficina = 'Despacho Alcalde'," +
               "             hip_cargo = 'Alcalde'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_twitter = '@ArcenioVargas'," +
               "             hip_facebook = 'AlcaldiaAcacias'," +
               "             hip_youtube = 'AlcaldiaAcacias'," +
               "             hip_email = 'alcaldia@acacias-meta.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_etiqueta = 'Alcalde,despacho,publico'," +
               "             hip_telefono = '6569939'," +
               "             hip_extension = '101'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 17");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y financiera'," +
               "             hip_cargo = 'Conductor'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 18");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Planeación'," +
               "             hip_cargo = 'Auxiliar'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'william.rivera@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 19");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Gobierno'," +
    		   "             hip_oficina = 'Secretaria de Despacho'," +
               "             hip_cargo = 'Secretario de Gobierno'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'gobierno@acacias-meta.gov.co'," +
               "             hip_facebook = 'Gobierno Acacías'," +
               "             hip_twitter = '@gobierno50006'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_etiqueta = 'Gobierno,  Espacio público, Restriccion, Desplazados, poblacion vulnerable, Damnificados'," +
               "             hip_trami_servi = 'Certificado residencia, victimas de la violencia, desplazado, desplazados'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 20");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Infraestructura'," +
               "             hip_cargo = 'Profesional Universitario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'jhon.restrepo@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 21");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Educación'," +
               "             hip_cargo = 'Técnico'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 22");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Infraestructura'," +
               "             hip_cargo = 'Conductor'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_etiqueta = 'Conductor, maquinaria'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 23");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Financiera'," +
               "             hip_oficina='Contabilidad',"+
               "             hip_cargo = 'Profesional Universitario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'contador@acacias-meta.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 24");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Financiera'," +
               "             hip_cargo = 'Auxiliar de Servicios'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_telefono = '6569109'," +
               "             hip_extension = '139'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 25");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Financiera'," +
               "             hip_cargo = 'Auxiliar de Servicios'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_telefono = '6569109'," +
               "             hip_extension = '139'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 25");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Financiera'," +
               "             hip_cargo = 'Auxiliar de Servicios'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'correspondencia@acacias-meta.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_telefono = '6569109'," +
               "             hip_extension = '131'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 26");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Planeación'," +
    		   "             hip_oficina = 'Sisben'," +
               "             hip_cargo = 'Técnico'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'tecsisben@acacias-meta.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_telefono = '6569109'," +
               "             hip_extension = '131'," +
               "             hip_etiqueta = 'sisben,nivel,puntaje sisben'," +
               "             hip_trami_servi = 'sisben,nivel,puntaje sisben'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 27");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Fomento'," +
               "             hip_cargo = 'Secretario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'ligia.nieto@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_telefono = '6569997'," +
               "             hip_extension = '122'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 28");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Financiera'," +
               "             hip_cargo = 'Secretario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'cecilia.melo@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 29");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Financiera'," +
    		   "             hip_oficina = 'Recaudo'," +
               "             hip_cargo = 'Auxiliar'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'fiscalizacion@acacias-meta.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 30");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Gobierno'," +
    		   "             hip_oficina = 'Comisaría de familia'," +
               "             hip_cargo = 'Comisario de familia'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'esperanza.canon@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 31");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Financiera'," +
    		   "             hip_oficina = 'Recaudo'," +
               "             hip_cargo = 'Auxiliar'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'carmen.paez@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 32");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Financiera'," +
    		   "             hip_oficina = 'Recaudo'," +
               "             hip_cargo = 'Auxiliar de servicios'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 33");
       
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Financiera'," +
    		   "             hip_oficina = 'Tesorería'," +
               "             hip_cargo = 'Tesorero General'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'tesorero@acacias-meta.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 34");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Contratación'," +
    		   "             hip_oficina = 'Doac'," +
               "             hip_cargo = 'Secretario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'myriam.celis@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 35");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Protección'," +
               "             hip_cargo = 'Auxiliar'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 36");
       
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Financiera'," +
    		   "             hip_oficina = 'Archivo'," +
               "             hip_cargo = 'Profesional'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'archivo@acacias-meta.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 37");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Despacho'," +
    		   "             hip_oficina = 'Despacho'," +
               "             hip_cargo = 'Secretario Ejecutivo'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_celular = '3214904883'," +
               "             hip_whatsapp = '3214904883'," +
               "             hip_telefono = '6569939'," +
               "             hip_extension = '101'," +
               "             hip_email = 'rosa.diaz@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_etiqueta = 'Secretaria de despacho,secretaria,despacho,alcalde'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 38");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Juridica'," +
               "             hip_cargo = 'Auxiliar'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'elsy.valenzuela@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 39");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Gobierno'," +
               "             hip_cargo = 'Auxiliar'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'beatriz.rojas@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 40");
       
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y financiera'," +
    		   "             hip_oficina = 'Tesorería'," +
               "             hip_cargo = 'Secretario Ejecutivo'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'mila.cubillos@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 41");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Gobierno'," +
               "             hip_cargo = 'Secretario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'naydu.infante@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 42");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Salud'," +
               "             hip_cargo = 'Profesional'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'adriana.hernandez@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 43");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y financiera'," +
    		   "             hip_oficina = 'Recaudo'," +
               "             hip_cargo = 'Secretario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'olga.olarte@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 44");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Despacho'," +
               "             hip_cargo = 'Auxiliar'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'melba.correal@acacias.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 45");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y financiera'," +
    		   "             hip_oficina = 'Recurso Humano'," +
               "             hip_cargo = 'Profesional'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_email = 'recursohumano@acacias-meta.gov.co'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 46");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y Financiera'," +
               "             hip_cargo = 'Auxiliar de Servicios'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 47");
       
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y Financiera'," +
               "             hip_cargo = 'Auxiliar de Servicios'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 48");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y Financiera'," +
               "             hip_cargo = 'Ayudante'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'maria.reina@acacias.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 49");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y Financiera'," +
               "             hip_cargo = 'Celador'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_etiqueta = 'celador, celadores, atencion, publico'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 50");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Infraestructura'," +
               "             hip_cargo = 'Conductor'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_etiqueta = 'conductor, maquinaria'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 51");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Gobierno'," +
               "             hip_cargo = 'Auxiliar'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'roberto.baquero@acacias.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 52");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Gobierno'," +
               "             hip_cargo = 'Auxiliar Administrativo'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'german.quevedo@acacias.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 53");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Educación'," +
               "             hip_cargo = 'Auxiliar Administrativo'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'ximena.pastas@acacias.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 54");
       
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_oficina = 'Recaudo'," +
               "             hip_cargo = 'Profesional Universitario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'recaudo@acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 55");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y Financiera'," +
    		   "             hip_oficina = 'Secretario de Despacho'," +
               "             hip_cargo = 'Director Operativo'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'proteccion@acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 56");
       
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y Financiera'," +
    		   "             hip_oficina = 'Secretario de Despacho'," +
               "             hip_cargo = 'Sec. Administrativo y Fro.'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_telefono = '6569997'," +
               "             hip_extension = '122'," +
               "             hip_email = 'financiera@acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 57");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Despacho'," +
    		   "             hip_oficina = 'Despacho'," +
               "             hip_cargo = 'Profesional Universitario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'sprivada@acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 58");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Infraestructura'," +
               "             hip_cargo = 'Auxiliar'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'lina.romero@acacias.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 59");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Administrativa y Financiera'," +
               "             hip_cargo = 'Auxiliar Administrativo'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'yolanda.guerrero@acacias.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 60");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Educación'," +
               "             hip_cargo = 'Auxiliar'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'educacion@acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 61");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Gobierno'," +
               "             hip_cargo = 'Auxiliar'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'sandra.abello@acacias.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 62");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Educación'," +
               "             hip_cargo = 'Profesional Universitario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'biblioteca@acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 63");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Planeación'," +
    		   "             hip_oficina = 'Urbanismo'," +
               "             hip_cargo = 'Profesional'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'diana.hernandez@acacias.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 64");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Fomento'," +
    		   "             hip_oficina = 'Secretario de Despacho'," +
               "             hip_cargo = 'Secretario de Fomento y\n Desarrollo'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'fomento@acacias-meta.gov.co'," +
               "             hip_etiqueta = 'medio ambiente, agricola'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 65");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Planeación'," +
               "             hip_cargo = 'Profesional Universitario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'heidy.baquero@acacias.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 66");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Despacho'," +
               "             hip_cargo = 'Profesional Universitario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 67");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Gobierno'," +
               "             hip_cargo = 'Inspector de Policía'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 68");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Gobierno'," +
               "             hip_cargo = 'Profesional Universitario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 69");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Infraestructura'," +
               "             hip_cargo = 'Profesional Universitario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'rafael.parra@acacias.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 70");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Contratación'," +
    		   "             hip_oficina = 'Secretario de Despacho'," +
               "             hip_cargo = 'Director Operativo'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'contratacion@acacias-meta.gov.co'," +
               "             hip_etiqueta = 'licitaciones, convocatorias, minima cuantia, contratos'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 71");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Planeación'," +
    		   "             hip_oficina = 'Secretario de Despacho'," +
               "             hip_cargo = 'Jefe Oficina Asesora'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'planeacion@acacias-meta.gov.co'," +
               "             hip_etiqueta = 'Proyectos, Programas, Planes, Plan de desarrollo'," +
               "             hip_trami_servi = 'Licencia construccion, sisben, Estratificación '," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 72");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Planeación'," +
               "             hip_cargo = 'Profesional Universitario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'bancodeproyectos@acacias-meta.gov.co'," +
               "             hip_etiqueta = 'proyectos'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 73");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Planeación'," +
               "             hip_cargo = 'Profesional Universitario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'bancodeinformacion@acacias-meta.gov.co'," +
               "             hip_etiqueta = 'Estratificacion'," +
               "             hip_trami_servi = 'Estratificación'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 74");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Infraestructura'," +
    		   "             hip_oficina = 'Secretario de Despacho'," +
               "             hip_cargo = 'Secre. de Obras Públicas'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'infraestructura@acacias-meta.gov.co'," +
               "             hip_etiqueta = 'Obras, vias, puentes, contrucciones'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 75");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Jurídica'," +
    		   "             hip_oficina = 'Secretario de Despacho'," +
               "             hip_cargo = 'Jefe Oficina Asesora'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'juridica@acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 76");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Planeación'," +
               "             hip_cargo = 'Técnico'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'jhon.orjuela@acacias.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 77");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Contratación'," +
               "             hip_cargo = 'Asesor'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'oscar.arias@acacias.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 78");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Salud'," +
               "             hip_cargo = 'Técnico'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 79");
       
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Salud'," +
    		   "             hip_oficina = 'Secretario de Despacho'," +
               "             hip_cargo = 'Sec. de Salud'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'salud@acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_etiqueta = 'Salud, dengue, vacunacion, prevencion, salud oral'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 80");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Salud'," +
               "             hip_cargo = 'Auxiliar Administrativo'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 81");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Salud'," +
               "             hip_cargo = 'Auxiliar'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 82");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Salud'," +
               "             hip_cargo = 'Auxiliar Administrativo'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'mercedez.rodriguez@acacias.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 83");
       
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Salud'," +
               "             hip_cargo = 'Secretario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'martha.pinzon@acacias.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 84");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Salud'," +
               "             hip_cargo = 'Auxiliar'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 85");
       
       db.execSQL( "UPDATE HIPOTECA3 SET hip_secretaria = 'Salud'," +
               "             hip_cargo = 'Secretario'," +
               "             hip_modalidad = 'Empleado Público'," +
               "             hip_paginaweb = 'www.acacias-meta.gov.co'," +
               "             hip_email = 'aseguramiento@acacias-meta.gov.co'," +
               "             hip_linea = '018000 112996'," +
               "             hip_publico = 'Si'," +
               "             hip_atencion = 'Lunes a Viernes de 7:00 a.m. a 12:00m y 2:00 p.m. a 5:00 p.m.'" +
                    " WHERE _id = 86");
       
    
       Log.i(this.getClass().toString(), "Actualización versión 2 finalizada");
   }
   
   
}