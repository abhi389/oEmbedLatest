package internal;

import java.util.regex.Pattern;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

public abstract class OEmbedParserWithPattern implements OEmbedParser {

	private final Pattern pattern;
	private final String endpoint;

	protected OEmbedParserWithPattern(@NonNull String pattern, @NonNull String endpoint) {

		if (null==pattern) throw new NullPointerException();
		if (null==endpoint) throw new NullPointerException();
		this.pattern = Pattern.compile(pattern);
		this.endpoint = endpoint;
	}

	@Override
	public OEmbedSource getSource(@NonNull Uri fromUri) {
		if (pattern.matcher(fromUri.toString()).find()) {
			return new OEmbedSource(fromUri);
		}
		/*Log.d("pass getSource","no pass"+fromUri.toString());
		Log.d("pass getSource","pattern"+pattern);*/
		return null;
	}

	private class OEmbedSource extends BaseOEmbedSource {
		public OEmbedSource(@NonNull Uri fromUri) {
			super(OEmbedParserWithPattern.this.endpoint, fromUri);
		}
	}
}
