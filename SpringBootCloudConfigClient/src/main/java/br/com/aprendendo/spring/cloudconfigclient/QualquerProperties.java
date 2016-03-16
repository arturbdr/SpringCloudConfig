package br.com.aprendendo.spring.cloudconfigclient;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(locations = "classpath:qualquer.properties")
public class QualquerProperties {
	
	private String chave;

	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}

}
