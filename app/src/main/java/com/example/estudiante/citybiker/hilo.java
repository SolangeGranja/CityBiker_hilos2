package com.example.estudiante.citybiker;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by solecito on 19/08/16.
 */
public class hilo extends Thread {

    private int FPS=30;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private juego panel;
    private boolean running;
    public static Canvas canvas;

    public hilo (SurfaceHolder surfaceHolder, juego panel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.panel = panel;
    }
    @Override
    public void run() {

        long startTime;
        long timeMills;
        long waitTime;
        long totalTime = 0;
        long frameCont = 0;
        long tartetTime = 1000 / FPS;

        while (running) {
            startTime = System.nanoTime();
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.panel.update();
                    this.panel.draw(canvas);
                }
            } catch (Exception e) {

            }
            finally {
                if(canvas!=null){
                    try{
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

            timeMills = (System.nanoTime() - startTime) / 1000000;
            waitTime = tartetTime - timeMills;

            try {
                this.sleep(waitTime);

            } catch (Exception e) {
            }

            totalTime+=System.nanoTime()-startTime;
            frameCont++;
            if(frameCont==FPS){
                averageFPS=1000/((totalTime/frameCont)/1000000);
                frameCont=0;
                totalTime=0;
                System.out.println(averageFPS);
            }
        }
    }
    public void setRunning(boolean b){
        running=b;
    }
}
