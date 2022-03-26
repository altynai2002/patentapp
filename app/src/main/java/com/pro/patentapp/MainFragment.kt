package com.pro.patentapp

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
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
            "Изобретения",
            "Полезные модели",
            "Промышленные образцы",
            "Традиционные знания",
            "Товарные знаки и обслуживания",
            "Наименование мест происхождения",
            "Рационализаторские предложения",
            "Топологии интегральных микросхем",
            "Селекционные достижения",
            "Программы для ЭВМ и баз данных",
        )

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
        setupGridView()
    }

    private fun setupGridView() {
        val adapter = ImageListAdapter(requireContext(), R.layout.item_recycler, itemList)
        binding.gridview.adapter = adapter

        binding.gridview.onItemClickListener =
            AdapterView.OnItemClickListener { parent, v, position, id ->
                listener.onObject()
            }

    }
}