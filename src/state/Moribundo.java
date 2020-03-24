package state;

public class Moribundo implements Estado{

    @Override
    public void verificarEstado() {
        System.out.println("Estado moribundo");
    }
    
}
