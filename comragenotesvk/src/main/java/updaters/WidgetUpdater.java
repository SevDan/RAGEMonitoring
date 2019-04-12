package updaters;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import loaders.ListLoader;
import loaders.RageMasterListLoader;
import parsers.JSONListParser;
import parsers.RageJSONListParser;
import selectors.RageTopSelector;
import selectors.TopSelector;
import updaters.widgetcodegenerator.CodeGenerator;
import updaters.widgetcodegenerator.WidgetCodeGenerator;

public class WidgetUpdater implements Updater {
    /*
        VK access block
     */
    private int groupId = 0;
    private String token = "";

    private VkApiClient apiClient;
    private GroupActor actor;

    /*
        Content provider block
     */
    private CodeGenerator codeGenerator;

    @Override
    public void init(int groupId, String token) {
        this.groupId = groupId;
        this.token = token;

        HttpTransportClient client = new HttpTransportClient();
        apiClient = new VkApiClient(client);
        actor = new GroupActor(groupId, token);

        codeGenerator = new WidgetCodeGenerator();
        codeGenerator.init(new RageMasterListLoader(), new RageJSONListParser(), new RageTopSelector());
    }

    @Override
    public void update() {
        codeGenerator.update();
        apiClient.appWidgets()
                .update(actor, codeGenerator.getCode());
    }
}
