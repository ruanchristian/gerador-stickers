import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class IMDBExtractor implements Extractor {

    @Override
    public List<Content> extract(String json) {
        List<Content> moviesExtracted = new LinkedList<>();
        JSONArray movies = new JSONObject(json).getJSONArray("items");

        for (int i = 0; i < movies.length(); i++) {
            JSONObject filme = movies.getJSONObject(i);
            String title = filme.getString("title");
            String url = filme.getString("image");

            moviesExtracted.add(new Content(title, url));
        }
        return moviesExtracted;
    }
    
}
