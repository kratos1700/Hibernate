package modelo;


import javax.persistence.*;


@Entity
@Table(name="usuarios")
public class Usuarios {
    // atributs
    @Id
    @Column(name = "id")
    private  int Id;
    @Column(name = "usuari")
    private String usuari;
    @Column(name = "pasword")
    private String pasword;
    @Column(name = "mail")
    private String mail;

// Constructors
    public Usuarios(int id, String usuari, String pasword, String mail) {
        Id = id;
        this.usuari = usuari;
        this.pasword = pasword;
        this.mail = mail;
    }

    public Usuarios() {
    }


    // gets y sets

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "Id=" + Id +
                ", usuari='" + usuari + '\'' +
                ", pasword='" + pasword + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}

