package wtc.carbon.carbonbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/getAMap")
    public HashMap<String, String> getAMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        return map;
    }

    @GetMapping("/getList")
    public ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("value1");
        list.add("value2");
        return list; // to motivate git 2
    }
}
