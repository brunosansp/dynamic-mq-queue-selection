package br.com.brunosan.gerenciarobjetivo.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    
    @Value("${ibm.mq.queueNameRequestSalvar:FR.SALVAR.REQ}")
    private String queueNameRequestSalvar;
    
    @Value("${ibm.mq.queueNameResponseSalvar:FL.SALVAR.RSP}")
    private String queueNameResponseSalvar;
    
    @Value("${ibm.mq.queueNameRequestSimular:FR.SIMULAR.REQ}")
    private String queueNameRequestSimular;
    
    @Value("${ibm.mq.queueNameResponseSimular:FL.SIMULAR.RSP}")
    private String queueNameResponseSimular;
    
    @Value("${ibm.mq.queueNameRequestDetalha:FR.DETALHA.REQ}")
    private String queueNameRequestDetalha;
    
    @Value("${ibm.mq.queueNameResponseDetalha:FL.DETALHA.RSP}")
    private String queueNameResponseDetalha;
    
    @Value("${ibm.mq.connName}")
    private String connName;
    
    @Value("${ibm.mq.queueManager}")
    private String queueManager;
    
    @Value("${ibm.mq.channel}")
    private String channel;
    
    @Value("${ibm.mq.port}")
    private Integer port;
    
    @Value("${ibm.mq.user:}")
    private String user;
    
    @Value("${ibm.mq.password:}")
    private String password;
    
    @Bean
    public QueueProperties queuePropertiesSalvar() {
        return createQueueProperties(queueNameRequestSalvar, queueNameResponseSalvar);
    }
    
    @Bean
    public QueueProperties queuePropertiesSimular() {
        return createQueueProperties(queueNameRequestSimular, queueNameResponseSimular);
    }
    
    @Bean
    public QueueProperties queuePropertiesDetalha() {
        return createQueueProperties(queueNameRequestDetalha, queueNameResponseDetalha);
    }
    
    private QueueProperties createQueueProperties(String queueNameRequest, String queueNameResponse) {
        return new QueueProperties(
            connName,
            queueManager,
            channel,
            port,
            user,
            password,
            queueNameRequest,
            queueNameResponse
        );
    }
}
