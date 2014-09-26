package com.tihiy.springdemo.abs;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMotherModel {
    protected Map<String, AbstractModel> mapOfSubModel = new HashMap<>();

    protected void addModel(String name, AbstractModel model){
        mapOfSubModel.put(name,model);
    }

    public void addAllModel(AbstractController mc){
        mapOfSubModel.keySet().forEach(e->mc.addModel(e, mapOfSubModel.get(e)));
    }
    public void removeAllModel(AbstractController mc){
        mapOfSubModel.keySet().forEach(e->mc.removeModel(mapOfSubModel.get(e)));
    }
}
