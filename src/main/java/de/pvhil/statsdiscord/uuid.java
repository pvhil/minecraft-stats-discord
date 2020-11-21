package de.pvhil.statsdiscord;


import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class uuid {
    public static String uuid;

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create( "https://api.mojang.com/users/profiles/minecraft/"+DiscordMessage.name))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(de.pvhil.statsdiscord.uuid::parse)
                .join();

    }
    public static String parse(String responseBody) {

        JSONObject obj = new JSONObject(responseBody);
        uuid = obj.getString("id");

        return null;
    }




}
