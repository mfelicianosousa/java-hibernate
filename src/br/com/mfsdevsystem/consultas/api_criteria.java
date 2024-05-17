/**
 *
 * @author Marcelino
 */
package br.com.mfsdevsystem.consultas;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.mfsdevsystem.model.Aluno;
import br.com.mfsdevsystem.utils.HibernateUtil;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

public class api_criteria {

    private static final Logger logger = LoggerFactory.getLogger(hql_query.class);

    public static void main(String[] args) {
        try {

            Session sessao = HibernateUtil.getSession();

            Criteria criteria = sessao.createCriteria(Aluno.class);
            //criteria.setMaxResults(5);
            //criteria.setFirstResult(1);
            //criteria.addOrder( Order.asc("nome"));
            //criteria.addOrder( Order.asc("cidade"));
            criteria.addOrder(Order.asc("curso"));
            //criteria.add(Expression.eq("nome", "Analu"));  

            //criteria.add(Restrictions.between("id", 2,7));
            // formas de pesquisa por cidade
            // forma 1 = Expression.eq()
            // criteria.add(Expression.eq("cidade", "Lajeado"));  
            //
            // forma 2 = Array
            //
            //String[] cidades = {"Carazinho", "Lajeado"};
            //criteria.add(Restrictions.in("cidade", cidades));
            
            // forma 3 = like 
            criteria.add(Restrictions.like("cidade", "Lajeado"));
            
            List<Aluno> list_alunos = criteria.list();

            int tamanho_lista = list_alunos.size();
            String dados = "";
            for (int i = 0; i < tamanho_lista; i++) {

                Aluno aluno = list_alunos.get(i);

                dados = dados + '\n' + aluno.getId() + " - " + aluno.getNome() + " - " + aluno.getCidade() + " - " + aluno.getCurso();
                System.out.println(aluno.getId() + " - " + aluno.getNome() + " - " + aluno.getCidade() + " - " + aluno.getCurso());
            }

            JOptionPane.showMessageDialog(null, dados);

            sessao.close();

        } catch (Exception e) {

            logger.error("Erro na listagem dos dado no banco de dados: " + e);
            JOptionPane.showMessageDialog(null, "Erro de listagem de dados no banco de dados : " + e);
        }

    }
}
