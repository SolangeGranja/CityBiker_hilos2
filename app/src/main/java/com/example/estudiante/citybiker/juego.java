package com.example.estudiante.citybiker;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by solecito on 19/08/16.
 */
public class juego extends SurfaceView implements SurfaceHolder.Callback{
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 350;
    private hilo thread;
   private fondo fd;
    private cicli cl;

    public juego(Context context)
    {
        super(context);


        //add the callback to the surfaceholder to intercept events
        getHolder().addCallback(this);

        thread = new hilo(getHolder(), this);

        //make gamePanel focusable so it can handle events
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        while(retry)
        {
            try{thread.setRunning(false);
                thread.join();

            }catch(InterruptedException e){e.printStackTrace();}
            retry = false;
        }

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){

        fd = new fondo(BitmapFactory.decodeResource(getResources(), R.drawable.escenariocompleto));
        cl = new cicli(BitmapFactory.decodeResource(getResources(), R.drawable.ciclista));

        fd.setVector(-5);
        cl.setVector(-5);
        thread.setRunning(true);
        thread.start();

    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return super.onTouchEvent(event);
    }

    public void update()
    {

       fd.update();
        cl.update();
    }
    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        final float scaleFactorX = getWidth()/WIDTH;
        final float scaleFactorY = getHeight()/HEIGHT;
        if(canvas!=null) {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            fd.draw(canvas);
            cl.draw(canvas);
            canvas.restoreToCount(savedState);
        }
    }

}

