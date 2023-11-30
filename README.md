# Exemplo de como usar uma lista de atributos setados no application.yml

#### Linguagem
`Nome: Java`  
`Versão da Linguagem: 11`  

#### Framework
`Nome: Spring Boot`  
`Versão do Framework: 2.7.9`

#### Dependências
`lombok`
`mockito-core`
`spring-boot-starter`
`springdoc-openapi-ui`
`spring-boot-starter-web`    
`spring-boot-starter-test`
`spring-boot-starter-validation`
`com.ibm.mq.allclient`

#### Plugins:
`spring-boot-maven-plugin`  
`jacoco-maven-plugin` 

#### Jacoco
`Versão: 0.8.7`  

### RUN Local
###### Executar o docker com serviço IBM MQ usando o seguinte comando no terminal.
> docker run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --publish 1414:1414 --publish 9443:9443 --detach ibmcom/mq
###### OBS: Certifique-se de ter o Docker instalado.
