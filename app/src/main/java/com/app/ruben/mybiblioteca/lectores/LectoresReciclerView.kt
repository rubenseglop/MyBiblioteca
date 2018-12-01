package com.app.ruben.mybiblioteca.lectores

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.ruben.mybiblioteca.R
import com.google.gson.Gson
import java.io.IOException
import java.net.URL
import kotlinx.android.synthetic.main.fragment_lectores_recicler_view.*




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
class LectoresReciclerView : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null



    var datos: ArrayList<Lectores> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        print("RESULTADO oncreate")

        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        print("RESULTADO oncreateview")
        return inflater.inflate(R.layout.fragment_lectores_recicler_view, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        URLJsonObjeto()
        recyclerViewFragment.layoutManager = LinearLayoutManager(context)
        recyclerViewFragment.layoutManager = GridLayoutManager(context,1)
        recyclerViewFragment.adapter= AdaptadorLectores(datos, context!!)

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
            LectoresReciclerView().apply {
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
        Log.d("RESULTADO", "URL TO JSON 3")


        val gson = Gson()
        Log.d("RESULTADO", "val gson")

        try {
            Log.d("RESULTADO", "try")
            val json = leerUrl("http://iesayala.ddns.net/BDSegura/lectores.php")
            //Log.d("RESULTADO", json)

            val lector = gson.fromJson(json, ArrayLectores::class.java)
            Log.d("RESULTADO", lector.toString())

            for (item in lector
                .lectores!!.iterator()) {
                //Log.d("RESULTADO",  item.apellidos)

                var lector: Lectores =
                    Lectores(item.dnilector, item.nombre, item.apellidos, item.direccion, item.telefono)
                datos.add(lector)
            }
        }

        catch (e: Exception){
            Log.d("RESULTADO", "error 2")
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
}