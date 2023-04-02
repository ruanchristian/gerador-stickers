import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;

public class NasaExtractor implements Extractor {

    @Override
    public List<Content> extract(String json) {
        List<Content> nasaInfos = new LinkedList<>();
        JSONArray nasaInfo = new JSONArray(json);

        for (int i = 0; i < nasaInfo.length(); i++) {
            var info = nasaInfo.getJSONObject(i);

            String title = info.getString("title");
            String url = info.getString("url");
            nasaInfos.add(new Content(title, url));
        }
        return nasaInfos;
    }
    
}
