package br.com.aprendendo.spring.cloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aprendendo.spring.cloudconfigclient.QualquerProperties;

@RestController
public class CheckParametersController {
	
	@Value("${parametro-teste}")
	private String parametroTeste;
	
	@Autowired 
	private Environment environment;
	
	@Autowired
	private QualquerProperties qualquerProperties;
	
	@RequestMapping("/getTesteProperties")
	public String getParametroTeste() {
		return parametroTeste;
	}
	
	@RequestMapping("/parameter/{parameterName}")
	public String getParametro(@PathVariable String parameterName) {
		return "nome da propriedade [" + parameterName + "] Valor [" +environment.getProperty(parameterName)+ "]";
	}
	
	@RequestMapping("/parameterlocal/chave")
	public String getParametroPropertieLocal() {
		return qualquerProperties.getChave();
	}

}
