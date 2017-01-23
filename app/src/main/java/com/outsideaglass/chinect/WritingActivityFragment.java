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


public class WritingActivityFragment extends Fragment {

    private String TAG = "Writing Frag";
    private String lang8URL;
    private String writingHackingChineseArticleURL;
    private Context context;


    public WritingActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this.getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_writing, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);


        Button articleTitle = (Button) linearLayout.findViewById(R.id.writingHackingChineseArticle);

        Button skritterButton = (Button) linearLayout.findViewById(R.id.skritterButton);
        Button lang8Button = (Button) linearLayout.findViewById(R.id.lang8Button);
        Button plecoButton = (Button) linearLayout.findViewById(R.id.plecoButton);

        TextView skritterTextView = (TextView) linearLayout.findViewById(R.id.skritterTextView);
        TextView lang8TextView = (TextView) linearLayout.findViewById(R.id.lang8TextView);
        TextView plecoTextView = (TextView) linearLayout.findViewById(R.id.plecoTextView);

        TextView skritterTitle = (TextView) linearLayout.findViewById(R.id.skritterTitle);
        TextView lang8Title = (TextView) linearLayout.findViewById(R.id.lang8Title);
        TextView plecoTitle = (TextView) linearLayout.findViewById(R.id.plecoTitle);

        String[] word = getResources().getStringArray(R.array.writing_res);
        String[] wordExplanations = getResources().getStringArray(R.array.writing_res_explanations);

        StringBuilder skritterTVBuilder = new StringBuilder();
        StringBuilder lang8TVBuilder = new StringBuilder();
        StringBuilder plecoTVBuilder = new StringBuilder();

        skritterTVBuilder.append("\n    " + wordExplanations[0]);
        lang8TVBuilder.append("\n    " + wordExplanations[1]);
        plecoTVBuilder.append("\n    " + wordExplanations[2]);

        skritterTitle.setText(word[0]);
        lang8Title.setText(word[1]);
        plecoTitle.setText(word[2]);

        skritterTextView.setText(skritterTVBuilder.toString().trim());
        lang8TextView.setText(lang8TVBuilder.toString().trim());
        plecoTextView.setText(plecoTVBuilder.toString().trim());

        writingHackingChineseArticleURL = "http://www.hackingchinese.com/archive-2/writing/";
        lang8URL = "http://lang-8.com/";

        articleTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(writingHackingChineseArticleURL));
                startActivity(intent);
            }
        });
        skritterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openApplication("com.inkren.skritter.chinese");
            }
        });
        lang8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(lang8URL));
                startActivity(intent);
            }
        });
        plecoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openApplication("com.pleco.chinesesystem");

            }
        });

        String articleTitleText = getResources().getString(R.string.writing_article);

        articleTitle.setText(articleTitleText);
        skritterButton.setText(word[0]);
        lang8Button.setText(word[1]);
        plecoButton.setText(word[2]);

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
