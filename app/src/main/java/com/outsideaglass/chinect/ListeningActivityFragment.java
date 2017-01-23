package com.outsideaglass.chinect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.lang.reflect.Array;


public class ListeningActivityFragment extends Fragment {

    private String TAG = "Listening Frag";
    private String listeningHackingChineseArticleURL;
    private String fluentUURL;
    private String forvoURL;
    private String listeningHackingChineseURL;
    private Context context;

    public ListeningActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this.getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listening, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);

        Button articleTitle = (Button) linearLayout.findViewById(R.id.listeningHackingChineseArticle);
        Button fluentUButton = (Button) linearLayout.findViewById(R.id.fluentUButton);
        Button forvoButton = (Button) linearLayout.findViewById(R.id.forvoButton);
        Button listeningHackingChineseButton = (Button) linearLayout.findViewById(R.id.listeningHackingChineseButton);
        TextView fluentUTextView = (TextView) linearLayout.findViewById(R.id.fluentUTextView);
        TextView forvoTextView = (TextView) linearLayout.findViewById(R.id.forvoTextView);
        TextView listeningHackingChineseTextView = (TextView) linearLayout.findViewById(R.id.listeningHackingChineseTextView);
        TextView fluentUTitle = (TextView) linearLayout.findViewById(R.id.fluentUTitle);
        TextView forvoTitle = (TextView) linearLayout.findViewById(R.id.forvoTitle);
        TextView listeningHackingChineseTitle = (TextView) linearLayout.findViewById(R.id.listeningHackingChineseTitle);

        String[] word = getResources().getStringArray(R.array.listening_res);
        String[] wordExplanations = getResources().getStringArray(R.array.listening_res_explanations);

        StringBuilder fluentUTVBuilder = new StringBuilder();
        StringBuilder forvoTVBuilder = new StringBuilder();
        StringBuilder listeningHackingChineseTVBuilder = new StringBuilder();

        fluentUTVBuilder.append("\n    " + wordExplanations[0]);
        forvoTVBuilder.append("\n    " + wordExplanations[1]);
        listeningHackingChineseTVBuilder.append("\n    " + wordExplanations[2]);

        fluentUTitle.setText(word[0]);
        forvoTitle.setText(word[1]);
        listeningHackingChineseTitle.setText(word[2]);

        fluentUTextView.setText(fluentUTVBuilder.toString().trim());
        forvoTextView.setText(forvoTVBuilder.toString().trim());
        listeningHackingChineseTextView.setText(listeningHackingChineseTVBuilder.toString().trim());

        listeningHackingChineseArticleURL = "http://www.hackingchinese.com/archive-2/listening/";
        fluentUURL = "https://www.fluentU.com";
        forvoURL = "https://www.forvo.com";
        listeningHackingChineseURL = "http://www.hackingchinese.com";

        articleTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(listeningHackingChineseArticleURL));
                startActivity(intent);
            }
        });
        fluentUButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(fluentUURL));
                startActivity(intent);
            }
        });
        forvoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(forvoURL));
                startActivity(intent);
            }
        });
        listeningHackingChineseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(listeningHackingChineseURL));
                startActivity(intent);
            }
        });

        String articleTitleText = getResources().getString(R.string.listening_article);

        articleTitle.setText(articleTitleText);
        fluentUButton.setText(word[0]);
        forvoButton.setText(word[1]);
        listeningHackingChineseButton.setText(word[2]);

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
