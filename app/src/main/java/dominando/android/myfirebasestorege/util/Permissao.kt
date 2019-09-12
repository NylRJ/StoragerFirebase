package com.example.mac.firebasecursods.kotlin.util

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


import java.util.ArrayList


object Permissao {


    fun permissao(activity: Activity, requestCode: Int, permissoes: Array<String>): Boolean {

        val list = ArrayList<String>()

        //No nosso for a variavel permissao irá receber de uma em uma as strings do array da variavel permissoes
        for (permissao in permissoes) {

            //caso o usuario NÃO tenha permitido ao aplicativo certos privilegios de acesso
            //a variavel ok recebera false
            val ok = ContextCompat.checkSelfPermission(activity, permissao) == PackageManager.PERMISSION_GRANTED


            if (!ok) {// caso a variavel ok tenha recebido false, então cairá dentro desse if


                // a variavel list irá receber a nossa string do for "que simboliza a permissao que
                // o aplicativo está querendo"
                list.add(permissao)
            }


        }// fim do nosso for - caso a variavel permissoes tenha mais de uma string,o for é executado novamente


        //se a nossa variavel list for vazia quer dizer que o usuario já permitiu que o nosso aplicativo
        //tenha certos privilegios e então entrará dentro no nosso if

        if (list.isEmpty()) {
            return true // caso entre dentro do nosso if o metodo acaba aqui
        }


        // caso a nossa variavel list não for vazia executa esse trecho de código abaixo
        val newPermissions = arrayOfNulls<String>(list.size)
        list.toTypedArray<String>()

        //solicita a permissao
        ActivityCompat.requestPermissions(activity, newPermissions, requestCode)
        return false
    }


}
