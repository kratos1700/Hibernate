import modelo.Usuarios;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //creamos session a hibernate pasamos el config y le decimos a que clase vamos a trabajar.
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuarios.class).buildSessionFactory();

        Session miSession = miFactory.openSession();

        try {
            // creamos el objeto
            Usuarios usuari = new Usuarios("Pepito", "123d", "qwegddf@gmail.com");
            Usuarios usuari2 = new Usuarios("algereu", "123erddd", "qweg345ere345ddf@gmail.com");
            //iniciamos la transaccio
            miSession.beginTransaction();
            //guardamos el objeto a la bbdd
            miSession.save(usuari2);
            //hacemos el commit
            miSession.getTransaction().commit();
            System.out.println("Registre guardat");


            // codifo para mostrar los registros de la bbdd
            Query query = miSession.createQuery("FROM Usuarios "); // se pasa la clase
            List list = query.list();
            for (int i=0; i<list.size();i++){
                System.out.println(list.get(i).toString());
            }

            //cerramos sesion
            miSession.close();
        } finally {
            //
            miFactory.close();
        }


    }

}
// codi per si falla mysql amb l'hora:    SET GLOBAL time_zone = '+03:00';