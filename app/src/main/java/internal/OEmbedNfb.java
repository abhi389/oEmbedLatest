package internal;


import android.util.Log;

public class OEmbedNfb extends OEmbedParserWithPattern {

	public static final OEmbedNfb INSTANCE = new OEmbedNfb();

	private OEmbedNfb() {
		super("http://.*.nfb.ca/film/*", "http://www.nfb.ca/remote/services/oembed/");


	}
}
