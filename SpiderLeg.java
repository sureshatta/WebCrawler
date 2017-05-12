import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexsimonian on 5/11/17.
 */
public class SpiderLeg {

    private List<String> links = new LinkedList<String>();  // Just a list of URLs
    private Document htmlDocument;                          // This is our web page

    public void crawl(String url) {
        try {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();

            System.out.println("Received web page at " + url);

            Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("Found (" + linksOnPage.size() + ") links");

            for(Elements link : linksOnPage) {
                this.links.add(link.absUrl("href"));
            }
        } catch(IOException ioe) {
            // We were not successful in our HTTP request
            System.out.println("Error in our HTTP request " + ioe);
        }

    }




}
