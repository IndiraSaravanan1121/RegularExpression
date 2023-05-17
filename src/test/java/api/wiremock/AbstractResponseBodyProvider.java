package api.wiremock;

import org.json.JSONObject;

public interface AbstractResponseBodyProvider {

	public JSONObject getResponseBody();
}
