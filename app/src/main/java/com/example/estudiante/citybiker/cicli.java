package com.example.estudiante.citybiker;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by solecito on 26/08/16.
 */
public class cicli {

    private Bitmap image;
    private int x, y, dx;

    public cicli(Bitmap res)
    {
        image = res;
    }
    public void update()
    {
        x+=dx;
        if(x<-juego.WIDTH){
            x=0;
        }
    }
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image, x, y,null);
        if(x<0)
        {
            canvas.drawBitmap(image, x+juego.WIDTH, y, null);
        }
    }
    public void setVector(int dx)
    {
        this.dx = dx;
    }
}


