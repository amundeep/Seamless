package me.amundeep.seamless;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ConfirmInformationActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_information);
		
		TextView eventName = (TextView)findViewById(R.id.event_name);
		TextView eventSubtext=(TextView)findViewById(R.id.event_subtext);
		TextView dateText=(TextView)findViewById(R.id.dates);
		TextView locationText=(TextView)findViewById(R.id.location);
		ImageView logo =(ImageView)findViewById(R.id.event_img);
		eventSubtext.setMaxWidth(400);
		eventSubtext.setMaxLines(3);
		new DownloadImageTask(logo).execute("http://cdn.evbuc.com/images/6610627/105260754357/1/logo.jpg");
		
		Intent i = getIntent();
		
		eventName.setText(i.getExtras().getString("name"));
		eventSubtext.setText(i.getExtras().getString("description"));
		
		
		String startDate=i.getExtras().getString("startDate");
		String endDate=i.getExtras().getString("endDate");
		String year=startDate.substring(0,4);
		String month;
		switch(startDate.substring(5,7)){
			case"01":
				month="January";
				break;
			case"02":
				month="February";
				break;
			case"03":
				month="March";
				break;
			case"04":
				month="April";
				break;
			case"05":
				month="May";
				break;
			case"06":
				month="June";
				break;
			case"07":
				month="July";
				break;
			case"08":
				month="August";
				break;
			case"09":
				month="September";
				break;
			case"10":
				month="October";
				break;
			case"11":
				month="November";
				break;
			case"12":
				month="December";
				break;
			default:
				month="";
				break;
		}
		startDate=startDate.substring(8,10);
		endDate=endDate.substring(8,10);
		
		
		dateText.setText(month+" "+startDate+"-"+endDate+", "+year);
		
		locationText.setText(i.getExtras().getString("location"));
//		logo.setImageResource(R.);
		
		
	
	
		Button confirmButton=(Button)findViewById(R.id.confirmButton);
		confirmButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ConfirmInformationActivity.this,DrawFragment1.class);
				startActivity(i);
				
			}
		});
		
		
	}

	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
	    ImageView bmImage;
	
	    public DownloadImageTask(ImageView bmImage) {
	        this.bmImage = bmImage;
	    }
	
	    protected Bitmap doInBackground(String... urls) {
	        String urldisplay = urls[0];
	        Bitmap mIcon11 = null;
	        try {
	            InputStream in = new java.net.URL(urldisplay).openStream();
	            mIcon11 = BitmapFactory.decodeStream(in);
	        } catch (Exception e) {
	            Log.e("Error", e.getMessage());
	            e.printStackTrace();
	        }
	        return mIcon11;
	    }
	
	    protected void onPostExecute(Bitmap result) {
	        bmImage.setImageBitmap(result);
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.confirm_information, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
