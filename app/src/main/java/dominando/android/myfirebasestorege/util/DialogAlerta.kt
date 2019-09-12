package dominando.android.myfirebasestorege.util

import android.annotation.SuppressLint
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import dominando.android.myfirebasestorege.R


@SuppressLint("ValidFragment")
class DialogAlerta @SuppressLint("ValidFragment")
constructor(private val title: String, private val msg: String) : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)


        val view = inflater.inflate(R.layout.dialog_alerta, container)
        val title = view.findViewById<View>(R.id.textView_DialogAlerta_Title) as TextView
        val msg = view.findViewById<View>(R.id.textView_DialogAlerta_MSG) as TextView
        val button = view.findViewById<View>(R.id.button_DialogAlerta_OK) as Button
        retainInstance = true


        title.text = this.title
        msg.text = this.msg

        button.setOnClickListener { dismiss() }

        return view

    }


}
