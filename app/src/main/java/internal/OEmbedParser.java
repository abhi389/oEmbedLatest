package internal;

import android.net.Uri;
import android.support.annotation.NonNull;

import oEmbed.OEmbedSource;


public interface OEmbedParser {
	OEmbedSource getSource(@NonNull Uri fromUri);
}
