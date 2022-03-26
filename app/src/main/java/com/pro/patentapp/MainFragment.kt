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

        binding.toolbar.inflateMenu(R.menu.menu)
        binding.toolbar.setOnMenuItemClickListener {

            when (it.itemId) {
                R.id.aboutMenu -> listener.onClickAbout()

            }

            if (it.itemId == R.id.aboutMenu) {
                Log.e("TAG", "click")
                listener.onClickAbout()
            } else {
                Toast.makeText(activity, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
            true
        }
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}