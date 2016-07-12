package oEmbed;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import internal.OEmbedCollegeHumor;
import internal.OEmbedDailymotion;
import internal.OEmbedDotsub;
import internal.OEmbedFunnyOrDie;
import internal.OEmbedHulu;
import internal.OEmbedImgur;
import internal.OEmbedInstagram;
import internal.OEmbedNfb;
import internal.OEmbedParser;
import internal.OEmbedUstream;
import internal.OEmbedViddler;
import internal.OEmbedVimeo;
import internal.OEmbedVine;
import internal.OEmbedYoutube;


/**
 * Helper class to find a suitable {@link co.tophe.oembed.OEmbedSource} for a specified URL.
 *
 * @see #lookup(String)
 */
public final class OEmbedFinder {

	private static final OEmbedParser parsers[] = new OEmbedParser[]{
			OEmbedYoutube.INSTANCE,
			OEmbedInstagram.INSTANCE,
			OEmbedImgur.INSTANCE,
			OEmbedVimeo.INSTANCE,
			OEmbedHulu.INSTANCE,
			OEmbedNfb.INSTANCE,
			OEmbedDailymotion.INSTANCE,
			OEmbedFunnyOrDie.INSTANCE,
			OEmbedVine.INSTANCE,
			OEmbedViddler.INSTANCE,
			OEmbedDotsub.INSTANCE,
			OEmbedCollegeHumor.INSTANCE,
			OEmbedUstream.INSTANCE,

	};

	/**
	 * Find an OEmbed source for the specified URL.
	 * <p>After that you can call {@link OEmbedSource#getThumbnail()} to get a picture representation of the URL.</p>
	 * <p>When a source is not found you may still use fallback sources like {@link co.tophe.oembed.fallback.OEmbedEmbedly OEmbedEmbedly},
	 * {@link co.tophe.oembed.fallback.OEmbedOohembed OEmbedOohembed} or {@link co.tophe.oembed.fallback.OEmbedReembed OEmbedReembed}</p>
	 *
	 * @return {@code null} if no source if found for this URL.
	 */
	@Nullable
	public static OEmbedSource lookup(String sourceUrl) {
		if (!TextUtils.isEmpty(sourceUrl)) {
			Uri sourceUri = Uri.parse(sourceUrl);
			for (OEmbedParser parser : parsers) {
				OEmbedSource src = parser.getSource(sourceUri);
				if (null != src)
					return src;
			}
		}
		return null;
	}

}
