import com.google.gson.Gson;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.queries.execute.ExecuteCodeQuery;
import com.vk.api.sdk.streaming.clients.VkStreamingApiClient;
import listentities.RageServerAttributesEntity;
import listentities.RageServerEntity;

import java.util.List;

public class MonitoringWiget {


    public static void main(String... args) throws Exception {
        HttpTransportClient client = new HttpTransportClient();
        VkApiClient apiClient = new VkApiClient(client);
    }
}
