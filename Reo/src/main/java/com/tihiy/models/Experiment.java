package com.tihiy.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Experiment {
    private List<Channel> channelList;

    public void setChannelList(Channel... channelArray){
        channelList = new ArrayList<>();
        Collections.addAll(channelList, channelArray);
    }

}
