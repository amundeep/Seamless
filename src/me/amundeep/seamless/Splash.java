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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Splash extends Activity {

	EditText etCode;
	Button bSubmitCode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splash);
	
//		Thread timer = new Thread(){
//			public void run(){
//				try{
//					sleep(2000);
//				}catch(InterruptedException e){
//					e.printStackTrace();
//				}finally {
////					Intent openMainMenu = new Intent("");
////					startActivity(openMainMenu);
//					Log.i("Startup", "Seamless successfully opened!");
//				}
//			}
//		};
//		timer.start();
		
		this.getActionBar().setIcon(android.R.color.transparent);
		this.getActionBar().setTitle("");
		
		etCode = (EditText) findViewById(R.id.etCode);
		etCode.setText("");
		bSubmitCode = (Button) findViewById(R.id.bSubmitCode);
		bSubmitCode.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				if(etCode.getText().toString() == ""){
						
				}else{
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
							} catch (Exception e){
								e.printStackTrace();
							}finally {
//								Intent openMainMenu = new Intent(Splash.this,ConfirmInformationActivity.class);
//								openMainMenu.putExtra("name", name).putExtra("description", description)
//											.putExtra("startDate",startDate).putExtra("endDate", endDate)
//											.putExtra("location", location);
//								startActivity(openMainMenu);
								Intent openShirtLayout = new Intent(Splash.this, ShirtLayout.class);
								startActivity(openShirtLayout);
								Log.i("Startup", "Seamless successfully opened!");
							}
						}
					};
					timer.start();
				}
				
			}
			
		});
		
	}
}

