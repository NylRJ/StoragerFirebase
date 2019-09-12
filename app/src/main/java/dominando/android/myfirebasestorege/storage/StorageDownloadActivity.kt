package dominando.android.myfirebasestorege.storage

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.squareup.picasso.Picasso
import dominando.android.myfirebasestorege.R
import kotlinx.android.synthetic.main.storage_activity_download.*
import java.util.zip.Inflater

class StorageDownloadActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var imageView: ImageView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.storage_activity_download)

        progressBar = findViewById(R.id.progressBarDownload)

        progressBar.visibility = View.GONE
        imageView = findViewById(R.id.imageViewDownload)
        setUpListener()

    }

    private fun setUpListener() {
        btnDownload.setOnClickListener(this)

    }

    override fun onClick(view: View?) {

        when (view) {

            btnDownload -> {
                download_imagem_1()

            }


            btnRemoverDownload -> {

                Toast.makeText(this, "remover", Toast.LENGTH_LONG).show()
            }


        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_storage_download, menu)

        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.compartilhar -> {
                Toast.makeText(this, "compartilhado", Toast.LENGTH_LONG).show()
            }
            R.id.item_criar_pdf -> {

                Toast.makeText(this, "PDF criado", Toast.LENGTH_LONG).show()
            }
        }

        return super.onOptionsItemSelected(item)


    }


    private fun download_imagem_1() {

        progressBarDownload.visibility = View.VISIBLE



        Picasso.with(this).load("https://firebasestorage.googleapis.com/v0/b/storegefirebaserj.appspot.com/o/imagens%2F8.%20BackTrack%20Silver%20Dragon%20by%20PCbots.png?alt=media&token=c70a4c4c-d7d2-4701-b6ab-c6b0176fb601")
            .into(imageView, object : com.squareup.picasso.Callback {
                override fun onSuccess() {

                    progressBarDownload.visibility = View.GONE



                }

                override fun onError() {
                    progressBarDownload!!.visibility = View.GONE


                }
            })





    }



}
