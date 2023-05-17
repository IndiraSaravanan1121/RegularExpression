package api.wiremock;

import com.github.tomakehurst.wiremock.client.MappingBuilder;

public interface AbstractStubProvider {
	
	public MappingBuilder getStub();

}