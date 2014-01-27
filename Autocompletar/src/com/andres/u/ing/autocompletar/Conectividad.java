package com.andres.u.ing.autocompletar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.LiveFolders;

public class Conectividad extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		LiveConnectivityManager.singleton(context).notifyConnectionChange();
	}

}
