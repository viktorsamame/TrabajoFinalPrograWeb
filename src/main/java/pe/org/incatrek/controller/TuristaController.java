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

import pe.org.incatrek.model.Turista;
import pe.org.incatrek.service.ITuristaService;

@Controller
@RequestMapping("/turista")

public class TuristaController {

		@Autowired
		private ITuristaService tService;
		
		@RequestMapping("/bienvenido")
		public String irTuristaBienvenido() {
			return "bienvenido";
		}
		
		@RequestMapping("/")
		public String irTurista(Map<String,Object>model) {
			model.put("listaTuristas", tService.listar());
			return "listTurista";
		}
		
		@RequestMapping("/irRegistrar")
		public String irPaginaRegistrar(Model model) {
			model.addAttribute("turista", new Turista());
			return "turista";
		}
		
		@RequestMapping("/registrar")
		public String registrar (@ModelAttribute Turista objTurista,BindingResult binRes,Model model)throws ParseException
			{
				if(binRes.hasErrors())
				return("turista");
				else {
					boolean flag = tService.insertar(objTurista);
					if (flag)
						return "redirect:/turista/listar";
					else {
						model.addAttribute("mensaje", "Ocurrio un error");
						return "redirect:/turista/irRegistrar";
					}
				}
			}
			
		@RequestMapping("/modificar/{id}")
		public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
			Optional<Turista> objTurista = tService.listarId(id);
			if(objTurista == null) {
				objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
				return "redirect:/turista/listar";
			}
			else {
				model.addAttribute("turista", objTurista);
				return "turista";
			}
		}		
			
		@RequestMapping("/eliminar")
		public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
			try {
				if (id != null && id>0) {
					tService.eliminar(id);
					model.put("listaTuristas", tService.listar());
				}
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				model.put("mensaje", "Ocurrio un error");
				model.put("listaTuristas", tService.listar());
			}
			return "listTurista";
		}
		
		@RequestMapping("/listar")
		public String listar(Map<String, Object> model) {
			model.put("listaTuristas", tService.listar());
			return "listTurista";
		}
		
		
		
}
