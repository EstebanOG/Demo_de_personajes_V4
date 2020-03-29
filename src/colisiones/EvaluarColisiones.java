package colisiones;

import animacion.Personaje;
import decorator.ElfoDecorator;
import decorator.EnanoDecorator;
import decorator.HumanoDecorator;
import decorator.OrcoDecorator;
import static gui.recreacion.eleccion;
import java.awt.Rectangle;

public class EvaluarColisiones {
    public Rectangle rect;
    public Rectangle rectPj;
    public boolean colision;
    public Personaje personaje;

    public EvaluarColisiones() {
    }

    public boolean evaluarColision(Rectangle rect, Rectangle rectPj, boolean colision){
        colision = rect.intersects(rectPj);
        return colision;
    }
    
    public Personaje personajeDecorado(Personaje personaje){
        switch (eleccion) {
            case "Orco":               
                personaje = new OrcoDecorator(personaje);
                break;
            case "Humano":
                personaje = new HumanoDecorator(personaje);               
                break;
            case "Elfo":               
                personaje = new ElfoDecorator(personaje);
                break;
            case "Enano":               
                personaje = new EnanoDecorator(personaje);
                break;
        }
        return personaje;
    }    
}
