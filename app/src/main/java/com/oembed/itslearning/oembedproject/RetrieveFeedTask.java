package com.oembed.itslearning.oembedproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.io.InputStream;
import oEmbed.OEmbedFinder;
import oEmbed.OEmbedSource;


class RetrieveFeedTask extends AsyncTask<String, Void,Bitmap[]> {

    Context context;
    RelativeLayout relativeLayout;
    public RetrieveFeedTask(RelativeLayout relativeLayout,Context context) {
        this.relativeLayout = relativeLayout;
        this.context=context;
    }

    protected Bitmap[] doInBackground(String... urls) {
        Bitmap mIcon11[] = new Bitmap[urls.length];
        String thumbnail=null;
        OEmbedSource dataSource=null;
        try {
            for(int urlIndex=0;urlIndex<urls.length;urlIndex++)
            {
                dataSource = OEmbedFinder.lookup(urls[urlIndex]);
                thumbnail = dataSource.getThumbnail();
                InputStream in = new java.net.URL(thumbnail).openStream();
                mIcon11[urlIndex] = BitmapFactory.decodeStream(in);
            }
           // OEmbedSource dataSource = OEmbedFinder.lookup(urls[0]);
           // OEmbedSource dataSource = OEmbedFinder.lookup("https://www.youtube.com/watch?v=C3peBB9z3P4");
            //OEmbedSource dataSource = OEmbedFinder.lookup("http://www.dailymotion.com/video/x4jlvvz_top-10-celebrity-death-conspiracies_shortfilms");
           // OEmbedSource dataSource = OEmbedFinder.lookup("http://www.funnyordie.com/videos/74/the-landlord-from-will-ferrell-and-adam-ghost-panther-mckay?_cc=__d___&_ccid=f7ee63ba-2d29-4a3f-8a34-ce1c1147b60e");
            //OEmbedSource dataSource = OEmbedFinder.lookup("http://vimeo.com/172387802");
           //OEmbedSource dataSource = OEmbedFinder.lookup("http://vimeo.com/172387802");
           // OEmbedSource dataSource = OEmbedFinder.lookup("http://dotsub.com/view/35fbc2bb-cf88-4956-9e9c-378dfe11e77f");
            //OEmbedSource dataSource = OEmbedFinder.lookup("http://www.collegehumor.com/video/6736895/the-fresh-prince-of-downton-abbey");
            //OEmbedSource dataSource = OEmbedFinder.lookup("http://www.viddler.com/v/1fb54dd4");
            //OEmbedSource dataSource = OEmbedFinder.lookup("http://www.nfb.ca/film/challenger_an_industrial_romance/");
           // OEmbedSource dataSource = OEmbedFinder.lookup("http://www.ustream.tv/towerbridge");

        } catch (Exception e) {
            Log.e("Error3", e.getMessage());
            e.printStackTrace();

        }
         return mIcon11;
    }

    protected void onPostExecute(Bitmap result[]) {

        GridView gridview = (GridView)relativeLayout.findViewById(R.id.gridview);
        Adapter adapter=new ImageAdapter(context,result);
        gridview.setAdapter((ListAdapter) adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"Image: "+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
