package com.example.etest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] numWord;
    private  int[] numImage;

    public MainAdapter(Context c, String[] numWord, int[] numImage)
    {
        context = c;
        this.numWord = numWord;
        this.numImage = numImage;
    }

    @Override
    public int getCount() {
        return numWord.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.cat_item_layout, null);
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),TestActivity.class);
                intent.putExtra("CAT_INDEX",position);
                intent.putExtra("SAMPLE TITLE",numWord);
                v.getContext().startActivity(intent);
            }
        });
        ImageView imageView = convertView.findViewById(R.id.image);
        TextView textView = convertView.findViewById(R.id.catName);

        imageView.setImageResource(numImage[position]);
        textView.setText(numWord[position]);
        return convertView;
    }
}
