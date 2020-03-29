package pocima;

import observer.colisionPocima;

public class Pocima implements colisionPocima{
    private String imagen = "/assets/Pocion2.png";
    public int coordenadaX = 390;
    public int coordenadaY = 400;
    private final int ancho = 60;
    private final int alto = 60;
    public Pocima() {
    }

    public String getImagen() {
        return imagen;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    
    public void cambioDePosicion(){
        
    }

    @Override
    public void update() {
        System.out.println(coordenadaY);
        if(coordenadaY == 400){
            this.coordenadaY = 100;
            this.coordenadaX = 100;
            System.out.println("Se cambia la pocision de pocima");
        }else{
            this.coordenadaY = 390;
            this.coordenadaX = 400;
            System.out.println("xd");
            
        }
        
    }
    
}
