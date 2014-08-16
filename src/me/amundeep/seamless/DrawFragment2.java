package me.amundeep.seamless;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class DrawFragment2 extends Activity{
	public Bitmap[][] bitmapArray;
	public ArrayList<ArrayList<Bitmap>> bmpArr;
	public Bitmap tempBMP;
	
	private static final int NUMBER_OF_VERTICAL_SQUARES = 4;
	private static final int NUMBER_OF_HORIZONTAL_SQUARES = 4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    setContentView(R.layout.fragment_2);
	    Intent i = getIntent();
	    
	    for(int r = 0; r < NUMBER_OF_VERTICAL_SQUARES; r++){
//	    	ArrayList<Bitmap> bswag = new ArrayList<Bitmap>();
	    	for(int c = 0; c < NUMBER_OF_HORIZONTAL_SQUARES; c++){
	    		Log.i("printing", "b:" + r + "," + c);
	    		Bitmap b = i.getParcelableExtra("b:" + r + "," + c);
//	    		byte[] byteArray = i.getByteArrayExtra("b:" + r + "," + c);
//	    		Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
	    		tempBMP = b;
	    	}
//	    	bmpArr.add(bswag);
	    }
	    
	    
		this.getActionBar().setIcon(android.R.color.transparent);
		this.getActionBar().setTitle("View Design"); //CHANGE TITLE OF ACTION BAR HERE

	    
	    SurfaceView surface = (SurfaceView) findViewById(R.id.surface2);
	    surface.getHolder().addCallback(new SurfaceHolder.Callback() {

	        @Override
	        public void surfaceCreated(SurfaceHolder holder) {
	            // Do some drawing when surface is ready

	            
	            Log.wtf("no","bitch ass niggas b h8in on my dick ass bitches");

	            Canvas canvas = holder.lockCanvas();
	            canvas.drawColor(Color.RED);
	            
	            Paint paint = new Paint();
	            paint.setStyle(Style.FILL);
	            int canvasWidth = canvas.getWidth();
	            int canvasHeight = canvas.getHeight();

	            int squareWidth = canvasWidth / NUMBER_OF_HORIZONTAL_SQUARES;
	            int squareHeight = canvasHeight / NUMBER_OF_VERTICAL_SQUARES;
	            Rect destinationRect = new Rect();

	            int xOffset;
	            int yOffset;

	            // Set the destination rectangle size
	            destinationRect.set(0, 0, squareWidth, squareHeight);
	            
	            for (int horizontalPosition = 0; horizontalPosition < NUMBER_OF_HORIZONTAL_SQUARES; horizontalPosition++){

	                xOffset = horizontalPosition * squareWidth;

	                for (int verticalPosition = 0; verticalPosition < NUMBER_OF_VERTICAL_SQUARES; verticalPosition++){

	                    yOffset = verticalPosition * squareHeight;

	                    // Set the destination rectangle offset for the canvas origin
	                    destinationRect.offsetTo(xOffset, yOffset);

	                    // Draw the bitmap into the destination rectangle on the canvas
	                    canvas.drawBitmap(
//	                    		bitmapArray[verticalPosition][horizontalPosition]
//	                    		bmpArr.get(verticalPosition).get(horizontalPosition)
	                    		tempBMP
	                    				, null, destinationRect, paint);
	                }
	            }
	            
//	            Bitmap icon = BitmapFactory.decodeResource(DrawFragment2.this.getResources(), R.drawable.ic_launcher);
//	            Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
//	            canvas.drawBitmap(bitmap, 0,0, paint);
//	            canvas.drawRect(new Rect(0, 0, 200, 200), paint);
	            
	            
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
}
