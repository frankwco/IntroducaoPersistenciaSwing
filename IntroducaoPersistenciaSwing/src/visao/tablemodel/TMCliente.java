/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Cliente;
import modelo.dao.DAOCliente;

/**
 *
 * @author Aluno
 */
public class TMCliente extends AbstractTableModel {

    List<Cliente> listaCliente;
    String[] colunas = {"Nome", "Idade"};
    DAOCliente dao;

    public TMCliente() {
        dao = new DAOCliente();
        listaCliente = dao.listaClientes();
    }

    @Override
    public int getRowCount() {
        return listaCliente.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cli = listaCliente.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cli.getNome();
            case 1:
                return cli.getIdade();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    
}
