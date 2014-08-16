package me.amundeep.seamless;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splash);
	
		Thread timer = new Thread(){
			public void run(){
				String result;
				String name="";
				String description="";
				String startDate="",endDate="";
				String location="";
				try{
					final HttpClient httpclient = new DefaultHttpClient();  
					final HttpGet request = new HttpGet("https://www.eventbriteapi.com/v3/events/11951688823/?token=HXJB3R54GZTWJLVKSHZU"); 
					final BasicResponseHandler handler = new BasicResponseHandler();  
					result = httpclient.execute(request, handler);
					final JSONObject obj = new JSONObject(result);
					name = obj.getJSONObject("name").getString("text");
					description=obj.getJSONObject("description").getString("text");
					startDate=description=obj.getJSONObject("start").getString("local");
					endDate=description=obj.getJSONObject("end").getString("local");
					location=description=obj.getJSONObject("venue").getJSONObject("address").getString("city")+", "+obj.getJSONObject("venue").getJSONObject("address").getString("region");
					sleep(2000);
				} catch (Exception e){
					e.printStackTrace();
				}finally {
					Intent openMainMenu = new Intent(Splash.this,ConfirmInformationActivity.class);
					openMainMenu.putExtra("name", name).putExtra("description", description)
								.putExtra("startDate",startDate).putExtra("endDate", endDate)
								.putExtra("location", location);
					startActivity(openMainMenu);
					Log.i("Startup", "Seamless successfully opened!");
				}
			}
		};
		timer.start();
	}
}

