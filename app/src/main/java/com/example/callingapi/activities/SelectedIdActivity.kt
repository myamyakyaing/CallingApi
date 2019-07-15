package com.example.callingapi.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.callingapi.R
import kotlinx.android.synthetic.main.activity_selected_id.*

class SelectedIdActivity : AppCompatActivity() {

    companion object {
        var USER_ID = "userId"
        var POST_ID = "id"
        var POST_TITLE = "title"
        var  POST_BODY= "body"

        fun newActivity(
            context: Context,
            userId: Int? = null,
            id: Int? = null,
            title: String? = null,
            body: String? = null
        ): Intent {
            val intent = Intent(context, SelectedIdActivity::class.java)
            intent.putExtra(USER_ID, userId)
            intent.putExtra(POST_ID, id)
            intent.putExtra(POST_TITLE, title)
            intent.putExtra(POST_BODY, body)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_id)
        textUserId.text = intent.getIntExtra(USER_ID,0).toString()
        textId.text = intent.getIntExtra(POST_ID, 0).toString()
        txtTitle.text = intent.getStringExtra(POST_TITLE)
        textbody.text = intent.getStringExtra(POST_BODY)
    }

}
