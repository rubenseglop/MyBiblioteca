package com.app.ruben.mybiblioteca.prestamo

import android.content.Context
import android.graphics.*
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.app.ruben.mybiblioteca.R
import com.app.ruben.mybiblioteca.catalogo.CatalogoLibros
import com.app.ruben.mybiblioteca.prestamo.ArrayLectores
import com.app.ruben.mybiblioteca.prestamo.Lectores
import com.app.ruben.mybiblioteca.prestamo.Libros
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import java.io.IOException
import java.net.URL
import kotlinx.android.synthetic.main.fragment_prestamos_recicler_view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CatalogoReciclerView.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CatalogoReciclerView.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class PrestamoReciclerView : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private var adaptera : AdaptadorPrestamos?=null
    private val p = Paint()

    var datos: ArrayList<Libros> = ArrayList()
    var datos2: ArrayList<Lectores> = ArrayList()
    var datos3: ArrayList<Prestados> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
//        Log.d("RESULTADO", "Libros")
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prestamos_recicler_view, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        URLJsonObjeto()
        URLJsonObjetoLectores()
        URLJsonObjetoPrestados()



        recyclerViewFragment.layoutManager = LinearLayoutManager(context)
        recyclerViewFragment.layoutManager = GridLayoutManager(context,1)
        //recyclerViewFragment.adapter= AdaptadorPrestamos(datos, datos2, datos3, context!!)

        adaptera = AdaptadorPrestamos(datos, datos2, datos3, context!!)
        recyclerViewFragment.adapter = adaptera
        initSwipe()


    }
    // TODO: Rename method, update argument and hook method into UI event


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RecyclerFragmentEquipos.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PrestamoReciclerView().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }




    fun URLJsonObjeto() {
        val gson = Gson()
        try {
            val json = leerUrl("http://iesayala.ddns.net/BDSegura/biblio.php")
            val libros = gson.fromJson(json, CatalogoLibros::class.java)

            for (item in libros.biblioteca!!.iterator()) {
                /*  Log.d("RESULTADO->>>", item.idLibro.toString())
                  Log.d("RESULTADO", item.foto)
                  Log.d("RESULTADO", item.titulo)
                  Log.d("RESULTADO", item.autor)
                  Log.d("RESULTADO", item.editorial)*/

                var libros: Libros =
                    Libros(item.idLibro, item.foto, item.titulo, item.autor, item.editorial)
                datos.add(libros)
            }}
        catch (e: Exception){
            Log.d("RESULTADO", "error")
        }
    }

    fun URLJsonObjetoLectores() {
        val gson = Gson()
        try {
            val json = leerUrl("http://iesayala.ddns.net/BDSegura/lectores.php")


            val lector = gson.fromJson(json, ArrayLectores::class.java)
//            Log.d("RESULTADO", lector.toString())

            for (item in lector
                .lectores!!.iterator()) {
//                Log.d("RESULTADO",  item.apellidos)

                var lector: Lectores =
                    Lectores(item.dnilector, item.nombre, item.apellidos, item.direccion, item.telefono)
                datos2.add(lector)

            }}
        catch (e: Exception){
            Log.d("RESULTADO", "error")
        }
    }
    fun URLJsonObjetoPrestados() {
        val gson = Gson()
        try {
            val json = leerUrl("http://iesayala.ddns.net/BDSegura/prestados.php")


            val lector = gson.fromJson(json, ArrayPrestados::class.java)
//            Log.d("RESULTADO", lector.toString())

            for (item in lector
                .prestados!!.iterator()) {
//                Log.d("RESULTADO",  item.apellidos)

                var pres: Prestados =
                    Prestados(item.idAlquiler, item.IdLector, item.idLibro)
                datos3.add(pres)

            }}
        catch (e: Exception){
            Log.d("RESULTADO", "error")
        }
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

    /////////////////

    private fun initSwipe() {
        val simpleItemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition

                if (direction == ItemTouchHelper.LEFT) {
                    adaptera!!.removeItem(position)
                } else {

                    adaptera!!.removeItem(position)

                }
            }
            private fun removeView() {
                if (view!!.parent != null) {
                    (view!!.parent as ViewGroup).removeView(view)
                }
            }
/*


*/

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {

                val icon: Bitmap
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

                    val itemView = viewHolder.itemView
                    val height = itemView.bottom.toFloat() - itemView.top.toFloat()
                    val width = height / 3

                    if (dX > 0) {
                        p.color = Color.parseColor("#388E3C")
                        val background = RectF(itemView.left.toFloat(), itemView.top.toFloat(), dX, itemView.bottom.toFloat())
                        c.drawRect(background, p)
                        //icon = BitmapFactory.decodeResource(resources, R.drawable.ic_edit_white)
                        //val icon_dest = RectF(itemView.left.toFloat() + width, itemView.top.toFloat() + width, itemView.left.toFloat() + 2 * width, itemView.bottom.toFloat() - width)
                        //c.drawBitmap(icon, null, icon_dest, p)
                    } else {
                        p.color = Color.parseColor("#388E3C")
                        val background = RectF(itemView.right.toFloat() + dX, itemView.top.toFloat(), itemView.right.toFloat(), itemView.bottom.toFloat())
                        c.drawRect(background, p)
                        //icon = BitmapFactory.decodeResource(resources, R.drawable.chico)
                        //val icon_dest = RectF(itemView.right.toFloat() - 2 * width, itemView.top.toFloat() + width, itemView.right.toFloat() - width, itemView.bottom.toFloat() - width)
                        //c.drawBitmap(icon, null, icon_dest, p)
                    }
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }
        }
        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(recyclerViewFragment)
    }






}

