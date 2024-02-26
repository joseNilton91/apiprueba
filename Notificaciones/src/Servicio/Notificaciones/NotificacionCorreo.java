package Servicio.Notificaciones;

public class NotificacionCorreo implements Inotifi {

    @Override
    public void notificar() {
        System.out.println("enviar mensaje por correo");
    }
    
}
