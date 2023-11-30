package br.com.brunosan.gerenciarobjetivo.configs;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@ToString
@Getter
@Setter
@Component
public class QueueProperties {
    
    private String connName;
    private String queueManager;
    private String channel;
    private Integer port;
    private String user;
    private String password;
    private String queueNameRequest;
    private String queueNameResponse;
    
    public QueueProperties(@Value("${ibm.mq.connName}") String connName,
                           @Value("${ibm.mq.queueManager}") String queueManager,
                           @Value("${ibm.mq.channel}") String channel,
                           @Value("${ibm.mq.port}") Integer port,
                           @Value("${ibm.mq.user:}") String user,
                           @Value("${ibm.mq.password:}") String password,
                           @Value("${ibm.mq.queueNameRequest}") String queueNameRequest,
                           @Value("${ibm.mq.queueNameResponse}") String queueNameResponse) {
        this.connName = connName;
        this.queueManager = queueManager;
        this.channel = channel;
        this.port = port;
        this.user = user;
        this.password = password;
        this.queueNameRequest = queueNameRequest;
        this.queueNameResponse = queueNameResponse;
    }
}
