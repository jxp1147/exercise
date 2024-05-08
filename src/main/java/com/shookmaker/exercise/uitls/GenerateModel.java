package com.shookmaker.exercise.uitls;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class GenerateModel {

    final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    final String client_id = "pwD0Xou41z44vvV2DUmXtbzQ";
    final String client_secret = "LCuuJuTiuoihPCwjA0JVR44kZXPpbRA6";

    public String generate(String content) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        ChatMessageModel message = new ChatMessageModel("user", content);
        List<ChatMessageModel> messages = List.of(message);
        ChatConfig config = new ChatConfig(false, false, messages);
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(config));
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/ernie-3.5-8k-preview?access_token=" + getAccessToken())
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        return response.body().string();
    }

    String getAccessToken() throws IOException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=" + client_id + "&client_secret=" + client_secret);
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        JSONObject jsonObject = JSON.parseObject(response.body().string());
        return jsonObject.getString("access_token");
    }
}
