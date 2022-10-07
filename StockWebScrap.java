import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StockWebScrap {
    public static void main(String[] args){
        
        final String url = 
                "https://in.investing.com/indices/major-indices";
        
        try{
            final Document document = Jsoup.connect(url).get();
//            System.out.println(document.outerHtml());
            for(Element row : document.select(
                "table.common-table.js-table.js-streamable-table.medium tr")){
                if(row.select(".js-instrument-page-link").text().equals("")){
                    continue;
                }
                else{
                    final String ticker = row.select(".js-instrument-page-link").text();
//                    System.out.println(ticker);
                    final String lastPrice = row.select(".u-txt-align-end.col-last").text();
//                    System.out.println(lastPrice);
                    final String highPrice = row.select(".u-txt-align-end.col-high").text();
//                    System.out.println(highPrice);
                    final String lowPrice = row.select(".u-txt-align-end.col-low").text();
//                    System.out.println(lowPrice);
                    System.out.println(ticker + "   " + lastPrice + "   " + highPrice + "   " + lowPrice);
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    

    }
}
