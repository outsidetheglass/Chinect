package com.outsideaglass.chinect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class VocabActivityFragment extends Fragment {

    private String TAG = "Vocab Frag";
    private String vocabHackingChineseURL;
    private String vocabHackingChineseArticleURL;
    private Context context;

    public VocabActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this.getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_vocab, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);

        Button articleTitle = (Button) linearLayout.findViewById(R.id.vocabHackingChineseArticle);

        Button ankiButton = (Button) linearLayout.findViewById(R.id.ankiButton);
        Button plecoButton = (Button) linearLayout.findViewById(R.id.plecoButton);
        Button vocabHackingChineseButton = (Button) linearLayout.findViewById(R.id.vocabHackingChineseButton);

        TextView ankiTextView = (TextView) linearLayout.findViewById(R.id.ankiTextView);
        TextView plecoTextView = (TextView) linearLayout.findViewById(R.id.plecoTextView);
        TextView vocabHackingChineseTextView = (TextView) linearLayout.findViewById(R.id.vocabHackingChineseTextView);

        TextView ankiTitle = (TextView) linearLayout.findViewById(R.id.ankiTitle);
        TextView plecoTitle = (TextView) linearLayout.findViewById(R.id.plecoTitle);
        TextView vocabHackingChineseTitle = (TextView) linearLayout.findViewById(R.id.vocabHackingChineseTitle);

        String[] word = getResources().getStringArray(R.array.vocab_res);
        String[] wordExplanations = getResources().getStringArray(R.array.vocab_res_explanations);

        StringBuilder ankiTVBuilder = new StringBuilder();
        StringBuilder plecoTVBuilder = new StringBuilder();
        StringBuilder vocabHackingChineseTVBuilder = new StringBuilder();

        ankiTVBuilder.append("\n    " + wordExplanations[0]);
        plecoTVBuilder.append("\n    " + wordExplanations[1]);
        vocabHackingChineseTVBuilder.append("\n    " + wordExplanations[2]);

        ankiTitle.setText(word[0]);
        plecoTitle.setText(word[1]);
        vocabHackingChineseTitle.setText(word[2]);

        ankiTextView.setText(ankiTVBuilder.toString().trim());
        plecoTextView.setText(plecoTVBuilder.toString().trim());
        vocabHackingChineseTextView.setText(vocabHackingChineseTVBuilder.toString().trim());

        vocabHackingChineseArticleURL = "http://www.hackingchinese.com/archive-2/vocabulary/";
        vocabHackingChineseURL = "http://www.hackingchinese.com/archive-2/vocabulary/";

        articleTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(vocabHackingChineseArticleURL));
                startActivity(intent);
            }
        });
        ankiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openApplication("com.ichi2.anki");
            }
        });
        plecoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openApplication("com.pleco.chinesesystem");

            }
        });
        vocabHackingChineseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(vocabHackingChineseURL));
                startActivity(intent);
            }
        });

        String articleTitleText = getResources().getString(R.string.vocab_article);

        articleTitle.setText(articleTitleText);
        ankiButton.setText(word[0]);
        plecoButton.setText(word[1]);
        vocabHackingChineseButton.setText(word[2]);
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
