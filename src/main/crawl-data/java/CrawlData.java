import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlData {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/crawl-data/data.txt")));
        String line;
        ArrayList<String> links = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            links.add(line);
        }
        for (String link : links) {
            System.out.println(link);
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
                Pattern p = Pattern.compile("<meta itemprop=\"image\" content=\"(.*?)\" />(.*?)<div class=\"area_price \" id=\"normalproduct\"> <strong>(.*?)₫</strong(.*?)class=\"table\"> <span>CPU:</span><div>(.*?)</div><span>RAM:</span><div>(.*?)</div><span>Ổ cứng:</span><div>(.*?)</div><span>Màn hình:</span><div>(.*?)</div(.*?)PAGE_TYPE = '(.*?)'");
                Matcher m = p.matcher(content);

                while (m.find()) {
                    String imgURL = m.group(1);
                    String price = m.group(3);
                    String description = "CPU: " +m.group(5)+ "\n" + "RAM: " +m.group(6) + "\n" +
                            "Ổ CỨNG: " + m.group(7) + "\n" +
                            "Màn Hình: " +m.group(8);
                    String nameProduct = m.group(10);
                    System.out.println("imgURL: " +imgURL);
                    System.out.println("price: " + price);
                    System.out.println("descripion: " + description);
                    System.out.println("name: " + nameProduct);
                    System.out.println("______________");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
