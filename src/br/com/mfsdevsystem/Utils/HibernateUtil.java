package br.com.mfsdevsystem.Utils;

/**
 *
 * @author Marcelino
 */
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml 
            sessionFactory = new Configuration().configure().buildSessionFactory();
            
        } catch( HibernateException error ){
            JOptionPane.showMessageDialog(null,"Erro na Fabrica de sessoes = "+error);
            sessionFactory = null;
        }
    }
    
   public  static Session getSession(){
        return sessionFactory.openSession();
    }
   
}
