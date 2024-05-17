/**
 *
 * @author Marcelino
 */
package br.com.mfsdevsystem.utils;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GenerateTables {
    
    public static void main(String[] args) {
    
        Configuration cfg = new Configuration().configure();
    
        SchemaExport schema = new SchemaExport(cfg);
        schema.create(true, true);
        
    
    }
   
}
