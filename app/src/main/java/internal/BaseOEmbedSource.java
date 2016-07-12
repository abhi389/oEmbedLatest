package internal;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;


import co.tophe.TopheClient;
import co.tophe.HttpException;
import co.tophe.ServerException;
import co.tophe.UriParams;
import oEmbed.OEmbed;
import oEmbed.OEmbedRequest;
import oEmbed.OEmbedSource;


public abstract class BaseOEmbedSource implements OEmbedSource {

	private OEmbed oembedData;
	private final String endpoint;
	private final String url;

	protected BaseOEmbedSource(@NonNull String endpoint, @NonNull Uri fromUri) {
		this.endpoint = endpoint;
		this.url = fromUri.toString();
	}

	final void assertDataLoaded() throws ServerException, HttpException {
		Log.d("assertDataLoaded","assertDataLoaded");
		OEmbedRequest request = createOembedRequest();
		oembedData = TopheClient.parseRequest(request);
	}

	@NonNull
	@Override
	public final OEmbedRequest createOembedRequest() {
		UriParams params = new UriParams(2);
		Log.d("OEmbedRequest","OEmbedRequest");
		params.add("url", url);
		params.add("format", "json");

		return new OEmbedRequestGet(endpoint, params);
	}

	@Nullable
	@Override
	public String getThumbnail() throws ServerException, HttpException {
		assertDataLoaded();

		if (null!=oembedData) {
			String thumbnail = oembedData.isLink() ? null : oembedData.getThumbnail();
			if (TextUtils.isEmpty(thumbnail))
				thumbnail = oembedData.getPhotoUrl();
			Log.d("here","=++"+thumbnail);
			return thumbnail;
		}
		return null;
	}
}