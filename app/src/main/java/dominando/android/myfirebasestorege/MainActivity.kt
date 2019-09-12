package dominando.android.myfirebasestorege

import android.Manifest
import android.content.Intent

import android.content.pm.PackageManager
import android.os.Bundle

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.mac.firebasecursods.kotlin.util.Permissao
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dominando.android.myauth.login.BaseActivity
import dominando.android.myfirebasestorege.storage.StorageDownloadActivity
import kotlinx.android.synthetic.main.activity_email_password.*
import kotlinx.android.synthetic.main.activity_email_password.detail
import kotlinx.android.synthetic.main.activity_email_password.status
import kotlinx.android.synthetic.main.activity_email_password.verifyEmailButton
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var auth: FirebaseAuth
    private var cardView_Storage_Download: CardView? = null
    private var cardView_Storage_Upload: CardView? = null
    private var cardView_Database_LerDados: CardView? = null
    private var cardView_Database_GravarAlterarExcluir: CardView? = null
    private var cardView_Empresa: CardView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardView_Storage_Download = findViewById<View>(R.id.cardView_Storage_Download) as CardView
        cardView_Storage_Upload = findViewById<View>(R.id.cardView_Storage_Upload) as CardView
        cardView_Database_LerDados = findViewById<View>(R.id.cardView_Database_LerDados) as CardView
        cardView_Database_GravarAlterarExcluir =
            findViewById<View>(R.id.cardView_Database_GravarAlterarExcluir) as CardView
        cardView_Empresa = findViewById<View>(R.id.cardView_Empresas) as CardView




        cardView_Storage_Download!!.setOnClickListener(this)
        cardView_Storage_Upload!!.setOnClickListener(this)
        cardView_Database_LerDados!!.setOnClickListener(this)
        cardView_Database_GravarAlterarExcluir!!.setOnClickListener(this)
        cardView_Empresa!!.setOnClickListener(this)
        mSignOutButton.setOnClickListener(this)


        auth =FirebaseAuth.getInstance()



        //permissao()

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }
    private fun signOut() {
        auth.signOut()
        updateUI(null)
    }


    //------------------------------------------TRATAMENTO DE CLICKS-------------------------------------------------
    override fun onClick(v: View) {


        when (v.id) {

            R.id.mSignOutButton -> signOut()



            R.id.cardView_Storage_Download -> {

                val intent = Intent(baseContext, StorageDownloadActivity::class.java)

                startActivity(intent)
            }

            R.id.cardView_Storage_Upload ->{}


//                startActivity(Intent(baseContext, StorageUploadActivity::class.java))

            R.id.cardView_Database_LerDados ->{}

//                startActivity(Intent(baseContext, DatabaseLerDadosActivity::class.java))

            R.id.cardView_Database_GravarAlterarExcluir ->{}


//                startActivity(Intent(baseContext, DatabaseGravarAlterarRemoverActivity::class.java))

            R.id.cardView_Empresas ->{}

//                startActivity(Intent(baseContext, DatabaseListaEmpresaActivity::class.java))
        }//ir para activity de download

    }


    //------------------------------------------PERMISSAO DO USUARIO-------------------------------------------------


    private fun permissao() {


        val permissoes = arrayOf(

            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
        )


        Permissao.permissao(this, 0, permissoes)

    }
    private fun updateUI(user: FirebaseUser?) {

        if (user != null) {
            status.text = getString(R.string.emailpassword_status_fmt,
                user.email, user.isEmailVerified)
            detail.text = getString(R.string.firebase_status_fmt, user.uid)

            //user.uid
            //firebadeDatabase("user/${user.uid}").setValue()

//            emailPasswordButtons.visibility = View.GONE
//            emailPasswordFields.visibility = View.GONE
//            signedInButtons.visibility = View.VISIBLE

            verifyEmailButton.isEnabled = !user.isEmailVerified
        } else {
            status.setText(R.string.signed_out)
            detail.text = null
            val intent = Intent(this,EmailPasswordActivity::class.java)
            startActivity(intent)
//            emailPasswordButtons.visibility = View.VISIBLE
//            emailPasswordFields.visibility = View.VISIBLE
//            signedInButtons.visibility = View.GONE
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)


        for (result in grantResults) {

            if (result == PackageManager.PERMISSION_DENIED) {

                Toast.makeText(
                    this,
                    "Aceite as permissões para o aplicativo funcionar corretamente",
                    Toast.LENGTH_LONG
                ).show()
                finish()

                break
            }

        }


    }
}

