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

import br.com.cenaculo.model.Aparicao;
import br.com.cenaculo.service.AparicaoService;

/**
 * @author prisc
 *
 */
@Controller
public class AparicaoController {

	private static final Logger logger = LoggerFactory.getLogger(AparicaoController.class);
	private AparicaoService aparicaoService ;

	@RequestMapping(value = "/ap", method = RequestMethod.GET)
	@ResponseBody
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "Nossa Senhora";
	}

	
	@RequestMapping(value = "/aparicao", method = RequestMethod.POST)
	@ResponseBody
	public String addAparicao(@RequestBody String aparicaoNova) {
		String resposta = null;
		logger.info("requisicao addAparicao ");
		if (aparicaoNova != null) {
			aparicaoService = new AparicaoService();
			resposta = aparicaoService.addAparicao(aparicaoNova);
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

	
	@RequestMapping(value = "/aparicao", method = RequestMethod.GET)
	@ResponseBody
	public String searchAparicao() {

		logger.info("requisicao consulta aparicao ");
		aparicaoService = new AparicaoService();
		List<Aparicao> list = aparicaoService.searchAparicaoAll();

		Gson gson = new Gson();
		String json = null;
		try {
			json = gson.toJson(list);
			logger.info(" json ------>" + json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	
	
	@RequestMapping(value = "/aparicaobyDay", method = RequestMethod.GET)
	@ResponseBody
	public String searchAparicaobyDay(@PathParam(value = "dia") String dia) {

		logger.info("requisicao consulta aparicao ");
		String resposta = null;
		aparicaoService = new AparicaoService();
		Aparicao aparicao = aparicaoService.searchAparicaobyDay(dia);

		Gson gson = new Gson();
		String json = null;
		try {
			json = gson.toJson(aparicao);
			logger.info(" json ------>" + json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resposta;
	}
	
	@RequestMapping(value = "/aparicao", method = RequestMethod.PUT)
	@ResponseBody
	public String updateAparicao(@PathParam(value = "dia") String dia, @RequestBody String jsonEntrada) throws SQLDataException {
		logger.info("requisicao consulta aparicao ");
		String resposta = null;
		aparicaoService = new AparicaoService();
		Aparicao aparicao = aparicaoService.searchAparicaobyDay(dia);
		Aparicao aparicaoEntrada = null;
		
		if(aparicao != null){
			Gson gson = new Gson();
			try {
				aparicaoEntrada = gson.fromJson(jsonEntrada, Aparicao.class);
				
			} catch (JsonSyntaxException e) {
				e.printStackTrace();
			}
			
			if(aparicao.getDia().equals(aparicaoEntrada.getDia()) && aparicao.getMes().equals(aparicaoEntrada.getMes())){
				aparicaoEntrada.setIdaparicao(aparicao.getIdaparicao());
				logger.info(" Santo ------>" + aparicaoEntrada.toString());
				resposta= aparicaoService.updateAparicao(aparicaoEntrada);
			}
			
		}
	
		return resposta;
	}

	@RequestMapping(value = "/aparicao", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteAparicao(@PathParam(value = "dia") String dia) throws SQLDataException {

		logger.info("requisicao exclusao aparicao ");
		
		AparicaoService aparicaoService = new AparicaoService();
		Aparicao santo = aparicaoService.searchAparicaobyDay(dia);

		aparicaoService.deleteAparicao(santo);
		
		return "deletedo";
		
	}
}
