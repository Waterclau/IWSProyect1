package icai.dtc.isw.domain;

import java.io.Serializable;


public class Review implements Serializable
{
    private String id_review;
    private String id_movil;
    private String usuario;
    private String comentario;
    private String puntuacion;

    public Review(String id_review, String id_movil, String usuario, String comentario, String puntuacion)
    {
        this.id_review=id_review;
        this.id_movil=id_movil;
        this.usuario=usuario;
        this.comentario=comentario;
        this.puntuacion=puntuacion;
    }

    public String getId_review()
    {
        return id_review;
    }

    public String getId_movil()
    {
        return id_movil;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public String getComentario(){
        return comentario;
    }

    public String getPuntuacion(){
        return puntuacion;
    }

    public String getDatos()
    {
        return "idMovil:"+id_movil+",  Usuario: "+ usuario+",  Comentario: "+comentario+",  Puntuacion: "+puntuacion;
    }


}
