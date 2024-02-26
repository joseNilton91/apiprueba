import Servicio.Notificaciones.Inotifi;
import Servicio.Notificaciones.NotificacionFactory;
import Servicio.Notificaciones.tipoNotificacion;

public class App {
    public static void main(String[] args) throws Exception {
     
        NotificacionFactory notificacionFactory=new NotificacionFactory();
        Inotifi notificacion=notificacionFactory.crearInotificacion(tipoNotificacion.whatsApp);
        notificacion.notificar();
    }
}
