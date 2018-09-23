package com.example.demo;

import com.example.demo.soap.CelsiusToFahrenheit;
import com.example.demo.soap.CelsiusToFahrenheitResponse;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.transform.TransformerException;
import java.io.IOException;

@Component
public class TestClient extends WebServiceGatewaySupport {
    public CelsiusToFahrenheitResponse call() {
        CelsiusToFahrenheit celsiusToFahrenheit = new CelsiusToFahrenheit();
        celsiusToFahrenheit.setCelsius("100");
        CelsiusToFahrenheitResponse response = (CelsiusToFahrenheitResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://www.w3schools.com/xml/tempconvert.asmx", celsiusToFahrenheit,
                        new SoapActionCallback("https://www.w3schools.com/xml/CelsiusToFahrenheit"));
        return response;
    }
}
