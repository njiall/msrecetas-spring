package com.recetario.util;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;



public class UtilesCriteria {

	    /**
	     * Método constructor.
	     */
	    private UtilesCriteria() {
	        throw new IllegalStateException("UtilitiesCriteria class");
	    }
	    
	    /**
	     * Método para establecer un criterio de búsqueda sobre un criteria con el operador like.
	     * @param value Object
	     * @param criteria Criteria
	     * @param nombreCampo String
	     */
	    public static void setCondicionCriteriaCadenaLike(final String value, final Criteria criteria,
	            final String nombreCampo) {

	        if (value != null && !value.trim().isEmpty()) {
	            //criteria.add(new LikeSinTildes(nombreCampo, value.trim(), MatchMode.ANYWHERE, true));
	        	criteria.add(Restrictions.ilike(nombreCampo, value.toLowerCase()));
	        }
	    }
	    
	    /**
	     * Método para establecer un criterio de búsqueda sobre un criteria con el operador mayor igual que.
	     * @param fechaDesde Date
	     * @param criteria Criteria
	     * @param nombreCampo String
	     */
	    public static void setCondicionCriteriaFechaMayor(final Date fechaDesde, final Criteria criteria,
	            final String nombreCampo) {
	        if (fechaDesde != null) {
	            final Date fechaDesdeIgual = new Date(fechaDesde.getTime() + TimeUnit.DAYS.toMillis(1));
	            criteria.add(Restrictions.ge(nombreCampo, fechaDesdeIgual));
	        }
	        
	    }
	    
	    /**
	     * Método para establecer un criterio de búsqueda sobre un criteria con el operador mayor igual que.
	     * @param fechaDesde Date
	     * @param criteria Criteria
	     * @param nombreCampo String
	     */
	    public static void setCondicionCriteriaFechaMayorIgual(final Date fechaDesde, final Criteria criteria,
	            final String nombreCampo) {
	        if (fechaDesde != null) {
	            criteria.add(Restrictions.ge(nombreCampo, fechaDesde));
	        }
	        
	    }
	    
	    /**
	     * Método para establecer un criterio de búsqueda sobre un criteria con el operador menor igual que.
	     * @param fechaHasta Date
	     * @param criteria Criteria
	     * @param nombreCampo String
	     */
	    public static void setCondicionCriteriaFechaMenorIgual(final Date fechaHasta, final Criteria criteria,
	            final String nombreCampo) {
	        if (fechaHasta != null) {
	            final Date fechaHastaIgual = new Date(fechaHasta.getTime() + TimeUnit.DAYS.toMillis(1));
	            criteria.add(Restrictions.le(nombreCampo, fechaHastaIgual));
	        }
	        
	    }
	    
	    /**
	     * Método para establecer un criterio de búsqueda sobre un criteria con el operador igual.
	     * @param value Object
	     * @param criteria Criteria
	     * @param nombreCampo String
	     */
	    public static void setCondicionCriteriaIgualdad(final Object value, final Criteria criteria,
	            final String nombreCampo) {
	        if (value != null) {
	            criteria.add(Restrictions.eq(nombreCampo, value));
	        }
	    }
	    
	    /**
	     * Método para establecer un criterio de búsqueda sobre un DetachedCriteria con el operador igual.
	     * @param value Object
	     * @param detach Detachedcriteria
	     * @param nombreCampo String
	     */
	    public static void setCondicionCriteriaIgualdad(final Object value, final DetachedCriteria detach,
	            final String nombreCampo) {
	        if (value != null) {
	            detach.add(Restrictions.eq(nombreCampo, value));
	        }
	    }
	    
	    /**
	     * Método para establecer un criterio de búsqueda sobre un criteria con el valor null sobre un campo.
	     * @param criteria Criteria
	     * @param nombreCampo String
	     */
	    public static void setCondicionNull(final Criteria criteria, final String nombreCampo) {
	        criteria.add(Restrictions.isNull(nombreCampo));
	    }
	    
	    /**
	     * Método para establecer un criterio de búsqueda sobre un criteria con el valor no null sobre un campo.
	     * @param criteria Criteria
	     * @param nombreCampo String
	     */
	    public static void setCondicionNotNull(final Criteria criteria, final String nombreCampo) {
	        criteria.add(Restrictions.isNotNull(nombreCampo));
	    }

}
