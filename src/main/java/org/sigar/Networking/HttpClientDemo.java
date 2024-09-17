package org.sigar.Networking;
import java.net.*;
import java.net.http.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

class HttpClientDemo {
    public static void oldHttpClient() throws Exception {
        // Obtain a client that uses the default settings.
        HttpClient myHC = HttpClient.newHttpClient();
        // Create a request.
        HttpRequest myReq = HttpRequest.newBuilder(
                new URI("http://www.google.com/")).build();
        // Send the request and get the response. Here, an InputStream is
        // used for the body.
//        HttpResponse<InputStream> myResp = myHC.send(myReq,
//                HttpResponse.BodyHandlers.ofInputStream());
        HttpResponse<Stream<String>> myResp = myHC.send(myReq,
                HttpResponse.BodyHandlers.ofLines());

     //   System.out.println(myResp.body());

        // Display response code and response method.
        System.out.println("Response code is " + myResp.statusCode());
        System.out.println("Request method is " + myReq.method());

        // Get headers from the response.
        HttpHeaders hdrs = myResp.headers();
        // Get a map of the headers.
        Map<String, List<String>> hdrMap = hdrs.map();
        Set<String> hdrField = hdrMap.keySet();
        System.out.println("\nHere is the header:");
        // Display all header keys and values.
        for(String k : hdrField) {
            System.out.println("Key: " + k +
                    " Value: " + hdrMap.get(k));
        }
        // Display the body.
        System.out.println("\nHere is the body: ");
        System.out.println(myResp.body());
//        int c;
//        // Read and display the entire body.
//        while((c = input.read()) != -1) {
//            System.out.print((char) c);
//        }
    }
//    Handling Asynchronous Requests:
//    HttpClient also supports asynchronous operations via the sendAsync method. Here's an example of how to do the same request asynchronously:
    public static void newHttpClient() {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.google.com"))
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> responseFuture =
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // Non-blocking: the code below runs while waiting for the response
        responseFuture.thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();  // Ensure the program waits for completion
    }

    public static void main(String[] args) throws Exception {
       // newHttpClient();
        oldHttpClient();
    }
}
