package org.sigar.Networking;
import java.net.*;
import java.util.List;
import java.util.Map;

public class CookieDemo {
    public static void cookieManager() throws Exception {
        // Set up the CookieManager with a custom policy
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);

        // Create a connection
       // URL url = new URL("https://cricbuzz.com");
        URL url = new URL("https://www.nytimes.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.getContent();
        // Handle cookies automatically
        Map<String, List<String>> headerFields = connection.getHeaderFields();
        List<String> cookiesHeader = headerFields.get("Set-Cookie");

        if (cookiesHeader != null) {
            for (String cookie : cookiesHeader) {
                System.out.println("Set-Cookie: " + cookie);
            }
        } else {
            System.out.println("No cookies found in headers.");
        }

        CookieStore store = cookieManager.getCookieStore();
        for (HttpCookie cookie : store.getCookies()) {
            System.out.println("Cookie from store: " + cookie.getName() + " = " + cookie.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        cookieManager();
    }
}
