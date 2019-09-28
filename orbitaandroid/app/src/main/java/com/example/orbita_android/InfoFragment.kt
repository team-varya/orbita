package com.example.orbita_android


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 */
class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val preferences = this.activity?.getSharedPreferences(getString(R.string.user_preference),
            Context.MODE_PRIVATE)
        val view = inflater.inflate(R.layout.fragment_info, container, false)
        val packageCountTextView = view.findViewById<TextView>(R.id.package_count)
        packageCountTextView.text = packageCountTextView.text.toString() +
                preferences!!.getInt(getString(R.string.package_counter), 0)

        val fullCostTextView = view.findViewById<TextView>(R.id.money)
        fullCostTextView.text = fullCostTextView.text.toString() +
                preferences!!.getInt(getString(R.string.pack_cost), 0)

        return view
    }


}
