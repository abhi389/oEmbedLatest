package oEmbed;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import co.tophe.HttpException;
import co.tophe.ServerException;

public interface OEmbedSource {

	/**
	 * Get a picture representation of the URL.
	 *
	 * @return {@code null} if no picture was found to represent the source URL.
	 * @throws ServerException when the OEmbed server sends an error response.
	 * @throws HttpException   for all issues processing the HTTP request not generated by the server.
	 */
	@Nullable
	String getThumbnail() throws ServerException, HttpException;


	/**
	 * Create an {@link co.tophe.oembed.OEmbedRequest} that can be used with {@link co.tophe.TopheClient TopheClient}
	 * or {@link co.tophe.async.AsyncTopheClient AsyncTopheClient}
	 */
	@NonNull
	OEmbedRequest createOembedRequest();

}
