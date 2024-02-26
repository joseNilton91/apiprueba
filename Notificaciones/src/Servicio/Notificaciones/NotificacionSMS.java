package Servicio.Notificaciones;

public class NotificacionSMS implements Inotifi {

    @Override
    public void notificar() {
         System.out.println("enviar mensaje por SMS");
    }
    
}
