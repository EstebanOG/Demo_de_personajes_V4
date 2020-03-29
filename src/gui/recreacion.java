package gui;

import animacion.*;
import chainOfResponsability.Verificar;
import colisiones.EvaluarColisiones;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import observer.AlarmaColisionPocima;
import pocima.Pocima;
import state.EstadoPersonaje;
import state.Herido;
import state.Moribundo;
import state.Vigoroso;
import strategy.StrategyNormal;
import strategy.StrategyDecorado;
import strategy.Strategy;

public class recreacion extends JPanel {
    //static Canon canon;
    static Personaje personaje;
    public Verificar aumentoPorPocima = new Verificar();//Se crea un objeto de la clase Verificar la cual se encuentra ChainOfResponsability
    Strategy clonarVida; // Objeto de la clase Strategy
    /*Se definen los objetos de las clases que se encargan de verificar el estado del personaje*/
    EstadoPersonaje estadoPersonaje = new EstadoPersonaje();
    Herido personajeHerido = new Herido();
    Moribundo personajeMoribundo = new Moribundo();
    Vigoroso personajeVigoroso = new Vigoroso();
    
    /*******************************************************************************************/
    EvaluarColisiones evaluarColisiones = new EvaluarColisiones();
    Pocima pocima = new Pocima();
    JFrame ventana = new JFrame();
    Font fuenteVida = new Font("Calibri", 3, 16);// Fuente vida
    Font fuenteEscudo = new Font("Calibri", 3, 16);// Fuente escudo
    static ArrayList<Canon> canonList = new ArrayList<>();
    static ArrayList<Personaje> personajetemp = new ArrayList<>();
    static ArrayList<Object> arreglo_personajes = new ArrayList<>();
    private final int AnchoVentana = 800;
    private final int AltoVentana = 600;
    Thread hilo;
    boolean inicio = false;
    BufferedImage bi;
    Image img, fondo, pocion, can;
    Toolkit h = Toolkit.getDefaultToolkit();
    Graphics2D g2d;
    int Incremento = 0;
    int incx = 340;
    int incy = 230;
    static int mx=(1/4)*93;
    static int my=(1/4)*93;
    int incremento = 0;
    boolean arriba = true;
    boolean abajo = true;
    boolean izquierda = true;
    boolean derecha = true;
    boolean ataca = false;
    String[] posicion = {"derecha", "derecha"};
    public static String eleccion;
    public static String poblacion;
    public static boolean clonar = false;
    static Animacion animar = new Animacion();
    int i = 0;
    boolean colision = false;
    boolean colisionPocima = false;
    Rectangle rect = new Rectangle(403, 423, 30, 20);
    Rectangle rectPj = new Rectangle(340, 230, 52, 80);
    private static int posY;
    private static int posX;

    boolean entra = true;

    public recreacion() {

        fondo = h.getImage(this.getClass().getResource("/assets/map.png"));
<<<<<<< HEAD
        pocion = h.getImage(this.getClass().getResource("/assets/Pocion2.png"));
        can = h.getImage(this.getClass().getResource("/assets/Canon_der.png"));
=======
        //pocion = h.getImage(this.getClass().getResource("/assets/Pocion2.png"));
        pocion = h.getImage(this.getClass().getResource(pocima.getImagen()));
>>>>>>> 462937d6e67695eafc9e7b4cc7a13a6bea1d912a
        ventana.setSize(AnchoVentana, AltoVentana);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Recreación");
        ventana.setVisible(true);
        ventana.getContentPane().add(this);
        bi = new BufferedImage(AnchoVentana, AltoVentana, BufferedImage.TYPE_INT_RGB);
        img = h.getImage(this.getClass().getResource(personaje.getDerecha()));
        inicio = true;
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        posicion[0] = posicion[1];
                        posicion[1] = "arriba";
                        ataca = false;
                        img = h.getImage(this.getClass().getResource(personaje.getArriba()));
                        Incremento++;
                        if (Incremento > 4) {
                            Incremento = 0;
                        }
                        if (arriba == true) {
                            incy = incy - 4;
                            if (incy < 20) {
                                incy = incy + 4;
                            }
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        posicion[0] = posicion[1];
                        posicion[1] = "abajo";
                        ataca = false;
                        img = h.getImage(this.getClass().getResource(personaje.getAbajo()));

                        Incremento++;

                        if (Incremento > 4) {
                            Incremento = 0;
                        }
                        if (abajo == true) {
                            incy = incy + 4;
                            if (incy > getHeight() - 40) {
                                incy = incy - 4;
                            }
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        posicion[0] = posicion[1];
                        posicion[1] = "derecha";
                        ataca = false;
                        img = h.getImage(this.getClass().getResource(personaje.getDerecha()));
                        Incremento++;
                        if (Incremento > 4) {
                            Incremento = 0;
                        }
                        if (derecha == true) {
                            incx = incx + 4;
                            if (incx > getWidth() - 15) {
                                incx = incx - 10;
                            }
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        posicion[0] = posicion[1];
                        posicion[1] = "izquierda";
                        ataca = false;
                        img = h.getImage(this.getClass().getResource(personaje.getIzquierda()));
                        Incremento++;
                        if (Incremento > 4) {
                            Incremento = 0;
                        }
                        if (izquierda = true) {
                            incx = incx - 4;
                            if (incx < -4) {
                                incx = incx + 4;
                            }
                        }
                        break;
                    case KeyEvent.VK_C:
                        posicion[0] = posicion[1];
                        switch (posicion[1]) {
                            case "arriba":
                                img = h.getImage(this.getClass().getResource(personaje.getAtacaArriba()));
                                break;
                            case "abajo":
                                img = h.getImage(this.getClass().getResource(personaje.getAtacaAbajo()));
                                break;
                            case "derecha":
                                img = h.getImage(this.getClass().getResource(personaje.getAtacaDerecha()));
                                break;
                            case "izquierda":
                                img = h.getImage(this.getClass().getResource(personaje.getAtacaIzquierda()));
                                break;
                        }
                        ataca = true;
                        Incremento = Incremento + 5;
                        if (Incremento > 5) {
                            Incremento = 0;
                        }
                        break;
                    case KeyEvent.VK_Q:
                        //personajetemp.clear();
                        for (i = 0; i < arreglo_personajes.size(); i++) {
                            personajetemp.add((Personaje) arreglo_personajes.get(i));
                            if (arreglo_personajes.size() < 2) {//Se clona el personaje, máximo un clon
                                /*Se utiliza Strategy para evaluar la vida que se le baja a ambos personajes*/
                                /*Si está decorado se le baja 20 de vida al clonar*/
                                /*Si está normal se le baja 40 de vida al clonar*/
                                /*Con la variable entra se evalua si cogio la pocima o no*/
                                if (entra == true) {
                                    clonarVida = new StrategyNormal(personajetemp.get(i));
                                    clonarVida.vidaEscudo();
                                } else {
                                    clonarVida = new StrategyDecorado(personajetemp.get(i));
                                    clonarVida.vidaEscudo();
                                }
                                Personaje personajeClonUno = (Personaje) personajetemp.get(i).clonar();
                                arreglo_personajes.add(personajeClonUno);
                            }
                        }
                        break;

                }
            }
        });
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bi, 0, 0, null);
        int mxA;
        int myA;
        int y = 0;
        int aumentoSpriteY;
        g2d = bi.createGraphics();
        g2d.drawImage(fondo, 0, 0, AnchoVentana, AltoVentana, this);
<<<<<<< HEAD
//        mx = 23;
//        my = 0;
//        for (int j = 0; j < canonList.size(); j++) {
//            if(j<=3){
//                can = h.getImage(this.getClass().getResource("/assets/Canon_izq.png"));
//            }
            can = h.getImage(this.getClass().getResource("/assets/Canon_izq.png"));
            g2d.drawImage(can, canonList.get(0).getPosX(), canonList.get(0).getPosY(), 100, 100, canonList.get(0).getIncX(), canonList.get(0).getIncY(), 23+93, 23+93, this);
            g2d.drawImage(can, canonList.get(1).getPosX(), canonList.get(1).getPosY(), 100, 100, canonList.get(1).getIncX(), canonList.get(1).getIncY(), 116+93, 93, this);
//            g2d.drawImage(can, canonList.get(2).getPosX(), canonList.get(2).getPosY(), 100, 100, canonList.get(2).getIncX(), canonList.get(2).getIncY(), mx+93, my+93, this);
//            g2d.drawImage(can, canonList.get(3).getPosX(), canonList.get(3).getPosY(), 100, 100, canonList.get(3).getIncX(), canonList.get(3).getIncY(), mx+93, my+93, this);
//            can = h.getImage(this.getClass().getResource("/assets/Canon_der.png"));
//            g2d.drawImage(can, canonList.get(4).getPosX(), canonList.get(4).getPosY(), 100, 100, canonList.get(4).getIncX(), canonList.get(4).getIncY(), mx+93, my+93, this);
//            g2d.drawImage(can, canonList.get(5).getPosX(), canonList.get(5).getPosY(), 100, 100, canonList.get(5).getIncX(), canonList.get(5).getIncY(), mx+93, my+93, this);
//            g2d.drawImage(can, canonList.get(6).getPosX(), canonList.get(6).getPosY(), 100, 100, canonList.get(6).getIncX(), canonList.get(6).getIncY(), mx+93, my+93, this);
//            
//            if(j>=3){
//                can = h.getImage(this.getClass().getResource("/assets/Canon_der.png"));
//            }
//        }
        //incremento++;
        
 
        if(colisionPocima == false){
            g2d.drawImage(pocion, 390, 400, 60, 60, this);
        }
=======
//        if(colisionPocima == false){
        g2d.drawImage(pocion, pocima.getCoordenadaX(), pocima.getCoordenadaY(), pocima.getAlto(), pocima.getAncho(), this);
//        }
>>>>>>> 462937d6e67695eafc9e7b4cc7a13a6bea1d912a
        if (1 == arreglo_personajes.size()) {
            aumentoSpriteY = 0;
        } else {
            aumentoSpriteY = 110;
        }
        for (i = 0; i < arreglo_personajes.size(); i++) {
            personajetemp.add((Personaje) arreglo_personajes.get(i));
            /*Se verifica el estado del personaje y cambia su daño así:
            Vigoroso(70 puntos de vida o más): Daño 50
            Herido(Más de 20 y menos de 70 puntos de vida): Daño 80
            Moribundo(20 puntos de vida o menos): Daño 100
            */
            estadoPersonaje.setPersonaje(personajetemp.get(i));
            System.out.println(pocima.getCoordenadaX());
            if(personajetemp.get(i).getVida()>70){
                estadoPersonaje.setEstadoPersonaje(personajeVigoroso);
            }else if(personajetemp.get(i).getVida()>20){
                estadoPersonaje.setEstadoPersonaje(personajeHerido);
            }else{
                estadoPersonaje.setEstadoPersonaje(personajeMoribundo);
            }
            estadoPersonaje.verificarEstado();
            /*************************************/
            if (ataca == true) {
                switch (posicion[0]) {
                    case "arriba":
                        mxA = (Incremento % personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaArribaX();
                        myA = (Incremento / personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaArribaY();
                        g2d.drawImage(img, incx - personajetemp.get(i).getIncxArribaUno(), y + incy - personajetemp.get(i).getIncyArribaUno(), personajetemp.get(i).getIncxArribaDos() + incx, personajetemp.get(i).getIncyArribaDos() + incy + y, mxA, myA, mxA + personajetemp.get(i).getSpriteAtacaArribaX(), myA + personajetemp.get(i).getSpriteAtacaArribaY(), this);
                        break;
                    case "abajo":
                        mxA = (Incremento % personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaAbajoX();
                        myA = (Incremento / personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaAbajoY();
                        g2d.drawImage(img, incx - personajetemp.get(i).getIncxAbajoUno(), y + incy - personajetemp.get(i).getIncyAbajoUno(), personajetemp.get(i).getIncxAbajoDos() + incx, personajetemp.get(i).getIncyAbajoDos() + incy + y, mxA, myA, mxA + personajetemp.get(i).getSpriteAtacaAbajoX(), myA + personajetemp.get(i).getSpriteAtacaAbajoY(), this);
                        break;
                    case "derecha":
                        mxA = (Incremento % personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaDerechaX();
                        myA = (Incremento / personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaDerechaY();
                        g2d.drawImage(img, incx - personajetemp.get(i).getIncxDerechaUno(), y + incy - personajetemp.get(i).getIncyDerechaUno(), personajetemp.get(i).getIncxDerechaDos() + incx, personajetemp.get(i).getIncyDerechaDos() + incy + y, mxA, myA, mxA + personajetemp.get(i).getSpriteAtacaDerechaX(), myA + personajetemp.get(i).getSpriteAtacaDerechaY(), this);
                        break;
                    case "izquierda":
                        mxA = (Incremento % personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaIzquierdaX();
                        myA = (Incremento / personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaIzquierdaY();
                        g2d.drawImage(img, incx - personajetemp.get(i).getIncxIzquierdaUno(), y + incy - personajetemp.get(i).getIncyIzquierdaUno(), personajetemp.get(i).getIncxIzquierdaDos() + incx, personajetemp.get(i).getIncyIzquierdaDos() + incy + y, mxA, myA, mxA + personajetemp.get(i).getSpriteAtacaIzquierdaX(), myA + personajetemp.get(i).getSpriteAtacaIzquierdaY(), this);
                        break;
                }
            } else {
                mxA = (Incremento % personajetemp.get(i).getNumSpritesMov()) * personajetemp.get(i).getSpriteMoverX();
                myA = (Incremento / personajetemp.get(i).getNumSpritesMov()) * personajetemp.get(i).getSpriteMoverY();
                g2d.drawImage(img, incx - 25, incy - 25 + y, 50 + incx, y + 50 + incy, mxA, myA, mxA + personajetemp.get(i).getSpriteMoverX(), myA + personajetemp.get(i).getSpriteMoverY(), this);
                rectPj.setRect(incx-15, incy-30+y, 52, 78);
                /*Se evalua la colision de cada personaje mediante la clase EvaluarColisiones y si es el caso se decora el personaje*/
                if(entra==true)
                    colision = evaluarColisiones.evaluarColisionPocima(rect,rectPj,colision);
                if (colision == true) {
                    if (entra == true) {
                        personaje = evaluarColisiones.personajeDecorado(personaje);
                       
                        //Se usa aumentoPorPocima para evaluar si aumentar escudo o vida por medio de Cadena de responsailidad
                        aumentoPorPocima.operacion(personajetemp.get(i).getVida(), personajetemp.get(i).getEscudo(), personajetemp.get(i));
                        
                    }
                    entra = false;
                    colisionPocima = true;
                }
                
            }
            g2d.setFont(fuenteVida);//Fuente del porcentaje de vida
            g2d.setColor(Color.RED);//Color de la vida
            g2d.drawString(String.valueOf(personajetemp.get(i).getVida()) + "%", incx , incy - 30 + y);//Pinta el porcentaje de vida que tiene
            g2d.setFont(fuenteEscudo);//Fuente del porcentaje de escudo
            g2d.setColor(Color.BLUE);//Color del escudo
            g2d.drawString(String.valueOf(personajetemp.get(i).getEscudo()) + "%" , incx , incy - 40 + y);//Pinta el porcentaje de escudo que tiene
            y = y + aumentoSpriteY;
        }
        personajetemp.clear();
        
        repaint();
    }

    public static void inicia() {
<<<<<<< HEAD
        
        canonList.clear();
=======
        AlarmaColisionPocima a = new AlarmaColisionPocima();
        a.attach(new Pocima());
>>>>>>> 462937d6e67695eafc9e7b4cc7a13a6bea1d912a
        arreglo_personajes.clear();
        personajetemp.clear();
        switch (eleccion) {
            case "Elfo":
                animar.SetPersonajeBuilder(new ElfoBuilder());
                break;
            case "Enano":
                animar.SetPersonajeBuilder(new EnanoBuilder());
                break;
            case "Humano":
                animar.SetPersonajeBuilder(new HumanoBuilder());
                break;
            case "Orco":
                animar.SetPersonajeBuilder(new OrcoBuilder());
                break;
        }
        animar.moverse();
        personaje = animar.getPersonaje();
        arreglo_personajes.add(personaje);
        posY=0;
        posX=0;
        for (int i = 0; i < 8; i++) {
            canonList.add(new Canon());
            canonList.get(i).setPosY(posY);
            canonList.get(i).setPosX(posX);
            canonList.get(i).setIncX(mx);
            canonList.get(i).setIncY(my);
            posY = posY+150;
            if(i==3){
                posX=700;
                posY=0;
            }
            
        }
//        for (int i = 0; i < 6; i++) {
//            canonList.get(i).getPosX();
//            canonList.get(i).getPosY();
//            System.out.println(canonList.get(i).getPosX() + " " +  canonList.get(i).getPosY());
//        }
        System.out.println(canonList.get(2).getPosX());
        if (poblacion.equals("Población")) {
            Personaje personajeClonUno = (Personaje) personaje.clonar();
            Personaje personajeClonDos = (Personaje) personaje.clonar();
            arreglo_personajes.add(personajeClonUno);
            arreglo_personajes.add(personajeClonDos);
        }
        //personaje.setVida(50);
        new recreacion().setVisible(true);
    }
}
