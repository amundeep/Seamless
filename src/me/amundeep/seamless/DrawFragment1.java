package me.amundeep.seamless;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class DrawFragment1 extends Activity{
	
	private static final int NUMBER_OF_VERTICAL_SQUARES = 4;
	private static final int NUMBER_OF_HORIZONTAL_SQUARES = 4;
	
	public Bitmap[] bitmapArray;
	
	SurfaceView surface;
	Button bNextFrag;
	Context context;
	
	ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    setContentView(R.layout.fragment_1);
	    
	    context = this;
	    
	    bitmapArray = new Bitmap[NUMBER_OF_VERTICAL_SQUARES*NUMBER_OF_HORIZONTAL_SQUARES];

		this.getActionBar().setIcon(android.R.color.transparent);
		this.getActionBar().setTitle("View Design"); //CHANGE TITLE OF ACTION BAR HERE
		new getURLSTask().execute();

	    int screenHeight= getResources().getDisplayMetrics().heightPixels;
	    Log.wtf("hi",""+screenHeight);
		
	    bNextFrag = (Button) findViewById(R.id.bNextFrag);
	    bNextFrag.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String key = "bmp";

				
				Intent i = new Intent(DrawFragment1.this, DrawFragment2.class);
				
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				
//				for(int row = 0; row < NUMBER_OF_VERTICAL_SQUARES; row++){
//					for(int col = 0; col < NUMBER_OF_HORIZONTAL_SQUARES; col++){
						
						
//						bmp.compress(Bitmap.CompressFormat.PNG, 50, stream);
//						byte[] byteArray = stream.toByteArray();
						
				i.putExtra("bitmaparray", bitmapArray);
				for(int j=1;j<=16;j++){
					i.putExtra(key+j,bitmapArray[j-1]);
				}
				
//						i.putExtra(key + row + "," + col, byteArray);
//						Log.wtf("data", key + row + "," + col);
						
//					}
//				}
				startActivity(i);
			}
		});
	    
	    
	    
	    Log.wtf("hiyadsf", "j;kladsf");
    	surface = (SurfaceView) findViewById(R.id.surface1);
	    surface.getHolder().addCallback(new SurfaceHolder.Callback() {

	        @Override
	        public void surfaceCreated(SurfaceHolder holder) {
	            // Do some drawing when surface is ready
	            Log.wtf("hi","bitch ass niggas b h8in on my dick ass bitches");

	            Canvas canvas = holder.lockCanvas();
	            canvas.drawColor(Color.RED);
	            
//	            int canvasWidth = canvas.getWidth();
//	            int canvasHeight = canvas.getHeight();
//
//	            int squareWidth = canvasWidth / NUMBER_OF_HORIZONTAL_SQUARES;
//	            int squareHeight = canvasHeight / NUMBER_OF_VERTICAL_SQUARES;
//	            Rect destinationRect = new Rect();
//
//	            int xOffset;
//	            int yOffset;
//
//	            // Set the destination rectangle size
//	            destinationRect.set(0, 0, squareWidth, squareHeight);
//	            
//	            for (int horizontalPosition = 0; horizontalPosition < NUMBER_OF_HORIZONTAL_SQUARES; horizontalPosition++){
//
//	                xOffset = horizontalPosition * squareWidth;
//
//	                for (int verticalPosition = 0; verticalPosition < NUMBER_OF_VERTICAL_SQUARES; verticalPosition++){
//
//	                    yOffset = verticalPosition * squareHeight;
//
//	                    // Set the destination rectangle offset for the canvas origin
//	                    destinationRect.offsetTo(xOffset, yOffset);
//
//	                    // Draw the bitmap into the destination rectangle on the canvas
//	                    canvas.drawBitmap(bitmapArray[horizontalPosition][verticalPosition], null, destinationRect, null);
//	                }
//	            }
	            
	            holder.unlockCanvasAndPost(canvas);
	        }

	        @Override
	        public void surfaceDestroyed(SurfaceHolder holder) {
	        }

	        @Override
	        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	        }
	    });
	    
	    
	}
	
	private class getURLSTask extends AsyncTask<Void, Void, ArrayList<String>> {

		final ArrayList<String> urlArr = new ArrayList<String>();
	
	
	    protected void onPostExecute(ArrayList<String> result) {
	    	Log.i("urls",result.toString());
	    	new DownloadImageTask(result).execute();
	    }

		@Override
		protected ArrayList<String> doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String result;
    		try{
    			final HttpClient httpclient = new DefaultHttpClient();  
				final HttpGet request = new HttpGet("https://api.instagram.com/v1/tags/fire/media/recent?access_token=1464502412.4529896.fb74f46ed2044daab188365e95b1147b"); 
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


	public static Bitmap scaleDownBitmap(Bitmap photo, int newHeight, Context context){
		final float densityMultiplier = context.getResources().getDisplayMetrics().density;
		int h = (int) (newHeight*densityMultiplier);
		int w = h;
		photo = Bitmap.createScaledBitmap(photo, w, h, true);
		return photo;
	}
	
	private class DownloadImageTask extends AsyncTask<ArrayList<String>, Void, Bitmap> {
	    ArrayList<String> arr;
	    ImageView image;
	
	    public DownloadImageTask(ArrayList<String> result) {
	        this.arr = result;
	    }
	
	    @Override
	    protected Bitmap doInBackground(ArrayList<String>... array) {
	        
	        Bitmap mIcon11 = null;
	        try {
	        	int counter = 0;
	        	for(int i = 0; i < 16; i++){
	        		InputStream in = new java.net.URL(arr.get(i)).openStream();
	        		Log.wtf("hello", arr.get(i));
		            mIcon11 = BitmapFactory.decodeStream(in);
		           
		            
//		            if(i%NUMBER_OF_HORIZONTAL_SQUARES == 0 && i != 0){
//		            	counter++;
//		            }
		            
		            bitmapArray[i] = scaleDownBitmap(mIcon11, 10, context);
		            Log.v("counter",""+counter);
		            
		            Log.i("Bitmap", mIcon11 + "");
		            
	        	}
	            
	        	
	            
	            
	        } catch (Exception e) {
	            Log.e("Error", e.getMessage());
	        }
	        return mIcon11;
	    }
	
	    protected void onPostExecute(Bitmap result) {
	    	
	    }

	}
}
