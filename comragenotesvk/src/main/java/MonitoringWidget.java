import com.google.gson.Gson;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.GroupAuthResponse;
import com.vk.api.sdk.objects.UserAuthResponse;
import com.vk.api.sdk.queries.execute.ExecuteCodeQuery;
import com.vk.api.sdk.streaming.clients.VkStreamingApiClient;
import listentities.RageServerAttributesEntity;
import listentities.RageServerEntity;

import java.util.List;

public class MonitoringWiget {

    private VkApiClient apiClient;
    private GroupActor actor;

    private final int APP_ID = 1;
    private final String CLIENT_SECRET = "rf";
    private final String REDIRECT_URI = "rf";
    private final String A_CODE = "rf";
    private final int groupId = 1;


    public static void main(String... args) throws Exception {
        MonitoringWiget wiget = new MonitoringWiget();
    }

    private void setup() throws ClientException, ApiException {
        HttpTransportClient client = new HttpTransportClient();
        apiClient = new VkApiClient(client);

        GroupAuthResponse authResponse = apiClient.oauth()
                .groupAuthorizationCodeFlow(APP_ID, CLIENT_SECRET, REDIRECT_URI, A_CODE)
                .execute();

        actor = new GroupActor(groupId, authResponse.getAccessTokens().get(groupId));
    }

    private void update() {
        apiClient.appWidgets().update(actor, "{ \n" +
                "    \"title\": \"My Table\", \n" +
                "    \"title_url\": \"https://link\", \n" +
                "    \"title_counter\": 31, \n" +
                "    \"more\": \"Посмотреть все результаты\", \n" +
                "    \"more_url\": \"https://link2\", \n" +
                "    \"head\": [{ \n" +
                "        \"text\": \"Название первой колонки\" \n" +
                "    }, { \n" +
                "        \"text\": \"Название второй колонки\", \n" +
                "        \"align\": \"center\" \n" +
                "    }], \n" +
                "    \"body\": [ \n" +
                "        [{ \n" +
                "            \"text\": \"Это первая ячейка первой строки\", \n" +
                "            \"icon_id\": \"3484735_23434324\" \n" +
                "        }, \n" +
                "        { \n" +
                "            \"text\": \"Это вторая ячейка первой строки\", \n" +
                "            \"url\": \"https://vk.com/wall-12345_542321\" \n" +
                "        }], \n" +
                "        [{ \n" +
                "            \"text\": \"Это первая ячейка второй строки\", \n" +
                "            \"icon_id\": \"3484735_23434324\" \n" +
                "        }, \n" +
                "        { \n" +
                "            \"text\": \"Это вторая ячейка второй строки\", \n" +
                "            \"url\": \"https://vk.com/wall-12345_54321\" \n" +
                "        } \n" +
                "        ] \n" +
                "    ] \n" +
                "}");
    }
}
