package mx.edu.ittepic.proyectojuegonave_u3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.sax.StartElementListener;

public class ImagenNaves {
    private Bitmap icono;
    private float x,y;
    boolean visible;
    CountDownTimer timer;
    int desplazamiento;
    int desplazadisparonave;
    int desplazameteoro;
    int desplazadisparocohete;
    int desplazadisparojefe;
    int desplazadisparojefe2;
    CountDownTimer timerdisparo;
    CountDownTimer timerdisparoJefe;

    public ImagenNaves(int resource, float _x, float _y, final LienzoNaves l,final ImagenNaves n){
        icono = BitmapFactory.decodeResource(l.getResources(),resource);
        x = _x;
        y = _y;
        visible = true;

        timer = new CountDownTimer(1000,100) {
            @Override
            public void onTick(long millisUntilFinished) {

                y+= desplazamiento;
                if (y >= l.getHeight()){
                    y = -50;
                }

                //y+= desplazadisparocohete;
                //if (y >= l.getHeight()){
                  //  y = -45;
                //}

                y+= desplazameteoro;
                if (y >= l.getHeight()){
                    y = -45;
                }

                y+= desplazadisparonave;
                if (y >= l.getHeight()){
                    y = n.getY();
                }


                y+= desplazadisparojefe;
                if (y >= l.getHeight()){
                    y = 300;
                }

                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };

        timerdisparo = new CountDownTimer(1000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                y += desplazadisparocohete;
                if (y <= 0){
                    y = 1640;
                    x = l.xCohete-50;

                }

            }

            @Override
            public void onFinish() {
                start();
            }
        };

        timerdisparoJefe = new CountDownTimer(1000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                y+= desplazadisparojefe2;
                if (y >= 300){
                    y = 100;
                }
            }

            @Override
            public void onFinish() {
                start();
            }
        };

    }

    public void pintar(Canvas c, Paint p){
        if (visible) c.drawBitmap(icono,x,y,p);

    }

    public void hacerVisible(boolean v){
        visible = v;
    }

    public void moverNave(int desplaza){//le asigna a desplazamiento del valor de desplaza
        desplazamiento = desplaza;
        timer.start();
    }

    public void moverDisparo(int desplaza){//le asigna a desplazamiento del valor de desplaza
        desplazadisparonave = desplaza;
        timer.start();
    }

    public void moverMeteoro(int desplaza){//le asigna a desplazamiento del valor de desplaza
        desplazameteoro = desplaza;
        timer.start();
    }

    //public void moverDisparoCohete(int desplaza){//le asigna a desplazamiento del valor de desplaza
        //desplazadisparocohete = desplaza;
        //timer.start();
    //}

    public void moverDisparoCohete2(int desplaza){//le asigna a desplazamiento del valor de desplaza
        desplazadisparocohete = desplaza;
        timerdisparo.start();
    }


    public void moverDisparoJefe(int desplaza){//le asigna a desplazamiento del valor de desplaza
        desplazadisparojefe = desplaza;
        timer.start();
    }

    public void moverDisparoJefe2(int desplaza){//le asigna a desplazamiento del valor de desplaza
        desplazadisparojefe2 = desplaza;
        timerdisparoJefe.start();
    }


    public boolean estaEnArea (float xp, float yp){
        if(!visible) return false;
        float x2,y2;

        x2 = x + icono.getWidth();
        y2 = y + icono.getHeight();

        if (xp >= x && xp <= x2){
            if (yp >= y && yp <= y2){
                return true;
            }
        }
        return false;
    }

    public void mover(float xp){
        x = xp - (icono.getWidth()/2);
    }


    public boolean colision(ImagenNaves objetoB){
        float x2 = x+icono.getWidth();
        float y2 = y+icono.getHeight();

        if (objetoB.estaEnArea(x2,y)){
            return true;
        }

        if (objetoB.estaEnArea(x,y)){//caso 2
            return true;
        }

        if (objetoB.estaEnArea(x2,y2)){//caso 3
            return true;
        }

        if (objetoB.estaEnArea(x,y2)){//caso 4
            return true;
        }

        return false;
    }


    public float getY(){
        return y;
    }

    public float getX(){
        return x;
    }


}
