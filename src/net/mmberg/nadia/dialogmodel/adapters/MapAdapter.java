package net.mmberg.nadia.dialogmodel.adapters;

import java.util.*;
import java.util.Map.Entry;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MapAdapter extends XmlAdapter<MapAdapter.AdaptedMap, Map<String, String>>{

    public static class AdaptedMap {
        public List<Item> item = new ArrayList<Item>();
    }

    public static class Item {
        @XmlAttribute String key;
        @XmlValue String value;
    }
    @Override
    public AdaptedMap marshal(Map<String, String> map) throws Exception {
        AdaptedMap adaptedMap = new AdaptedMap();
        if(map!=null){
	        for(Entry<String, String> entry : map.entrySet()) {
	            Item item = new Item();
	            item.key = entry.getKey();
	            item.value = entry.getValue();
	            adaptedMap.item.add(item);
	        }
	        return adaptedMap;
        }
        return null;
    }

    @Override
    public Map<String, String> unmarshal(AdaptedMap adaptedMap) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        for(Item item : adaptedMap.item) {
            map.put(item.key, item.value);
        }
        return map;
    }

}