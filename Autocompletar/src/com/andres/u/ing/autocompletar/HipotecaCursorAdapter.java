package com.andres.u.ing.autocompletar;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
 
public class HipotecaCursorAdapter extends CursorAdapter
{
 
   private HipotecaDbAdapter dbAdapter = null ;
 
   public HipotecaCursorAdapter(Context context, Cursor c)
   {
      super(context, c);
      dbAdapter = new HipotecaDbAdapter(context);
      dbAdapter.abrir();
   }
 
   @Override
   public void bindView(View view, Context context, Cursor cursor)
   {
      TextView tv = (TextView) view ;
 
      tv.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_NOMBRE)));
   }
 
   @Override
   public View newView(Context context, Cursor cursor, ViewGroup parent)
   {
      final LayoutInflater inflater = LayoutInflater.from(context);
      final View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
 
      return view;
   }
}