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

/**
 * {@link Fragment} that displays a list of hotels.
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Create a list of hotels
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.string.hotel1_name,R.string.hotel1_description,
                R.drawable.kanonicza,R.string.hotel1_location,R.string.hotel1_type,
                "http://www.kanonicza22.com/en/"));
        items.add(new Item(R.string.hotel2_name,R.string.hotel2_description,
                R.drawable.metropolitan,R.string.hotel2_location,R.string.hotel2_type,
                "http://metropolitan-boutique.krakowhotels.net/en/"));
        items.add(new Item(R.string.hotel3_name,R.string.hotel3_description,
                R.drawable.amadeus,R.string.hotel3_location,R.string.hotel3_type, "http://www.hotel-amadeus.pl/en/"));
        items.add(new Item(R.string.hotel4_name,R.string.hotel4_description,
                R.drawable.indigo,R.string.hotel4_location,R.string.hotel4_type, "http://filipa18.com/"));
        items.add(new Item(R.string.hotel5_name,R.string.hotel5_description,
                R.drawable.mercure,R.string.hotel5_location,R.string.hotel5_type,
                "http://www.mercure.com/gb/hotel-9627-mercure-krakow-stare-miasto/index.shtml"));
        items.add(new Item(R.string.hotel6_name,R.string.hotel6_description,
                R.drawable.bonerowski,R.string.hotel6_location,R.string.hotel6_type, "http://www.palacbonerowski.com/"));
        items.add(new Item(R.string.hotel7_name,R.string.hotel7_description,
                R.drawable.puro,R.string.hotel7_location,R.string.hotel7_type, "http://purohotel.pl/en/krakow"));
        items.add(new Item(R.string.hotel8_name,R.string.hotel8_description,
                R.drawable.stary,R.string.hotel8_location,R.string.hotel8_type, "https://stary.hotel.com.pl/en/"));
        items.add(new Item(R.string.hotel9_name,R.string.hotel9_description,
                R.drawable.grodek,R.string.hotel9_location,R.string.hotel9_type, "http://hotelgrodek.com/"));
        items.add(new Item(R.string.hotel10_name,R.string.hotel10_description,
                R.drawable.qhotel,R.string.hotel10_location,R.string.hotel10_type, "http://www.qhotels.pl/en/krakow"));

        // Create an {@link HotelsItemAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        HotelsItemAdapter adapter = new HotelsItemAdapter(getActivity(), items, R.color.category_color);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link HotelsItemAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Item} in the list.
        listView.setAdapter(adapter);

        // Open the url for every Item.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Item item = items.get(position);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(item.getHotelUrl()));
                startActivity(i);
            }
        });

        return rootView;
    }

}
