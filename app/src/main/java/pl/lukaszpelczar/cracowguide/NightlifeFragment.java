/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.lukaszpelczar.cracowguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NightlifeFragment extends Fragment {

    public NightlifeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Create a list of nightlife items
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.string.nightlife1_name, R.string.nightlife1_address,
                R.string.nightlife1_description, R.string.nightlife1_tags, R.string.nightlife1_type,
                R.drawable.frantic, "http://www.frantic.pl/"));
        items.add(new Item(R.string.nightlife2_name, R.string.nightlife2_address,
                R.string.nightlife2_description, R.string.nightlife2_tags, R.string.nightlife2_type,
                R.drawable.house_of_beer, "http://www.houseofbeerkrakow.com/"));
        items.add(new Item(R.string.nightlife3_name, R.string.nightlife3_address,
                R.string.nightlife3_description, R.string.nightlife3_tags,
                R.string.nightlife3_type, R.drawable.prominent, "http://www.kamienna.krakow.pl/"));
        items.add(new Item(R.string.nightlife4_name, R.string.nightlife4_address,
                R.string.nightlife4_description, R.string.nightlife4_tags,
                R.string.nightlife4_type, R.drawable.shine, "http://krakow.shineclub.com.pl/"));
        items.add(new Item(R.string.nightlife5_name, R.string.nightlife5_address,
                R.string.nightlife5_description,
                R.string.nightlife5_tags, R.string.nightlife5_type,
                R.drawable.coco, "http://www.clubcoco.pl/en/"));
        items.add(new Item(R.string.nightlife6_name, R.string.nightlife6_address,
                R.string.nightlife6_description, R.string.nightlife6_tags, R.string.nightlife6_type,
                R.drawable.jazz, "http://kornetklub.pl/"));
        items.add(new Item(R.string.nightlife7_name, R.string.nightlife7_address,
                R.string.nightlife7_description, R.string.nightlife7_tags,
                R.string.nightlife7_type, R.drawable.forty, "http://www.fortykleparz.pl/"));
        items.add(new Item(R.string.nightlife8_name, R.string.nightlife8_address,
                R.string.nightlife8_description, R.string.nightlife8_tags, R.string.nightlife8_type,
                R.drawable.opium, "http://www.opium.krakow.pl/"));
        items.add(new Item(R.string.nightlife9_name, R.string.nightlife9_address,
                R.string.nightlife9_description, R.string.nightlife9_tags,
                R.string.nightlife9_type, R.drawable.amnesia, "http://www.where2b.org/178354"));
        items.add(new Item(R.string.nightlife10_name, R.string.nightlife10_address,
                R.string.nightlife10_description, R.string.nightlife10_tags,
                R.string.nightlife10_type, R.drawable.totu, "http://www.totuklub.pl/"));

        // Create an {@link NightlifeItemAdapter}, whose data source is a list of {@link Item}s.
        // The adapter knows how to create list items for each item in the list.
        NightlifeItemAdapter adapter = new NightlifeItemAdapter(getActivity(), items, R.color.category_color);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link EssentialsItemAdapter} we created above,
        // so that the {@link ListView} will display list items for each {@link Item} in the list.
        listView.setAdapter(adapter);

        // Open the url for every Item.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Item item = items.get(position);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(item.getNightlifeUrl()));
                startActivity(i);
            }
        });

        return rootView;
    }

}
