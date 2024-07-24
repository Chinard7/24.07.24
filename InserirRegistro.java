import java.sql.*;
public class InserirRegistro {

    public static String cadastrar (String Db, String tbl, String campo, String nome) {
        String retorno = "Nada aconteceu ainda...";
       try {
            Connection conexao = MySQLConector.conectar();
            String strSqlInserirRegistro = "insert into `" + Db + "`.`" + tbl + "`(`" + campo + "`) values ('" + nome +"');";
            Statement stmSqlInserirRegistro = conexao.createStatement();

            stmSqlInserirRegistro.addBatch(strSqlInserirRegistro);
            stmSqlInserirRegistro.executeBatch();
            stmSqlInserirRegistro.close();
            retorno = "Registro inserido com sucesso!";

            System.out.println("Registro Inserido Com Sucesso :) ");
            
        } catch (Exception e) {
            retorno = "Ops! Ocorreu o erro: *" + e;
            System.out.println("Ops! ocorreu um erro:" + e);            
        }
        return retorno;
    }
}