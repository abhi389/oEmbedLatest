package internal;


public class OEmbedCollegeHumor extends OEmbedParserWithPattern {

	public static final OEmbedCollegeHumor INSTANCE = new OEmbedCollegeHumor();

	private OEmbedCollegeHumor() {
		super("http://www.collegehumor.com/video/*", "http://www.collegehumor.com/oembed.json");
	}
}
