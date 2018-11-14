package com.jenkov.crawler.mt.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.BrokenBarrierException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jenkov.crawler.util.UrlNormalizer;

public class JustATest {
	public static void main(String[] args) throws Throwable {
		 URL url = new URL("https://in.yahoo.com/");
		  URLConnection urlConnection = null;
	        try {
	            urlConnection = url.openConnection();

	            try (InputStream input = urlConnection.getInputStream()) {

	                Document doc      = Jsoup.parse(input, "UTF-8", "");
	                Elements elements = doc.select("a");

	                String baseUrl = url.toExternalForm();
	                for(Element element : elements){
	                    String linkUrl       = element.attr("href");
	                    System.out.println("The URL reference is "+linkUrl);
	                    String normalizedUrl = UrlNormalizer.normalize(linkUrl, baseUrl);
	                    //crawler.linksQueue.put(normalizedUrl);
	                   // crawler.linksQueue.put(normalizedUrl);
	                   
	                    
	                    
	                    System.out.println(" - "+normalizedUrl);
	                    
	                }
	               /* if(crawler.barrier.getNumberWaiting()==1){
	                    crawler.barrier.await();
	                    
	                }*/
	               

	            } catch (IOException e) {
	                throw new RuntimeException("Error connecting to URL", e);
	            } 
	        } catch (Throwable t) {
	        	t.printStackTrace();
	        	
	        }
	}

}
