package br.com.poc.spring.cloudconfigclient.gateway;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(
    value = "/", tags = "Sample ConfigServer client",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
public class CheckParametersController {

  private final Environment environment;

  @Value("sample")
  private String sample;

  @Value("${testing-parameter}")
  private String testingParameter;

  @ApiOperation(
      notes = "Retrieve the testing-parameter from the ConfigServer ",
      value = "${CheckParametersController.getPropertiesParameter}",
      response = String.class)
  @GetMapping("/properties")
  public ResponseEntity<String> getPropertiesParameter() {
    return ResponseEntity.ok(testingParameter);
  }

  @ApiOperation(
      notes = "Retrieve any parameter from Spring Environment. "
          + "<br/>This will show that any parameter retrieved from ConfigServer "
          + "<br/> will be available in Environment Spring context",
      value = "${CheckParametersController.getParameterFromEnvironment}",
      response = String.class)
  @GetMapping("/parameterFromEnvironment/{parameterName}")
  public ResponseEntity<String> getParameterFromEnvironment(
      @ApiParam(
          value = "${CheckParametersController.getParameterFromEnvironment.parameterName}",
          required = true)
      @PathVariable String parameterName) {
    String responseMsg =
        "nome da propriedade [" + parameterName + "] Valor da propriedade [" + environment
            .getProperty(parameterName) + "]";
    return ResponseEntity.ok(responseMsg);
  }

  @ApiOperation(
      notes = "Retrieve the value of as internal propertie val",
      value = "${CheckParametersController.getInternalProperty}",
      response = String.class)
  @GetMapping("/properties-key")
  public ResponseEntity<String> getInternalProperty() {
    return ResponseEntity.ok(sample);
  }

}
