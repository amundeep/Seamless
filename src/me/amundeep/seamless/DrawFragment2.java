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
	public Bitmap[] bitmapArray;
	public ArrayList<ArrayList<Bitmap>> bmpArr;
	public Bitmap bmp1;
	public Bitmap bmp2;
	public Bitmap bmp3;
	public Bitmap bmp4;
	public Bitmap bmp5;
	public Bitmap bmp6;
	public Bitmap bmp7;
	public Bitmap bmp8;
	public Bitmap bmp9;
	public Bitmap bmp10;
	public Bitmap bmp11;
	public Bitmap bmp12;
	public Bitmap bmp13;
	public Bitmap bmp14;
	public Bitmap bmp15;
	public Bitmap bmp16;
	
	private static final int NUMBER_OF_VERTICAL_SQUARES = 4;
	private static final int NUMBER_OF_HORIZONTAL_SQUARES = 4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    setContentView(R.layout.fragment_2);
	    Intent i = getIntent();
//	    
//	    for(int r = 0; r < NUMBER_OF_VERTICAL_SQUARES; r++){
//	    	ArrayList<Bitmap> bswag = new ArrayList<Bitmap>();
//	    	for(int c = 0; c < NUMBER_OF_HORIZONTAL_SQUARES; c++){
	    		//bitmapArray = (Bitmap[]) i.getExtras().get("bitmapArray");
//	    		byte[] byteArray = i.getByteArrayExtra("b:" + r + "," + c);
//	    		Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//	    		bitmapArray[r][c]=b[r][c];
	//    	}
//	    	bmpArr.add(bswag);
	  //  }
	    
	    bmp1=(Bitmap) i.getExtras().get("bmp1");
	    bmp2=(Bitmap) i.getExtras().get("bmp2");
	    bmp3=(Bitmap) i.getExtras().get("bmp3");
	    bmp4=(Bitmap) i.getExtras().get("bmp4");
	    bmp5=(Bitmap) i.getExtras().get("bmp5");
	    bmp6=(Bitmap) i.getExtras().get("bmp6");
	    bmp7=(Bitmap) i.getExtras().get("bmp7");
	    bmp8=(Bitmap) i.getExtras().get("bmp8");
	    bmp9=(Bitmap) i.getExtras().get("bmp9");
	    bmp10=(Bitmap) i.getExtras().get("bmp10");
	    bmp11=(Bitmap) i.getExtras().get("bmp11");
	    bmp12=(Bitmap) i.getExtras().get("bmp12");
	    bmp13=(Bitmap) i.getExtras().get("bmp13");
	    bmp14=(Bitmap) i.getExtras().get("bmp14");
	    bmp15=(Bitmap) i.getExtras().get("bmp15");
	    bmp16=(Bitmap) i.getExtras().get("bmp16");
	    
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

	            int xOffset=0;
	            int yOffset=0;
	            int counter=0;

	            // Set the destination rectangle size
	            destinationRect.set(0, 0, squareWidth, squareHeight);
	            
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
//	                    canvas.drawBitmap(
////	                    		bitmapArray[verticalPosition][horizontalPosition]
////	                    		bmpArr.get(verticalPosition).get(horizontalPosition)
//	                    		bitmapArray[counter]
//	                    				, null, destinationRect, paint);
//	                    counter++;
//	                }
//	            }
	            
	            canvas.drawBitmap(bmp1, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp2, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp3, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp4, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            xOffset=0;
	            yOffset+=squareHeight;
	            
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp5, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp6, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp7, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp8, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            xOffset=0;yOffset+=squareHeight;
	            
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp9, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp10, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp11, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp12, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            xOffset=0;yOffset+=squareHeight;
	            
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp13, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp14, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp15, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            canvas.drawBitmap(bmp16, null, destinationRect, paint);
	            xOffset+=squareWidth;
	            destinationRect.offsetTo(xOffset, yOffset);
	            xOffset=0;yOffset+=squareHeight;
	            

	            
	            
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
