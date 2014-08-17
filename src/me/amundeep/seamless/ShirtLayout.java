package me.amundeep.seamless;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ShirtLayout extends Activity implements OnClickListener{

	Button bRandom, bColorPick, bConfirm;
	Button bGold, bRed, bBlue, bYellow, bPurple, bTeal, bWhite;
	Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shirtlayout);
		
		this.getActionBar().setIcon(android.R.color.transparent);
		
		context = this;
		
		bRandom = (Button) findViewById(R.id.bRandom);
		bRandom.setOnClickListener(this);
		bColorPick = (Button) findViewById(R.id.bColorPick);
		bColorPick.setOnClickListener(this);
		bConfirm = (Button) findViewById(R.id.bConfirm);
		bConfirm.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bRandom: 
			//do something
			break;
		case R.id.bColorPick:
			final Dialog dial = new Dialog(this);
			dial.setContentView(R.layout.dialog_colorpick);
			dial.setTitle("Choose A Color");
    
		    bGold = (Button) dial.findViewById(R.id.bGold);  //GOLD
		    bGold.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dial.dismiss();
					Toast.makeText(context, "You selected GOLD", 2000).show();
				}
		    	
		    });
		    bRed = (Button) dial.findViewById(R.id.bRed);   //RED
		    bRed.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dial.dismiss();
					Toast.makeText(context, "You selected RED", 2000).show();
				}
		    	
		    });
		    bBlue = (Button) dial.findViewById(R.id.bBlue);   //BLUE
		    bBlue.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dial.dismiss();
					Toast.makeText(context, "You selected BLUE", 2000).show();
				}
		    	
		    });
		    bYellow = (Button) dial.findViewById(R.id.bYellow);  //YELLOW
		    bYellow.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dial.dismiss();
					Toast.makeText(context, "You selected YELLOW", 2000).show();
				}
		    	
		    });
		    bPurple = (Button) dial.findViewById(R.id.bPurple); //PURPLE
		    bPurple.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dial.dismiss();
					Toast.makeText(context, "You selected PURPLE", 2000).show();
				}
		    	
		    });
		    bTeal = (Button) dial.findViewById(R.id.bTeal);  //TEAL
		    bTeal.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dial.dismiss();
					Toast.makeText(context, "You selected TEAL", 2000).show();
				}
		    	
		    });
		    bWhite = (Button) dial.findViewById(R.id.bWhite);  //WHITE
		    bWhite.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dial.dismiss();
					Toast.makeText(context, "You selected WHITE", 2000).show();
				}
		    	
		    });
		    
		    dial.show();
			break;
		case R.id.bConfirm:
			//do something
			break;
			
		}
	}

	
	
}
