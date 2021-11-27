package reptile;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lifengming
 * @date 2021.09.11
 */
@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class SogouImgProcessor {

    private final String url;
    private final SogouImgPipeline pipeline;

    private final List<JSONObject> dataList;
    private final List<String> urlList;
    private final String word;

    public SogouImgProcessor(String url, String word) {
        this.url = url;
        this.word = word;
        this.pipeline = new SogouImgPipeline();
        this.dataList = new ArrayList<>();
        this.urlList = new ArrayList<>();
    }

    public void process(int idx, int size) {
        String res = HttpUtil.get(String.format(this.url, idx, size, this.word), StandardCharsets.UTF_8);
        JSONObject object = JSONUtil.parseObj(res);
        //noinspection unchecked
        List<JSONObject> items = (List<JSONObject>) ((JSONObject) object.get("data")).get("items");
        for (JSONObject item : items) {
            this.urlList.add(item.getStr("picUrl"));
        }
        this.dataList.addAll(items);
    }

    public void pipelineData() {
        pipeline.processSync(this.urlList, this.word);
    }
}
