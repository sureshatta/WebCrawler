/**
 * Created by alexsimonian on 5/11/17.
 */
public class SpiderTest
{
    /**
     * This is our test. It creates a spider (which creates spider legs) and crawls the web.
     *
     * @param args
     *            - not used
     */
    public static void main(String[] args)
    {
        Spider spider = new Spider();
        spider.search("http://arstechnica.com/", "computer");
    }
}