package com.recetario.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.recetario.repository.entities.Receta;
import com.recetario.service.RecetaService;

@Controller
public class JSONPController {

	@Autowired
	RecetaService servicio;
	
	@Autowired
	ObjectMapper om;//mapeador JSON
		
		@GetMapping("detalle/{id}")//http://localhost:8081/jsonp/alumno?callback=mifuncion"
		public void obtenerAlumnoJsonP (HttpServletRequest request, HttpServletResponse respuesta, @PathVariable Long id,
				@RequestParam(name = "callback", required = true) String callback) throws IOException {
			
			Optional<Receta> optional;
			optional = servicio.obtieneRecetaPorId(id);
			
			ObjectNode objectNode = om.createObjectNode();
			
			if (optional.isPresent()) {
				Receta rece = optional.get();
				objectNode.put("nombre", rece.getNombre());
				objectNode.put("categoria", rece.getCategoria());
				objectNode.put("etiquetas", rece.getEtiquetas());
				objectNode.put("ingredientes", rece.getIngredientes());
				objectNode.put("instrucciones", rece.getInstrucciones());
				objectNode.put("notas", rece.getNotas());
				//objectNode.put("fechaAlta", rece.getFechaAlta());
			}
			String alumno_json = objectNode.toString();
			String cuerpo_respuesta = callback + "(" + alumno_json +")";
			
			//escribimos la respuesta
			respuesta.getWriter().print(cuerpo_respuesta);
			respuesta.setContentType("application/javascript;charset=UTF-8");
			
			
		}
	

}
