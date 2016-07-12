package internal;


public class OEmbedDotsub extends OEmbedParserWithPattern {

	public static final OEmbedDotsub INSTANCE = new OEmbedDotsub();

	private OEmbedDotsub() {
		super("http://dotsub.com/view/*", "https://dotsub.com/services/oembed");
	}
}
