import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
 
public class Starter {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o texto da figurinha: ");
        String text = sc.nextLine();
        sc.close();

        // API.IMDB_TOP_MOVIES, API.IMDB_TOP_TVS, API.NASA_PICS
        API api = API.IMDB_TOP_MOVIES;
       
        ApiClient client = new ApiClient();
        String json = client.requestBody(api.getUrl());   
        
        Extractor extractorContent = api.getExtractorType();
        List<Content> contents = extractorContent.extract(json);
        StickerFactory factory = new StickerFactory(text);

        for (Content content : contents) {
            InputStream inputStream = new URL(content.getImgUrl()).openStream();
            String fileName = content.getTitle() + ".png";

            factory.create(inputStream, fileName);
            System.out.println();
        }
    }
}