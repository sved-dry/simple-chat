package com.chatr.ws;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;

@Component
public class ChatrWebsocket extends TextWebSocketHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    final private ObjectMapper jackson = new ObjectMapper();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String payload = message.getPayload();

        try {
            Map<String, Object> map = jackson.readValue(payload, new TypeReference<>() {});
            session.sendMessage(new TextMessage("Hi " + map.get("user")));
        } catch (Exception e) {
            session.sendMessage(new TextMessage("Exception: " + e));
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("Opening connection for session: {}", session.getId());
        session.sendMessage(new TextMessage("hi"));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        logger.warn("Encountered the following Transport Error for mup websocket {}, {}", session.getId(), exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(@NotNull WebSocketSession session, @NotNull CloseStatus status) {
    }

}