package pe.org.incatrek.controller;

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

import pe.org.incatrek.model.Declaracion;
import pe.org.incatrek.service.IDeclaracionService;

@Controller
@RequestMapping("/declaracion")

public class DeclaracionController {

		@Autowired
		private IDeclaracionService dService;
		
		@RequestMapping("/bienvenido")
		public String irDeclaracionBienvenido() {
			return "bienvenido";
		}
		
		@RequestMapping("/")
		public String irDeclaracion(Map<String,Object>model) {
			model.put("listaDeclaraciones", dService.listar());
			return "listDeclaracion";
		}
		
		@RequestMapping("/irRegistrar")
		public String irPaginaRegistrar(Model model) {
			model.addAttribute("declaracion", new Declaracion());
			return "declaracion";
		}
		
		@RequestMapping("/registrar")
		public String registrar (@ModelAttribute Declaracion objDeclaracion,BindingResult binRes,Model model)throws ParseException
			{
				if(binRes.hasErrors())
				return("declaracion");
				else {
					boolean flag = dService.insertar(objDeclaracion);
					if (flag)
						return "redirect:/declaracion/listar";
					else {
						model.addAttribute("mensaje", "Ocurrio un error");
						return "redirect:/declaracion/irRegistrar";
					}
				}
			}
			
		@RequestMapping("/modificar/{id}")
		public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
			Optional<Declaracion> objDeclaracion = dService.listarId(id);
			if(objDeclaracion == null) {
				objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
				return "redirect:/declaracion/listar";
			}
			else {
				model.addAttribute("declaracion", objDeclaracion);
				return "declaracion";
			}
		}		
			
		@RequestMapping("/eliminar")
		public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
			try {
				if (id != null && id>0) {
					dService.eliminar(id);
					model.put("listaDeclaraciones", dService.listar());
				}
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				model.put("mensaje", "Ocurrio un error");
				model.put("listaDeclaraciones", dService.listar());
			}
			return "listDeclaracion";
		}
		
		@RequestMapping("/listar")
		public String listar(Map<String, Object> model) {
			model.put("listaDeclaraciones", dService.listar());
			return "listDeclaracion";
		}
		
		
		
}
