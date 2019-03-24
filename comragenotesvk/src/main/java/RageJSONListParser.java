import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import listentities.RageServerAttributesEntity;
import listentities.RageServerEntity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RageJSONListParser {
    private final Gson gson = new Gson();

    public List<RageServerEntity> parseList(String jsonString) {
        ArrayList<RageServerEntity> list = new ArrayList<>();

        Type type = new TypeToken<Map<String, RageServerAttributesEntity>>(){}.getType();
        Map<String, RageServerAttributesEntity> map = gson.fromJson(jsonString, type);

        for(String address : map.keySet()) {
            RageServerEntity entity = new RageServerEntity(address, map.get(address));
            list.add(entity);
        }
        return list;
    }
}

/*
{
"IP:PORT":
    {
      "name":"NAME",
      "gamemode":"freeroam",
      "url":"vk.com/ragecomplex",
      "lang":"ru",
      "voiceChat":false,
      "resourcesWeight": 0,
      "players":1,
      "peak":10,
      "maxplayers":200,
      "playersHistory":[1,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,5,4,1,3,0,0,1,2,3,1,0,0,1,0,0,1,1,0,2,3,3,2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,2,2,4,2,2,2,1,1,1,0,0,0,0,1,1,3,4,2,0,0,0,0,1,1,2,2,0,0,1,1,1,4,1,3,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,2,3,3,3,1,3,3,1,3,4,4,4,1,3,0,0,0,1,2,2,0,1,0,0,0,2,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,4,7,7]
    }
}
 */