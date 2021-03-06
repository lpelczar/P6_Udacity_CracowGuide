package pl.lukaszpelczar.cracowguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link EssentialsItemAdapter} is an {@link ArrayAdapter} that can provide the layout for each list * item based on a data source, which is a list of {@link Item} objects.
 */
public class EssentialsItemAdapter extends ArrayAdapter<Item> {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link EssentialsItemAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param items is the list of {@link Item}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public EssentialsItemAdapter(Context context, ArrayList<Item> items, int colorResourceId) {
        super(context, 0, items);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.essentials_item, parent, false);
        }

        // Get the {@link Item} object located at this position in the list
        Item currentItem = getItem(position);

        //Find the TextView in the xml file and set the text to wanted string.
        TextView essentialsNameTextView = (TextView) listItemView.findViewById(R.id.essentials_name_text_view);
        essentialsNameTextView.setText(currentItem.getEssentialsNameId());

        TextView essentialsDescriptionTextView = (TextView) listItemView.findViewById(R.id.essentials_description_text_view);
        essentialsDescriptionTextView.setText(currentItem.getEssentialsDescriptionId());

        TextView essentialsTypeTextView = (TextView) listItemView.findViewById(R.id.essentials_type_text_view);
        essentialsTypeTextView.setText(currentItem.getEssentialsTypeId());

        // Find the ImageView in the xml file.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.essentials_image);
        // Check if an image is provided for this item or not
        if (currentItem.essentialsHasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentItem.getEssentialsImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout so that it can be shown in the ListView.
        return listItemView;
    }
}
