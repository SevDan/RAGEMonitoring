import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RageMasterListLoader implements ListLoader {
    private static final String RAGE_CDN_URL = "https://cdn.rage.mp/master/";

    private String masterListJson = "";

    public void loadMasterList() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(RAGE_CDN_URL);

            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity httpEntity = response.getEntity();
                        return httpEntity != null ? EntityUtils.toString(httpEntity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };

            String responseBody = client.execute(httpGet, responseHandler);
            if (responseBody != null && responseBody.length() > 1)
                masterListJson = responseBody;
        }
        finally {
            client.close();
        }
    }

    public String getMasterListJSON() {
        return masterListJson;
    }

}
