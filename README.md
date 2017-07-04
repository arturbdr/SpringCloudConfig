# SpringCloudConfig
Possui dois projetos de testes que exibem o funcionamento do Spring Cloud Config tanto para o Client como o Server.

O projeto Spring Cloud Config Server deve ser iniciado em primeiro lugar para que sejam colatos os valores dos arquivos de properties.
Atualmente ele está configurado para ler os valores dos properties da seguinte URL:
https://github.com/arturbdr/SpringCloudServerConfigData

Uma vez lido os properties, será automaticamente exposto um serviço RESTful para leitura desses properties.

--
Após a subida com sucesso do Server, deve ser inicializado o SpringCloudConfigClient. Ele automaticamente consumirá o serviço exposto acima para leitura 
recuperando os parâmetros e disponibilizando para a Aplicação.

Sendo uma aplicação Spring, os valores dos parâmetros podem ser recuperados atráves da interface "org.springframework.core.env.Environment".
O uso dessa inteface pode ser visto no controller CheckParametersController disponivel nessa aplicação.

Verificar os serviços disponibilizados e respectiva documentação em (após inicializar os projetos) :
http://localhost:8002/swagger-ui.html
