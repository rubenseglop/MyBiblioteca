package com.app.ruben.mybiblioteca.catalogo

import android.content.Context
import android.net.Uri
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.app.ruben.mybiblioteca.R
import com.app.ruben.mybiblioteca.lectores.LectoresReciclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_catalogo_recicler_view.view.*
import kotlinx.android.synthetic.main.fragment_datos.view.*
import java.io.IOException
import java.net.URL
import kotlin.collections.ArrayList


class AdaptadorCatalogo(val items: ArrayList<Libros>, val items2: ArrayList<Lectores>,val context: Context,val pasardni: EditText) : RecyclerView.Adapter<ViewHolder>() {
    // Obtiene el número de datos


    override fun getItemCount(): Int {
        return items.size
    }

    //infla el layout activity_datos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.fragment_datos,
                parent,
                false
            )
        )

//////

    }
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder?.tvDatosA?.text = items.get(position).titulo
        holder?.tvDatosB?.text = items.get(position).autor
        holder?.tvDatosC?.text = items.get(position).editorial

        holder?.ivDatos?.loadUrl(items.get(position).foto)

        holder?.itemView?.setOnClickListener({

            var idAlquiler = items.get(position).idLibro // devuelve la id del libro

            if (compruebalector()==true) {

            val url = "http://iesayala.ddns.net/BDSegura/insertarprestamo.php/?idLector=" + pasardni.text.toString() + "&idLibro=" + items.get(position).idLibro

            Log.d("RESULTADO", url )

            leerUrl(url)

            Toast.makeText(context,  "Libro prestado", Toast.LENGTH_SHORT).show()} else {
                Toast.makeText(context,  "El cliente " +pasardni.text.toString() + " no existe", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun compruebalector(): Boolean {
        val resultado: Boolean = false

        for (i in 0..items2.size-1) {
            Log.d("RESULTADO" , i.toString())
            Log.d("RESULTADO" , items2.get(i).dnilector)
            if (items2.get(i).dnilector.equals(pasardni.text.toString())) {
                Log.d("RESPUESTA", "es true")
                return true
            }
        }
        Log.d("RESPUESTA", "es false")
        return false
    }

    private fun leerUrl(urlString:String): String{

        val response = try {
            URL(urlString)
                .openStream()
                .bufferedReader()
                .use { it.readText() }
        } catch (e: IOException) {
            "Error with ${e.message}."
        }

        return response
    }
    fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)

    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Mantiene el TextView
    val tvDatosA = view.textViewTitulo
    val tvDatosB = view.textViewAutor
    val tvDatosC = view.textViewEditorial
    val ivDatos= view.ivPortada
    val idLector= view.dniprestamo

}


