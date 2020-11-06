import modelo.Usuarios;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory miFactory =  new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuarios.class).buildSessionFactory();
        Session miSession = miFactory.openSession(); // obrim sessio

        try {
            Usuarios usuari = new Usuarios("Pepito", "123d","qwegf@gmail.com");
            miSession.beginTransaction();
            miSession.save(usuari);
            miSession.getTransaction().commit();
            System.out.println("REgistre guardat");
            miSession.close();
        }finally {
            miFactory.close();
        }


    }
}
