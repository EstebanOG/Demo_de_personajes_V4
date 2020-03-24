package state;

import animacion.Personaje;

public class EstadoPersonaje {
    
    private Personaje personaje;
    private Estado estadoPersonaje;

    public void setEstadoPersonaje(Estado estadoPersonaje) {
        this.estadoPersonaje = estadoPersonaje;
//        this.personaje = personaje;
    }

    
    public void verificarEstado(){
        estadoPersonaje.verificarEstado();
    }
}
