package internal;


public class OEmbedUstream extends OEmbedParserWithPattern {

	public static final OEmbedUstream INSTANCE = new OEmbedUstream();

	private OEmbedUstream() {
		super("http://.*.ustream.tv/*|http://.*.ustream.com/*", "http://www.ustream.tv/oembed");
	}
}
