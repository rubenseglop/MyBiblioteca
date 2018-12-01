package com.app.ruben.mybiblioteca.lectores

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.app.ruben.mybiblioteca.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_datos2.view.*



class AdaptadorLectores(val items2: ArrayList<Lectores>, val context: Context) : RecyclerView.Adapter<ViewHolderLectores>() {

    // Obtiene el número de datos
    override fun getItemCount(): Int {
        return items2.size
    }

    //infla el layout activity_datos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLectores {

        return ViewHolderLectores(
            LayoutInflater.from(context).inflate(
                R.layout.fragment_datos2,
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

    override fun onBindViewHolder(holder: ViewHolderLectores, position: Int) {
        Log.d("RESULTADO" , items2.get(position).dnilector)
        holder?.tvDatosA?.text = items2.get(position).dnilector

        holder?.tvDatosB?.text = items2.get(position).nombre
        holder?.tvDatosC?.text = items2.get(position).apellidos
        holder?.tvDatosD?.text = items2.get(position).direccion
        holder?.tvDatosE?.text = items2.get(position).telefono


        //holder?.itemView?.setOnClickListener(View.OnClickListener { Toast.makeText(context,  items2.get(position).dnilector, Toast.LENGTH_SHORT).show() })
    }
    fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)
    }
}

class ViewHolderLectores (view: View) : RecyclerView.ViewHolder(view) {
    // Mantiene el TextView
    val tvDatosA = view.textViewDNI
    val tvDatosB = view.textViewNombre
    val tvDatosC = view.textViewApellidos
    val tvDatosD = view.textViewDomicilio
    val tvDatosE = view.textViewTelefono

}


