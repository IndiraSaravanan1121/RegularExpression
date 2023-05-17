package api.wiremock;

import org.json.JSONObject;

public class EmptyResponseBody implements AbstractResponseBodyProvider {

	@Override
	public JSONObject getResponseBody() {
		return new JSONObject();
	}
}
