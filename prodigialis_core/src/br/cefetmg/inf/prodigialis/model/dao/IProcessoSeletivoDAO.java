/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.model.dao;

import br.cefetmg.inf.prodigialis.model.domain.ProcessoSeletivo;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import br.cefetmg.inf.prodigialis.util.db.persistence.GenericDAO;
import java.util.List;

/**
 *
 * @author Cliente
 */
public interface IProcessoSeletivoDAO{
    public boolean inserir(ProcessoSeletivo obj) throws PersistenciaException;
    public boolean atualizar(ProcessoSeletivo obj) throws PersistenciaException;
    public boolean excluir(long id) throws PersistenciaException;
    public ProcessoSeletivo consultarPorId(long id) throws PersistenciaException;
    public List<ProcessoSeletivo> listarTodos() throws PersistenciaException;
}
