package pe.org.incatrek.controller;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.org.incatrek.model.Encuesta;
import pe.org.incatrek.service.IEncuestaService;
import pe.org.incatrek.service.ITuristaService;

@Controller
@RequestMapping("/encuesta")

public class EncuestaController {

		@Autowired
		private IEncuestaService eService;
		
		@Autowired
		private ITuristaService tService;
		
		@RequestMapping("/bienvenido")
		public String irEncuestaBienvenido() {
			return "bienvenido";
		}
		
		@RequestMapping("/")
		public String irEncuesta(Map<String,Object>model) {
			model.put("listaEncuestas", eService.listar());
			return "listEncuesta";
		}
		
		@RequestMapping("/irRegistrar")
		public String irPaginaRegistrar(Model model) {
			model.addAttribute("listaTuristas", tService.listar());
			model.addAttribute("encuesta", new Encuesta());
			return "encuesta";
		}
		
		
		
		@RequestMapping("/registrar")
		public String registrar (@ModelAttribute Encuesta objEncuesta,BindingResult binRes,Model model)throws ParseException
			{
			
			
			if(binRes.hasErrors()) {
				
				model.addAttribute("listaTuristas", tService.listar());
		
				return("encuesta");
				}
				
				
				else {
					boolean flag = eService.insertar(objEncuesta);
					if (flag)
						return "redirect:/encuesta/listar";
					else {
						model.addAttribute("mensaje", "Ocurrio un error");
						return "redirect:/encuesta/irRegistrar";
					}
				}
				
				
			}
			
		@RequestMapping("/modificar/{id}")
		public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
			Optional<Encuesta> objEncuesta = eService.listarId(id);
			if(objEncuesta == null) {
				objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
				return "redirect:/encuesta/listar";
			}
			else {
				model.addAttribute("listaTuristas", tService.listar());
				if(objEncuesta.isPresent())
					objEncuesta.ifPresent(o -> model.addAttribute("encuesta" ,o ));
				return "encuesta";
			}
		}		
			
		@RequestMapping("/eliminar")
		public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
			try {
				if (id != null && id>0) {
					eService.eliminar(id);
					model.put("listaEncuestas", eService.listar());
				}
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				model.put("mensaje", "Ocurrio un error");
				model.put("listaEncuestas", eService.listar());
			}
			return "listEncuesta";
		}
		
		@RequestMapping("/listar")
		public String listar(Map<String, Object> model) {
			model.put("listaEncuestas", eService.listar());
			return "listEncuesta";
		}
		
		@RequestMapping("/irBuscar")
		public String buscar(Model model) {
			model.addAttribute("encuesta", new Encuesta());
			return "buscarEncuesta";
		}
		
		@RequestMapping("/buscar")
		public String findByCategory(Map<String, Object> model, @ModelAttribute Encuesta encuesta)throws ParseException	
		{
			List<Encuesta> listaEncuestas;
			encuesta.setIdEncuesta(encuesta.getIdEncuesta());
			listaEncuestas = eService.buscarPorId(encuesta.getIdEncuesta());
			if (listaEncuestas.isEmpty()) {
				listaEncuestas = eService.buscarTurista(encuesta.getNombreEncuesta());
			}

			model.put("listaEncuestas", listaEncuestas);
			return "buscarEncuesta";
		}
		
		
}
