package Servicio.Notificaciones;

public class NotificacionFactory {
    
    public Inotifi crearInotificacion(tipoNotificacion tipo){
        switch(tipo) {
            case SMS:
             return new NotificacionSMS();

            case Inserccion:
             return new NotificacionInserccion();
                
            case correo:
             return new NotificacionCorreo();


            case whatsApp:
             return new NotificacionWhastsapp();

            default:
             throw new IllegalStateException("Canal" + tipo + "desconocido");
        }

    }
    
}
