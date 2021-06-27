package com.gyde.mylibrary.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.gyde.mylibrary.R
import com.gyde.mylibrary.network.response.walkthroughlist.HelpArticle
import kotlinx.android.synthetic.main.activity_help_article_details.*

internal class HelpArticleDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_article_details)

        getIntentData()
        img_back.setOnClickListener {
            this@HelpArticleDetailsActivity.finish()
        }
    }

    private fun getIntentData() {
        val helpArticleJson = intent.getStringExtra("helpArticleJson")
        val helpArticle = Gson().fromJson(helpArticleJson, HelpArticle::class.java)

        tv_title.text = helpArticle.question
        web_view.loadUrl(helpArticle.urlForMobileWebView)
    }
}