import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.*;
public class CrawlData {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/crawl-data/data.txt")));
        String line;
        ArrayList<String> links = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            links.add(line);
        }
        for (String link : links) {
            try {
                URL url = new URL(link);
                Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
                scanner.useDelimiter("\\Z");
                String content = scanner.next();
                scanner.close();
                content = content.replaceAll("\\n+", "");
                content = content.replaceAll("\\s+"," ");
                content = content.replaceAll("<a href='(.*?)' target='_blank'>","");
                content = content.replaceAll("</a>","");
                content = content.replaceAll("<li class=\"(.*?)\">","");
                content = content.replaceAll("</li>","");
                content = content.replaceAll("\\.","");
                content = content.replaceAll(",","");
                Pattern p = Pattern.compile("<meta itemprop=\"image\" content=\"(.*?)\" />(.*?)<div class=\"area_price \" id=\"normalproduct\"> <strong>(.*?)₫</strong(.*?)class=\"table\"> <span>CPU:</span><div>(.*?)</div><span>RAM:</span><div>(.*?)</div><span>Ổ cứng:</span><div>(.*?)</div><span>Màn hình:</span><div>(.*?)</div(.*?)PAGE_TYPE = '(.*?)'");
                Matcher m = p.matcher(content);
                String text = "INSERT INTO product (productName, price, description, imgURL)";
                while (m.find()) {
                    String imgURL = "'"+ m.group(1)+"'";
                    long price =Long.parseLong(m.group(3));
                    String description = "'"+"CPU: " +m.group(5)+ "\n" + "RAM: " +m.group(6) + "\n" +
                            "Ổ CỨNG: " + m.group(7) + "\n" +
                            "Màn Hình: " +m.group(8) +"'";
                    String productName = "'"+m.group(10)+"'";
                    String textV = "VALUES ("+productName+",'" +price+"',"+ description+","+imgURL+" ),";
                    System.out.println(textV);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
