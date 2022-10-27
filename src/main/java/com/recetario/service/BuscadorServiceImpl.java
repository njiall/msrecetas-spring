package com.recetario.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.recetario.modelo.FiltroBusqueda;
import com.recetario.repository.entities.Receta;
import com.recetario.util.UtilesCriteria;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class BuscadorServiceImpl implements BuscadorService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
     * Session factory.
     */
    @Autowired
    private SessionFactory sessionFactory;
    
      
    /**
     * Session.
     */
    private Session sesion;
    
    //TODO Cambiar por CriteriaBuilder
	@Override
	public Iterable<Receta> buscarRecetasCriteria(FiltroBusqueda filtro) {
		try {
			sesion = sessionFactory.openSession();
			Criteria criteria = sesion.createCriteria(Receta.class);
			if (StringUtils.isNotEmpty(filtro.getNombre())) {
				UtilesCriteria.setCondicionCriteriaCadenaLike(filtro.getNombre(), criteria, "nombre");
			}
			if (StringUtils.isNotEmpty(filtro.getCategoria())) {
				UtilesCriteria.setCondicionCriteriaCadenaLike(filtro.getCategoria(), criteria, "categoria");
			}
			if (StringUtils.isNotEmpty(filtro.getEtiquetas())) {
				StringBuilder sql = new StringBuilder(" ( ");
				
				String[] etiq = filtro.getEtiquetas().split(",");
				Object[] obj = etiq; 
				Type[] tipos= new Type[etiq.length];
				
				sql.append(" etiquetas like '%").append(etiq[0].trim()).append("%'");
				tipos[0] = StandardBasicTypes.STRING;
						
				for (int i=1; i< etiq.length; i++) {
					sql.append(" OR etiquetas like '%").append(etiq[i].trim()).append("%'");
					tipos[i] = StandardBasicTypes.STRING;
				}
				sql.append(" ) ");
				
				criteria.add(Restrictions.sqlRestriction(sql.toString(), obj, tipos));
				
				
			}
			if (filtro.getFechaHasta()!=null) {
				UtilesCriteria.setCondicionCriteriaFechaMenorIgual(filtro.getFechaHasta(), criteria, "fechaAlta");
			}
			if (filtro.getFechaDesde()!=null) {
				UtilesCriteria.setCondicionCriteriaFechaMayorIgual(filtro.getFechaDesde(), criteria, "fechaAlta");
			}
			return criteria.list();
		} finally {
			sesion.close();
		}
	}

	@Override
	public Iterable<Receta> buscarRecetasTemplate(FiltroBusqueda filtro) {
//TODO Revisar las query
		StringBuilder sql = new StringBuilder(" SELECT * ").append(" FROM recetas ").append(" WHERE 1=1 ");

		if (StringUtils.isNotEmpty(filtro.getNombre())) {
			sql.append(" AND UPPER(nombre) like '%").append(filtro.getNombre().toUpperCase()).append("%' ");
		}
		if (StringUtils.isNotEmpty(filtro.getCategoria())) {
			sql.append(" AND UPPER(categoria) like '%").append(filtro.getCategoria().toUpperCase()).append("%' ");
		}

		if (StringUtils.isNotEmpty(filtro.getEtiquetas())) {
			String[] etiq = filtro.getEtiquetas().split(",");

			sql.append(" AND ( ").append(" UPPER(etiquetas) like '%").append(etiq[0].toUpperCase()).append("%' ");
			for (int i = 1; i < etiq.length; i++) {
				sql.append(" OR UPPER(etiquetas) like '%").append(etiq[i].toUpperCase()).append("%' ");
			}

			sql.append(" ) ");

		}
		if (filtro.getFechaHasta() != null) {
			
			sql.append(" AND fecha_alta <= TO_DATE('").append(filtro.getFechaHasta()).append("','Dy Mon DD HH24:MI:SS')");
		}
		if (filtro.getFechaDesde() != null) {
			sql.append(" AND fecha_alta >= TO_DATE('").append(filtro.getFechaDesde()).append("','Dy Mon DD HH24:MI:SS')");
		}

		return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Receta.class));

	}
}
