package me.amundeep.seamless;

import javax.security.auth.callback.Callback;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class DrawFragment2 extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    setContentView(R.layout.fragment_2);

	    SurfaceView surface = (SurfaceView) findViewById(R.id.surface2);
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
	}
}
