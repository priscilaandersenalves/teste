/**
 * 
 */
package br.com.cenaculo.controller;

import java.sql.SQLDataException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import br.com.cenaculo.model.Santo;
import br.com.cenaculo.service.SantoService;

/**
 * @author prisc
 *
 */
@Controller
public class SantoController {

	private static final Logger logger = LoggerFactory.getLogger(SantoController.class);
	private SantoService santoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "santo";
	}

	/**
	 * Cria orders
	 * 
	 * @param payment
	 * @return
	 */
	@RequestMapping(value = "/santos", method = RequestMethod.POST)
	@ResponseBody
	public String addSanto(@RequestBody String santoNovo) {
		String resposta = null;
		logger.info("requisicao addSanto ");
		if (santoNovo != null) {
			santoService = new SantoService();
			resposta = santoService.addSanto(santoNovo);
		}

		Gson gson = new Gson();
		String json = null;
		try {
			json = gson.toJson(resposta);
			logger.info(" json ------>" + json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resposta;
	}

	/**
	 * Busca todos os Pagamentos cadastrados, se for informado o auth-code,
	 * será feito o filtro pelo informado
	 * 
	 * @param jsonEntrada
	 * @return
	 */
	@RequestMapping(value = "/santos", method = RequestMethod.GET)
	@ResponseBody
	public String searchSanto() {

		logger.info("requisicao consulta santos ");
		String resposta = null;
		santoService = new SantoService();
		List<Santo> list = santoService.searchSantoAll();

		Gson gson = new Gson();
		String json = null;
		try {
			json = gson.toJson(list);
			logger.info(" json ------>" + json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resposta;
	}

	
	/**
	 * Busca todos os Pagamentos cadastrados, se for informado o auth-code,
	 * será feito o filtro pelo informado
	 * 
	 * @param jsonEntrada
	 * @return
	 */
	@RequestMapping(value = "/santos", method = RequestMethod.GET)
	@ResponseBody
	public String searchSantobyDay(@PathParam(value = "dia") String dia) {

		logger.info("requisicao consulta santos ");
		String resposta = null;
		santoService = new SantoService();
		Santo santo = santoService.searchSantobyDay(dia);

		Gson gson = new Gson();
		String json = null;
		try {
			json = gson.toJson(santo);
			logger.info(" json ------>" + json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resposta;
	}
	@RequestMapping(value = "/santos", method = RequestMethod.PUT)
	@ResponseBody
	public String updatePayment(@PathParam(value = "dia") String dia, @RequestBody String jsonEntrada) throws SQLDataException {
		logger.info("requisicao consulta santos ");
		String resposta = null;
		santoService = new SantoService();
		Santo santo = santoService.searchSantobyDay(dia);
		Santo santoEntrada = null;
		
		if(santo != null){
			Gson gson = new Gson();
			try {
				santoEntrada = gson.fromJson(jsonEntrada, Santo.class);
				santoEntrada.setStatus("A");
				
			} catch (JsonSyntaxException e) {
				e.printStackTrace();
			}
			
			if(santo.getDia().equals(santoEntrada.getDia()) && santo.getMes().equals(santoEntrada.getMes())){
				santoEntrada.setSantoId(santo.getSantoId());
				logger.info(" Santo ------>" + santoEntrada.toString());
				resposta= santoService.updateSanto(santoEntrada);
			}
			
		}
	
		return resposta;
	}

	@RequestMapping(value = "/santos", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteSanto(@PathParam(value = "dia") String dia) throws SQLDataException {

		logger.info("requisicao exclusao santos ");
		
		santoService = new SantoService();
		Santo santo = santoService.searchSantobyDay(dia);

		santoService.deleteSanto(santo);
		
		return "deletedo";
		
	}
}
