package br.com.brunosan.gerenciarobjetivo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class QueuePropertiesProvider {
    
    @Autowired
    @Qualifier("queuePropertiesSalvar")
    private QueueProperties queuePropertiesSalvar;
    
    @Autowired
    @Qualifier("queuePropertiesSimular")
    private QueueProperties queuePropertiesSimular;
    
    @Autowired
    @Qualifier("queuePropertiesDetalha")
    private QueueProperties queuePropertiesDetalha;
    
    public QueueProperties getQueueProperties(String endpoint) {
        switch (endpoint) {
            case "/salvar":
                return queuePropertiesSalvar;
            case "/simular":
                return queuePropertiesSimular;
            case "/detalhar":
                return queuePropertiesDetalha;
            // Adicionar mais casos se necessário
            default:
                throw new IllegalArgumentException("Endpoint desconhecido: " + endpoint);
        }
    }
}