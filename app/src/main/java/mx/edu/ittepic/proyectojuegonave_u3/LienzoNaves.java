package mx.edu.ittepic.proyectojuegonave_u3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class LienzoNaves extends View {
    ImagenNaves nave1,nave2,nave3, cohete, puntero, fondo,disparar,gameover,meteoro1,meteoro2,
            meteoro3,meteoro4,meteoro5,meteoro6,meteoro7,meteoro8,meteoro9,meteoro10,puntero2,dispararnave1,
            dispararnave2, dispararnave3,botonReiniciar,ganaste, jefe,disparoJefe1,disparoJefe2,disparoJefe3,disparoJefe4,disparoJefe5,
            punterodisparonave1,punterodisparonave2,punterodisparonave3, punterodisparoJefe1, punterodisparoJefe2,
            punterodisparoJefe3,punterodisparoJefe4,punterodisparoJefe5;
    MainActivity sonidoPrincipal, punteroInicio,sonidoPerdiste,sonidoGanaste;
    String score;
    float xCohete;
    int numero = 00000;
    public LienzoNaves(Context context) {
        super(context);

        score = "SCORE: "+numero;

        botonReiniciar = new ImagenNaves(R.drawable.reiniciar,300,1200,this,botonReiniciar);
        fondo = new ImagenNaves(R.drawable.fondo1, 0, 0, this,fondo);
        cohete = new ImagenNaves(R.drawable.cohete, 100, 1640, this,cohete);
        disparar = new ImagenNaves(R.drawable.disparo, 205, 1670, this,disparar);//disparo de cohete
        gameover = new ImagenNaves(R.drawable.game,50,500,this,gameover);
        ganaste = new ImagenNaves(R.drawable.ganaste,50,500,this,ganaste);
        jefe = new ImagenNaves(R.drawable.jefe, 20, 50, this,jefe);


        meteoro1 =  new ImagenNaves(R.drawable.meteoro,920,-1250,this,meteoro1);
        meteoro2 =  new ImagenNaves(R.drawable.meteoro,730,-1600,this,meteoro2);
        meteoro3 =  new ImagenNaves(R.drawable.meteoro,20,-500,this,meteoro3);
        meteoro4 =  new ImagenNaves(R.drawable.meteoro,510,-3300,this,meteoro4);
        meteoro6 =  new ImagenNaves(R.drawable.meteoro,380,-1500,this,meteoro6);
        meteoro7 =  new ImagenNaves(R.drawable.meteoro,130,-800,this,meteoro7);
        meteoro8 =  new ImagenNaves(R.drawable.meteoro,290,-1300,this,meteoro8);
        meteoro9 =  new ImagenNaves(R.drawable.meteoro,890,-2400,this,meteoro9);
        meteoro10 = new ImagenNaves(R.drawable.meteoro,930,-1000,this,meteoro10);

        nave1 = new ImagenNaves(R.drawable.navealien, 25, 5, this,nave1);
        nave2 = new ImagenNaves(R.drawable.navealien,400,-10,this,nave2);
        nave3 =  new ImagenNaves(R.drawable.navealien,750,-5,this,nave3);

        //disparos de cada nave alien
        dispararnave1 = new ImagenNaves(R.drawable.disparonave, 130, -5, this,nave1);
        dispararnave2 = new ImagenNaves(R.drawable.disparonave, 510, -10, this,nave2);
        dispararnave3 = new ImagenNaves(R.drawable.disparonave, 855, -5, this,nave3);

        //disparos del jefe

        disparoJefe1 = new ImagenNaves(R.drawable.disparonave, 10, 500, this,disparoJefe1);
        disparoJefe2 = new ImagenNaves(R.drawable.disparonave,460,700,this,disparoJefe2);
        disparoJefe3 =  new ImagenNaves(R.drawable.disparonave,850,500,this,disparoJefe3);
        disparoJefe4 = new ImagenNaves(R.drawable.disparonave, 650, 480, this,disparoJefe4);
        disparoJefe5 = new ImagenNaves(R.drawable.disparonave,270,480,this,disparoJefe5);

        disparoJefe1.moverDisparoJefe2(5);
        disparoJefe2.moverDisparoJefe2(14);
        disparoJefe3.moverDisparoJefe2(10);
        disparoJefe4.moverDisparoJefe2(13);
        disparoJefe5.moverDisparoJefe2(3);

        meteoro1.moverMeteoro(3);
        meteoro2.moverMeteoro(7);
        meteoro3.moverMeteoro(6);
        meteoro4.moverMeteoro(10);
        meteoro6.moverMeteoro(3);
        meteoro7.moverMeteoro(13);
        meteoro8.moverMeteoro(8);
        meteoro9.moverMeteoro(4);
        meteoro10.moverMeteoro(15);

        nave1.moverNave(10);//moviendo nave1
        nave2.moverNave(5);//moviendo nave2
        nave3.moverNave(8);//moviendo nave3

        dispararnave1.moverDisparo(15);//moviendo disparo de la nave1
        dispararnave2.moverDisparo(20);
        dispararnave3.moverDisparo(12);

        disparar.moverDisparoCohete2(-37);//DISPARO DEL COHETE.


        puntero = null;
        puntero2 = null;
        gameover.hacerVisible(false);
        botonReiniciar.hacerVisible(false);
        ganaste.hacerVisible(false);
        jefe.hacerVisible(false);

        disparoJefe1.hacerVisible(false);
        disparoJefe2.hacerVisible(false);
        disparoJefe3.hacerVisible(false);
        disparoJefe5.hacerVisible(false);
        disparoJefe4.hacerVisible(false);


        punteroInicio = (MainActivity) context;//manda llamar al metodo
        sonidoPrincipal = (MainActivity) context;
        sonidoPrincipal.musicaInicio();//musica de inicio

        sonidoGanaste = (MainActivity) context;
        sonidoPerdiste = (MainActivity) context;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        fondo.pintar(canvas,p);

        p.setTextSize(50);
        p.setColor(Color.WHITE);
        canvas.drawText(score,450,50,p);

        nave1.pintar(canvas, p);
        nave2.pintar(canvas,p);
        nave3.pintar(canvas,p);
        disparar.pintar(canvas,p);
        dispararnave1.pintar(canvas,p);
        dispararnave2.pintar(canvas,p);
        dispararnave3.pintar(canvas,p);

        meteoro1.pintar(canvas,p);
        meteoro2.pintar(canvas,p);
        meteoro3.pintar(canvas,p);
        meteoro4.pintar(canvas,p);
        meteoro6.pintar(canvas,p);
        meteoro7.pintar(canvas,p);
        meteoro8.pintar(canvas,p);
        meteoro9.pintar(canvas,p);
        meteoro10.pintar(canvas,p);
        disparoJefe1.pintar(canvas,p);
        disparoJefe2.pintar(canvas,p);
        disparoJefe3.pintar(canvas,p);
        disparoJefe4.pintar(canvas,p);
        disparoJefe5.pintar(canvas,p);
        jefe.pintar(canvas,p);
        cohete.pintar(canvas,p);
        botonReiniciar.pintar(canvas,p);
        ganaste.pintar(canvas,p);
        gameover.pintar(canvas,p);


    }

    public boolean onTouchEvent(MotionEvent e){
        float xp = e.getX(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las x (lo ancho de la pantalla)
        float yp = e.getY(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las y (lo alto de la pantalla)


        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (cohete.estaEnArea(xp,yp)) {
                    //disparar = new ImagenNaves(R.drawable.disparo, xp, yp, this,disparar);
                    puntero = cohete;
                    puntero2 = disparar;

                    punterodisparonave1 = dispararnave1;//disparos de las naves
                    punterodisparonave2 = dispararnave2;
                    punterodisparonave3 = dispararnave3;

                    punterodisparoJefe1 = disparoJefe1;
                    punterodisparoJefe2 = disparoJefe2;
                    punterodisparoJefe3 = disparoJefe3;
                    punterodisparoJefe4 = disparoJefe4;
                    punterodisparoJefe5 = disparoJefe5;

                }

                if (botonReiniciar.estaEnArea(xp,yp)){
                    if (numero == 0){
                        Intent nuevos = new Intent(punteroInicio,MainActivity.class);
                        punteroInicio.startActivity(nuevos);
                        sonidoPrincipal.pararMusicaInicio();
                    }

                    if (numero >= 10){
                        Intent nuevos = new Intent(punteroInicio,MainActivity.class);
                        punteroInicio.startActivity(nuevos);
                        sonidoPrincipal.pararMusicaInicio();
                    }

                    ////////////////////////////////////////////////////////////arreglando bug

                    if (numero == 1010){
                        Intent nuevos = new Intent(punteroInicio,MainActivity.class);
                        punteroInicio.startActivity(nuevos);
                        sonidoPrincipal.pararMusicaInicio();
                        numero = 1000;
                    }

                    if (numero == 2010){
                        Intent nuevos = new Intent(punteroInicio,MainActivity.class);
                        punteroInicio.startActivity(nuevos);
                        sonidoPrincipal.pararMusicaInicio();
                        numero = 2000;
                    }
                }

                //disparar.moverDisparoCohete(-30);

                break;

            case MotionEvent.ACTION_MOVE:

                if (puntero != null){
                    if (puntero == cohete) {
                        cohete.mover(xp);
                        xCohete = puntero.getX()+150;

                        punterodisparoJefe1 = disparoJefe1;
                        punterodisparoJefe2 = disparoJefe2;
                        punterodisparoJefe3 = disparoJefe3;
                        punterodisparoJefe4 = disparoJefe4;
                        punterodisparoJefe5 = disparoJefe5;
                    }

                    if (puntero2.colision(nave1) && puntero2 == disparar){
                        disparar.hacerVisible(true);
                        nave1.hacerVisible(false);
                        numero = 1000+numero;
                        score = "SCORE: "+numero;
                        dispararnave1 = new ImagenNaves(R.drawable.disparonave, -100, -5, this,nave1);
                        dispararnave1.hacerVisible(false);

                    }

                    if (puntero2.colision(nave2) && puntero2 == disparar){
                        disparar.hacerVisible(true);
                        nave2.hacerVisible(false);
                        numero = 1000+numero;
                        score = "SCORE: "+numero;
                        dispararnave2 = new ImagenNaves(R.drawable.disparonave, -100, -10, this,nave2);
                        dispararnave2.hacerVisible(false);
                    }

                    if (puntero2.colision(nave3) && puntero2 == disparar){
                        disparar.hacerVisible(true);
                        nave3.hacerVisible(false);
                        numero = 1000+numero;
                        score = "SCORE: "+numero;
                        dispararnave3 = new ImagenNaves(R.drawable.disparonave, -100, -5, this,nave3);
                        dispararnave3.hacerVisible(false);


                    }
                    //////////////////////////////////////////////cohete toca a alguna nave.

                    if (puntero.colision(nave1) && puntero == cohete){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (puntero.colision(nave2) && puntero == cohete){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (puntero.colision(nave3) && puntero == cohete){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    /////////////////////////////// meteorito toca al cohete

                    if (puntero.colision(meteoro1) && puntero == cohete){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (puntero.colision(meteoro2) && puntero == cohete){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (puntero.colision(meteoro3) && puntero == cohete){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (puntero.colision(meteoro4) && puntero == cohete){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (puntero.colision(meteoro6) && puntero == cohete){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (puntero.colision(meteoro7) && puntero == cohete){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (puntero.colision(meteoro8) && puntero == cohete){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (puntero.colision(meteoro9) && puntero == cohete){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (puntero.colision(meteoro10) && puntero == cohete){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }


                    //////////////////////////////// disparos de las naves chocan con cohete (colision)

                    if (punterodisparonave3.colision(cohete) && punterodisparonave3 == dispararnave3){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (punterodisparonave1.colision(cohete) && punterodisparonave1 == dispararnave1){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (punterodisparonave2.colision(cohete) && punterodisparonave2 == dispararnave2){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    ////////////////////////////////////// colision disparo cohete toca a jefe

                    if (puntero2.colision(jefe) && puntero2 == disparar){
                        disparar.hacerVisible(true);
                        nave1.hacerVisible(false);
                        numero = 1000+numero;
                        score = "SCORE: "+numero;

                    }

                    /////////////////////////////////////////// colision disparo jefe toca a cohete

                    if (punterodisparoJefe1.colision(cohete) && punterodisparoJefe1 == disparoJefe1){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (punterodisparoJefe2.colision(cohete) && punterodisparoJefe2 == disparoJefe2){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (punterodisparoJefe3.colision(cohete) && punterodisparoJefe3 == disparoJefe3){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (punterodisparoJefe4.colision(cohete) && punterodisparoJefe4 == disparoJefe4){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    if (punterodisparoJefe5.colision(cohete) && punterodisparoJefe5 == disparoJefe5){
                        cohete.hacerVisible(false);
                        gameover.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        disparar.hacerVisible(false);
                        numero = 10;
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoPerdiste.musicaPerdiste();
                    }

                    /////////////////////////////////////////////7

                    if (numero == 3000){
                        jefe.hacerVisible(true);
                        dispararnave1.hacerVisible(false);
                        dispararnave2.hacerVisible(false);
                        dispararnave3.hacerVisible(false);

                        disparoJefe1 = new ImagenNaves(R.drawable.disparonave, 60, 500, this,disparoJefe1);
                        disparoJefe5 = new ImagenNaves(R.drawable.disparonave,320,480,this,disparoJefe5);
                        disparoJefe2 = new ImagenNaves(R.drawable.disparonave,510,700,this,disparoJefe2);
                        disparoJefe4 = new ImagenNaves(R.drawable.disparonave, 700, 480, this,disparoJefe4);
                        disparoJefe3 =  new ImagenNaves(R.drawable.disparonave,900,500,this,disparoJefe3);

                        disparoJefe1.moverDisparoJefe(5);
                        disparoJefe2.moverDisparoJefe(7);
                        disparoJefe3.moverDisparoJefe(12);
                        disparoJefe4.moverDisparoJefe(7);
                        disparoJefe5.moverDisparoJefe(3);


                        sonidoPrincipal.pararMusicaInicio();
                        sonidoGanaste.musicaJefe();

                    }

                    if (numero >= 800000){
                        cohete.hacerVisible(false);
                        ganaste.hacerVisible(true);
                        botonReiniciar.hacerVisible(true);
                        jefe.hacerVisible(false);
                        disparar.hacerVisible(false);
                        disparoJefe1.hacerVisible(false);
                        disparoJefe2.hacerVisible(false);
                        disparoJefe3.hacerVisible(false);
                        disparoJefe4.hacerVisible(false);
                        disparoJefe5.hacerVisible(false);
                        sonidoPrincipal.pararMusicaInicio();
                        sonidoGanaste.musicaGanaste();
                        numero = 0;
                    }

                }

                break;

            case MotionEvent.ACTION_UP:
                puntero = null;
                puntero2 = null;

                punterodisparonave1 = null;
                punterodisparonave2 = null;
                punterodisparonave3 = null;

                punterodisparoJefe1 = null;
                punterodisparoJefe2 = null;
                punterodisparoJefe3 = null;

        }
        invalidate();
        return true;
    }
}
