package com.example.mac.firebasecursods.kotlin.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast

object Util {


    fun statusInternet(context: Context): Boolean {

        val conexao = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


        val informacao = conexao.activeNetworkInfo

        return if (informacao != null && informacao.isConnected) {

            true

        } else {

            false
        }
    }


    fun verificarCampos(context: Context, texto_1: String, texto_2: String): Boolean {


        if (!texto_1.isEmpty() && !texto_2.isEmpty()) {

            if (statusInternet(context)) {

                return true

            } else {

                Toast.makeText(context, "Sem conexão com a Internet", Toast.LENGTH_LONG).show()

                return false
            }

        } else {

            Toast.makeText(context, "Preencha os campos", Toast.LENGTH_LONG).show()
            return false
        }


    }


}
