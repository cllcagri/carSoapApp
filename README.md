# CarSoapServiceApp
Created car soap service in spring boot <br/>
##### Step 1 
Created a car_info.txt file under resources root pack. <br/>
Added wsdl4j dependency in pom. <br/>
##### Step 2
Created cars xsd file.  <br/> 
Also added plugin inside pom.xml and give buildpath for generate java classes from xsd file. <br/>
##### Step 3
CarRepositoy is created for reading inside txt file. <br/>
We do this daoImpl inside carRestServiceApp before.<br/>
##### Step 4
Created CarEndpoint for Controller.We used **@Endpoint,@PayloadRoot,@ResponsePayload** annotations.<br/>
**@RequestPayload** gets incoming message and map to request.<br/>
Added method for getting request and return response also.<br/>
When we create xsd we define Request and Response Object to generate.<br/>
Inside method we use this objects instance and return response.<br/>
##### Step 5
Created WebServiceConfig class for bean configuration and define target. <br/>
##### Step 6 
Time to call soap service. <br/>
Make a request.xml file for request. <br/>
Xml content like :
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
				  xmlns:gs="http://spring.io/guides/gs-producing-web-service">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getCarSearchRequest>
         <gs:searchCriteria>hepsi</gs:searchCriteria>
         <gs:key>-</gs:key>
      </gs:getCarSearchRequest>
   </soapenv:Body>
</soapenv:Envelope>

```
 When this file done, we can use something similar to [SoapUI](https://www.soapui.org/) or use command-line tools if you are on a *nix/Mac system. <br/>
 If you are using mac open the terminal and move request.xml go to the folder where the file is located and write command below. <br/>
 
 >curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws
 
 When data return, get data and put xml parser. Response is ready! <br/>
 
 End !! 
 
 

