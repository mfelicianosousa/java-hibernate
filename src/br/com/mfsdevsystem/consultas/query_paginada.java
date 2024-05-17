/**
 *
 * @author Marcelino
 */
package br.com.mfsdevsystem.consultas;


import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.mfsdevsystem.model.Aluno;
import br.com.mfsdevsystem.utils.HibernateUtil;

public class query_paginada {
	private static final Logger logger = LoggerFactory.getLogger(hql_query.class);
	   
	public static void main(String[] args) {
		 try {
			 
			 Session sessao = HibernateUtil.getSession();
			 Query query = sessao.createQuery("from Aluno");
			 query.setMaxResults(4);
			 
			 List<Aluno> list_alunos = query.list();
		    
             int tamanho_lista = list_alunos.size();
             String dados = "";
	         for (int i=0; i < tamanho_lista; i++){
	             
	        	 Aluno aluno = list_alunos.get(i);
	             
	             dados = dados + '\n'+aluno.getId()+" - "+aluno.getNome()+" - "+aluno.getCidade()+" - "+aluno.getCurso();
	             System.out.println(aluno.getId()+" - "+aluno.getNome()+" - "+aluno.getCidade()+" - "+aluno.getCurso());
	         }
         
             JOptionPane.showMessageDialog(null, dados);
         
              sessao.close();

         
     } catch (Exception e) {
         logger.error("Erro na listagem dos dado no banco de dados: "+e);
         JOptionPane.showMessageDialog(null,"Erro de listagem de dados no banco de dados : "+e);
     } 
		 
	}    
}
