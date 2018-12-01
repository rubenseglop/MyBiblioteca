package com.app.ruben.mybiblioteca.prestamo

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.app.ruben.mybiblioteca.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_datos.view.*
import kotlinx.android.synthetic.main.fragment_datos_prestamos.view.*
import java.io.IOException
import java.net.URL

class AdaptadorPrestamos(val items: ArrayList<Libros>, val items2: ArrayList<Lectores>, val items3: ArrayList<Prestados>,val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    // Obtiene el número de datos

    override fun getItemCount(): Int {
        return items3.size
    }

    //infla el layout activity_datos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.fragment_datos_prestamos,
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

        println("RESULTADO" + position)

        val milector = items3.get(position).IdLector
        val milibro = items3.get(position).idLibro
        val mialquiler = items3.get(position).idAlquiler

        holder?.tvDatosA?.text = items2.get(milector.toInt()).dnilector
        holder?.tvDatosB?.text = items2.get(milector.toInt()).nombre
        holder?.tvDatosC?.text = items2.get(milector.toInt()).apellidos
        holder?.tvDatosD?.text =  items.get(milibro.toInt()).titulo

        holder?.ivDatos?.loadUrl(items.get(milibro?.toInt()).foto)
        holder?.itemView?.setOnClickListener({
            var idAlquiler = items3.get(position).idAlquiler // devuelve la id del alquiler
                Toast.makeText(context,  idAlquiler.toString(), Toast.LENGTH_SHORT).show()

        })
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

    fun removeItem(position: Int) {
        val response = try {
            println("RESULTADO - z " +"http://iesayala.ddns.net/BDSegura/eliminaprestado.php/?idAlquiler="+items3.get(position).idAlquiler)
            URL("http://iesayala.ddns.net/BDSegura/eliminaprestado.php/?idAlquiler="+items3.get(position).idAlquiler)
                .openStream()
                .bufferedReader()
                .use { it.readText() }
        } catch (e: IOException) {
            "Error with ${e.message}."
        }
        items3.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, items3.size)

    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Mantiene el TextView
    val tvDatosA = view.textViewDNI
    val tvDatosB = view.textViewNombre
    val tvDatosC = view.textViewApellidos
    val ivDatos= view.ivPortada2
    val tvDatosD = view.textViewTitulo2


}