package me.amundeep.seamless;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;

public class DrawFragment1 extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    setContentView(R.layout.fragment_1);

		this.getActionBar().setIcon(android.R.color.transparent);
		this.getActionBar().setTitle("View Design"); //CHANGE TITLE OF ACTION BAR HERE

	    
	    SurfaceView surface = (SurfaceView) findViewById(R.id.surface1);
	    surface.getHolder().addCallback(new SurfaceHolder.Callback() {

	        @Override
	        public void surfaceCreated(SurfaceHolder holder) {
	            // Do some drawing when surface is ready
	            Canvas canvas = holder.lockCanvas();
	            canvas.drawColor(Color.RED);
	            holder.unlockCanvasAndPost(canvas);
	        }

	        @Override
	        public void surfaceDestroyed(SurfaceHolder holder) {
	        }

	        @Override
	        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	        }
	    });
	    
	    new getURLSTask().execute();
	    
	    
	}
	
	private class getURLSTask extends AsyncTask<Void, Void, ArrayList<String>> {
		final ArrayList<String> urlArr = new ArrayList<>();
	
	
	    protected void onPostExecute(ArrayList<String> result) {
	    	Log.i("urls",result.toString());
	    
	    }

		@Override
		protected ArrayList<String> doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String result;
    		try{
    			final HttpClient httpclient = new DefaultHttpClient();  
				final HttpGet request = new HttpGet("https://api.instagram.com/v1/tags/Snow/media/recent?access_token=1464502412.4529896.fb74f46ed2044daab188365e95b1147b"); 
				final BasicResponseHandler handler = new BasicResponseHandler();  
				result = httpclient.execute(request, handler);
				final JSONObject obj = new JSONObject(result);
				final JSONArray data = obj.getJSONArray("data");
				for(int i=0;i<data.length();i++){
					final JSONObject pic = data.getJSONObject(i);
					if(!pic.getString("type").equals("image")){
						continue;
					} else {
						urlArr.add(pic.getJSONObject("images").getJSONObject("low_resolution").getString("url"));
					}
				}
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		return urlArr;
		}
	}
}
