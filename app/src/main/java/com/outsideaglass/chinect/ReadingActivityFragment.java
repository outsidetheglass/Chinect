package com.outsideaglass.chinect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ReadingActivityFragment extends Fragment {

    private String TAG = "Reading Frag";
    private String favBookURL;
    private String chairmansBaoURL;
    private String readingHackingChineseArticleURL;
    private Context context;


    public ReadingActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this.getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_reading, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);


        Button articleTitle = (Button) linearLayout.findViewById(R.id.readingHackingChineseArticle);

        Button duChineseButton = (Button) linearLayout.findViewById(R.id.duChineseButton);
        Button favBookButton = (Button) linearLayout.findViewById(R.id.favBookButton);
        Button chairmansBaoButton = (Button) linearLayout.findViewById(R.id.chairmansBaoButton);

        TextView duChineseTextView = (TextView) linearLayout.findViewById(R.id.duChineseTextView);
        TextView favBookTextView = (TextView) linearLayout.findViewById(R.id.favBookTextView);
        TextView chairmansBaoTextView = (TextView) linearLayout.findViewById(R.id.chairmansBaoTextView);

        TextView duChineseTitle = (TextView) linearLayout.findViewById(R.id.duChineseTitle);
        TextView favBookTitle = (TextView) linearLayout.findViewById(R.id.favBookTitle);
        TextView chairmansBaoTitle = (TextView) linearLayout.findViewById(R.id.chairmansBaoTitle);

        String[] word = getResources().getStringArray(R.array.reading_res);
        String[] wordExplanations = getResources().getStringArray(R.array.reading_res_explanations);

        StringBuilder duChineseTVBuilder = new StringBuilder();
        StringBuilder favBookTVBuilder = new StringBuilder();
        StringBuilder chairmansBaoTVBuilder = new StringBuilder();

        duChineseTVBuilder.append("\n    " + wordExplanations[0]);
        favBookTVBuilder.append("\n    " + wordExplanations[1]);
        chairmansBaoTVBuilder.append("\n    " + wordExplanations[2]);

        duChineseTitle.setText(word[0]);
        favBookTitle.setText(word[1]);
        chairmansBaoTitle.setText(word[2]);

        duChineseTextView.setText(duChineseTVBuilder.toString().trim());
        favBookTextView.setText(favBookTVBuilder.toString().trim());
        chairmansBaoTextView.setText(chairmansBaoTVBuilder.toString().trim());

        readingHackingChineseArticleURL = "http://www.hackingchinese.com/archive-2/reading/";
        favBookURL = "https://www.amazon.com/Harry-Potter-Philosophers-Simplified-Chinese/dp/7020033431/ref=sr_1_1?ie=UTF8&qid=1482479155&sr=8-1&keywords=harry+potter+mandarin+chinese";
        chairmansBaoURL = "http://www.thechairmansbao.com/";

        articleTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(readingHackingChineseArticleURL));
                startActivity(intent);
            }
        });
        duChineseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openApplication("org.sinamon.duchinese");
            }
        });
        favBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(favBookURL));
                startActivity(intent);
            }
        });
        chairmansBaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openApplication("com.chairmansBao.chinesesystem");

            }
        });

        String articleTitleText = getResources().getString(R.string.reading_article);

        articleTitle.setText(articleTitleText);
        duChineseButton.setText(word[0]);
        favBookButton.setText(word[1]);
        chairmansBaoButton.setText(word[2]);
        
        return view;
    }

    public void openApplication(String packageN) {
        Intent i = context.getPackageManager().getLaunchIntentForPackage(packageN);
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageN)));
        }
        catch (android.content.ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + packageN)));
        }

    }
}
