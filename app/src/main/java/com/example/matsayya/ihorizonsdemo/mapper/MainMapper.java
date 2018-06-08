package com.example.matsayya.ihorizonsdemo.mapper;



import com.example.matsayya.ihorizonsdemo.mvp.model.Item;
import com.example.matsayya.ihorizonsdemo.mvp.model.RepoMainResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainMapper {
    @Inject
    public MainMapper() {

    }

    public static List<Item> mapRepository(RepoMainResponse repoMainResponse) {
        List<Item> itemList = new ArrayList<>();
        if (repoMainResponse != null) {


            List<Item> itemResultList = repoMainResponse.getItems();
            if (repoMainResponse != null) {

                for (Item item : itemResultList) {
                    Item itemResult = new Item();
                    itemResult.setName(item.getName());
                    itemResult.setDescription(item.getDescription());
                    itemResult.setForksCount(item.getForksCount());
                    itemResult.setOwner(item.getOwner());

                    itemList.add(itemResult);
                }
            }
        }
        return itemList;
    }
}
