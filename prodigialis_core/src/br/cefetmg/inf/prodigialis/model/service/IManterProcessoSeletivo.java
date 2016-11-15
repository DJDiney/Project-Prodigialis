/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.model.service;

import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.model.domain.ProcessoSeletivo;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Cliente
 */
public interface IManterProcessoSeletivo {
    public boolean inserir(ProcessoSeletivo obj) throws PersistenciaException, NegocioException;
    public boolean atualizar(ProcessoSeletivo obj) throws PersistenciaException, NegocioException;
    public boolean excluir(Long id) throws PersistenciaException;
    public Participante consultarPorId(Long id) throws PersistenciaException;
    public List<ProcessoSeletivo> listarTodos() throws PersistenciaException;
}
