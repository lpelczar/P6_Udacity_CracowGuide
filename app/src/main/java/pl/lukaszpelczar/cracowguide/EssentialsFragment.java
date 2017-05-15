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

public class EssentialsFragment extends Fragment {

    public EssentialsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Create a list of essentials
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.string.essentials1_name,R.string.essentials1_description,
                R.string.essentials1_type,R.drawable.main_square,
                "https://en.wikipedia.org/wiki/Main_Square,_Krak%C3%B3w"));
        items.add(new Item(R.string.essentials2_name,R.string.essentials2_description,
                R.string.essentials2_type,R.drawable.wawel,
                "https://en.wikipedia.org/wiki/Wawel_Castle"));
        items.add(new Item(R.string.essentials3_name,R.string.essentials3_description,
                R.string.essentials3_type,R.drawable.basilica,
                "https://en.wikipedia.org/wiki/St._Mary%27s_Basilica,_Krak%C3%B3w"));
        items.add(new Item(R.string.essentials4_name,R.string.essentials4_description,
                R.string.essentials4_type,R.drawable.salt,
                "https://en.wikipedia.org/wiki/Wieliczka_Salt_Mine"));
        items.add(new Item(R.string.essentials5_name,R.string.essentials5_description,
                R.string.essentials5_type,R.drawable.cloth,
                "https://en.wikipedia.org/wiki/Krak%C3%B3w_Cloth_Hall"));
        items.add(new Item(R.string.essentials6_name,R.string.essentials6_description,
                R.string.essentials6_type,R.drawable.cathedral,
                "https://en.wikipedia.org/wiki/Wawel_Cathedral"));
        items.add(new Item(R.string.essentials7_name,R.string.essentials7_description,
                R.string.essentials7_type,R.drawable.collegium,
                "https://en.wikipedia.org/wiki/Collegium_Maius"));
        items.add(new Item(R.string.essentials8_name,R.string.essentials8_description,
                R.string.essentials8_type,R.drawable.barbican,
                "https://en.wikipedia.org/wiki/Krak%C3%B3w_Barbican"));
        items.add(new Item(R.string.essentials9_name,R.string.essentials9_description,
                R.string.essentials9_type,R.drawable.planty,
                "https://en.wikipedia.org/wiki/Planty_Park"));
        items.add(new Item(R.string.essentials10_name,R.string.essentials10_description,
                R.string.essentials10_type,R.drawable.aviation,
                "https://en.wikipedia.org/wiki/Polish_Aviation_Museum"));

        // Create an {@link EssentialsItemAdapter}, whose data source is a list of {@link Item}s.
        // The adapter knows how to create list items for each item in the list.
        EssentialsItemAdapter adapter = new EssentialsItemAdapter(getActivity(), items, R.color.category_color);

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
                i.setData(Uri.parse(item.getEssentialsUrl()));
                startActivity(i);
            }
        });

        return rootView;
    }

}
