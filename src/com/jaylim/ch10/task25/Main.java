package com.jaylim.ch10.task25;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);

        System.out.println("Input URL: ");

        //getting URL from User
        CompletableFuture<String> url = getURL();

        //parsing links
        CompletableFuture<List<String>> links = url.thenApply(new Function<String, List<String>>() {
            @Override
            public List<String> apply(String s) {
                List<String> links = new ArrayList<>();
                try {
                    Document document = Jsoup.connect(s).get();
                    Elements elements = document.select("a[href]");

                    for (Element element : elements) {
                        links.add(element.attr("href"));
                    }
                } catch (IOException e) {
                    System.out.println("Cannot parse link.");
                }
                return links;
            }
        });

        //printing links
        CompletableFuture<Void> print = links.thenAccept(new Consumer<List<String>>() {
            @Override
            public void accept(List<String> strings) {
                for (String s : strings) {
                    System.out.println(s);
                }
            }
        });
    }

    private static CompletableFuture<String> getURL() {
        CompletableFuture<String> future = new CompletableFuture<>();
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            future.complete(scanner.nextLine());
        }
        return future;
    }
}
