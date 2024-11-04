package org.testovoe;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.RateLimiter;

public class CrptApi {
    private final RateLimiter rateLimiter;
    private final HttpClient client;

    public CrptApi(TimeUnit timeUnit, int requestLimit) {
        double permitsPerSecond = calculatePermitsPerSecond(timeUnit, requestLimit);
        this.rateLimiter = RateLimiter.create(permitsPerSecond);
        this.client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    private double calculatePermitsPerSecond(TimeUnit timeUnit, int requestLimit) {
        long seconds = timeUnit.toSeconds(1);
        return (double) requestLimit / seconds;
    }

    public void createDocument(Document document, String signature) throws Exception {
        rateLimiter.acquire(); // Блокирует, если превышен лимит запросов

        String authToken = "Bearer a93e657b-f402-4e7a-b61f-6fbe717fa5e1"; // Замените на ваш реальный токен

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://ismp.crpt.ru/api/v3/lk/documents/create"))
                .header("Content-Type", "application/json")
                .header("Authorization", authToken) // Добавляем заголовок Authorization
                .POST(HttpRequest.BodyPublishers.ofString(toJson(document)))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to create document: " + response.body());
        }
    }

//    public String authenticate(String username, String password) throws Exception {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(new URI("https://ismp.crpt.ru/api/v3/auth/login")) // Пример URL, замените на реальный
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(
//                        "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}"))
//                .build();
//
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        if (response.statusCode() != 200) {
//            throw new RuntimeException("Failed to authenticate: " + response.body());
//        }
//
//        // Предполагается, что токен возвращается в поле "token" в JSON
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readTree(response.body()).get("token").asText();
//    }


    private String toJson(Document document) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(document);
    }

    public static class Document {
        public String doc_id;
        public String doc_status;
        public String doc_type;
        public String participantInn;
        public boolean importRequest;
        public String owner_inn;
        public String producer_inn;
        public String production_date;
        public String production_type;
        public Product[] products;

        public static class Product {
            public String certificate_document;
            public String certificate_document_date;
            public String certificate_document_number;
            public String owner_inn;
            public String producer_inn;
            public String production_date;
            public String tnved_code;
            public String uit_code;
            public String uitu_code;
        }
    }
}


