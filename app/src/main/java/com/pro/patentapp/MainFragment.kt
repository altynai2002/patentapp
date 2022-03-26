package com.pro.patentapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.pro.patentapp.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: OnClick

    private val itemList: Array<String>
        get() = arrayOf(
            "Объекты авторского права",
            "Оъекты смежных прав",
            "Промышленные образцы",
            "Традиционные знания",
            "Товарные знаки и обслуживания",
            "Наименование мест происхождения",
            "Рационализаторские предложения",
            "Топологии интегральных микросхем",
            "Селекционные достижения",
            "Программы для ЭВМ и баз данных",
            "Полезные модели",
            "Изобретения"
        )

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        binding.toolbar.inflateMenu(R.menu.menu)
        binding.toolbar.setOnMenuItemClickListener {

            when (it.itemId) {
                R.id.aboutMenu -> listener.onClickAbout()
                R.id.publications -> listener.onClickPublications()
                R.id.publicServices -> listener.onClickPublicServices()
                R.id.innovations -> listener.onClickInnovations()
                else -> {
                    Toast.makeText(activity, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
        setupGridView()

        binding.search.setOnClickListener {
            listener.onClickSearch()
        }
    }

    private fun setupGridView() {
        val adapter = ImageListAdapter(requireContext(), R.layout.item_recycler, itemList)
        binding.gridview.adapter = adapter

        binding.gridview.onItemClickListener =
            AdapterView.OnItemClickListener { parent, v, position, id ->
                listener.onObject()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}