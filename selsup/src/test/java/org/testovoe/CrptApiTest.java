package org.testovoe;

import java.util.concurrent.TimeUnit;

public class CrptApiTest {
    public static void main(String[] args) {
        try {
            CrptApi api = new CrptApi(TimeUnit.MINUTES, 10);

            CrptApi.Document document = new CrptApi.Document();
            document.doc_id = "123456";
            document.doc_status = "NEW";
            document.doc_type = "LP_INTRODUCE_GOODS";
            document.participantInn = "7701234567";
            document.importRequest = true;
            document.owner_inn = "7701234567";
            document.producer_inn = "7701234567";
            document.production_date = "2024-09-01";
            document.production_type = "PRODUCT";
            document.products = new CrptApi.Document.Product[1];
            document.products[0] = new CrptApi.Document.Product();
            document.products[0].certificate_document = "CERT123";
            document.products[0].certificate_document_date = "2024-09-01";
            document.products[0].certificate_document_number = "CERTNUM123";
            document.products[0].owner_inn = "7701234567";
            document.products[0].producer_inn = "7701234567";
            document.products[0].production_date = "2024-09-01";
            document.products[0].tnved_code = "1234567890";
            document.products[0].uit_code = "UITCODE123";
            document.products[0].uitu_code = "UITUCODE123";

            api.createDocument(document, "signature");

            System.out.println("Документ успешно отправлен!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
