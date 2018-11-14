package com.jenkov.crawler.mt.io;


import com.jenkov.crawler.util.UrlNormalizer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.BrokenBarrierException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrawlJobMT implements Runnable {
	 protected CrawlerMT crawler    = null;
	    protected String  urlToCrawl = null;
	    
	    public CrawlJobMT(String urlToCrawl, CrawlerMT crawler) {
	        this.urlToCrawl = urlToCrawl;
	        this.crawler    = crawler;
	    }
	    @Override
	    public void run(){
	        try{
	            crawl();
	        }catch(Exception ex){
	            
	        }
	    }
	    public void crawl() throws IOException{

	        URL url = new URL(this.urlToCrawl);

	        URLConnection urlConnection = null;
	        try {
	            urlConnection = url.openConnection();
	            System.out.println("The URL to connect is "+urlToCrawl);

	            try (InputStream input = urlConnection.getInputStream()) {

	                Document doc      = Jsoup.parse(input, "UTF-8", "");
	                Elements elements = doc.select("a");

	                String baseUrl = url.toExternalForm();
	                for(Element element : elements){
	                    String linkUrl       = element.attr("href");
	                    System.out.println("Printing the linked URL "+linkUrl);
	                    String normalizedUrl = UrlNormalizer.normalize(linkUrl, baseUrl);
	                    //crawler.linksQueue.put(normalizedUrl);
	                    crawler.linksQueue.put(normalizedUrl);
	                   
	                    
	                    
	                    System.out.println(" - "+normalizedUrl);
	                    
	                }
	               /* if(crawler.barrier.getNumberWaiting()==1){
	                    crawler.barrier.await();
	                    
	                }*/
	                if(crawler.barrier.getNumberWaiting()==1){
	                    crawler.barrier.await();
	                    
	                }

	            } catch (IOException e) {
	                throw new RuntimeException("Error connecting to URL", e);
	            } catch (InterruptedException ex) {
	                Logger.getLogger(CrawlJobMT.class.getName()).log(Level.SEVERE, null, ex);
	            } catch (BrokenBarrierException ex) {
	                Logger.getLogger(CrawlJobMT.class.getName()).log(Level.SEVERE, null, ex);
	            } 
	        } catch(IOException e) {
	            throw new RuntimeException("Error connecting to URL", e);
	        }
	    }



}
