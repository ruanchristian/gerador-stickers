import java.util.List;

public interface Extractor {
    public List<Content> extract(String json);
}
