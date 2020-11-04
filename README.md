# carSoapServiceApp
Created car soap service in spring boot 
#Step 1 
Created a car_info.txt file under resources root pack.
Added wsdl4j dependency in pom.
#Step 2 
Created cars xsd file 
Also added plugin inside pom.xml and give buildpath for generate java classes from xsd file.
#Step 3
CarRepositoy is created for reading inside txt file. 
We do this daoImpl inside carRestServiceApp.
#Step 4
Created CarEndpoint for Controller.We used @Endpoint,@PayloadRoot,@ResponsePayload annotations.
@RequestPayload gets incoming message and map to request.
Added method for getting request and return response also.
When we create xsd we define Request and Response Object to generate.
Inside method we use this objects instance and return response.
#Step5 
Created WebServiceConfig class for bean configuration and define target.
#Step6 
Time to call soap service.

Make a request.xml file for request
Xml content like :
----------
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

-----------
 When this file done, we can use something similar to SoapUI(https://www.soapui.org/) or use command-line tools if you are on a *nix/Mac system.
 If you are using mac open the terminal and move request.xml go to the folder where the file is located and write command below.
 
 curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws
 
 When data return, get data and put xml parser. Response is ready!
 
 End.
 
 

