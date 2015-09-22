package est.core.repository.tokenizer;

public class TitleToken extends DOPToken {

    public TitleToken(String content) {
        super(content);
    }

    @Override
    public String toString() {
        return "title:\"" + getEscapedContent() + "\"";
    }
}
