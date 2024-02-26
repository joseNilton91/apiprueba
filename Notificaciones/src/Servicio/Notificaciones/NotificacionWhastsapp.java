package Servicio.Notificaciones;

public class NotificacionWhastsapp implements Inotifi {

    @Override
    public void notificar() {
        System.out.println("enviar mensaje por whatsApp");
    }
    
}
