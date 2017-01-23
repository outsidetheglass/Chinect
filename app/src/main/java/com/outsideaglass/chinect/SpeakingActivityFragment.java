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


public class SpeakingActivityFragment extends Fragment {

    private String TAG = "Speaking Frag";
    private String speakingHackingChineseArticleURL;
    private String italkiURL;
    private String pimsleurURL;
    private String meetupURL;
    private Context context;

    public SpeakingActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this.getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_speaking, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);

        Button articleTitle = (Button) linearLayout.findViewById(R.id.speakingHackingChineseArticle);

        Button italkiButton = (Button) linearLayout.findViewById(R.id.italkiButton);
        Button pimsleurButton = (Button) linearLayout.findViewById(R.id.pimsleurButton);
        Button meetupButton = (Button) linearLayout.findViewById(R.id.meetupButton);

        TextView italkiTextView = (TextView) linearLayout.findViewById(R.id.italkiTextView);
        TextView pimsleurTextView = (TextView) linearLayout.findViewById(R.id.pimsleurTextView);
        TextView meetupTextView = (TextView) linearLayout.findViewById(R.id.meetupTextView);

        TextView italkiTitle = (TextView) linearLayout.findViewById(R.id.italkiTitle);
        TextView pimsleurTitle = (TextView) linearLayout.findViewById(R.id.pimsleurTitle);
        TextView meetupTitle = (TextView) linearLayout.findViewById(R.id.meetupTitle);

        String[] word = getResources().getStringArray(R.array.speaking_res);
        String[] wordExplanations = getResources().getStringArray(R.array.speaking_res_explanations);

        StringBuilder italkiTVBuilder = new StringBuilder();
        StringBuilder pimsleurTVBuilder = new StringBuilder();
        StringBuilder meetupTVBuilder = new StringBuilder();

        italkiTVBuilder.append("\n    " + wordExplanations[0]);
        pimsleurTVBuilder.append("\n    " + wordExplanations[1]);
        meetupTVBuilder.append("\n    " + wordExplanations[2]);

        italkiTitle.setText(word[0]);
        pimsleurTitle.setText(word[1]);
        meetupTitle.setText(word[2]);

        italkiTextView.setText(italkiTVBuilder.toString().trim());
        pimsleurTextView.setText(pimsleurTVBuilder.toString().trim());
        meetupTextView.setText(meetupTVBuilder.toString().trim());

        italkiURL = "https://www.italki.com/partners";
        pimsleurURL = "https://www.pimsleur.com";
        meetupURL = "https://www.meetup.com/find/events/?allMeetups=false&keywords=chinese";
        speakingHackingChineseArticleURL = "http://www.hackingchinese.com/archive-2/speaking/";

        articleTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(speakingHackingChineseArticleURL));
                startActivity(intent);
            }
        });
        italkiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(italkiURL));
                startActivity(intent);
            }
        });
        pimsleurButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(pimsleurURL));
                startActivity(intent);
            }
        });
        meetupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(meetupURL));
                startActivity(intent);
            }
        });

        String articleTitleText = getResources().getString(R.string.speaking_article);

        articleTitle.setText(articleTitleText);
        italkiButton.setText(word[0]);
        pimsleurButton.setText(word[1]);
        meetupButton.setText(word[2]);

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
