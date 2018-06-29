package com.guo.projectg.ui.adapter;


import java.util.HashMap;

/**
 * Author : jugg
 * Date   : 2018/6/28
 */
public class AbsAdapterDelegateMgr {

    private AbsAdapterDelegateMgr() {
    }

    private HashMap<Integer, AbsAdapterDelegate> map;

    public AbsAdapterDelegate routing(int viewType) {
        return map.get(viewType);
    }


    public static class Builder {
        private HashMap<Integer, AbsAdapterDelegate> map;

        private AbsAdapterDelegateMgr mgr;

        public Builder() {
            mgr = new AbsAdapterDelegateMgr();
            map = new HashMap<>();
        }

        public Builder regist(int viewType, AbsAdapterDelegate delegate) {
            map.put(viewType, delegate);
            return this;
        }

        public AbsAdapterDelegateMgr build() {
            mgr.map = map;
            return mgr;
        }
    }
}
