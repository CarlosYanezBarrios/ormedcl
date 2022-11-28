package cl.carlosyanezbarrios.ormedcl;

public class paginasweb {
    public String nombrerecinto;
    public String paginarecinto;
    public String uid;

    public paginasweb() {
    }

    public String getNombrerecinto() {
        return nombrerecinto;
    }

    public void setNombrerecinto(String nombrerecinto) {
        this.nombrerecinto = nombrerecinto;
    }

    public String getPaginarecinto() {
        return paginarecinto;
    }

    public void setPaginarecinto(String paginarecinto) {
        this.paginarecinto = paginarecinto;
    }

    @Override
    public String toString() {
        return nombrerecinto + '\n' + paginarecinto;
    }


    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }
}
