package com.workflow.web.controller.callback;

import com.alibaba.fastjson2.JSONObject;
import com.workflow.common.core.domain.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/callback/event")
public class EventCallbackController {

    private static final String Encrypt_Key="U85Qdj5DrG5mcSKZU1iwHdnLKpJEztOT";
    private static final String Verification_Token ="vZIr2hA6kI5gN3NWvdUzGdxgjIAlwEmi";

    @PostMapping(value = "/fight", consumes = "application/json")
    public Object larkEventCallback(@RequestHeader("X-Forwarded-For") String xForwardedFor, @RequestBody EncryptData EncryptData) {
        //System.out.println("xForwardedFor:"+xForwardedFor);
        String encrypt=EncryptData.getEncrypt();
        try{
            Decrypt cipher = new Decrypt(Encrypt_Key);
            String encrypt_data = cipher.decrypt(encrypt);
            System.out.println(encrypt_data);
            JSONObject decrypt_data = JSONObject.parseObject(encrypt_data);
            String type = decrypt_data.getString("type");
            System.out.println(type);
            if (type.equals("url_verification")) {
                String challenge = decrypt_data.getString("challenge");
                return decrypt_data;
            }
            String token = decrypt_data.getString("token");
            if (!token.equals(Verification_Token)){
                return R.fail("error");
            }
            String uuid = decrypt_data.getString("uuid");
            String event_json = decrypt_data.getString("event");
            return decrypt_data;
        }catch (Exception e){
            System.out.println("解密失败:{}"+e.getMessage());
        }
        System.out.println("larkEventCallback");
        return R.ok("success");
    }


}
