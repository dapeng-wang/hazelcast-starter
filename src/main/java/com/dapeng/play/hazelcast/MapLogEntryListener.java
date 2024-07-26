package com.dapeng.play.hazelcast;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;
import com.hazelcast.map.MapEvent;

public class MapLogEntryListener implements EntryListener<String, String> {
    @Override
    public void entryAdded(EntryEvent<String, String> entryEvent) {
        System.out.println("ADD: " + entryEvent.getKey() + "->" + entryEvent.getValue());
    }

    @Override
    public void entryEvicted(EntryEvent<String, String> entryEvent) {
        System.out.println("EVICT: " + entryEvent.getKey());
    }

    @Override
    public void entryRemoved(EntryEvent<String, String> entryEvent) {
        System.out.println("REMOVE: " + entryEvent.getKey());
    }

    @Override
    public void entryUpdated(EntryEvent<String, String> entryEvent) {
        System.out.println("UPDATE: " + entryEvent.getKey());
    }

    @Override
    public void mapCleared(MapEvent mapEvent) {
        System.out.println("CLEAR");
    }

    @Override
    public void mapEvicted(MapEvent mapEvent) {
        System.out.println("EVICT");
    }

    @Override
    public void entryExpired(EntryEvent<String, String> entryEvent) {
        System.out.println("EXPIRE");
    }
}
